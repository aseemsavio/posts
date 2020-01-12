package com.aseemsavio.responsio.posts.controllers;

import com.aseemsavio.responsio.posts.model.requests.CreateQuestionRequest;
import com.aseemsavio.responsio.posts.model.responses.QuestionResponse;
import com.aseemsavio.responsio.posts.model.responses.ResponsioResponseEntity;
import com.aseemsavio.responsio.posts.model.entities.DeleteQuestionRequest;
import com.aseemsavio.responsio.posts.model.entities.Question;
import com.aseemsavio.responsio.posts.model.entities.Questions;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@RestController
@RequestMapping("/v1.0")
@ApiOperation(value = "Requests related to Questions in Responsio")
public class QuestionsController {

    @GetMapping(value = "/hi", produces = "application/json")
    public ResponsioResponseEntity<Mono<String>> hello() {

        Mono<String> stringMono = just("Hello world");
        ResponsioResponseEntity<Mono<String>> responseEntity = new ResponsioResponseEntity(
                HttpStatus.OK,
                "SUCCESS",
                "STRING",
                stringMono
        );

        return responseEntity;
    }

    @PutMapping(value = "/createQuestion", produces = "application/json")
    @ApiOperation(value = "Creates a question")
    public Flux<ResponsioResponseEntity> createQuestion(@RequestBody CreateQuestionRequest question) {

        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setId("jhsakjhdaskjd");
        questionResponse.setMessage("Question Created successfully");
        questionResponse.setContent(question.getContent());

        ResponsioResponseEntity<QuestionResponse> responseEntity = new ResponsioResponseEntity(
                HttpStatus.OK,
                "SUCCESS",
                "QuestionResponse",
                questionResponse
        );
        return Flux.just(responseEntity);
    }

    @DeleteMapping(value = "/deleteQuestion", produces = "application/json")
    @ApiOperation(value = "Deletes a question")
    public Flux<ResponsioResponseEntity> deleteQuestion(@RequestBody DeleteQuestionRequest question) {
        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setId(question.getQuestionId());
        questionResponse.setMessage("Question Deleted successfully");
        questionResponse.setContent("hjkhkjhkjh");

        ResponsioResponseEntity<QuestionResponse> responseEntity = new ResponsioResponseEntity(
                HttpStatus.OK,
                "SUCCESS",
                "QuestionResponse",
                questionResponse
        );
        return Flux.just(responseEntity);
    }

    @GetMapping("/getMyQuestions/{userId}")
    @ApiOperation(value = "Gets all the questions of a particular user")
    public Flux<ResponsioResponseEntity> getMyQuestions(@PathVariable("userId") String userId) {
        Questions questions = new Questions();

        ResponsioResponseEntity<QuestionResponse> responseEntity = new ResponsioResponseEntity(
                HttpStatus.OK,
                "SUCCESS",
                "Questions",
                questions
        );
        return Flux.just(responseEntity);
    }

    public Flux<ResponsioResponseEntity> getQuestionForId() {
        Question question = new Question();
        ResponsioResponseEntity<QuestionResponse> responseEntity = new ResponsioResponseEntity(
                HttpStatus.OK,
                "SUCCESS",
                "Question",
                question
        );
        return Flux.just(responseEntity);
    }


}
