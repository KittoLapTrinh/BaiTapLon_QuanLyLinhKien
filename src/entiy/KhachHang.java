package entiy;

import java.util.Objects;

public class KhachHang {
	private String maKH;
	private String hoTenKH;
	private String sdt;
	private String diaChi;
	public KhachHang(String maKH, String hoTenKH, String sdt, String diaChi) {
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	
	public KhachHang(String hoTenKH, String sdt, String diaChi) {
		this.hoTenKH = hoTenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}

	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKH, other.maKH);
	}
	
}
