package vn.com.itqnu.onlinetest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.itqnu.onlinetest.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	private SubjectService subjectService;

	public SubjectController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@GetMapping
	public ResponseEntity<?> getAllSubject() {
		return ResponseEntity.ok(subjectService.getAllSubject());
	}
}
