package org.kyree.sample.rws;

import org.junit.Test;
import org.kyree.sample.rws.documents.SampleContent;
import org.springframework.http.MediaType;

public class SampleContentControllerIT extends AbstractWebIT{
	@Test public void testFindAll() {
		webTestClient.get().uri("/mvc/samples")
			.accept(MediaType.APPLICATION_JSON_UTF8)
			.exchange()
			.expectStatus().isOk()
			.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
			.expectBodyList(SampleContent.class);
	}
	
	@Test public void testFindById() {
		SampleContent expectedSampleContent = sampleContentRepository.findByContentStartsWith("b").blockFirst();
		
		webTestClient.get().uri("/mvc/samples/" + expectedSampleContent.getId())
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody(SampleContent.class)
		.isEqualTo(expectedSampleContent);
	}
}
