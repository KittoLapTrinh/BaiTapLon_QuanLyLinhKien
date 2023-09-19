package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.TrangChuDao;
import entiy.LinhKien;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class frm_TrangChu extends JPanel {
	private TrangChuDao trangChu;
	private frm_CTLinhKien ctLinhKien;
	private JTextField txtTim;
	private DefaultTableModel tableModel, tableModel1;
	private JTable table;
	private JTextField txtMaHD;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtNgayLapHD;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTable table_1;
	private JTextField txtTongTien;
	private JTextField txtTienKhachTra;
	private JTextField txtTienThoi;
	private JTextField txtSoLuong;

	/**
	 * Create the panel.
	 */
	public frm_TrangChu() {
		//kết nối SQL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		trangChu = new TrangChuDao();
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 458, 663);
		add(panel);
		panel.setLayout(null);
		
		JLabel lbTimKiem = new JLabel("Tìm kiếm theo: ");
		lbTimKiem.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\search11.png"));
		lbTimKiem.setForeground(new Color(0, 0, 0));
		lbTimKiem.setFont(new Font("Arial", Font.BOLD, 17));
		lbTimKiem.setBounds(10, 43, 165, 29);
		panel.add(lbTimKiem);
		
		JComboBox comboBox_TimKiem = new JComboBox();
		comboBox_TimKiem.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox_TimKiem.setModel(new DefaultComboBoxModel(new String[] {"Tên linh kiện", "Mã linh kiện"}));
		comboBox_TimKiem.setBounds(10, 76, 98, 21);
		panel.add(comboBox_TimKiem);
		
		txtTim = new JTextField();
		txtTim.setBounds(128, 76, 225, 21);
		panel.add(txtTim);
		txtTim.setColumns(10);
		

//		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3", "T\u00EAn linh ki\u1EC7n", "Th\u01B0\u01A1ng hi\u1EC7u", "SL", "\u0110\u01A1n gi\u00E1"
			}
		));
		//load dữ liệu
		table.setRowHeight(25);
		for(LinhKien lk : trangChu.getAll()) {
			Object[] rowData = {lk.getMaLK(), lk.getTenLK(), lk.getThuongHieu(), lk.getSoLuongTon(), lk.getDonGia()};
			tableModel.addRow(rowData);
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(54);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setMinWidth(21);
		table.getColumnModel().getColumn(3).setPreferredWidth(42);
		table.setBounds(10, 136, 438, 428);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 136, 438, 428);
		panel.add(scrollPane);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setBackground(new Color(0, 128, 255));
		btnThem.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\linhKien11.png"));
		btnThem.setFont(new Font("Arial", Font.BOLD, 20));
		btnThem.setBounds(259, 620, 189, 36);
		panel.add(btnThem);
		
		JButton btnFirst = new JButton("<<");
		btnFirst.setForeground(new Color(255, 255, 255));
		btnFirst.setBackground(new Color(128, 128, 128));
		btnFirst.setFont(new Font("Arial", Font.PLAIN, 10));
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFirst.setBounds(10, 582, 47, 21);
		panel.add(btnFirst);
		
		JButton btnBack = new JButton("<");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(128, 128, 128));
		btnBack.setFont(new Font("Arial", Font.PLAIN, 10));
		btnBack.setBounds(61, 582, 47, 21);
		panel.add(btnBack);
		
		JButton btnNext = new JButton(">");
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.setBackground(new Color(128, 128, 128));
		btnNext.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNext.setBounds(116, 582, 47, 21);
		panel.add(btnNext);
		
		JButton btnLast = new JButton(">>");
		btnLast.setForeground(new Color(255, 255, 255));
		btnLast.setBackground(new Color(128, 128, 128));
		btnLast.setFont(new Font("Arial", Font.PLAIN, 10));
		btnLast.setBounds(168, 582, 47, 21);
		panel.add(btnLast);
		
		JPanel panelLinhKien = new JPanel();
		panelLinhKien.setLayout(null);
		panelLinhKien.setBackground(new Color(0, 128, 0));
		panelLinhKien.setBounds(0, 0, 458, 36);
		panel.add(panelLinhKien);
		
		JLabel lbThongTin = new JLabel("Thông tin linh kiện");
		lbThongTin.setBounds(0, 0, 448, 33);
		panelLinhKien.add(lbThongTin);
		lbThongTin.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\thongtin.png"));
		lbThongTin.setForeground(new Color(255, 255, 255));
		lbThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lbThongTin.setFont(new Font("Arial", Font.BOLD, 25));
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("Arial", Font.BOLD, 15));
		btnTim.setBackground(new Color(0, 128, 255));
		btnTim.setBounds(363, 76, 85, 26);
		panel.add(btnTim);
		
		JLabel lbSoLuong = new JLabel("Số lượng: ");
		lbSoLuong.setFont(new Font("Arial", Font.BOLD, 15));
		lbSoLuong.setBounds(259, 574, 85, 29);
		panel.add(lbSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(336, 574, 96, 23);
		panel.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(459, 0, 458, 663);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbMaHD = new JLabel("Mã HD: ");
		lbMaHD.setFont(new Font("Arial", Font.BOLD, 15));
		lbMaHD.setBounds(10, 45, 59, 22);
		panel_1.add(lbMaHD);
		
		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setBounds(73, 45, 147, 21);
		panel_1.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		JLabel lbMaKH = new JLabel("Mã KH: ");
		lbMaKH.setFont(new Font("Arial", Font.BOLD, 15));
		lbMaKH.setBounds(235, 45, 59, 22);
		panel_1.add(lbMaKH);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(301, 45, 147, 21);
		panel_1.add(txtMaKH);
		
		JLabel lbTenKH = new JLabel("Tên KH: ");
		lbTenKH.setFont(new Font("Arial", Font.BOLD, 15));
		lbTenKH.setBounds(10, 77, 69, 22);
		panel_1.add(lbTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(73, 76, 147, 21);
		panel_1.add(txtTenKH);
		
		JLabel lbNgayLapHD = new JLabel("Ngày lập HD: ");
		lbNgayLapHD.setFont(new Font("Arial", Font.BOLD, 15));
		lbNgayLapHD.setBounds(235, 77, 99, 22);
		panel_1.add(lbNgayLapHD);
		
		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setColumns(10);
		txtNgayLapHD.setBounds(335, 76, 113, 21);
		panel_1.add(txtNgayLapHD);
		
		JLabel lbSDT = new JLabel("SĐT: ");
		lbSDT.setFont(new Font("Arial", Font.BOLD, 15));
		lbSDT.setBounds(10, 108, 69, 22);
		panel_1.add(lbSDT);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(73, 109, 147, 21);
		panel_1.add(txtSDT);
		
		JLabel lbDiaChi = new JLabel("Địa chỉ: ");
		lbDiaChi.setFont(new Font("Arial", Font.BOLD, 15));
		lbDiaChi.setBounds(235, 109, 69, 22);
		panel_1.add(lbDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(301, 109, 147, 21);
		panel_1.add(txtDiaChi);
		
		table_1 = new JTable();
		table_1.setModel(tableModel1 = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 linh ki\u1EC7n", "T\u00EAn linh ki\u1EC7n", "SL", "\u0110\u01A1n gi\u00E1", "B\u1EA3o h\u00E0nh", "T\u1ED5ng ti\u1EC1n"
			}
		));
		table_1.setBounds(0, 0, 1, 1);
		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setBounds(10, 140, 438, 379);
		panel_1.add(scrollPane_1);
		
		JPanel panel_ThanhToan = new JPanel();
		panel_ThanhToan.setBounds(10, 529, 251, 124);
		panel_ThanhToan.setBorder(BorderFactory.createTitledBorder("Thanh toán"));
		panel_1.add(panel_ThanhToan);
		panel_ThanhToan.setLayout(null);
		
		JLabel lbTongTien = new JLabel("Tổng tiền: ");
		lbTongTien.setForeground(new Color(255, 0, 0));
		lbTongTien.setFont(new Font("Arial", Font.BOLD, 15));
		lbTongTien.setBounds(10, 20, 85, 25);
		panel_ThanhToan.add(lbTongTien);
		
		txtTongTien = new JTextField();
		txtTongTien.setEditable(false);
		txtTongTien.setBounds(95, 20, 146, 21);
		panel_ThanhToan.add(txtTongTien);
		txtTongTien.setColumns(10);
		
		JLabel lbTienKhachTra = new JLabel("Tiền khách trả: ");
		lbTienKhachTra.setForeground(Color.RED);
		lbTienKhachTra.setFont(new Font("Arial", Font.BOLD, 15));
		lbTienKhachTra.setBounds(10, 55, 116, 25);
		panel_ThanhToan.add(lbTienKhachTra);
		
		JLabel lbTienThoi = new JLabel("Tiền thối: ");
		lbTienThoi.setForeground(Color.RED);
		lbTienThoi.setFont(new Font("Arial", Font.BOLD, 15));
		lbTienThoi.setBounds(10, 89, 85, 25);
		panel_ThanhToan.add(lbTienThoi);
		
		txtTienKhachTra = new JTextField();
		txtTienKhachTra.setColumns(10);
		txtTienKhachTra.setBounds(125, 55, 116, 21);
		panel_ThanhToan.add(txtTienKhachTra);
		
		txtTienThoi = new JTextField();
		txtTienThoi.setEditable(false);
		txtTienThoi.setColumns(10);
		txtTienThoi.setBounds(95, 90, 146, 21);
		panel_ThanhToan.add(txtTienThoi);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(255, 255, 255));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setFont(new Font("Arial", Font.BOLD, 12));
		btnXoa.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\xoa.png"));
		btnXoa.setBounds(271, 530, 177, 56);
		panel_1.add(btnXoa);
		
		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setForeground(new Color(255, 255, 255));
		btnThanhToan.setBackground(new Color(0, 128, 0));
		btnThanhToan.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\thanhtoan.png"));
		btnThanhToan.setFont(new Font("Arial", Font.BOLD, 15));
		btnThanhToan.setBounds(271, 596, 180, 56);
		panel_1.add(btnThanhToan);
		
		JPanel panelLinhKien_1 = new JPanel();
		panelLinhKien_1.setLayout(null);
		panelLinhKien_1.setBackground(new Color(0, 0, 255));
		panelLinhKien_1.setBounds(0, 0, 458, 36);
		panel_1.add(panelLinhKien_1);
		
		JLabel lbHoaDon = new JLabel("Hóa đơn đặt hàng");
		lbHoaDon.setBackground(new Color(0, 0, 255));
		lbHoaDon.setBounds(0, 0, 458, 33);
		panelLinhKien_1.add(lbHoaDon);
		lbHoaDon.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\donhang.png"));
		lbHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lbHoaDon.setForeground(new Color(255, 255, 255));
		lbHoaDon.setFont(new Font("Arial", Font.BOLD, 25));

		btnFirst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				trangChu.first();
			}
		});
	}
}
