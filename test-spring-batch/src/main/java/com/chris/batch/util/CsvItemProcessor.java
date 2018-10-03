package com.chris.batch.util;

import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

import com.chris.batch.domain.PersonBatch;

public class CsvItemProcessor extends ValidatingItemProcessor<PersonBatch> {

	@Override
	public PersonBatch process(PersonBatch item) throws ValidationException {
		super.process(item);

		if (item.getNation().equals("汉族")) {
			item.setNation("01");
		} else {
			item.setNation("02");
		}

		return item;
	}

}
