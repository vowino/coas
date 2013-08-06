package cs.mum.model;

import javax.persistence.Entity;

@Entity 
public class EnglishProficiency extends Section {
	private String readAndWrite;
	private String spokenEnglish;
	private String understandSpokenEnglish;
	private int toeflYear;
	private double toeflYearScore;
	private int greYear;
	private double greVerbalScore;
	private double greVerbalScorePercentile;
	private double greQuantitativeScore;
	private double greQuantitativeScorePercentile;
	
	
	public EnglishProficiency(String readAndWrite, String spokenEnglish,
			String understandSpokenEnglish, int toeflYear,
			double toeflYearScore, int greYear, double greVerbalScore,
			double greVerbalScorePercentile, double greQuantitativeScore,
			double greQuantitativeScorePercentile) {
		this.readAndWrite = readAndWrite;
		this.spokenEnglish = spokenEnglish;
		this.understandSpokenEnglish = understandSpokenEnglish;
		this.toeflYear = toeflYear;
		this.toeflYearScore = toeflYearScore;
		this.greYear = greYear;
		this.greVerbalScore = greVerbalScore;
		this.greVerbalScorePercentile = greVerbalScorePercentile;
		this.greQuantitativeScore = greQuantitativeScore;
		this.greQuantitativeScorePercentile = greQuantitativeScorePercentile;
	}
	public EnglishProficiency() {
	
	}
	public String getReadAndWrite() {
		return readAndWrite;
	}
	public void setReadAndWrite(String readAndWrite) {
		this.readAndWrite = readAndWrite;
	}
	public String getSpokenEnglish() {
		return spokenEnglish;
	}
	public void setSpokenEnglish(String spokenEnglish) {
		this.spokenEnglish = spokenEnglish;
	}
	public String getUnderstandSpokenEnglish() {
		return understandSpokenEnglish;
	}
	public void setUnderstandSpokenEnglish(String understandSpokenEnglish) {
		this.understandSpokenEnglish = understandSpokenEnglish;
	}
	public int getToeflYear() {
		return toeflYear;
	}
	public void setToeflYear(int toeflYear) {
		this.toeflYear = toeflYear;
	}
	public double getToeflYearScore() {
		return toeflYearScore;
	}
	public void setToeflYearScore(double toeflYearScore) {
		this.toeflYearScore = toeflYearScore;
	}
	public int getGreYear() {
		return greYear;
	}
	public void setGreYear(int greYear) {
		this.greYear = greYear;
	}
	public double getGreVerbalScore() {
		return greVerbalScore;
	}
	public void setGreVerbalScore(double greVerbalScore) {
		this.greVerbalScore = greVerbalScore;
	}
	public double getGreVerbalScorePercentile() {
		return greVerbalScorePercentile;
	}
	public void setGreVerbalScorePercentile(double greVerbalScorePercentile) {
		this.greVerbalScorePercentile = greVerbalScorePercentile;
	}
	public double getGreQuantitativeScore() {
		return greQuantitativeScore;
	}
	public void setGreQuantitativeScore(double greQuantitativeScore) {
		this.greQuantitativeScore = greQuantitativeScore;
	}
	public double getGreQuantitativeScorePercentile() {
		return greQuantitativeScorePercentile;
	}
	public void setGreQuantitativeScorePercentile(
			double greQuantitativeScorePercentile) {
		this.greQuantitativeScorePercentile = greQuantitativeScorePercentile;
	}
	
	

}
