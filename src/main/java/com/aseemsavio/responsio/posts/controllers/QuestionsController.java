package com.aseemsavio.responsio.posts.controllers;

import com.aseemsavio.responsio.posts.exceptions.DuplicateQuestionFoundException;
import com.aseemsavio.responsio.posts.model.requests.CreateQuestionRequest;
import com.aseemsavio.responsio.posts.model.responses.QuestionResponse;
import com.aseemsavio.responsio.posts.model.responses.ResponsioResponseEntity;
import com.aseemsavio.responsio.posts.model.requests.DeleteQuestionRequest;
import com.aseemsavio.responsio.posts.model.entities.Question;
import com.aseemsavio.responsio.posts.model.responses.Questions;
import com.aseemsavio.responsio.posts.service.QuestionService;
import com.aseemsavio.responsio.posts.utils.PostRESToperation;
import com.aseemsavio.responsio.posts.utils.factories.QuestionResponseFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.aseemsavio.responsio.posts.utils.PostRESToperation.QUESTION_CREATION;
import static com.aseemsavio.responsio.posts.utils.Status.SUCCESS;

@RestController
@RequestMapping("/v1.0")
@ApiOperation(value = "Requests related to Questions in Responsio")
public class QuestionsController {

    @Autowired
    QuestionService questionService;

    @PutMapping(value = "/createQuestion", produces = "application/json")
    @ApiOperation(value = "Creates a question")
    public Flux<ResponsioResponseEntity<QuestionResponse>> createQuestion(@RequestBody CreateQuestionRequest createQuestionRequest) throws DuplicateQuestionFoundException {
        return questionService.createQuestion(createQuestionRequest);
    }

    @DeleteMapping(value = "/deleteQuestion", produces = "application/json")
    @ApiOperation(value = "Deletes a question")
    public Flux<ResponsioResponseEntity<QuestionResponse>> deleteQuestion(@RequestBody DeleteQuestionRequest deleteQuestionRequest) {
        return questionService.deleteQuestion(deleteQuestionRequest);
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

    @GetMapping("/getQuestionForId/{questionId}")
    @ApiOperation(value = "Gets the question belonging to a Question ID")
    public Flux<ResponsioResponseEntity> getQuestionForId(@PathVariable("questionId") String userId) {
        Question question = new Question();
        ResponsioResponseEntity<QuestionResponse> responseEntity = new ResponsioResponseEntity(
                HttpStatus.OK,
                "SUCCESS",
                "Question",
                question
        );
        return Flux.just(responseEntity);
    }

    public Flux<ResponsioResponseEntity> updateQuestion() {
        return null;
    }

    public Flux<ResponsioResponseEntity> getAllQuestions() {
        return null;
    }


}
