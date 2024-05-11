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
import entities.TaiKhoan;
import utils.ClientDAO;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frm_DangNhap extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTop;
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;
	private JComboBox comboQuyenTruyCap;
	private JCheckBox checkNhoMK;
	private JButton btn_DangNhap;
	private JButton btn_Thoat;
	private JButton btn_TaoTK;
	private Frm_TrangChu tC;
	private Frm_DoiMatKhau formQuenMatKhau;
	private TaiKhoan_DAO taiKhoan_DAO;
	private JButton lblDoiMK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_DangNhap frame = new Frm_DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public Frm_DangNhap() throws MalformedURLException, RemoteException, NotBoundException {
		setTitle("Đăng nhập hệ thống");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		buiGUI();
	}

	private void buiGUI() throws MalformedURLException, RemoteException, NotBoundException {
		taiKhoan_DAO = ClientDAO.getTaiKhoanDAO();

		// TOP:
		JPanel pnl_top = new JPanel();
		getContentPane().add(pnl_top, BorderLayout.NORTH);
		pnl_top.add(lblTop = new JLabel("Đăng Nhập Hệ Thống"));
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
		b.setBounds(37, 27, 302, 118);
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox();
		b5 = Box.createHorizontalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b.add(b5);
		b.add(Box.createVerticalStrut(10));
		pnl_mid.add(b);

		JLabel lblTenDangNhap, lblMatKhau, lblQuyenTruyCap, lblNhoMatKhau, lblQuenMatKhau;
		b1.add(lblTenDangNhap = new JLabel("Tên Đăng Nhập: "));
		b1.add(Box.createHorizontalStrut(50));
//		b1.add(Box.createHorizontalGlue());
		b1.add(txtTenDangNhap = new JTextField(20));

		b2.add(lblMatKhau = new JLabel("Mật Khẩu: "));
		b2.add(Box.createHorizontalStrut(84));
		b2.add(txtMatKhau = new JPasswordField(20));

		b5.add(btn_DangNhap = new FixButton("Đăng Nhập", "img/dangnhap.png", 28, 22));
		btn_DangNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// Xử lý đăng nhập khi nhấn phím Enter
					try {
						dangNhap();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		txtMatKhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// Xử lý đăng nhập khi nhấn phím Enter
					try {
						dangNhap();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_DangNhap.setBackground(Color.green);
		btn_DangNhap.setForeground(Color.white);
		b5.add(Box.createRigidArea(new Dimension(50, 0)));
		b5.add(btn_Thoat = new FixButton("Thoát", "img/thoathethong.png", 28, 22));
		btn_Thoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblDoiMK = new JButton("Quên mật khẩu");
		lblDoiMK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					formQuenMatKhau = new Frm_DoiMatKhau();
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				formQuenMatKhau.setVisible(true);
			}
		});
		lblDoiMK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Quên mật khẩu");
			}
		});
		lblDoiMK.setBounds(129, 168, 129, 21);
		pnl_mid.add(lblDoiMK);
		btn_Thoat.setBackground(Color.red);
		btn_Thoat.setForeground(Color.white);

		// bot

		btn_DangNhap.addActionListener(this);
		btn_Thoat.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o == btn_DangNhap) {
			try {
				dangNhap();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (o == lblDoiMK) {
			try {
				this.hide();
				formQuenMatKhau = new Frm_DoiMatKhau();
				formQuenMatKhau.setVisible(true);
			} catch (RemoteException | MalformedURLException | NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void dangNhap() throws RemoteException {
		String tenDangNhap = txtTenDangNhap.getText();
		String matKhau = txtMatKhau.getText();
		System.out.println("tk: " + tenDangNhap + " mat khau: " + matKhau);

		try {
			TaiKhoan_DAO taiKhoan_DAO = ClientDAO.getTaiKhoanDAO();
			TaiKhoan tk = taiKhoan_DAO.getTaiKhoanTuTenDangNhap(tenDangNhap, matKhau);
			if (tk != null) {
				this.hide();
				tC = new Frm_TrangChu(tk.getNhanVien());
				tC.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
}
