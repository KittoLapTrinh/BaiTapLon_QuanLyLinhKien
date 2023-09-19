package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;

import connectDB.ConnectDB;
import dao.TrangChuDao;

import javax.swing.border.EtchedBorder;

public class frm_Main extends JFrame {

	private JPanel contentPane;
	private TrangChuDao trangChu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frm_Main frame = new frm_Main();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public frm_Main() {
		//kết nối SQL
				try {
					ConnectDB.getInstance().connect();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				trangChu = new TrangChuDao();
		setTitle("Quản lý linh kiện");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(new Color(184, 186, 199));
		panelWest.setBounds(0, 0, 207, 663);
		contentPane.add(panelWest);
		panelWest.setLayout(null);
		
		JButton btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setForeground(new Color(255, 255, 255));
		btnTrangChu.setFont(new Font("Arial", Font.PLAIN, 20));
		btnTrangChu.setBackground(new Color(192, 192, 192));
		btnTrangChu.setBounds(10, 67, 187, 47);
		btnTrangChu.setIcon(new ImageIcon(getClass().getResource("/images_menu/trangchu11.png")));
		panelWest.add(btnTrangChu);
		
		
		JButton btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\donhang.png"));
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoaDon.setForeground(Color.RED);
		btnHoaDon.setFont(new Font("Arial", Font.PLAIN, 20));
		btnHoaDon.setBackground(Color.LIGHT_GRAY);
		btnHoaDon.setBounds(10, 135, 187, 47);
		panelWest.add(btnHoaDon);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\acount11.png"));
		btnKhachHang.setForeground(Color.RED);
		btnKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		btnKhachHang.setBackground(Color.LIGHT_GRAY);
		btnKhachHang.setBounds(10, 207, 187, 47);
		panelWest.add(btnKhachHang);
		
		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\acount11.png"));
		btnNhanVien.setForeground(Color.RED);
		btnNhanVien.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNhanVien.setBackground(Color.LIGHT_GRAY);
		btnNhanVien.setBounds(10, 352, 187, 47);
		panelWest.add(btnNhanVien);
		
		JButton btnLinhKien = new JButton("Linh kiện");
		btnLinhKien.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\linhKien11.png"));
		btnLinhKien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLinhKien.setForeground(Color.RED);
		btnLinhKien.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLinhKien.setBackground(Color.LIGHT_GRAY);
		btnLinhKien.setBounds(10, 278, 187, 47);
		panelWest.add(btnLinhKien);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\dangxuat.png"));
		btnDangXuat.setForeground(Color.RED);
		btnDangXuat.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDangXuat.setBackground(Color.LIGHT_GRAY);
		btnDangXuat.setBounds(10, 426, 187, 47);
		panelWest.add(btnDangXuat);
		
		JPanel panelNhom16 = new JPanel();
		panelNhom16.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00E0nh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNhom16.setBounds(10, 495, 187, 158);
		panelWest.add(panelNhom16);
		panelNhom16.setLayout(null);
		
		JLabel lbTTK = new JLabel("Trần Tuấn Kiệt");
		lbTTK.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\acount11.png"));
		lbTTK.setFont(new Font("Arial", Font.BOLD, 15));
		lbTTK.setBounds(10, 20, 167, 32);
		panelNhom16.add(lbTTK);
		
		JLabel lbNVT = new JLabel("Ngô Văn Toàn");
		lbNVT.setFont(new Font("Arial", Font.BOLD, 15));
		lbNVT.setBounds(10, 62, 167, 32);
		panelNhom16.add(lbNVT);
		
		JLabel lbDTK = new JLabel("Dương Tuấn Kiệt");
		lbDTK.setFont(new Font("Arial", Font.BOLD, 15));
		lbDTK.setBounds(10, 98, 167, 20);
		panelNhom16.add(lbDTK);
		
		JLabel lbNTTD = new JLabel("Nguyễn Tấn T.Dương");
		lbNTTD.setFont(new Font("Arial", Font.BOLD, 15));
		lbNTTD.setBounds(10, 128, 167, 20);
		panelNhom16.add(lbNTTD);
		
		JLabel lblNewLabel = new JLabel("Nhóm 16");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 187, 32);
		panelWest.add(lblNewLabel);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(192, 192, 192));
		panelMain.setBounds(269, 0, 917, 663);
		contentPane.add(panelMain);
		panelMain.setLayout(new CardLayout(0, 0));
		
