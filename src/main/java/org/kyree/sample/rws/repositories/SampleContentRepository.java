package org.kyree.sample.rws.repositories;

import org.kyree.sample.rws.documents.SampleContent;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;

import reactor.core.publisher.Flux;

public interface SampleContentRepository extends ReactiveMongoRepository<SampleContent, String>{
	Flux<SampleContent> findByContentStartsWith(@Param("prefix") String prefix);
}
