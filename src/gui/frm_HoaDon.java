package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class frm_HoaDon extends JPanel {
	private frm_CTHoaDon ctHoaDon;
	private DefaultTableModel tableModel;
	private JTextField txtTimKiem;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public frm_HoaDon() {
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JPanel panelHoaDon = new JPanel();
		panelHoaDon.setBackground(new Color(0, 128, 0));
		panelHoaDon.setBounds(0, 0, 917, 47);
		add(panelHoaDon);
		panelHoaDon.setLayout(null);
		
		JLabel lbQLHoaDon = new JLabel("Quản lý hóa đơn");
		lbQLHoaDon.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\donhang.png"));
		lbQLHoaDon.setForeground(new Color(255, 255, 255));
		lbQLHoaDon.setFont(new Font("Arial", Font.BOLD, 25));
		lbQLHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lbQLHoaDon.setBounds(241, 0, 452, 47);
		panelHoaDon.add(lbQLHoaDon);
		
		JLabel lbTimKiem = new JLabel("Tìm kiếm theo mã hóa đơn: ");
		lbTimKiem.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\search11.png"));
		lbTimKiem.setFont(new Font("Arial", Font.BOLD, 15));
		lbTimKiem.setBounds(10, 72, 245, 29);
		add(lbTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Arial", Font.PLAIN, 10));
		txtTimKiem.setBounds(265, 75, 233, 25);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setModel(tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 h\u00F3a \u0111\u01A1n", "M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn linh ki\u1EC7n", "M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 111, 897, 440);
		add(scrollPane);
		
		JButton btnFirst = new JButton("<<");
		btnFirst.setForeground(Color.WHITE);
		btnFirst.setFont(new Font("Arial", Font.PLAIN, 10));
		btnFirst.setBackground(Color.GRAY);
		btnFirst.setBounds(10, 561, 47, 21);
		add(btnFirst);
		
		JButton btnBack = new JButton("<");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 10));
		btnBack.setBackground(Color.GRAY);
		btnBack.setBounds(67, 561, 47, 21);
		add(btnBack);
		
		JButton btnNext = new JButton(">");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Arial", Font.PLAIN, 10));
		btnNext.setBackground(Color.GRAY);
		btnNext.setBounds(125, 561, 47, 21);
		add(btnNext);
		
		JButton btnLast = new JButton(">>");
		btnLast.setForeground(Color.WHITE);
		btnLast.setFont(new Font("Arial", Font.PLAIN, 10));
		btnLast.setBackground(Color.GRAY);
		btnLast.setBounds(182, 561, 47, 21);
		add(btnLast);
		
		JButton btnXem = new JButton("Xem chi tiết hóa đơn");
		btnXem.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\danhmuc11.png"));
		btnXem.setForeground(new Color(255, 255, 255));
		btnXem.setBackground(new Color(128, 128, 128));
		btnXem.setFont(new Font("Arial", Font.BOLD, 14));
		btnXem.setBounds(10, 606, 219, 47);
		add(btnXem);
		
		JButton btnIn = new JButton("In hóa đơn");
		btnIn.setIcon(new ImageIcon("D:\\Nhom01_QuanLyCuaHangMuaBanLinhKien\\QLLK\\src\\images_menu\\printer.png"));
		btnIn.setBackground(new Color(128, 255, 255));
		btnIn.setFont(new Font("Arial", Font.BOLD, 15));
		btnIn.setBounds(752, 606, 155, 47);
		add(btnIn);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new Font("Arial", Font.BOLD, 15));
		btnTim.setBackground(new Color(0, 128, 255));
		btnTim.setBounds(508, 75, 85, 26);
		add(btnTim);
		
		btnXem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
					ctHoaDon = new frm_CTHoaDon();
					ctHoaDon.setVisible(true);
				}else
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn cần xem!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		});
	}

}
