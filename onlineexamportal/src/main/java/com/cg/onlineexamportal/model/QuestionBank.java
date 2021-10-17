package com.cg.onlineexamportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="questionbank_table")
public class QuestionBank {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questionbank_generator")
	@SequenceGenerator(name = "questionbank_generator", sequenceName = "questionbank_sequence", allocationSize = 1)
	@Column(name = "questionbank_id")
	private long questionbankId;
	
	@Column(name = "questionbank_course_type")
	private String questionbankCourseType;

	public QuestionBank() {
		super();
	}

	public QuestionBank(String questionbankCourseType) {
		super();
		this.questionbankCourseType = questionbankCourseType;
	}

	public QuestionBank(long questionbankId, String questionbankCourseType) {
		super();
		this.questionbankId = questionbankId;
		this.questionbankCourseType = questionbankCourseType;
	}

	public long getQuestionbankId() {
		return questionbankId;
	}

	public void setQuestionbankId(long questionbankId) {
		this.questionbankId = questionbankId;
	}

	public String getQuestionbankCourseType() {
		return questionbankCourseType;
	}

	public void setQuestionbankCourseType(String questionbankCourseType) {
		this.questionbankCourseType = questionbankCourseType;
	}

	@Override
	public String toString() {
		return "QuestionBank [questionbankId=" + questionbankId + ", questionbankCourseType=" + questionbankCourseType
				+ "]";
	}	
}
