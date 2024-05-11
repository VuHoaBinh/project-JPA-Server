package ui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.KhachHang_DAO;
import entities.KhachHang;
import utils.ClientDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class JPanel_KhachHang extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableKhachHang;
	private JTextField txtNhapSoDT;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private DefaultTableModel modelQuanLyKhachHang;
	private JTable tableQuanLyKhachHang;
	private KhachHang_DAO KhachHang_dao;

	/**
	 * Create the panel.
	 * 
	 * @throws RemoteException
	 */
	public JPanel_KhachHang() throws RemoteException {
		try {

			KhachHang_dao = ClientDAO.getKhachHangDAO();
			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ket noi that bai");
		}
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 85, 170), new Color(0, 85, 170)),
						"Qua\u0309n ly\u0301 kha\u0301ch ha\u0300ng", TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 85, 170)));
		panel.setBounds(0, 0, 1226, 656);
		add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 85, 170), new Color(0, 85, 170)),
						"Danh Sa\u0301ch Kha\u0301ch Ha\u0300ng", TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 85, 170)));
		panel_2.setBounds(20, 28, 1186, 245);
		panel.add(panel_2);
		panel_2.setLayout(null);

		String[] header = { "Mã KH", "Tên KH", "SĐT", "Địa Chỉ", "Email" };
		modelQuanLyKhachHang = new DefaultTableModel(header, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		tableQuanLyKhachHang = new JTable(modelQuanLyKhachHang);
		JScrollPane scrollPane = new JScrollPane(tableQuanLyKhachHang);

		// đưa dl từ db vào model
		DocKhachHachTuDBVaoModel();
		tableQuanLyKhachHang.addMouseListener(this);

		scrollPane.setBounds(10, 21, 1166, 213);
		panel_2.add(scrollPane);

		JLabel lblNhapSoDT = new JLabel("Nhập Số Điện Thoại: ");
		lblNhapSoDT.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNhapSoDT.setBounds(30, 287, 148, 20);
		panel.add(lblNhapSoDT);

		txtNhapSoDT = new JTextField();
		txtNhapSoDT.setBounds(185, 287, 310, 20);
		panel.add(txtNhapSoDT);
		txtNhapSoDT.setColumns(10);

		JButton btnTim = new FixButton("Tìm", "img/tim.png", 28, 22);
		btnTim.setForeground(new Color(0, 0, 0));
		btnTim.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sdt = txtNhapSoDT.getText();
				KhachHang kh = null;
				try {
					kh = KhachHang_dao.getKhachHangBySDT(sdt);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (sdt.equals("")) {
					modelQuanLyKhachHang.getDataVector().removeAllElements();
					try {
						DocKhachHachTuDBVaoModel();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (kh == null) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
				} else {
					modelQuanLyKhachHang.getDataVector().removeAllElements();
					Object[] obj = new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSdt(),
							kh.getDiaChi(), kh.getEmail() };
					modelQuanLyKhachHang.addRow(obj);
				}
			}

		});
		btnTim.setBounds(505, 286, 89, 23);
		panel.add(btnTim);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 85, 170), new Color(0, 85, 170)),
						"Th\u00F4ng Tin Kha\u0301ch Ha\u0300ng", TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 85, 170)));
		panel_3.setBounds(20, 318, 1186, 224);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblMaKH = new JLabel("Mã KH:");
		lblMaKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMaKH.setBounds(97, 32, 128, 20);
		panel_3.add(lblMaKH);

		txtMaKH = new JTextField();
		txtMaKH.setEditable(true);
		txtMaKH.setBounds(235, 33, 357, 20);
		panel_3.add(txtMaKH);
		txtMaKH.setColumns(10);

		JLabel lblTenKH = new JLabel("Tên KH:");
		lblTenKH.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTenKH.setBounds(97, 63, 128, 20);
		panel_3.add(lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(235, 64, 357, 20);
		panel_3.add(txtTenKH);

		JLabel lblSDT = new JLabel("SĐT:");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSDT.setBounds(97, 94, 128, 20);
		panel_3.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(235, 95, 357, 20);
		panel_3.add(txtSDT);

		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDiaChi.setBounds(97, 125, 128, 20);
		panel_3.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(235, 126, 357, 20);
		panel_3.add(txtDiaChi);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBounds(97, 156, 128, 20);
		panel_3.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(235, 157, 357, 20);
		panel_3.add(txtEmail);

		JButton btnThem = new FixButton("Thêm", "img/Them.png", 28, 22);
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (isValidKhachHang() && !trungSDT()) {
						KhachHang kh = taoKhachHangTuField();
						try {
							if (KhachHang_dao.themKhachHang(kh) > 0) {
								capNhatModelKhachHang();
								txtMaKH.setText("");
								txtTenKH.setText("");
								txtSDT.setText("");
								txtDiaChi.setText("");
								txtEmail.setText("");
								JOptionPane.showMessageDialog(null, "Thêm thành công");
								xoaRongField();
							} else
								JOptionPane.showMessageDialog(null, "Thêm thất bại");
						} catch (HeadlessException | RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnThem.setBounds(89, 590, 133, 43);
		panel.add(btnThem);

		JButton btnSua = new FixButton("Sửa", "img/Sua.png", 28, 22);
		btnSua.setForeground(new Color(0, 0, 0));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isValidKhachHang()) {
					KhachHang kh = taoKhachHangTuField();
					try {
						if (KhachHang_dao.suaKhachHang(kh) > 0) {
							capNhatModelKhachHang();
							txtMaKH.setText("");
							txtTenKH.setText("");
							txtSDT.setText("");
							txtDiaChi.setText("");
							txtEmail.setText("");
							JOptionPane.showMessageDialog(null, "Sửa thành công");
						} else
							JOptionPane.showMessageDialog(null, "Sửa thất bại");
					} catch (HeadlessException | RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnSua.setBounds(528, 590, 133, 43);
		panel.add(btnSua);

		JButton btnXoaRong = new FixButton("Xóa Rỗng", "img/XoaRong.png", 28, 22);
		btnXoaRong.setForeground(new Color(0, 0, 0));
		btnXoaRong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXoaRong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaRongField();
				txtMaKH.setEditable(true);
			}
		});
		btnXoaRong.setBounds(952, 590, 133, 43);
		panel.add(btnXoaRong);

		JLabel lblNewLabel_3_1 = new JLabel("1/2");
		lblNewLabel_3_1.setBounds(600, 545, 24, 20);
		panel.add(lblNewLabel_3_1);

		JButton btnTatCa = new FixButton("Tất Cả", "img/LamMoi.png", 28, 22);
		btnTatCa.setForeground(new Color(0, 0, 0));
		btnTatCa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnTatCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelQuanLyKhachHang.getDataVector().removeAllElements();
				try {
					DocKhachHachTuDBVaoModel();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnTatCa.setBounds(604, 286, 118, 23);
		panel.add(btnTatCa);

		JButton btnlen = new FixButton("", "img/Len.png", 20, 18);
		btnlen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableQuanLyKhachHang.getSelectedRow();

				if (selectedRow > 0) {
					// Nếu dòng đã chọn không phải là dòng đầu tiên, giảm dòng được chọn
					tableQuanLyKhachHang.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);

					// Scroll to make the newly selected row visible
					tableQuanLyKhachHang
							.scrollRectToVisible(tableQuanLyKhachHang.getCellRect(selectedRow - 1, 0, true));
				}
			}
		});
		btnlen.setBounds(553, 544, 41, 23);
		panel.add(btnlen);

		JButton btnxuong = new FixButton("", "img/Xuong.png", 20, 18);
		btnxuong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableQuanLyKhachHang.getSelectedRow();
				int rowCount = tableQuanLyKhachHang.getRowCount();

				if (selectedRow < rowCount - 1) {
					// Nếu dòng đã chọn không phải là dòng cuối cùng, tăng dòng được chọn
					tableQuanLyKhachHang.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);

					// Scroll to make the newly selected row visible
					tableQuanLyKhachHang
							.scrollRectToVisible(tableQuanLyKhachHang.getCellRect(selectedRow + 1, 0, true));
				}
			}
		});
		btnxuong.setBounds(620, 544, 41, 23);
		panel.add(btnxuong);

	}

	private void DocKhachHachTuDBVaoModel() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<KhachHang> listKH = KhachHang_dao.getAllKhachHang();
		for (KhachHang khachHang : listKH) {
			Object[] obj = new Object[] { khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.getSdt(),
					khachHang.getDiaChi(), khachHang.getEmail() };
			modelQuanLyKhachHang.addRow(obj);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableQuanLyKhachHang.getSelectedRow();
		txtMaKH.setText(modelQuanLyKhachHang.getValueAt(row, 0).toString());
		txtTenKH.setText(modelQuanLyKhachHang.getValueAt(row, 1).toString());
		txtSDT.setText(modelQuanLyKhachHang.getValueAt(row, 2).toString());
		txtDiaChi.setText(modelQuanLyKhachHang.getValueAt(row, 3).toString());
		txtEmail.setText(modelQuanLyKhachHang.getValueAt(row, 4).toString());
		txtMaKH.setEditable(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private KhachHang taoKhachHangTuField() {
		String maKH = txtMaKH.getText();
		String tenKH = txtTenKH.getText();
		String sdt = txtSDT.getText();
		String diaChi = txtDiaChi.getText();
		String email = txtEmail.getText();
		KhachHang kh = new KhachHang(maKH, tenKH, sdt, diaChi, email);
		return kh;
	}

	private boolean isValidKhachHang() {
		// TODO Auto-generated method stub
		if (!(txtMaKH.getText().matches("^KH\\d{6}$"))) {
			JOptionPane.showMessageDialog(null, "Mã khách hàng không hợp lệ");
			txtTenKH.requestFocus();
			return false;
		}
		if (txtTenKH.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên khách hàng không được để trống");
			txtTenKH.requestFocus();
			return false;
		}

		if (!(txtSDT.getText().length() > 0 && txtSDT.getText().matches("^0\\d{9}$"))) {
			JOptionPane.showMessageDialog(this, "Số điện thoại phải dủ 10 số");
			txtSDT.requestFocus();
			return false;
		}

		if (txtDiaChi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống");
			txtDiaChi.requestFocus();
			return false;
		}

		if ((txtEmail.getText().equals("")) || !(txtEmail.getText().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$"))) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng email");
			txtEmail.requestFocus();
			return false;
		}
		return true;
	}
//	private boolean trungSDT() throws HeadlessException, RemoteException {
//		if (KhachHang_dao.getKhachHangBySDT(txtSDT.getText()) != null) {
//			JOptionPane.showMessageDialog(null, "SDT khách hàng đã tồn tại!");
//			return true;
//		}
//		return false;
//	}

	private boolean checkSDTExists(String sdt) throws RemoteException {
		KhachHang khachHang = KhachHang_dao.getKhachHangBySDT(sdt);
		return khachHang != null;
	}

	private boolean trungSDT() throws RemoteException {
		boolean exists = checkSDTExists(txtSDT.getText());
		if (exists) {
			JOptionPane.showMessageDialog(null, "SDT đã bị trùng!");
			return true;
		}
		return false;
	}

	private void capNhatModelKhachHang() throws RemoteException {
		// TODO Auto-generated method stub
		modelQuanLyKhachHang.getDataVector().removeAllElements();
		DocKhachHachTuDBVaoModel();

	}

	private void xoaRongField() {
		// TODO Auto-generated method stub
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");

	}

}
