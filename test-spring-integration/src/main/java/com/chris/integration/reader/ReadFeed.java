package com.chris.integration.reader;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.stereotype.Component;

import com.rometools.rome.feed.synd.SyndEntry;

@Component
public class ReadFeed {

	@Value("https://spring.io/blog.atom")
	private Resource resource;

	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerMetadata poller() {
		return Pollers.fixedRate(500).get();
	}

	@Bean
	public FeedEntryMessageSource feedMessageSource() throws IOException {
		FeedEntryMessageSource source = new FeedEntryMessageSource(resource.getURL(), "news");

		return source;
	}

	@Bean
	public IntegrationFlow readFlow() throws IOException {
		return IntegrationFlows.from(feedMessageSource()).<SyndEntry, String>route(
				payload -> payload.getCategories().get(0).getName(),
				mapping -> mapping.channelMapping("releases", "releasesChannel")
						.channelMapping("engineering", "engineeringChannel").channelMapping("news", "newsChannel"))
				.get();
	}
}
