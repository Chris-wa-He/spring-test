package com.chris.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.chris.batch.domain.PersonBatch;
import com.chris.batch.util.CsvBeanValidator;
import com.chris.batch.util.CsvItemProcessor;
import com.chris.batch.util.CsvJobListener;

//@Configuration
@EnableBatchProcessing
public class CsvBatchConfig {

	@Bean
	public ItemReader<PersonBatch> reader() {

		FlatFileItemReader<PersonBatch> reader = new FlatFileItemReader<PersonBatch>();

		reader.setResource(new ClassPathResource("people.csv"));

		reader.setLineMapper(new DefaultLineMapper<PersonBatch>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "name", "age", "nation", "address" });
					}
				});

				setFieldSetMapper(new BeanWrapperFieldSetMapper<PersonBatch>() {
					{
						setTargetType(PersonBatch.class);
					}
				});
			}

		});

		return reader;

	}

	@Bean
	public ItemProcessor<PersonBatch, PersonBatch> processor() {
		CsvItemProcessor itemProcessor = new CsvItemProcessor();
		itemProcessor.setValidator(csvBeanValidator());

		return itemProcessor;
	}

	@Bean
	public ItemWriter<PersonBatch> writer(DataSource dataSource) {

		JdbcBatchItemWriter<PersonBatch> writer = new JdbcBatchItemWriter<>();

		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<PersonBatch>());

		String sql = "insert into person_batch (id,name,age,nation,address)"
				+ "values (hibernate_sequence.nextval,:name,:age,:nation,:address)";

		writer.setSql(sql);
		writer.setDataSource(dataSource);

		return writer;

	}

	@Bean
	public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager)
			throws Exception {

		JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();

		factoryBean.setDataSource(dataSource);
		factoryBean.setTransactionManager(transactionManager);
		factoryBean.setDatabaseType("oracle");

		return factoryBean.getObject();

	}

	@Bean
	public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager)
			throws Exception {

		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository(dataSource, transactionManager));
		return jobLauncher;

	}

	@Bean
	public Job importJob(JobBuilderFactory jobs, Step s1) {
		return jobs.get("importJob").incrementer(new RunIdIncrementer()).flow(s1).end().listener(csvJobListener())
				.build();

	}

	@Bean
	public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<PersonBatch> itemReader,
			ItemWriter<PersonBatch> itemWriter, ItemProcessor<PersonBatch, PersonBatch> itemProcessor) {
		return stepBuilderFactory.get("step1").<PersonBatch, PersonBatch>chunk(65000).reader(itemReader)
				.processor(itemProcessor).writer(itemWriter).build();

	}

	@Bean
	public CsvJobListener csvJobListener() {
		return new CsvJobListener();
	}

	@Bean
	public Validator<PersonBatch> csvBeanValidator() {
		return new CsvBeanValidator<PersonBatch>();

	}

}
