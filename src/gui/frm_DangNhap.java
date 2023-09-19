package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.NhanVienDao;
import dao.TaiKhoan_Dao;
import entiy.NhanVien;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class frm_DangNhap extends JFrame {
	static frm_Main main; 
	private JPanel contentPane;
	private JTextField txtDangNhap;
	private JLabel lbMatKhau;
	private JPasswordField passwordField;
	private NhanVienDao nv_dao = new NhanVienDao();
	private TaiKhoan_Dao tk_Dao = new TaiKhoan_Dao();
	private frm_TrangChu trangchu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_DangNhap frame = new frm_DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_DangNhap() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
		e.printStackTrace();
		}
		setTitle("Đăng nhập");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitle = new JLabel("Đăng nhập hệ thống");
		lbTitle.setForeground(new Color(255, 0, 0));
		lbTitle.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\dangnhapHT.png"));
		lbTitle.setFont(new Font("Arial", Font.PLAIN, 23));
		lbTitle.setBounds(170, 10, 282, 42);
		contentPane.add(lbTitle);
		
		JLabel lbTen = new JLabel("Tên đăng nhập: ");
		lbTen.setForeground(new Color(64, 0, 64));
		lbTen.setFont(new Font("Arial", Font.PLAIN, 18));
		lbTen.setBounds(74, 80, 157, 28);
		contentPane.add(lbTen);
		
		txtDangNhap = new JTextField();
		txtDangNhap.setBounds(241, 83, 230, 27);
		contentPane.add(txtDangNhap);
		txtDangNhap.setColumns(10);
		
		lbMatKhau = new JLabel("Mật khẩu: ");
		lbMatKhau.setForeground(new Color(64, 0, 64));
		lbMatKhau.setFont(new Font("Arial", Font.PLAIN, 18));
		lbMatKhau.setBounds(74, 118, 157, 28);
		contentPane.add(lbMatKhau);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(241, 121, 230, 27);
		contentPane.add(passwordField);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBackground(new Color(0, 128, 0));
		btnDangNhap.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangNhap.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\login.png"));
		btnDangNhap.setBounds(109, 186, 157, 38);
		contentPane.add(btnDangNhap);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\log-out.png"));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThoat.setBackground(new Color(255, 0, 0));
		btnThoat.setBounds(339, 186, 157, 38);
		contentPane.add(btnThoat);

		TaiKhoan_Dao tk_Dao = new TaiKhoan_Dao();
		btnDangNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtDangNhap.getText()+String.valueOf(passwordField.getPassword()));
				if(tk_Dao.timKiemTen(txtDangNhap.getText(),String.valueOf(passwordField.getPassword()))==true) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					main=new frm_Main();
					main.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Dang nhap ","Dang nhap that bai", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?", "Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					setVisible(false);				
			}
		});
		
	}

}
