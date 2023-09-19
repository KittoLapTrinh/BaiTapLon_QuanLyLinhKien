package entiy;

public class CT_HoaDon {
	private HoaDon hoaDon;
	private LinhKien linhKien;
	private int soLuong;
	public CT_HoaDon(HoaDon hoaDon, LinhKien linhKien, int soLuong) {
		this.hoaDon = hoaDon;
		this.linhKien = linhKien;
		this.soLuong = soLuong;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public LinhKien getLinhKien() {
		return linhKien;
	}
	public void setLinhKien(LinhKien linhKien) {
		this.linhKien = linhKien;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
}
