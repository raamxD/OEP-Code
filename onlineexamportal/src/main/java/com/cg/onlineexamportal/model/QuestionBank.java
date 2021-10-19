package com.cg.onlineexamportal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH })
	@JoinColumn(name = "fk_questionbank_id", referencedColumnName = "questionbank_id")
	private Set<Question> questionbankQuestions;

	public QuestionBank() {
		super();
	}

	public QuestionBank(String questionbankCourseType, Set<Question> questionbankQuestions) {
		super();
		this.questionbankCourseType = questionbankCourseType;
		this.questionbankQuestions = questionbankQuestions;
	}

	public QuestionBank(long questionbankId, String questionbankCourseType, Set<Question> questionbankQuestions) {
		super();
		this.questionbankId = questionbankId;
		this.questionbankCourseType = questionbankCourseType;
		this.questionbankQuestions = questionbankQuestions;
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

	public Set<Question> getQuestionbankQuestions() {
		return questionbankQuestions;
	}

	public void setQuestionbankQuestions(Set<Question> questionbankQuestions) {
		this.questionbankQuestions = questionbankQuestions;
	}

	@Override
	public String toString() {
		return "QuestionBank [questionbankId=" + questionbankId + ", questionbankCourseType=" + questionbankCourseType
				+ ", questionbankQuestions=" + questionbankQuestions + "]";
	}
}