		frm_TrangChu frm_TrangChu = new frm_TrangChu();
		panelMain.setLayout(new java.awt.BorderLayout());
		panelMain.removeAll();
		panelMain.add(frm_TrangChu);
		panelMain.revalidate();
		btnTrangChu.setBackground(Color.GRAY);
		
		btnTrangChu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_TrangChu frm_TrangChu = new frm_TrangChu();
				panelMain.setLayout(new java.awt.BorderLayout());
				panelMain.removeAll();
				panelMain.add(frm_TrangChu);
				panelMain.revalidate();
				btnTrangChu.setBackground(Color.GRAY);
				btnHoaDon.setBackground(Color.LIGHT_GRAY);
				btnKhachHang.setBackground(Color.LIGHT_GRAY);
				btnLinhKien.setBackground(Color.LIGHT_GRAY);
				btnNhanVien.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnHoaDon.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_HoaDon frm_HoaDon = new frm_HoaDon();
				panelMain.setLayout(new java.awt.BorderLayout());
				panelMain.removeAll();
				panelMain.add(frm_HoaDon);
				btnHoaDon.setBackground(Color.GRAY);
				btnTrangChu.setBackground(Color.LIGHT_GRAY);
				btnKhachHang.setBackground(Color.LIGHT_GRAY);
				btnLinhKien.setBackground(Color.LIGHT_GRAY);
				btnNhanVien.setBackground(Color.LIGHT_GRAY);
				panelMain.revalidate();
			}
		});
		btnKhachHang.addMouseListener(new MouseListener() {
			
			private frm_KhachHang frm_KhachHang;

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_KhachHang = new frm_KhachHang();
				panelMain.setLayout(new java.awt.BorderLayout());
				panelMain.removeAll();
				panelMain.add(frm_KhachHang);
				btnKhachHang.setBackground(Color.GRAY);
				btnHoaDon.setBackground(Color.LIGHT_GRAY);
				btnLinhKien.setBackground(Color.LIGHT_GRAY);
				btnNhanVien.setBackground(Color.LIGHT_GRAY);
				btnTrangChu.setBackground(Color.LIGHT_GRAY);
				panelMain.revalidate();
			}
		});
		btnLinhKien.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_LinhKien frm_LinhKien = new frm_LinhKien();
				panelMain.setLayout(new java.awt.BorderLayout());
				panelMain.removeAll();
				panelMain.add(frm_LinhKien);
				btnLinhKien.setBackground(Color.GRAY);
				btnKhachHang.setBackground(Color.LIGHT_GRAY);
				btnHoaDon.setBackground(Color.LIGHT_GRAY);
				btnNhanVien.setBackground(Color.LIGHT_GRAY);
				btnTrangChu.setBackground(Color.LIGHT_GRAY);
				panelMain.revalidate();
			}
		});
		btnNhanVien.addMouseListener(new MouseListener() {
			
			private frm_NhanVien frm_NhanVien;

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Chức năng này chỉ dành cho người quản lý", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				frm_NhanVien = new frm_NhanVien();
				panelMain.setLayout(new java.awt.BorderLayout());
				panelMain.removeAll();
				panelMain.add(frm_NhanVien);
				btnNhanVien.setBackground(Color.GRAY);
				btnLinhKien.setBackground(Color.LIGHT_GRAY);
				btnHoaDon.setBackground(Color.LIGHT_GRAY);
				btnKhachHang.setBackground(Color.LIGHT_GRAY);
				btnTrangChu.setBackground(Color.LIGHT_GRAY);
				panelMain.revalidate();
			}
		});
		btnDangXuat.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không", "Cảnh cáo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					setVisible(false);
					frm_DangNhap dn = new frm_DangNhap();
					dn.setVisible(true);
				}
			}
		});
		
	}
}
