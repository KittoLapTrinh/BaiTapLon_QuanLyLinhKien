package gui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.KhachHangDao;
import entiy.KhachHang;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frm_KhachHang extends JPanel {
	private KhachHangDao khachHangDao;
	private KhachHang khachHang;
	private JTable table;
	private JTextField txtTimMa;
	private JTextField txtMa;
	private JTextField txtSdt;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public frm_KhachHang() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		khachHangDao = new KhachHangDao();
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JPanel panelKhachHang = new JPanel();
		panelKhachHang.setLayout(null);
		panelKhachHang.setBackground(new Color(0, 128, 0));
		panelKhachHang.setBounds(0, 0, 917, 47);
		add(panelKhachHang);
		
		JLabel lbQLKhachHang = new JLabel("Quản lý khách hàng");
		lbQLKhachHang.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\khachHang11.png"));
		lbQLKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lbQLKhachHang.setForeground(Color.WHITE);
		lbQLKhachHang.setFont(new Font("Arial", Font.BOLD, 25));
		lbQLKhachHang.setBounds(241, 0, 452, 47);
		panelKhachHang.add(lbQLKhachHang);
		
		JPanel panelTableKH = new JPanel();
		panelTableKH.setBounds(10, 57, 897, 310);
		panelTableKH.setBorder(BorderFactory.createTitledBorder("Danh sách khách hàng"));

		panelTableKH.setLayout(null);
		
		table = new JTable();
		table.setModel(tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 KH", "T\u00EAn KH", "S\u0110T", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		//Load dữ liệu
		table.setRowHeight(25);
//		for(KhachHang kh : khachHangDao.getAll()) {
//			Object[] rowData = {kh.getMaKH(), kh.getHoTenKH(), kh.getSdt(), kh.getDiaChi()};
//			tableModel.addRow(rowData);
//		}
		loadTable();
		
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(10, 20, 877, 264);
		JScrollPane roll = new JScrollPane(table);
		roll.setBounds(10, 20, 877, 280);
		panelTableKH.add(roll);

		add(panelTableKH);
		
		JLabel lbTim = new JLabel("Nhập mã cần tìm: ");
		lbTim.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\search11.png"));
		lbTim.setFont(new Font("Arial", Font.BOLD, 15));
		lbTim.setBounds(20, 377, 168, 30);
		add(lbTim);
		
		txtTimMa = new JTextField();
		txtTimMa.setBounds(186, 377, 235, 26);
		add(txtTimMa);
		txtTimMa.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(430, 377, 85, 26);
		add(btnNewButton);
		
		JButton btnFirst = new JButton("<<");
		btnFirst.setForeground(Color.WHITE);
		btnFirst.setFont(new Font("Arial", Font.PLAIN, 10));
		btnFirst.setBackground(Color.GRAY);
		btnFirst.setBounds(689, 377, 47, 26);
		add(btnFirst);
		
		JButton btnBack = new JButton("<");
		btnBack.setHorizontalAlignment(SwingConstants.RIGHT);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 10));
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(746, 377, 47, 26);
		add(btnBack);
		
		JButton btnNext = new JButton(">");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNext.setBackground(Color.GRAY);
		btnNext.setBounds(803, 377, 47, 26);
		add(btnNext);
		
		JButton btnLast = new JButton(">>");
		btnLast.setForeground(Color.WHITE);
		btnLast.setFont(new Font("Arial", Font.PLAIN, 10));
		btnLast.setBackground(Color.GRAY);
		btnLast.setBounds(860, 377, 47, 26);
		add(btnLast);
		
		JPanel panelThongTin = new JPanel();
		panelThongTin.setBounds(10, 417, 897, 181);
		panelThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		add(panelThongTin);
		panelThongTin.setLayout(null);
		
		JLabel lbMa = new JLabel("Mã khách hàng: ");
		lbMa.setFont(new Font("Arial", Font.BOLD, 15));
		lbMa.setBounds(109, 33, 132, 23);
		panelThongTin.add(lbMa);
		
		JLabel lbSDT = new JLabel("Số điện thoại: ");
		lbSDT.setFont(new Font("Arial", Font.BOLD, 15));
		lbSDT.setBounds(109, 66, 132, 23);
		panelThongTin.add(lbSDT);
		
		JLabel lbHoTen = new JLabel("Họ tên: ");
		lbHoTen.setFont(new Font("Arial", Font.BOLD, 15));
		lbHoTen.setBounds(109, 99, 132, 23);
		panelThongTin.add(lbHoTen);
		
		JLabel lbDiaChi = new JLabel("Địa chỉ: ");
		lbDiaChi.setFont(new Font("Arial", Font.BOLD, 15));
		lbDiaChi.setBounds(109, 132, 132, 23);
		panelThongTin.add(lbDiaChi);
		
		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setBounds(231, 34, 256, 23);
		panelThongTin.add(txtMa);
		txtMa.setColumns(10);
		
		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(231, 67, 501, 23);
		panelThongTin.add(txtSdt);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(231, 100, 501, 23);
		panelThongTin.add(txtHoTen);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(231, 133, 501, 23);
		panelThongTin.add(txtDiaChi);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\them.png"));
		btnThem.setBackground(new Color(0, 128, 0));
		btnThem.setForeground(new Color(255, 255, 255));
		btnThem.setFont(new Font("Arial", Font.BOLD, 15));
		btnThem.setBounds(89, 608, 115, 43);
		add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\sua.png"));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Arial", Font.BOLD, 15));
		btnSua.setBackground(new Color(128, 128, 128));
		btnSua.setBounds(287, 608, 115, 43);
		add(btnSua);
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\xuly11.png"));
		btnXoaRong.setHorizontalAlignment(SwingConstants.RIGHT);
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Arial", Font.BOLD, 15));
		btnXoaRong.setBackground(new Color(128, 128, 128));
		btnXoaRong.setBounds(514, 608, 144, 43);
		add(btnXoaRong);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\xoa.png"));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Arial", Font.BOLD, 15));
		btnXoa.setBackground(new Color(255, 0, 0));
		btnXoa.setBounds(735, 608, 115, 43);
		add(btnXoa);
		
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
				txtMa.setText(tableModel.getValueAt(row, 0).toString());
				txtHoTen.setText(tableModel.getValueAt(row, 1).toString());
				txtSdt.setText(tableModel.getValueAt(row, 2).toString());
				txtDiaChi.setText(tableModel.getValueAt(row, 3).toString());
			}
		});
		btnXoaRong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaRong();
			}
		});
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtHoTen.getText().equals("") || txtSdt.getText().equals("") || txtDiaChi.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ dữ liệu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				else {
					khachHang = new KhachHang(txtHoTen.getText(), txtSdt.getText(), txtDiaChi.getText());
					int kq = khachHangDao.insert(khachHang);
					if(kq != 0) {
						JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						Object[] rowData = {khachHang.getHoTenKH(), khachHang.getSdt(), khachHang.getDiaChi()};
						tableModel.addRow(rowData);
						xoaRong();
					}
				}
				
			}
		});
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				khachHang = new KhachHang(txtMa.getText(), txtHoTen.getText(), txtSdt.getText(), txtDiaChi.getText());
				int kq = khachHangDao.update(khachHang);
				if(kq != 0) {
					JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					xoaRong();
				}else {
					JOptionPane.showMessageDialog(null, "Sửa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				khachHang = new KhachHang(txtMa.getText(), txtHoTen.getText(), txtSdt.getText(), txtDiaChi.getText());
				int kq = khachHangDao.delete(khachHang);
				if(table.getSelectedRow() != -1) {
					if(kq != 0) {
						tableModel.removeRow(table.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						xoaRong();
					}else {
						JOptionPane.showMessageDialog(null, "Xóa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Chọn khách hàng cần xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	public void loadTable() {
		for(KhachHang kh : khachHangDao.getAll()) {
			Object[] rowData = {kh.getMaKH(), kh.getHoTenKH(), kh.getSdt(), kh.getDiaChi()};
			tableModel.addRow(rowData);
		}
	}
	public void removeTable() {
		table.removeAll();
	}
	public void xoaRong() {
		txtMa.setText("");
		txtHoTen.setText("");
		txtSdt.setText("");
		txtDiaChi.setText("");
	}
}
