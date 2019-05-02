package bean;

public class sinhVienBean {

	private String maSv;
	private String tenSv;
	private boolean gioiTinh;
	private double dtb;
	public String getMaSv() {
		return maSv;
	}
	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}
	public String getTenSv() {
		return tenSv;
	}
	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public double getDtb() {
		return dtb;
	}
	public void setDtb(double dtb) {
		this.dtb = dtb;
	}
	public sinhVienBean(String maSv, String tenSv, boolean gioiTinh, double dtb) {
		super();
		this.maSv = maSv;
		this.tenSv = tenSv;
		this.gioiTinh = gioiTinh;
		this.dtb = dtb;
	}
	
}
