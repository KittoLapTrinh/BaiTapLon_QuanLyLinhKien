package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entiy.LinhKien;

public class TrangChuDao implements DAOInterface<LinhKien>{

	@Override
	public List<LinhKien> getAll() {
		List<LinhKien> dsLinhKien = new ArrayList<LinhKien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LinhKien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				dsLinhKien.add(new LinhKien(rs.getString("MALK"), rs.getString("TENLK"), rs.getString("MOTALK"), rs.getDouble("DONGIA"), rs.getString("LOAILK"), rs.getString("THUONGHIEU"), rs.getInt("SOLUONGTON"), rs.getDate("NGAYNHAP"), rs.getInt("BAOHANH")));
			}
//			ConnectDB.getInstance().disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsLinhKien;
	}

	@Override
	public int insert(LinhKien t) {
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			//Bước 3: Thực thi câu lệnh SQL
			String sql = "insert into LinhKien(MALK, TENLK, SOLUONGTON, DONGIA, BAOHANH)"+
						" values('"+t.getMaLK()+"','"+ t.getTenLK()+ "', "+ t.getSoLuongTon()+", "+ t.getDonGia()+", "+t.getBaoHanh()+")";
			ResultSet rs = st.executeQuery(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(LinhKien t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "update LinhKien "+
					" set MALK = '"+t.getMaLK()+"'"+
					", TENLK = '"+t.getTenLK()+"'"+
					", MOTALK = '"+t.getMoTaLK()+"'"+
					", DONGIA = '"+t.getDonGia()+"'"+
					", LOAILK = '"+t.getLoaiLK()+"'"+
					", THUONGHIEU = '"+t.getThuongHieu()+"'"+
					", SOLUONGTON = '"+t.getSoLuongTon()+"'"+
					", NGAYNHAP = '"+t.getNgayNhap()+"'"+
					", BAOHANH = '"+t.getBaoHanh()+"'"+
					"where MALK = '"+t.getMaLK()+"'";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(LinhKien t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "delete from LinhKien "+
					" where MALK = '"+t.getMaLK()+"'";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public LinhKien selectByID(LinhKien t) {
		LinhKien lk = null;
		try {
			//Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.getConnection();
			//Bước 2: Tạo ra đối tượng statement
			Statement st = con.createStatement();
			//Bước 3: Thực thi câu lệnh SQL
			String sql = "select * from LinhKien where MALK = '"+t.getMaLK()+"'";
			ResultSet rs = st.executeQuery(sql);
			//Bước 4:
			while(rs.next()) {
				lk = new LinhKien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lk;
	}
	public void first() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from LinhKien";
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			rs.first();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
