package org.kyree.sample.rws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

public abstract class AbstractWebIT extends AbstractRepositoryIT{
	@Autowired WebTestClient webTestClient;
	
	
}
