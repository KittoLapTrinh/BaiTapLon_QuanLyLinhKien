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
import dao.NhanVienDao;
import entiy.LinhKien;
import entiy.NhanVien;

public class frm_NhanVien extends JPanel {
	private NhanVienDao nhanVienDao;
	private NhanVien nv;
	private JTextField txtMaNV;
	private JTextField txtHoTen;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtMatKhau;
	private JTextField txtNgaySinh;
	private JTextField txtTim;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField txtEmail;

	/**
	 * Create the panel.
	 */
	public frm_NhanVien() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nhanVienDao = new NhanVienDao();
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JPanel panelNhanVien = new JPanel();
		panelNhanVien.setLayout(null);
		panelNhanVien.setBackground(new Color(0, 128, 0));
		panelNhanVien.setBounds(0, 0, 917, 47);
		add(panelNhanVien);
		
		JLabel lbNhanVien = new JLabel("Quản lý nhân viên");
		lbNhanVien.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\nhanvien11.png"));
		lbNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lbNhanVien.setForeground(Color.WHITE);
		lbNhanVien.setFont(new Font("Arial", Font.BOLD, 25));
		lbNhanVien.setBounds(241, 0, 452, 47);
		panelNhanVien.add(lbNhanVien);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên: ");
		lblMNhnVin.setFont(new Font("Arial", Font.BOLD, 15));
		lblMNhnVin.setBounds(10, 57, 113, 31);
		add(lblMNhnVin);
		
		JLabel lbHoTen = new JLabel("Họ tên: ");
		lbHoTen.setFont(new Font("Arial", Font.BOLD, 15));
		lbHoTen.setBounds(10, 90, 113, 31);
		add(lbHoTen);
		
		JLabel lbSDT = new JLabel("Số điện thoại: ");
		lbSDT.setFont(new Font("Arial", Font.BOLD, 15));
		lbSDT.setBounds(10, 120, 113, 31);
		add(lbSDT);
		
		JLabel lbDiaChi = new JLabel("Địa chỉ: ");
		lbDiaChi.setFont(new Font("Arial", Font.BOLD, 15));
		lbDiaChi.setBounds(10, 150, 113, 31);
		add(lbDiaChi);
		
		JLabel lbTimMa = new JLabel("Nhập mã nhân viên cần tìm: ");
		lbTimMa.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\search11.png"));
		lbTimMa.setFont(new Font("Arial", Font.BOLD, 15));
		lbTimMa.setBounds(10, 227, 245, 31);
		add(lbTimMa);
		
		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setBounds(118, 60, 236, 23);
		add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(118, 93, 236, 23);
		add(txtHoTen);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(118, 127, 236, 23);
		add(txtSDT);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(118, 157, 789, 23);
		add(txtDiaChi);
		
		JLabel lbMatKhau = new JLabel("Mật khẩu: ");
		lbMatKhau.setFont(new Font("Arial", Font.BOLD, 15));
		lbMatKhau.setBounds(569, 57, 78, 31);
		add(lbMatKhau);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(671, 60, 236, 23);
		add(txtMatKhau);
		
		JLabel lbGioiTinh = new JLabel("Giới tính: ");
		lbGioiTinh.setFont(new Font("Arial", Font.BOLD, 15));
		lbGioiTinh.setBounds(569, 90, 78, 31);
		add(lbGioiTinh);
		
		JLabel lbNgaySinh = new JLabel("Ngày sinh: ");
		lbNgaySinh.setFont(new Font("Arial", Font.BOLD, 15));
		lbNgaySinh.setBounds(569, 120, 92, 31);
		add(lbNgaySinh);
		
