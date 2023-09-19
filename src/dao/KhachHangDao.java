package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entiy.KhachHang;

public class KhachHangDao implements DAOInterface<KhachHang>{

	@Override
	public List<KhachHang> getAll() {
		List<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "select * from KhachHang";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				dsKhachHang.add(new KhachHang(rs.getString("MAKH"), rs.getString("HOTENKH"), rs.getString("SODIENTHOAIKH"), rs.getString("DIACHIKH")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "insert into KhachHang"
					+ " values (dbo.AUTO_IDKH(), '"+t.getHoTenKH()+"', '"+t.getSdt()+"', '"+t.getDiaChi()+"')";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "update KhachHang "+
						" set HOTENKH = '"+t.getHoTenKH()+"'"+
						", SODIENTHOAIKH = '"+t.getSdt()+"'"+
						", DIACHIKH = '"+t.getDiaChi()+"'"+
						"where MAKH = '"+t.getMaKH()+"'";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "delete from KhachHang "+
						" where MAKH = '"+t.getMaKH()+"'";
			ketQua = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public KhachHang selectByID(KhachHang t) {
		
		return null;
	}


}
