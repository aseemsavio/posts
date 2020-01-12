package com.aseemsavio.responsio.posts.repositories;

import com.aseemsavio.responsio.posts.model.entities.Question;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface QuestionsRepository extends ReactiveMongoRepository<Question, String> {
    Mono<Question> findByContent(String content);
}
