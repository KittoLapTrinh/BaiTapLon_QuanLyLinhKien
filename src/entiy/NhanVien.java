package entiy;

import java.sql.Date;
import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String hoTen;
	private Date ngaySinh;
	private String gioiTinh;
	private String email;
	private String sdt;
	private String diaChi;
	private String matkhau;
	private String quyenTruyCap;
	

	public NhanVien(String maNV, String hoTen, Date ngaySinh, String gioiTinh, String email, String sdt, String diaChi,
			String matkhau, String quyenTruyCap) {
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.matkhau = matkhau;
		this.quyenTruyCap = quyenTruyCap;
	}

	public NhanVien(String maNV, String matkhau) {
		super();
		this.maNV = maNV;
		this.matkhau = matkhau;
	}

	public NhanVien(String hoTen, Date ngaySinh, String gioiTinh, String email, String sdt, String diaChi,
			String matkhau, String quyenTruyCap) {
		super();
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.matkhau = matkhau;
		this.quyenTruyCap = quyenTruyCap;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getQuyenTruyCap() {
		return quyenTruyCap;
	}
	public void setQuyenTruyCap(String quyenTruyCap) {
		this.quyenTruyCap = quyenTruyCap;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	

}
