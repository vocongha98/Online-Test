package vn.com.itqnu.onlinetest.model;

public class QuestionModel {

	private long id;
	private String questionName;
	private String result;
	private int level;
	private int subjectId;

	public QuestionModel(String questionName, String result, int level, int subjectId) {
		super();
		this.questionName = questionName;
		this.result = result;
		this.level = level;
		this.subjectId = subjectId;
	}

	public QuestionModel(long id, String questionName, String result, int level, int subjectId) {
		super();
		this.id = id;
		this.questionName = questionName;
		this.result = result;
		this.level = level;
		this.subjectId = subjectId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

}
