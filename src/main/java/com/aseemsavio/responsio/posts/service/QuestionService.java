package com.aseemsavio.responsio.posts.service;

import com.aseemsavio.responsio.posts.exceptions.DuplicateQuestionFoundException;
import com.aseemsavio.responsio.posts.model.entities.Question;
import com.aseemsavio.responsio.posts.model.requests.CreateQuestionRequest;
import com.aseemsavio.responsio.posts.model.responses.QuestionResponse;
import com.aseemsavio.responsio.posts.model.responses.ResponsioResponseEntity;
import com.aseemsavio.responsio.posts.repositories.QuestionsRepository;
import com.aseemsavio.responsio.posts.utils.factories.QuestionResponseFactory;
import com.aseemsavio.responsio.posts.utils.factories.ResponseioResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.aseemsavio.responsio.posts.utils.ErrorCode.DUPLICATE_QUESTION_FOUND_EXCEPTION_CODE;
import static com.aseemsavio.responsio.posts.utils.ErrorMessage.DUPLICATE_QUESTION_FOUND_EXCEPTION_MSG;
import static com.aseemsavio.responsio.posts.utils.PostRESToperation.QUESTION_CREATION;
import static com.aseemsavio.responsio.posts.utils.Status.FAILURE;
import static com.aseemsavio.responsio.posts.utils.Status.SUCCESS;
import static com.aseemsavio.responsio.posts.utils.StringUtils.isNullOrEmpty;

@Service
public class QuestionService {

    @Autowired
    QuestionsRepository questionsRepository;

    public Flux<ResponsioResponseEntity<QuestionResponse>> createQuestion(CreateQuestionRequest createQuestionRequest) throws DuplicateQuestionFoundException {

        Question question = new Question();
        question.setUserId(createQuestionRequest.getUserId());
        question.setCreationTS(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
        question.setContent(createQuestionRequest.getContent());

        QuestionResponse questionResponse;
        ResponsioResponseEntity<QuestionResponse> responsioResponseEntity;
        ResponseioResponseFactory<QuestionResponse> responseFactory = new ResponseioResponseFactory<>();

        Mono<Question> isFound = questionsRepository.findByContent(createQuestionRequest.getContent());
        if(isFound.block() != null) {
            throw new DuplicateQuestionFoundException(DUPLICATE_QUESTION_FOUND_EXCEPTION_CODE, DUPLICATE_QUESTION_FOUND_EXCEPTION_MSG);
            /*questionResponse = QuestionResponseFactory.build(question, QUESTION_CREATION, FAILURE);
            responsioResponseEntity = responseFactory.build(questionResponse, QUESTION_CREATION, FAILURE);
            return Flux.just(responsioResponseEntity);*/
        }

        Mono<Question> createdQuestionMono = questionsRepository.save(question);
        Question createdQuestion = createdQuestionMono.block();

        if (isNullOrEmpty(createdQuestion.getQuestionId())) {
            questionResponse = QuestionResponseFactory.build(createdQuestion, QUESTION_CREATION, FAILURE);
            responsioResponseEntity = responseFactory.build(questionResponse, QUESTION_CREATION, FAILURE);
        } else {
            questionResponse = QuestionResponseFactory.build(createdQuestion, QUESTION_CREATION, SUCCESS);
            responsioResponseEntity = responseFactory.build(questionResponse, QUESTION_CREATION, SUCCESS);
        }
        return Flux.just(responsioResponseEntity);
    }
}
