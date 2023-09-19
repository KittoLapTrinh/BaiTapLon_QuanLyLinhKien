package entiy;

import java.sql.Date;
import java.util.Objects;

public class LinhKien {
	private String maLK;
	private String tenLK;
	private String moTaLK;
	private double donGia;
	private String loaiLK;
	private String thuongHieu;
	private int soLuongTon;
	private Date ngayNhap;
	private int baoHanh;
	public LinhKien(String maLK, String tenLK, String moTaLK, double donGia, String loaiLK, String thuongHieu,
			int soLuongTon, Date ngayNhap, int baoHanh) {
		this.maLK = maLK;
		this.tenLK = tenLK;
		this.moTaLK = moTaLK;
		this.donGia = donGia;
		this.loaiLK = loaiLK;
		this.thuongHieu = thuongHieu;
		this.soLuongTon = soLuongTon;
		this.ngayNhap = ngayNhap;
		this.baoHanh = baoHanh;
	}
	public String getMaLK() {
		return maLK;
	}
	public void setMaLK(String maLK) {
		this.maLK = maLK;
	}
	public String getTenLK() {
		return tenLK;
	}
	public void setTenLK(String tenLK) {
		this.tenLK = tenLK;
	}
	public String getMoTaLK() {
		return moTaLK;
	}
	public void setMoTaLK(String moTaLK) {
		this.moTaLK = moTaLK;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getLoaiLK() {
		return loaiLK;
	}
	public void setLoaiLK(String loaiLK) {
		this.loaiLK = loaiLK;
	}
	public String getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public int getBaoHanh() {
		return baoHanh;
	}
	public void setBaoHanh(int baoHanh) {
		this.baoHanh = baoHanh;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLK);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		LinhKien other = (LinhKien) obj;
		return Objects.equals(maLK, other.maLK);
	}
	
}
