package org.kyree.sample.rws;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.kyree.sample.rws.documents.SampleContent;
import org.kyree.sample.rws.repositories.SampleContentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;

public abstract class AbstractRepositoryIT extends AbstractIT{ 
	@Autowired protected SampleContentRepository sampleContentRepository;
	
	@BeforeEach public void before() {
		List<SampleContent> sampleEntries = 
				Stream.of("a", "b", "c")
				.map(i -> {
					SampleContent s = new SampleContent();
					s.setContent(i);
					return s;
					
				}).collect(Collectors.toList());
		
		sampleContentRepository.deleteAll()
			.thenMany(Flux.fromIterable(sampleEntries))
			.flatMap(sampleContentRepository::save)
			.then()
			.block();
	}
}
