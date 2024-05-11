package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.TaiKhoan_DAO;
import entities.NhanVien;
import entities.TaiKhoan;
import utils.ClientDAO;
import java.awt.Component;

public class Frm_XemThongTinCaNhan extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2214737532282066779L;

	private JPanel contentPane;
	private JLabel lblTop;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JComboBox comboQuyenTruyCap;
	private JCheckBox checkNhoMK;
	private JButton btn_DangNhap;
	private JButton btn_Thoat;
	private JButton btn_TaoTK;
	private Frm_TrangChu tC;
	private Frm_DoiMatKhau formQuenMatKhau;
	private TaiKhoan_DAO taiKhoan_DAO;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtSoDienThoai;

	private JButton btnThoat;

//	private NhanVien nhanVien;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frm_XemThongTinCaNhan frame = new Frm_XemThongTinCaNhan(nhanVien);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * 
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public Frm_XemThongTinCaNhan(NhanVien nhanVien) throws MalformedURLException, RemoteException, NotBoundException {
		setTitle("Xem Thông Tin Cá Nhân");
		setSize(418, 390);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		buiGUI(nhanVien);
	}

	private void buiGUI(NhanVien nhanVien) throws MalformedURLException, RemoteException, NotBoundException {
		taiKhoan_DAO = ClientDAO.getTaiKhoanDAO();

		// TOP:
		JPanel pnl_top = new JPanel();
		getContentPane().add(pnl_top, BorderLayout.NORTH);
		pnl_top.add(lblTop = new JLabel("Thông Tin Cá Nhân"));
		lblTop.setForeground(Color.red);
		Font font_lbl = new Font("Arial", Font.BOLD, 25);
		lblTop.setFont(font_lbl);

		// mid:
		JPanel pnl_mid = new JPanel();
//		pnl_mid.setPreferredSize(new Dimension(0, 300));
		getContentPane().add(pnl_mid, BorderLayout.CENTER);
		Box b, b1, b2, b3, b5;
		pnl_mid.setLayout(null);
		b = Box.createVerticalBox();
		b.setBounds(10, 10, 384, 293);
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b5 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);

		Box b2_1 = Box.createHorizontalBox();
		b.add(b2_1);

		JLabel lblDiaChi = new JLabel("Địa Chỉ:");
		b2_1.add(lblDiaChi);

		Component horizontalStrut = Box.createHorizontalStrut(80);
		b2_1.add(horizontalStrut);

		txtDiaChi = new JTextField(20);
		txtDiaChi.setText(nhanVien.getDiaChi());
		txtDiaChi.disable();
		b2_1.add(txtDiaChi);

		Box b2_2 = Box.createHorizontalBox();
		b.add(b2_2);

		JLabel lblEmail = new JLabel("Email:");
		b2_2.add(lblEmail);

		Component horizontalStrut_1 = Box.createHorizontalStrut(88);
		b2_2.add(horizontalStrut_1);

		txtEmail = new JTextField(20);
		txtEmail.setText(nhanVien.getEmail());
		txtEmail.disable();
		b2_2.add(txtEmail);

		Box b2_3 = Box.createHorizontalBox();
		b.add(b2_3);

		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		b2_3.add(lblSoDienThoai);

		Component horizontalStrut_2 = Box.createHorizontalStrut(48);
		b2_3.add(horizontalStrut_2);

		txtSoDienThoai = new JTextField(20);
		txtSoDienThoai.setText(nhanVien.getSdt());
		txtSoDienThoai.disable();
		b2_3.add(txtSoDienThoai);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(b5);
		
		btnThoat = new JButton("Thoat");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		b.add(btnThoat);
		Component verticalStrut = Box.createHorizontalStrut(10);
		b.add(verticalStrut);
		b.add(Box.createVerticalStrut(10));
		pnl_mid.add(b);

		JLabel lblMaNhanVien, lblTenNhanVien, lblQuyenTruyCap, lblNhoMatKhau, lblQuenMatKhau;
		b1.add(lblMaNhanVien = new JLabel("Mã Nhân Viên:"));
		b1.add(Box.createHorizontalStrut(50));
		b1.add(txtMaNhanVien = new JTextField(20));
		txtMaNhanVien.setText(nhanVien.getMaNhanVien());
		txtMaNhanVien.disable();
		
		b2.add(lblTenNhanVien = new JLabel("Tên Nhân Viên"));
		lblTenNhanVien.setAlignmentX(0.5f);
		b2.add(Box.createHorizontalStrut(50));
		b2.add(txtTenNhanVien = new JTextField(20));
		txtTenNhanVien.setText(nhanVien.getTenNhanVien());
		txtTenNhanVien.disable();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		 if (e.getSource() == btnThoat) {
		        dispose(); 
		    }
	}

	public void dangNhap() throws RemoteException {

	}
}
