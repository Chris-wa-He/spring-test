package com.chris.integration.processflow;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.channel.MessageChannels;
import org.springframework.integration.dsl.file.Files;
import org.springframework.integration.dsl.mail.Mail;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.stereotype.Component;

import com.rometools.rome.feed.synd.SyndEntry;

@Component
public class ProcessFlow {

	@Bean
	public IntegrationFlow releasesFlow() {

		return IntegrationFlows.from(MessageChannels.queue("releasesChannel", 10)).<SyndEntry, String>transform(
				payload -> "《" + payload.getTitle() + "》" + payload.getLink() + System.getProperty("line.separator"))
				.handle(Files.outboundAdapter(new File("D:/test/springblog")).fileExistsMode(FileExistsMode.APPEND)
						.charset("UTF-8").fileNameGenerator(message -> "releases.txt").get())
				.get();
	}

	@Bean
	public IntegrationFlow engineeringFlow() {

		return IntegrationFlows.from(MessageChannels.queue("engineeringChannel", 10))
				.<SyndEntry, String>transform(
						e -> "《" + e.getTitle() + "》" + e.getLink() + System.getProperty("line.separator"))
				.handle(Files.outboundAdapter(new File("D:/test/springblog")).fileExistsMode(FileExistsMode.APPEND)
						.charset("UTF-8").fileNameGenerator(message -> "engineering.txt").get())
				.get();
	}

	@Bean
	public IntegrationFlow newsFlow() {

		return IntegrationFlows.from(MessageChannels.queue("newsChannel", 10))
				.<SyndEntry, String>transform(payload -> "《" + payload.getTitle() + "》" + payload.getLink()
						+ System.getProperty("line.separator"))
				.enrichHeaders(Mail.headers().subject("News from Spring").to("Chris.wa.He@Amway.com")
						.from("Chris.wa.He@Amway.com"))
				.handle(Mail.outboundAdapter("smtp.office365.com").port(587).protocol("smtp")
						.credentials("Chris.wa.He@Amway.com", "Y6t5r4e3")
						.javaMailProperties(p -> p.put("mail.debug", "false")), e -> e.id("stmpOut"))
				.get();
	}

}
