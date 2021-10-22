package com.cg.onlineexamportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="question_table")
public class Question{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_generator")
	@SequenceGenerator(name = "question_generator", sequenceName = "question_sequence", allocationSize = 1)
	@Column(name="question_id")
	private long questionId;

	@Column(name="question_sentence")
	private String questionSentence;	
	
	@Column(name="question_choice1")
	private String questionChoice1;

	@Column(name="question_choice2")
	private String questionChoice2;

	@Column(name="question_choice3")
	private String questionChoice3;

	@Column(name="question_choice4")
	private String questionChoice4;
	
	@Column(name="question_correct_choice")
	private String questionCorrectChoice;
	
	// constructors
	
	public Question() {
		super();
	}

	public Question(String questionSentence, String questionChoice1, String questionChoice2, String questionChoice3,
			String questionChoice4, String questionCorrectChoice) {
		super();
		this.questionSentence = questionSentence;
		this.questionChoice1 = questionChoice1;
		this.questionChoice2 = questionChoice2;
		this.questionChoice3 = questionChoice3;
		this.questionChoice4 = questionChoice4;
		this.questionCorrectChoice = questionCorrectChoice;
	}

	public Question(long questionId, String questionSentence, String questionChoice1, String questionChoice2,
			String questionChoice3, String questionChoice4, String questionCorrectChoice) {
		super();
		this.questionId = questionId;
		this.questionSentence = questionSentence;
		this.questionChoice1 = questionChoice1;
		this.questionChoice2 = questionChoice2;
		this.questionChoice3 = questionChoice3;
		this.questionChoice4 = questionChoice4;
		this.questionCorrectChoice = questionCorrectChoice;
	}

	// getters and setters
	
	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionSentence() {
		return questionSentence;
	}

	public void setQuestionSentence(String questionSentence) {
		this.questionSentence = questionSentence;
	}

	public String getQuestionChoice1() {
		return questionChoice1;
	}

	public void setQuestionChoice1(String questionChoice1) {
		this.questionChoice1 = questionChoice1;
	}

	public String getQuestionChoice2() {
		return questionChoice2;
	}

	public void setQuestionChoice2(String questionChoice2) {
		this.questionChoice2 = questionChoice2;
	}

	public String getQuestionChoice3() {
		return questionChoice3;
	}

	public void setQuestionChoice3(String questionChoice3) {
		this.questionChoice3 = questionChoice3;
	}

	public String getQuestionChoice4() {
		return questionChoice4;
	}

	public void setQuestionChoice4(String questionChoice4) {
		this.questionChoice4 = questionChoice4;
	}

	public String getQuestionCorrectChoice() {
		return questionCorrectChoice;
	}

	public void setQuestionCorrectChoice(String questionCorrectChoice) {
		this.questionCorrectChoice = questionCorrectChoice;
	}

	// to string method
	
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionSentence=" + questionSentence + ", questionChoice1="
				+ questionChoice1 + ", questionChoice2=" + questionChoice2 + ", questionChoice3=" + questionChoice3
				+ ", questionChoice4=" + questionChoice4 + ", questionCorrectChoice=" + questionCorrectChoice + "]";
	}
}