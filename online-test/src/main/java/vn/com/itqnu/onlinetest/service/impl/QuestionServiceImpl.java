package vn.com.itqnu.onlinetest.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.com.itqnu.onlinetest.entity.Question;
import vn.com.itqnu.onlinetest.model.QuestionModel;
import vn.com.itqnu.onlinetest.repository.QuestionRepository;
import vn.com.itqnu.onlinetest.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService {

	private QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Override
	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

	@Override
	public Question getQuestionByID(Long idQuestion) {
		Optional<Question> optional = questionRepository.findById(idQuestion);
		if (optional != null && optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Question createQuestion(QuestionModel questionModel) {
		if (questionModel.getQuestionName() == null || questionModel.getQuestionName().trim().length() == 0) {
			throw new RuntimeException("Question name is required!");
		}

		//
		
		Question question = new Question();
		question.setQuestionName(questionModel.getQuestionName());
		question.setResult(questionModel.getResult());

		question.setCreatedBy("ADMIN");
		question.setCreatedDate(new Date());
		question.setModifiedBy("ADMIN");
		question.setModifiedDate(new Date());

		questionRepository.save(question);
		return null;
	}

	@Override
	public Question updateQuestion(QuestionModel questionModel) {
		Question question = getQuestionByID(questionModel.getId());
		if (question == null) {
			throw new RuntimeException("Question does not exits!");
		}
		
		
		question.setQuestionName(questionModel.getQuestionName());
		question.setResult(questionModel.getResult());
		
		question.setModifiedBy("ADMIN");
		question.setModifiedDate(new Date());

		questionRepository.save(question);

		return question;
	}

	@Override
	public void deleteQuestion(Long idQuestion) {
		Question question = getQuestionByID(idQuestion);

		if (question == null) {
			throw new RuntimeException("Question does not exits!");
		}
		questionRepository.delete(question);

	}

}
