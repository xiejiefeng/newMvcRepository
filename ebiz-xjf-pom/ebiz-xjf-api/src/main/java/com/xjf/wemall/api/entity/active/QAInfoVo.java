package com.xjf.wemall.api.entity.active;

/**
 * 活动答题VO（包含问题、答案信息）
 * 
 * @author chongwenjun
 *
 */
public class QAInfoVo {
	// 行号
	private String rn;
	// 问题
	private String question;
	// 答案A
	private String answerA;
	// 答案B
	private String answerB;
	// 答案C
	private String answerC;
	// 答案D
	private String answerD;
	// 标准答案
	private String trueAnswer;
	// 标准答案得分
	private String score;

	public QAInfoVo() {
		this.trueAnswer = "1";
	}

	public String getRn() {
		return rn;
	}

	public void setRn(String rn) {
		this.rn = rn;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public String getTrueAnswer() {
		return trueAnswer;
	}

	public void setTrueAnswer(String trueAnswer) {
		this.trueAnswer = trueAnswer;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}