		JComboBox comboBox_GioiTinh = new JComboBox();
		comboBox_GioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		comboBox_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox_GioiTinh.setBounds(671, 93, 113, 21);
		add(comboBox_GioiTinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(671, 127, 236, 23);
		add(txtNgaySinh);
		
		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(252, 232, 236, 23);
		add(txtTim);
		
		JButton tbtnTim = new JButton("Tìm");
		tbtnTim.setForeground(Color.WHITE);
		tbtnTim.setFont(new Font("Arial", Font.BOLD, 15));
		tbtnTim.setBackground(new Color(0, 128, 255));
		tbtnTim.setBounds(498, 229, 85, 26);
		add(tbtnTim);
		
		
		
		table = new JTable();
		table.setModel(tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n vi\u00EAn", "H\u1ECD t\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "Email", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "M\u1EADt kh\u1EA9u", "Quy\u1EC1n"
			}
		));
		//Load dữ liệu
		table.setRowHeight(25);
		for(NhanVien nv : nhanVienDao.getAll()) {
			Object[] rowData = {nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getEmail(), nv.getSdt(), nv.getDiaChi(), nv.getMatkhau(), nv.getQuyenTruyCap()};
			tableModel.addRow(rowData);
		}
		
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setBounds(0, 0, 1, 1);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 282, 897, 318);
		add(scrollPane);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\them.png"));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Arial", Font.BOLD, 15));
		btnThem.setBackground(new Color(0, 128, 0));
		btnThem.setBounds(79, 610, 115, 43);
		add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\sua.png"));
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Arial", Font.BOLD, 15));
		btnSua.setBackground(Color.GRAY);
		btnSua.setBounds(280, 610, 115, 43);
		add(btnSua);
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\xuly11.png"));
		btnXoaRong.setHorizontalAlignment(SwingConstants.RIGHT);
		btnXoaRong.setForeground(Color.WHITE);
		btnXoaRong.setFont(new Font("Arial", Font.BOLD, 15));
		btnXoaRong.setBackground(Color.GRAY);
		btnXoaRong.setBounds(499, 610, 148, 43);
		add(btnXoaRong);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\xoa.png"));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Arial", Font.BOLD, 15));
		btnXoa.setBackground(Color.RED);
		btnXoa.setBounds(717, 610, 115, 43);
		add(btnXoa);
		
		JLabel lbQuyen = new JLabel("Quyền truy cập: ");
		lbQuyen.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\phanquyen.png"));
		lbQuyen.setFont(new Font("Arial", Font.BOLD, 15));
		lbQuyen.setBounds(10, 186, 157, 31);
		add(lbQuyen);
		
		JComboBox cbbQuyen = new JComboBox();
		cbbQuyen.setFont(new Font("Arial", Font.BOLD, 12));
		cbbQuyen.setModel(new DefaultComboBoxModel(new String[] {"User", "Admin"}));
		cbbQuyen.setBounds(177, 190, 78, 23);
		add(cbbQuyen);
		
		JLabel lbEmail = new JLabel("Email: ");
		lbEmail.setFont(new Font("Arial", Font.BOLD, 15));
		lbEmail.setBounds(569, 186, 92, 31);
		add(lbEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(671, 190, 236, 23);
		add(txtEmail);
		
		//Sự kiện
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
				txtMaNV.setText(tableModel.getValueAt(row, 0).toString());
				txtMaNV.setEditable(false);
				txtHoTen.setText(tableModel.getValueAt(row, 1).toString());
				txtSDT.setText(tableModel.getValueAt(row, 5).toString());
				txtDiaChi.setText(tableModel.getValueAt(row, 6).toString());
				txtMatKhau.setText(tableModel.getValueAt(row, 7).toString());
				if(tableModel.getValueAt(row, 3).toString().equals("Nam"))
					comboBox_GioiTinh.setSelectedIndex(0);
				else
					comboBox_GioiTinh.setSelectedIndex(1);
				txtNgaySinh.setText(tableModel.getValueAt(row, 2).toString());
				if(tableModel.getValueAt(row, 8).toString().trim().equals("User"))
					cbbQuyen.setSelectedIndex(0);
				if(tableModel.getValueAt(row, 8).toString().trim().equals("Admin"))
					cbbQuyen.setSelectedIndex(1);
				txtEmail.setText(tableModel.getValueAt(row, 4).toString());
			}
		});
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtHoTen.getText().equals("") || txtDiaChi.getText().equals("") || 
						txtMatKhau.getText().equals("") || txtNgaySinh.getText().equals("") || txtSDT.getText().equals("") || txtEmail.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ dữ liệu!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				else {
					nv = new NhanVien(txtHoTen.getText(), Date.valueOf(txtNgaySinh.getText()), comboBox_GioiTinh.getSelectedItem().toString(), txtEmail.getText(), txtSDT.getText(), txtDiaChi.getText(), txtMatKhau.getText(), cbbQuyen.getSelectedItem().toString());
					int kq = nhanVienDao.insert(nv);
					if(kq != 0) {
						JOptionPane.showMessageDialog(null, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						Object[] rowData = {nv.getMaNV(), nv.getHoTen(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getEmail(), nv.getSdt(), nv.getDiaChi(), nv.getMatkhau(), nv.getQuyenTruyCap()};
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
				nv = new NhanVien(txtMaNV.getText(), txtHoTen.getText(), Date.valueOf(txtNgaySinh.getText()), comboBox_GioiTinh.getSelectedItem().toString(), txtEmail.getText(), txtSDT.getText(), txtDiaChi.getText(), txtMatKhau.getText(), cbbQuyen.getSelectedItem().toString());
				int kq = nhanVienDao.update(nv);
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
				nv = new NhanVien(txtMaNV.getText(), txtHoTen.getText(), Date.valueOf(txtNgaySinh.getText()), comboBox_GioiTinh.getSelectedItem().toString(), txtEmail.getText(), txtSDT.getText(), txtDiaChi.getText(), txtMatKhau.getText(), cbbQuyen.getSelectedItem().toString());

				int kq = nhanVienDao.delete(nv);
				if(table.getSelectedRow() != -1) {
					if(kq != 0) {
						tableModel.removeRow(table.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						xoaRong();
					}else {
						JOptionPane.showMessageDialog(null, "Xóa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Chọn nhân viên cần xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnXoaRong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaRong();
			}
		});
		
	}
	public void xoaRong() {
		txtMaNV.setText("");
		txtMatKhau.setText("");
		txtHoTen.setText("");
		txtSDT.setText("");
		txtNgaySinh.setText("");
		txtDiaChi.setText("");
	}
}
