package model;

import java.io.Serializable;

public class HocPhan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maHP;
	private String tenHP;
	private int soTinChi;
	private String giangVien;
	private double score1;
	private double score2;
	private double score3;
	private double scoreFinal;
	private String rankHP;
	
	public HocPhan(int maHP, String tenHP, int soTinChi, String giangVien) {
		this.maHP = maHP;
		this.tenHP = tenHP;
		this.soTinChi = soTinChi;
		this.giangVien = giangVien;
	}

	public HocPhan() {
		
	}

	public int getMaHP() {
		return maHP;
	}

	public void setMaHP(int maHP) {
		this.maHP = maHP;
	}

	public String getTenHP() {
		return tenHP;
	}

	public void setTenHP(String tenHP) {
		this.tenHP = tenHP;
	}

	public int getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	public String getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(String giangVien) {
		this.giangVien = giangVien;
	}

	public double getScore1() {
		return score1;
	}

	public void setScore1(double score1) {
		this.score1 = score1;
	}

	public double getScore2() {
		return score2;
	}

	public void setScore2(double score2) {
		this.score2 = score2;
	}

	public double getScore3() {
		return score3;
	}

	public void setScore3(double score3) {
		this.score3 = score3;
	}

	public double getScoreFinal() {
		return scoreFinal;
	}

	public void setScoreFinal(double scoreFinal) {
		this.scoreFinal = scoreFinal;
	}
	public void setScoreFinal(double s1,double s2, double s3) {
		this.scoreFinal = (s1*0.2) + (s2*0.3) + (s3*0.5);
	}
	public String getRankHP() {
		return rankHP;
	}

	public void setRankHP(String rankHP) {
		this.rankHP = rankHP;
	}

	public void setRankHP(double tongket) {
		if (tongket >= 9.0) {
	           this.rankHP =("A+");
	        } else if (tongket >= 8.5) {
	        	this.rankHP =("A");
	        } else if (tongket >= 8.0) {
	        	this.rankHP =("B+");
	        } else if (tongket >= 7.0) {
	        	this.rankHP =("B");
	        } else if (tongket >= 6.0) {
	        	this.rankHP =("C+");
	        } else if (tongket >= 5.5) {
	        	this.rankHP =("C");
	        } else if (tongket >= 5.0) {
	        	this.rankHP =("D+");
	        } else if (tongket >= 4.0) {
	        	this.rankHP =("D");
	        } else  {
	        	this.rankHP =("F");
	        } 
	}
	
	
}
