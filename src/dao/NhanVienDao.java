package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entiy.NhanVien;

public class NhanVienDao implements DAOInterface<NhanVien>{
	private Connection con;
	@Override
	public List<NhanVien> getAll() {
		List<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		con = ConnectDB.getConnection();
		try {
			String sql = "select * from NhanVien";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
				dsNhanVien.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getDate(4), rs.getString(3), rs.getString(5), rs.getString(7), rs.getString(6), rs.getString(8), rs.getString(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	@Override
	public int insert(NhanVien t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "insert into NhanVien"
					+ " values (dbo.AUTO_IDNV(), '"+t.getHoTen()+"', '"+t.getGioiTinh()+"', '"+t.getNgaySinh()+"', '"+t.getEmail()+"', '"+t.getDiaChi()+"', '"+t.getSdt()+"', '"+t.getMatkhau()+"', '"+t.getQuyenTruyCap()+"')";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(NhanVien t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "update NhanVien "+
					"set HOTENNV = '"+t.getHoTen()+"'"+
					", GIOITINHNV = '"+t.getGioiTinh()+"'"+
					", NGAYSINHNV = '"+t.getNgaySinh()+"'"+
					", EMAIL = '"+t.getEmail()+"'"+
					", DIACHINV = '"+t.getDiaChi()+"'"+
					", SODIENTHOAINV = '"+t.getSdt()+"'"+
					", MATKHAU = '"+t.getMatkhau()+"'"+
					", QUYENTRUYCAP = '"+t.getQuyenTruyCap()+"'"+
					" where MANV = '"+t.getMaNV()+"'";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(NhanVien t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "delete from NhanVien "+
						" where MANV = '"+t.getMaNV()+"'";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public NhanVien selectByID(NhanVien t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
