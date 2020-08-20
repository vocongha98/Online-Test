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

import vn.com.itqnu.onlinetest.entity.Subject;
import vn.com.itqnu.onlinetest.model.SubjectModel;
import vn.com.itqnu.onlinetest.service.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	private SubjectService subjectService;

	public SubjectController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@GetMapping
	public List<Subject> getAllSubject() {
		return subjectService.getAllSubject();
	}
	
	@GetMapping("/{id}")
	public Subject getSubjectById(@PathVariable(name = "id") Long idSubject) {
		return subjectService.getSubjectById(idSubject);
		}
	
	@PostMapping()
	public ResponseEntity<?> createSubject(@RequestBody SubjectModel subjectModel){
		try {
			return ResponseEntity.ok(subjectService.createSubject(subjectModel));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	
	@PutMapping
	public ResponseEntity<?> updateSubject(@RequestBody SubjectModel subjectModel) {
		try {
			return ResponseEntity.ok(subjectService.updateSubject(subjectModel));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public String deleteSubjectById(@PathVariable(name = "id") Long idSubject) {
		try {
			subjectService.deleteSubject(idSubject);
			return "Delete success!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
