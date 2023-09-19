package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class frm_CTHoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHD;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtNgay;
	private JTextField txtDiaChi;
	private JTextField txtSdt;
	private JTextField txtMaLK;
	private JTextField txtTenLK;
	private JTextField txtThuongHieu;
	private JTextField txtSoLuong;
	private JTextField txtDonGia;
	private JTextField txtBaoHanh;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frm_CTHoaDon frame = new frm_CTHoaDon();
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
	public frm_CTHoaDon() {
		setTitle("Chi tiết hóa đơn");
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(new Color(0, 128, 0));
		contentPane.add(pnNorth, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblNewLabel.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QuanLyLinhKien\\src\\images_menu\\note.png"));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		pnNorth.add(lblNewLabel);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(new Color(192, 192, 192));
		contentPane.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JLabel lbMaHD = new JLabel("Mã hóa đơn:");
		lbMaHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbMaHD.setBounds(10, 10, 115, 33);
		pnCenter.add(lbMaHD);
		
		JLabel lbMaKH = new JLabel("Mã khách hàng:");
		lbMaKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbMaKH.setBounds(403, 53, 115, 33);
		pnCenter.add(lbMaKH);
		
		JLabel lbTenKH = new JLabel("Tên khách hàng:");
		lbTenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTenKH.setBounds(10, 53, 115, 33);
		pnCenter.add(lbTenKH);
		
		JLabel lbSdt = new JLabel("Số điện thoại:");
		lbSdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSdt.setBounds(10, 91, 115, 33);
		pnCenter.add(lbSdt);
		
		JLabel lbNgay = new JLabel("Ngày lập HĐ:");
		lbNgay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbNgay.setBounds(403, 96, 115, 33);
		pnCenter.add(lbNgay);
		
		JLabel lbDiaChi = new JLabel("Địa chỉ:");
		lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDiaChi.setBounds(403, 134, 115, 33);
		pnCenter.add(lbDiaChi);
		
		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setBounds(125, 15, 586, 28);
		pnCenter.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(524, 58, 187, 28);
		pnCenter.add(txtMaKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(125, 53, 187, 28);
		pnCenter.add(txtTenKH);
		
		txtNgay = new JTextField();
		txtNgay.setEditable(false);
		txtNgay.setColumns(10);
		txtNgay.setBounds(524, 96, 187, 28);
		pnCenter.add(txtNgay);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(528, 134, 187, 28);
		pnCenter.add(txtDiaChi);
		
		txtSdt = new JTextField();
		txtSdt.setEditable(false);
		txtSdt.setColumns(10);
		txtSdt.setBounds(125, 96, 187, 28);
		pnCenter.add(txtSdt);
		
		JLabel lbMaLK = new JLabel("Mã linh kiện:");
		lbMaLK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbMaLK.setBounds(10, 134, 115, 33);
		pnCenter.add(lbMaLK);
		
		txtMaLK = new JTextField();
		txtMaLK.setEditable(false);
		txtMaLK.setColumns(10);
		txtMaLK.setBounds(125, 134, 187, 28);
		pnCenter.add(txtMaLK);
		
		JLabel lbTenLK = new JLabel("Tên linh kiện:");
		lbTenLK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbTenLK.setBounds(10, 191, 115, 33);
		pnCenter.add(lbTenLK);
		
		txtTenLK = new JTextField();
		txtTenLK.setEditable(false);
		txtTenLK.setColumns(10);
		txtTenLK.setBounds(125, 182, 586, 56);
		pnCenter.add(txtTenLK);
		
		JLabel lbThuongHieu = new JLabel("Thương hiệu:");
		lbThuongHieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbThuongHieu.setBounds(10, 243, 115, 33);
		pnCenter.add(lbThuongHieu);
		
		txtThuongHieu = new JTextField();
		txtThuongHieu.setEditable(false);
		txtThuongHieu.setColumns(10);
		txtThuongHieu.setBounds(125, 248, 187, 28);
		pnCenter.add(txtThuongHieu);
		
		JLabel lbSoLuong = new JLabel("Số lượng:");
		lbSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbSoLuong.setBounds(403, 248, 115, 33);
		pnCenter.add(lbSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(524, 248, 187, 28);
		pnCenter.add(txtSoLuong);
		
		JLabel lbDonGia = new JLabel("Đơn giá:");
		lbDonGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDonGia.setBounds(10, 286, 115, 33);
		pnCenter.add(lbDonGia);
		
		JLabel lblBoHnh = new JLabel("Bảo hành:");
		lblBoHnh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBoHnh.setBounds(403, 291, 115, 33);
		pnCenter.add(lblBoHnh);
		
		txtDonGia = new JTextField();
		txtDonGia.setEditable(false);
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(125, 291, 187, 28);
		pnCenter.add(txtDonGia);
		
		txtBaoHanh = new JTextField();
		txtBaoHanh.setEditable(false);
		txtBaoHanh.setColumns(10);
		txtBaoHanh.setBounds(524, 291, 187, 28);
		pnCenter.add(txtBaoHanh);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QuanLyLinhKien\\src\\images_menu\\thoat.png"));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setFont(new Font("Arial", Font.BOLD, 14));
		btnThoat.setBackground(new Color(255, 0, 0));
		btnThoat.setAlignmentY(1.0f);
		btnThoat.setAlignmentX(1.0f);
		btnThoat.setBounds(596, 356, 115, 33);
		pnCenter.add(btnThoat);
		
		JLabel lbNV = new JLabel("Nhân viên");
		lbNV.setFont(new Font("Arial", Font.BOLD, 12));
		lbNV.setBounds(10, 331, 91, 22);
		pnCenter.add(lbNV);
		
		JLabel lbKH = new JLabel("Khách hàng");
		lbKH.setFont(new Font("Arial", Font.BOLD, 12));
		lbKH.setBounds(232, 329, 91, 22);
		pnCenter.add(lbKH);
		
		btnThoat.addMouseListener(new MouseListener() {
			
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
				setVisible(false);
			}
		});
	}
}
