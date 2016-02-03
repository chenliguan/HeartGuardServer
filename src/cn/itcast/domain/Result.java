package cn.itcast.domain;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Result implements Serializable {

	public String username;
	public String nick;
	public String time;
	public String rate_grade;
	public String symptoms_rhythm;
	public String rate_average;
	public String rate_min;
	public String rate_max;
	public String rhythm_heart;
	public String sinus_arrest;
	public String cardia_heart;
	public String heart_beat_number;
	public String psvc_number;
	public String pvc_number;
	public String QRS;
	public String RR;
	public String QT;
	public String PR;
	public String QTC;
	public String symptoms_heart;
	public String symptoms_heart_left;
	public String symptoms_heart_right;
	public String symptoms_heart_two;

	public Result() {
		super();
	}

	public Result(String username, String nick, String time, String rate_grade,
			String symptoms_rhythm, String rate_average, String rate_min,
			String rate_max, String rhythm_heart, String sinus_arrest,
			String cardia_heart, String heart_beat_number, String psvc_number,
			String pvc_number, String qRS, String rR, String qT, String pR,
			String qTC, String symptoms_heart, String symptoms_heart_left,
			String symptoms_heart_right, String symptoms_heart_two) {
		super();
		this.username = username;
		this.nick = nick;
		this.time = time;
		this.rate_grade = rate_grade;
		this.symptoms_rhythm = symptoms_rhythm;
		this.rate_average = rate_average;
		this.rate_min = rate_min;
		this.rate_max = rate_max;
		this.rhythm_heart = rhythm_heart;
		this.sinus_arrest = sinus_arrest;
		this.cardia_heart = cardia_heart;
		this.heart_beat_number = heart_beat_number;
		this.psvc_number = psvc_number;
		this.pvc_number = pvc_number;
		QRS = qRS;
		RR = rR;
		QT = qT;
		PR = pR;
		QTC = qTC;
		this.symptoms_heart = symptoms_heart;
		this.symptoms_heart_left = symptoms_heart_left;
		this.symptoms_heart_right = symptoms_heart_right;
		this.symptoms_heart_two = symptoms_heart_two;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRate_grade() {
		return rate_grade;
	}

	public void setRate_grade(String rate_grade) {
		this.rate_grade = rate_grade;
	}

	public String getSymptoms_rhythm() {
		return symptoms_rhythm;
	}

	public void setSymptoms_rhythm(String symptoms_rhythm) {
		this.symptoms_rhythm = symptoms_rhythm;
	}

	public String getRate_average() {
		return rate_average;
	}

	public void setRate_average(String rate_average) {
		this.rate_average = rate_average;
	}

	public String getRate_min() {
		return rate_min;
	}

	public void setRate_min(String rate_min) {
		this.rate_min = rate_min;
	}

	public String getRate_max() {
		return rate_max;
	}

	public void setRate_max(String rate_max) {
		this.rate_max = rate_max;
	}

	public String getRhythm_heart() {
		return rhythm_heart;
	}

	public void setRhythm_heart(String rhythm_heart) {
		this.rhythm_heart = rhythm_heart;
	}

	public String getSinus_arrest() {
		return sinus_arrest;
	}

	public void setSinus_arrest(String sinus_arrest) {
		this.sinus_arrest = sinus_arrest;
	}

	public String getCardia_heart() {
		return cardia_heart;
	}

	public void setCardia_heart(String cardia_heart) {
		this.cardia_heart = cardia_heart;
	}

	public String getHeart_beat_number() {
		return heart_beat_number;
	}

	public void setHeart_beat_number(String heart_beat_number) {
		this.heart_beat_number = heart_beat_number;
	}

	public String getPsvc_number() {
		return psvc_number;
	}

	public void setPsvc_number(String psvc_number) {
		this.psvc_number = psvc_number;
	}

	public String getPvc_number() {
		return pvc_number;
	}

	public void setPvc_number(String pvc_number) {
		this.pvc_number = pvc_number;
	}

	public String getQRS() {
		return QRS;
	}

	public void setQRS(String qRS) {
		QRS = qRS;
	}

	public String getRR() {
		return RR;
	}

	public void setRR(String rR) {
		RR = rR;
	}

	public String getQT() {
		return QT;
	}

	public void setQT(String qT) {
		QT = qT;
	}

	public String getPR() {
		return PR;
	}

	public void setPR(String pR) {
		PR = pR;
	}

	public String getQTC() {
		return QTC;
	}

	public void setQTC(String qTC) {
		QTC = qTC;
	}

	public String getSymptoms_heart() {
		return symptoms_heart;
	}

	public void setSymptoms_heart(String symptoms_heart) {
		this.symptoms_heart = symptoms_heart;
	}

	public String getSymptoms_heart_left() {
		return symptoms_heart_left;
	}

	public void setSymptoms_heart_left(String symptoms_heart_left) {
		this.symptoms_heart_left = symptoms_heart_left;
	}

	public String getSymptoms_heart_right() {
		return symptoms_heart_right;
	}

	public void setSymptoms_heart_right(String symptoms_heart_right) {
		this.symptoms_heart_right = symptoms_heart_right;
	}

	public String getSymptoms_heart_two() {
		return symptoms_heart_two;
	}

	public void setSymptoms_heart_two(String symptoms_heart_two) {
		this.symptoms_heart_two = symptoms_heart_two;
	}
}
