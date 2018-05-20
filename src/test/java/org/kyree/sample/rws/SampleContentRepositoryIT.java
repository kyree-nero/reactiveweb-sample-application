package org.kyree.sample.rws;

import org.junit.Test;
import org.kyree.sample.rws.documents.SampleContent;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class SampleContentRepositoryIT extends AbstractRepositoryIT{
	@Test public void testSave() {
		SampleContent c = new SampleContent();
		StepVerifier.create(sampleContentRepository.save(c))
			.expectNextMatches(i -> !i.getId().equals(""))
			.verifyComplete();
	}
	
	@Test public void testFindAll() {
		StepVerifier.create(sampleContentRepository.findAll())
			.expectNextCount(3)
			.verifyComplete();
	}
	
	@Test public void testFindByContent() {
		StepVerifier.create(sampleContentRepository.findByContentStartsWith("c"))
			.expectNextMatches(p -> p != null)
			.verifyComplete();
	}
	
	@Test public void testById() {
		SampleContent sampleContent = sampleContentRepository
				.findByContentStartsWith("c")
				.flatMap(i -> Mono.just(i))
				.blockFirst();
		
		StepVerifier.create(sampleContentRepository.findById(sampleContent.getId())).expectNext(sampleContent).verifyComplete();
	}
	
	
	
}
