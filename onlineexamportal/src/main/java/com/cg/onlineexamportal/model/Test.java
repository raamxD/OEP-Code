package com.cg.onlineexamportal.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "test_table")
public class Test {
	
	@Id
	@Column(name = "test_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_generator")
	@SequenceGenerator(name = "test_generator", sequenceName = "test_sequence", allocationSize = 1)
	private long testId;
	
	@Column(name = "test_course_type")
	private String testCourseType;
	
	@Column(name = "test_start_time")
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date testStartTime;
	
	@Column(name = "test_end_time")
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date testEndTime;
	
	@Column(name = "test_exam_date")
	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date testExamDate;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH })
	private QuestionBank testQuestionBank;
	
	public Test() {
		super();
	}

	public Test(String testCourseType, Date testStartTime, Date testEndTime, Date testExamDate,
			QuestionBank testQuestionBank) {
		super();
		this.testCourseType = testCourseType;
		this.testStartTime = testStartTime;
		this.testEndTime = testEndTime;
		this.testExamDate = testExamDate;
		this.testQuestionBank = testQuestionBank;
	}

	public Test(long testId, String testCourseType, Date testStartTime, Date testEndTime, Date testExamDate,
			QuestionBank testQuestionBank) {
		super();
		this.testId = testId;
		this.testCourseType = testCourseType;
		this.testStartTime = testStartTime;
		this.testEndTime = testEndTime;
		this.testExamDate = testExamDate;
		this.testQuestionBank = testQuestionBank;
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}

	public String getTestCourseType() {
		return testCourseType;
	}

	public void setTestCourseType(String testCourseType) {
		this.testCourseType = testCourseType;
	}

	public Date getTestStartTime() {
		return testStartTime;
	}

	public void setTestStartTime(Date testStartTime) {
		this.testStartTime = testStartTime;
	}

	public Date getTestEndTime() {
		return testEndTime;
	}

	public void setTestEndTime(Date testEndTime) {
		this.testEndTime = testEndTime;
	}

	public Date getTestExamDate() {
		return testExamDate;
	}

	public void setTestExamDate(Date testExamDate) {
		this.testExamDate = testExamDate;
	}

	public QuestionBank getTestQuestionBank() {
		return testQuestionBank;
	}

	public void setTestQuestionBank(QuestionBank testQuestionBank) {
		this.testQuestionBank = testQuestionBank;
	}
}	
