package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import entiy.LinhKien;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class frm_CTLinhKien extends JFrame {
	private frm_TrangChu trangChu;
	private JPanel contentPane;
	private JTextField txtMaLK;
	private JTextField txtNgayNhap;
	private JTextField txtTenLK;
	private JLabel jlbMoTaLK;
	private JTextField txtThuongHieu;
	private JTextField txtSLT;
	private JTextField txtLoai;
	private JTextField txtDonGia;
	private JTextField txtBaoHanh;
	private JTextArea txtMoTa;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frm_CTLinhKien frame = new frm_CTLinhKien();
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
	public frm_CTLinhKien() {
		setFont(new Font("Arial", Font.BOLD, 16));
		setTitle("Chi tiết linh kiện");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 656);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBounds(0, 0, 774, 53);
		pnTieuDe.setBackground(new Color(0, 128, 0));
		contentPane.add(pnTieuDe);
		pnTieuDe.setLayout(null);
		
		JLabel jlbTieuDe = new JLabel("Chi tiết linh kiện");
		jlbTieuDe.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QuanLyLinhKien\\src\\images_menu\\note.png"));
		jlbTieuDe.setForeground(new Color(255, 255, 255));
		jlbTieuDe.setFont(new Font("Arial", Font.BOLD, 26));
		jlbTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		jlbTieuDe.setBounds(208, 10, 387, 34);
		pnTieuDe.add(jlbTieuDe);
		
		JLabel jlbMaLK = new JLabel("Mã linh kiện: ");
		jlbMaLK.setBounds(38, 84, 133, 29);
		jlbMaLK.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(jlbMaLK);
		
		JLabel jlbNgayNhap = new JLabel("Ngày nhập: ");
		jlbNgayNhap.setBounds(470, 84, 133, 29);
		jlbNgayNhap.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(jlbNgayNhap);
		
		txtMaLK = new JTextField();
		txtMaLK.setEditable(false);
		txtMaLK.setFont(new Font("Arial", Font.BOLD, 16));
		txtMaLK.setBounds(175, 84, 158, 29);
		contentPane.add(txtMaLK);
		txtMaLK.setColumns(10);
		
		txtNgayNhap = new JTextField();
		txtNgayNhap.setEditable(false);
		txtNgayNhap.setFont(new Font("Arial", Font.BOLD, 16));
		txtNgayNhap.setBounds(594, 84, 158, 29);
		contentPane.add(txtNgayNhap);
		txtNgayNhap.setColumns(10);
		
		JLabel jlbTenLK = new JLabel("Tên linh kiện: ");
		jlbTenLK.setBounds(38, 134, 133, 40);
		jlbTenLK.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(jlbTenLK);
		
		txtTenLK = new JTextField();
		txtTenLK.setEditable(false);
		txtTenLK.setFont(new Font("Arial", Font.BOLD, 16));
		txtTenLK.setBounds(175, 137, 577, 64);
		contentPane.add(txtTenLK);
		txtTenLK.setColumns(10);
		
		JLabel jlbThuongHieu = new JLabel("Thương hiệu: ");
		jlbThuongHieu.setBounds(38, 240, 152, 29);
		jlbThuongHieu.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(jlbThuongHieu);
		
		JLabel jlbLoai = new JLabel("Loại: ");
		jlbLoai.setBounds(470, 245, 85, 19);
		jlbLoai.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(jlbLoai);
		
		JLabel jlbSLT = new JLabel("Số lượng tồn: ");
		jlbSLT.setBounds(38, 296, 128, 29);
		jlbSLT.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(jlbSLT);
		
		JLabel jlbDonGia = new JLabel("Đơn giá: ");
		jlbDonGia.setBounds(470, 296, 101, 24);
		jlbDonGia.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(jlbDonGia);
		
		jlbMoTaLK = new JLabel("Mô tả linh kiện: ");
		jlbMoTaLK.setBounds(38, 367, 179, 29);
		jlbMoTaLK.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(jlbMoTaLK);
		
		JLabel jlbBaoHanh = new JLabel("Bảo hành: ");
		jlbBaoHanh.setBounds(470, 349, 133, 29);
		jlbBaoHanh.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(jlbBaoHanh);
		
		txtThuongHieu = new JTextField();
		txtThuongHieu.setEditable(false);
		txtThuongHieu.setFont(new Font("Arial", Font.BOLD, 16));
		txtThuongHieu.setBounds(175, 240, 184, 29);
		contentPane.add(txtThuongHieu);
		txtThuongHieu.setColumns(10);
		
		txtSLT = new JTextField();
		txtSLT.setEditable(false);
		txtSLT.setFont(new Font("Arial", Font.BOLD, 16));
		txtSLT.setBounds(175, 296, 184, 29);
		contentPane.add(txtSLT);
		txtSLT.setColumns(10);
		
		txtLoai = new JTextField();
		txtLoai.setEditable(false);
		txtLoai.setFont(new Font("Arial", Font.BOLD, 16));
		txtLoai.setBounds(594, 240, 158, 29);
		contentPane.add(txtLoai);
		txtLoai.setColumns(10);
		
		txtDonGia = new JTextField();
		txtDonGia.setEditable(false);
		txtDonGia.setBounds(594, 296, 158, 29);
		contentPane.add(txtDonGia);
		txtDonGia.setColumns(10);
		
		txtBaoHanh = new JTextField();
		txtBaoHanh.setEditable(false);
		txtBaoHanh.setFont(new Font("Arial", Font.BOLD, 16));
		txtBaoHanh.setBounds(594, 349, 158, 26);
		contentPane.add(txtBaoHanh);
		txtBaoHanh.setColumns(10);
		
		JButton btThoat = new JButton("Thoát");
		btThoat.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QuanLyLinhKien\\src\\images_menu\\thoat.png"));
		btThoat.setForeground(new Color(255, 255, 255));
		btThoat.setBounds(636, 557, 116, 40);
		btThoat.setBackground(new Color(255, 0, 0));
		btThoat.setFont(new Font("Arial", Font.BOLD, 16));
		contentPane.add(btThoat);
		
		txtMoTa = new JTextArea();
		txtMoTa.setRows(25);
		txtMoTa.setBounds(38, 406, 712, 141);
		contentPane.add(txtMoTa);
		
		btThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	public void getDataFromTable(String ma, String ten, String mota, double donGia, String loai, String thuongHieu, int sl, Date ngayNhap, int baoHanh) {
		LinhKien lk = new LinhKien(ma, ten, mota, donGia, loai, thuongHieu, sl, ngayNhap, baoHanh);
		txtMaLK.setText(lk.getMaLK());
		txtNgayNhap.setText(String.valueOf(lk.getNgayNhap()));
		txtTenLK.setText(lk.getTenLK());
		txtThuongHieu.setText(lk.getThuongHieu());
		txtLoai.setText(lk.getLoaiLK());
		txtSLT.setText(String.valueOf(lk.getSoLuongTon()));
		txtDonGia.setText(String.valueOf(lk.getDonGia()));
		txtBaoHanh.setText(String.valueOf(lk.getBaoHanh()));
		txtMoTa.setText(lk.getMoTaLK());
	}
}
