package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entiy.NhanVien;

public class TaiKhoan_Dao {
	private ConnectDB con;
	private NhanVien nv;
	
	public TaiKhoan_Dao() {

	}
//	public ArrayList<TaiKhoan> getAllNhanVien() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	//kiet
	public boolean timKiemTen(String maNV,String matkhau) {
		NhanVien nv = null;
		try {
			PreparedStatement stmt = null;
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			stmt = con.prepareStatement("select * from NhanVien where MANV = ? and MATKHAU = ?");
			stmt.setString(1, maNV);
			stmt.setString(2, matkhau);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				nv = new NhanVien(rs.getString("MANV"),rs.getString("MATKHAU"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(nv.getMaNV()!=null) {
			return true;
		}
		return false;
	}
	
//	public String TimKiemMatKhauByMa(String maNV){
//        String nv = null;
//        try{
//            PreparedStatement stmt = con.prepareStatement("select matkhau from NhanVien where maNV = ?");
//            stmt.setString(1,maNV);
//            ResultSet rs = stmt.executeQuery();
//            while(rs.next()) {
//                nv = new NhanVien(rs.getString(1)).getMatkhau();
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return nv;
//    }
}
