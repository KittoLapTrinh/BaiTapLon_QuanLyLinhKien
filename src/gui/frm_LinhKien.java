package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.LinhKienDao;
import dao.TrangChuDao;
import entiy.KhachHang;
import entiy.LinhKien;

public class frm_LinhKien extends JPanel {
	private LinhKienDao linhKien;
	private frm_CTLinhKien ctLinhKien;
	private LinhKien lKien;
	private JTextField txtMaLK;
	private JTextField txtSoLuong;
	private JTextField txtMoTa;
	private JTextField txtTenLK;
	private JTextField txtDonGia;
	private JTextField txtLoaiLK;
	private JTextField txtThuongHieu;
	private JTextField txtNgayNhap;
	private JTextField txtBaoHanh;
	private JTextField txtTim;
	private DefaultTableModel tableModel;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public frm_LinhKien() {
		//kết nối SQL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		linhKien = new LinhKienDao();
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JPanel panelLinhKien = new JPanel();
		panelLinhKien.setLayout(null);
		panelLinhKien.setBackground(new Color(0, 128, 0));
		panelLinhKien.setBounds(0, 0, 917, 47);
		add(panelLinhKien);
		
		JLabel lbLinhKien = new JLabel("Quản lý linh kiện");
		lbLinhKien.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\linhKien11.png"));
		lbLinhKien.setHorizontalAlignment(SwingConstants.CENTER);
		lbLinhKien.setForeground(Color.WHITE);
		lbLinhKien.setFont(new Font("Arial", Font.BOLD, 25));
		lbLinhKien.setBounds(241, 0, 452, 47);
		panelLinhKien.add(lbLinhKien);
		
		JLabel lbMa = new JLabel("Mã linh kiện: ");
		lbMa.setFont(new Font("Arial", Font.BOLD, 15));
		lbMa.setBounds(10, 59, 113, 31);
		add(lbMa);
		
		JLabel lbSoLuong = new JLabel("Số lương: ");
		lbSoLuong.setFont(new Font("Arial", Font.BOLD, 15));
		lbSoLuong.setBounds(10, 92, 113, 31);
		add(lbSoLuong);
		
		JLabel lbMoTa = new JLabel("Mô tả: ");
		lbMoTa.setFont(new Font("Arial", Font.BOLD, 15));
		lbMoTa.setBounds(10, 142, 113, 31);
		add(lbMoTa);
		
		txtMaLK = new JTextField();
		txtMaLK.setBounds(109, 63, 208, 21);
		add(txtMaLK);
		txtMaLK.setColumns(10);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(109, 98, 208, 21);
		add(txtSoLuong);
		
		txtMoTa = new JTextField();
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(109, 130, 798, 57);
		add(txtMoTa);
		
		JLabel lbTenLK = new JLabel("Tên linh kiện: ");
		lbTenLK.setFont(new Font("Arial", Font.BOLD, 15));
		lbTenLK.setBounds(339, 57, 113, 31);
		add(lbTenLK);
		
		txtTenLK = new JTextField();
		txtTenLK.setColumns(10);
		txtTenLK.setBounds(446, 59, 461, 21);
		add(txtTenLK);
		
		JLabel lbDonGia = new JLabel("Đơn giá: ");
		lbDonGia.setFont(new Font("Arial", Font.BOLD, 15));
		lbDonGia.setBounds(339, 92, 113, 31);
		add(lbDonGia);
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(446, 97, 168, 21);
		add(txtDonGia);
		
		JLabel lbLoaiLK = new JLabel("Loại LK: ");
		lbLoaiLK.setFont(new Font("Arial", Font.BOLD, 15));
		lbLoaiLK.setBounds(643, 92, 79, 31);
		add(lbLoaiLK);
		
		txtLoaiLK = new JTextField();
		txtLoaiLK.setColumns(10);
		txtLoaiLK.setBounds(714, 97, 193, 21);
		add(txtLoaiLK);
		
		JLabel lbThuongHieu = new JLabel("Thương hiệu: ");
		lbThuongHieu.setFont(new Font("Arial", Font.BOLD, 15));
		lbThuongHieu.setBounds(10, 199, 113, 31);
		add(lbThuongHieu);
		
		txtThuongHieu = new JTextField();
		txtThuongHieu.setColumns(10);
		txtThuongHieu.setBounds(109, 204, 208, 21);
		add(txtThuongHieu);
		
		JLabel lbNgayNhap = new JLabel("Ngày nhập: ");
		lbNgayNhap.setFont(new Font("Arial", Font.BOLD, 15));
		lbNgayNhap.setBounds(339, 199, 113, 31);
		add(lbNgayNhap);
		
		txtNgayNhap = new JTextField();
		txtNgayNhap.setColumns(10);
		txtNgayNhap.setBounds(446, 204, 168, 21);
		add(txtNgayNhap);
		
		JLabel lbBaoHanh = new JLabel("Bảo hành: ");
		lbBaoHanh.setFont(new Font("Arial", Font.BOLD, 15));
		lbBaoHanh.setBounds(639, 199, 113, 31);
		add(lbBaoHanh);
		
		txtBaoHanh = new JTextField();
		txtBaoHanh.setColumns(10);
		txtBaoHanh.setBounds(714, 204, 193, 21);
		add(txtBaoHanh);
		
		JLabel lbTimKiem = new JLabel("Tìm kiếm theo: ");
		lbTimKiem.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\search11.png"));
		lbTimKiem.setFont(new Font("Arial", Font.BOLD, 15));
		lbTimKiem.setBounds(10, 240, 160, 31);
		add(lbTimKiem);
		
		JComboBox comboBox_Tim = new JComboBox();
		comboBox_Tim.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox_Tim.setModel(new DefaultComboBoxModel(new String[] {"Tên linh kiện", "Mã linh kiện", "Loại linh kiện"}));
		comboBox_Tim.setBounds(167, 247, 150, 21);
		add(comboBox_Tim);
		
		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(336, 247, 278, 21);
		add(txtTim);
		
		JButton btnFirst = new JButton("<<");
		btnFirst.setForeground(Color.WHITE);
		btnFirst.setFont(new Font("Arial", Font.PLAIN, 10));
		btnFirst.setBackground(Color.GRAY);
		btnFirst.setBounds(10, 281, 47, 26);
		add(btnFirst);
		
		JButton btnBack = new JButton("<");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 10));
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(67, 281, 47, 26);
		add(btnBack);
		
		JButton btnNext = new JButton(">");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNext.setBackground(Color.GRAY);
		btnNext.setBounds(124, 281, 47, 26);
		add(btnNext);
		
		JButton btnLast = new JButton(">>");
		btnLast.setForeground(Color.WHITE);
		btnLast.setFont(new Font("Arial", Font.PLAIN, 10));
		btnLast.setBackground(Color.GRAY);
		btnLast.setBounds(181, 281, 47, 26);
		add(btnLast);
		
		
		
		table = new JTable();
		table.setModel(tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 linh ki\u1EC7n", "T\u00EAn linh ki\u1EC7n", "M\u00F4 t\u1EA3", "\u0110\u01A1n gi\u00E1", "Lo\u1EA1i linh ki\u1EC7n", "Th\u01B0\u01A1ng hi\u1EC7u", "SL", "Ng\u00E0y nh\u1EADp", "B\u1EA3o h\u00E0nh"
			}
		));
		//load dữ liệu
		table.setRowHeight(25);
		for(LinhKien lk : linhKien.getAll()) {
			Object[] rowData = {lk.getMaLK(), lk.getTenLK(), lk.getMoTaLK(), lk.getDonGia(), lk.getLoaiLK(), lk.getThuongHieu(), lk.getSoLuongTon(), lk.getNgayNhap(), lk.getBaoHanh()};
			tableModel.addRow(rowData);
		}
		
		table.getColumnModel().getColumn(4).setPreferredWidth(54);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 327, 897, 269);
		add(scrollPane);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\them.png"));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Arial", Font.BOLD, 15));
		btnThem.setBackground(new Color(0, 128, 0));
		btnThem.setBounds(253, 610, 115, 43);
		add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\sua.png"));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Arial", Font.BOLD, 15));
		btnSua.setBackground(Color.GRAY);
		btnSua.setBounds(429, 610, 115, 43);
		add(btnSua);
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\xuly11.png"));
		btnXoaRong.setHorizontalAlignment(SwingConstants.RIGHT);
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Arial", Font.BOLD, 15));
		btnXoaRong.setBackground(Color.GRAY);
		btnXoaRong.setBounds(607, 610, 145, 43);
		add(btnXoaRong);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\xoa.png"));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Arial", Font.BOLD, 15));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(792, 610, 115, 43);
		add(btnXoa);
		
		JButton btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\danhmuc11.png"));
		btnXemChiTiet.setForeground(Color.WHITE);
		btnXemChiTiet.setFont(new Font("Arial", Font.BOLD, 15));
		btnXemChiTiet.setBackground(new Color(128, 128, 128));
		btnXemChiTiet.setBounds(10, 610, 160, 43);
		add(btnXemChiTiet);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("Arial", Font.BOLD, 15));
		btnTim.setBackground(new Color(0, 128, 255));
		btnTim.setBounds(643, 247, 85, 26);
		add(btnTim);
		
		table.addMouseListener(new MouseListener() {
			
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
				int row = table.getSelectedRow();
				txtMaLK.setText(tableModel.getValueAt(row, 0).toString());
				txtSoLuong.setText(tableModel.getValueAt(row, 6).toString());
				txtMoTa.setText(tableModel.getValueAt(row, 2).toString());
				txtThuongHieu.setText(tableModel.getValueAt(row, 5).toString());
				txtNgayNhap.setText(tableModel.getValueAt(row, 7).toString());
				txtTenLK.setText(tableModel.getValueAt(row, 1).toString());
				txtDonGia.setText(tableModel.getValueAt(row, 3).toString());
				txtLoaiLK.setText(tableModel.getValueAt(row, 4).toString());
				txtBaoHanh.setText(tableModel.getValueAt(row, 8).toString());
			}
		});
		
		btnXemChiTiet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					ctLinhKien = new frm_CTLinhKien();
					ctLinhKien.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn linh kiện cần xem!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtBaoHanh.getText().equals("") || txtDonGia.getText().equals("") || txtLoaiLK.getText().equals("") || 
						txtMaLK.getText().equals("") || txtMoTa.getText().equals("") || txtNgayNhap.getText().equals("") ||
						txtSoLuong.getText().equals("") || txtTenLK.getText().equals("") || txtThuongHieu.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ dữ liệu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				else {
					lKien = new LinhKien(txtMaLK.getText(), txtTenLK.getText(), txtMoTa.getText(), Double.valueOf(txtDonGia.getText()), txtLoaiLK.getText(), txtThuongHieu.getText(), Integer.valueOf(txtSoLuong.getText()), Date.valueOf(txtNgayNhap.getText()), Integer.valueOf(txtBaoHanh.getText()));
					int kq = linhKien.insert(lKien);
					if(kq != 0) {
						JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						Object[] rowData = {lKien.getMaLK(), lKien.getTenLK(), lKien.getMoTaLK(), lKien.getDonGia(), lKien.getLoaiLK(), lKien.getThuongHieu(), lKien.getSoLuongTon(), lKien.getNgayNhap(), lKien.getBaoHanh()};
						tableModel.addRow(rowData);
						xoaRong();
					}else 
						JOptionPane.showMessageDialog(null, "Thêm không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lKien = new LinhKien(txtMaLK.getText(), txtTenLK.getText(), txtMoTa.getText(), Double.valueOf(txtDonGia.getText()), txtLoaiLK.getText(), txtThuongHieu.getText(), Integer.valueOf(txtSoLuong.getText()), Date.valueOf(txtNgayNhap.getText()), Integer.valueOf(txtBaoHanh.getText()));
				int kq = linhKien.update(lKien);
				if(kq != 0) {
					JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					xoaRong();
				}else {
					JOptionPane.showMessageDialog(null, "Sửa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnXoaRong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaRong();
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lKien = new LinhKien(txtMaLK.getText(), txtTenLK.getText(), txtMoTa.getText(), Double.valueOf(txtDonGia.getText()), txtLoaiLK.getText(), txtThuongHieu.getText(), Integer.valueOf(txtSoLuong.getText()), Date.valueOf(txtNgayNhap.getText()), Integer.valueOf(txtBaoHanh.getText()));

				int kq = linhKien.delete(lKien);
				if(table.getSelectedRow() != -1) {
					if(kq != 0) {
						tableModel.removeRow(table.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						xoaRong();
					}else {
						JOptionPane.showMessageDialog(null, "Xóa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Chọn linh kiện cần xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
	}
	public void xoaRong() {
		txtMaLK.setText("");
		txtSoLuong.setText("");
		txtMoTa.setText("");
		txtThuongHieu.setText("");
		txtNgayNhap.setText("");
		txtTenLK.setText("");
		txtDonGia.setText("");
		txtLoaiLK.setText("");
		txtBaoHanh.setText("");
	}
}
