package vn.com.itqnu.onlinetest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.itqnu.onlinetest.entity.Subject;
import vn.com.itqnu.onlinetest.model.SubjectModel;
import vn.com.itqnu.onlinetest.repository.SubjectRepository;
import vn.com.itqnu.onlinetest.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	private SubjectRepository subjectRepository;

	public SubjectServiceImpl(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}

	@Override
	public Subject createSubject(SubjectModel subjectModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject getSubjectById(Long idSubject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject updateSubject(SubjectModel subjectModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSubject(Long idSubject) {
		// TODO Auto-generated method stub

	}

}
