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

import vn.com.itqnu.onlinetest.entity.Answer;
import vn.com.itqnu.onlinetest.model.AnswerModel;
import vn.com.itqnu.onlinetest.service.AnswerService;

@RestController
@RequestMapping("/answers")
public class AnswerController {

	private AnswerService answerService;

	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}

	@PostMapping()
	public ResponseEntity<?> createAnswer(@RequestBody AnswerModel answerModel) {
		try {
			return ResponseEntity.ok(answerService.createAnswer(answerModel));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@GetMapping
	public List<Answer> getAllAnswer() {
		return answerService.getAllAnswer();
	}

	@GetMapping("/{id}")
	public Answer getAnswerById(@PathVariable(name = "id") Long idAnswer) {
		return answerService.getAnswerByID(idAnswer);
	}

	@PutMapping
	public ResponseEntity<?> updateAnswer(@RequestBody AnswerModel answerModel) {
		try {
			return ResponseEntity.ok(answerService.updateAnswer(answerModel));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public String deleteAnswerById(@PathVariable(name = "id") Long idAnswer) {
		try {
			answerService.deleteAnswer(idAnswer);
			return "Delete success!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
