package vn.com.itqnu.onlinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.itqnu.onlinetest.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	Question findByQuestionName(String questionName);
}
