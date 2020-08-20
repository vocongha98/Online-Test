package vn.com.itqnu.onlinetest.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.itqnu.onlinetest.entity.Question;
import vn.com.itqnu.onlinetest.model.QuestionModel;
import vn.com.itqnu.onlinetest.service.QuestionService;

@RestController
@RequestMapping("/Question")
public class QuestionController {

	private QuestionService questionService;
	
	public QuestionController (QuestionService questionService) {
		this.questionService = questionService;
	}
	@PostMapping()
	public ResponseEntity<?> createQuestion(@RequestBody QuestionModel questionModel) {
		try {
			return ResponseEntity.ok(questionService.createQuestion(questionModel));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@GetMapping
	public List<Question> getAllQuestion() {
		return questionService.getAllQuestion();
	}

	@GetMapping("/{id}")
	public Question getQuestionById(@PathVariable(name = "id") Long idQuestion) {
		return questionService.getQuestionByID(idQuestion);
	}

	@PutMapping
	public ResponseEntity<?> updateQuestion(@RequestBody QuestionModel questionModel) {
		try {
			return ResponseEntity.ok(questionService.updateQuestion(questionModel));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public String deleteQuestionById(@PathVariable(name = "id") Long idQuestion) {
		try {
			questionService.deleteQuestion(idQuestion);
			return "Delete success!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
