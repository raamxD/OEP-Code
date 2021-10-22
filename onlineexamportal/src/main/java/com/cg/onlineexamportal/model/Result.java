package com.cg.onlineexamportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "result_table")
public class Result {
	
	@Id
	@Column(name = "result_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "result_generator")
	@SequenceGenerator(name = "result_generator", sequenceName = "result_sequence", allocationSize = 1)
	private long resultId;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "test_id")
	private long testId;
	
	@Column(name="question_id")
	private long questionId;
	
	@Column(name="choice_marked")
	private String choiceMarked;
	
	@Column(name="correct_choice")
	private String correctChoice;

	// constructors
	
	public Result() {
		super();
	}

	public Result(long userId, long testId, long questionId, String choiceMarked, String correctChoice) {
		super();
		this.userId = userId;
		this.testId = testId;
		this.questionId = questionId;
		this.choiceMarked = choiceMarked;
		this.correctChoice = correctChoice;
	}

	public Result(long resultId, long userId, long testId, long questionId, String choiceMarked, String correctChoice) {
		super();
		this.resultId = resultId;
		this.userId = userId;
		this.testId = testId;
		this.questionId = questionId;
		this.choiceMarked = choiceMarked;
		this.correctChoice = correctChoice;
	}

	// getters and setters
	
	public long getResultId() {
		return resultId;
	}

	public void setResultId(long resultId) {
		this.resultId = resultId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getChoiceMarked() {
		return choiceMarked;
	}

	public void setChoiceMarked(String choiceMarked) {
		this.choiceMarked = choiceMarked;
	}

	public String getCorrectChoice() {
		return correctChoice;
	}

	public void setCorrectChoice(String correctChoice) {
		this.correctChoice = correctChoice;
	}

	// to string method
	
	@Override
	public String toString() {
		return "Result [resultId=" + resultId + ", userId=" + userId + ", testId=" + testId + ", questionId="
				+ questionId + ", choiceMarked=" + choiceMarked + ", correctChoice=" + correctChoice + "]";
	}
}