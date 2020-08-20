package vn.com.itqnu.onlinetest.model;

public class SubjectModel {

	private Long id;
	private String subjectName;
	private int creditNumber;
	private String description;

	public SubjectModel() {
		super();
	}

	public SubjectModel(String subjectName, int creditNumber, String description) {
		super();
		this.subjectName = subjectName;
		this.creditNumber = creditNumber;
		this.description = description;
	}

	public SubjectModel(Long id, String subjectName, int creditNumber, String description) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.creditNumber = creditNumber;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getCreditNumber() {
		return creditNumber;
	}

	public void setCreditNumber(int creditNumber) {
		this.creditNumber = creditNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
