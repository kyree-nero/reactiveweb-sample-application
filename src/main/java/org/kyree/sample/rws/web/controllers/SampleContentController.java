package org.kyree.sample.rws.web.controllers;

import org.kyree.sample.rws.documents.SampleContent;
import org.kyree.sample.rws.repositories.SampleContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SampleContentController {
	@Autowired SampleContentRepository sampleContentRepository;
	
	@GetMapping("/samples")
	public @ResponseBody Flux<SampleContent> findSamples(){
		return sampleContentRepository.findAll();
	} 
	
	@GetMapping("/samples/{id}")
	public @ResponseBody Mono<SampleContent> findById (@PathVariable String id){
		return sampleContentRepository.findById(id);
	}
}
