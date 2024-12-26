package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class SinhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mssv;
	private String name;
	private Boolean gender;
	private int age;
	private String lopDanhNghia;
	private List<HocPhan> hocPhans = new ArrayList<HocPhan>();
	private int tongTinChiTichLuy;
	private double diemTBTichLuy;
	private String xepLoaiTichLuy;
	
	public SinhVien(int mssv, String name, Boolean gender, int age, String lopDanhNghia) {
		this.mssv = mssv;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.lopDanhNghia = lopDanhNghia;
	}

	public SinhVien() {

	}

	public int getMssv() {
		return mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLopDanhNghia() {
		return lopDanhNghia;
	}

	public void setLopDanhNghia(String lopDanhNghia) {
		this.lopDanhNghia = lopDanhNghia;
	}

	
	
	public int getTongTinChiTichLuy() {
		return tongTinChiTichLuy;
	}

	public void setTongTinChiTichLuy(int tongTinChiTichLuy) {
		this.tongTinChiTichLuy = tongTinChiTichLuy;
	}

	public double getDiemTBTichLuy() {
		return diemTBTichLuy;
	}

	public void setDiemTBTichLuy(double diemTBTichLuy) {
		this.diemTBTichLuy = diemTBTichLuy;
	}

	public String getXepLoaiTichLuy() {
		return xepLoaiTichLuy;
	}

	public void setXepLoaiTichLuy(String xepLoaiTichLuy) {
		this.xepLoaiTichLuy = xepLoaiTichLuy;
	}

	public List<HocPhan> getHocPhans() {
		return hocPhans;
	}

	public void setHocPhans(List<HocPhan> hocPhans) {
		this.hocPhans = hocPhans;
	}
	
	public void thongKeKetQua() {
		int sumMonHocCoDiem = 0 ;
		int sumTinChi=0;
		double sumDiemThanhPhan =0;
		for (HocPhan hocPhan : hocPhans) {	
			if(hocPhan.getScore1() > 0
				&& hocPhan.getScore2() >0
				&& hocPhan.getScore3() >0		
			) {
				sumTinChi+=hocPhan.getSoTinChi();
				sumDiemThanhPhan +=hocPhan.getScoreFinal();
				sumMonHocCoDiem++;
			}	
		}
		double tbTichLuyHe10 = sumDiemThanhPhan/(sumMonHocCoDiem*1.0);
		double tbTichLuy = tbTichLuyHe10 * 0.4;
		
		if(tbTichLuy < 2.0) {
			this.setXepLoaiTichLuy("Yếu");
		}else if(tbTichLuy < 2.5) {
			this.setXepLoaiTichLuy("Trung bình");
		}else if(tbTichLuy < 3.2) {
			this.setXepLoaiTichLuy("Khá");
		}else if(tbTichLuy < 3.6) {
			this.setXepLoaiTichLuy("Giỏi");
		}else if(tbTichLuy < 4.0){
			this.setXepLoaiTichLuy("Xuất sắc");
		}else {
			this.setXepLoaiTichLuy("");
		}
		// Sử dụng DecimalFormat để làm tròn đến 2 số thập phân
        DecimalFormat df = new DecimalFormat("#.##");
        
        this.setDiemTBTichLuy(Double.parseDouble(df.format(tbTichLuyHe10)));
		this.setTongTinChiTichLuy(sumTinChi);
	}
	
	
}
