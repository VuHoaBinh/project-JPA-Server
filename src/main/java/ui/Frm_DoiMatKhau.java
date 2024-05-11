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

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.TaiKhoan_DAO;
import entities.TaiKhoan;
import utils.ClientDAO;
import java.awt.Component;
import java.awt.SystemColor;

public class Frm_DoiMatKhau extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_DoiMatKhau frame = new Frm_DoiMatKhau();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private TaiKhoan_DAO taiKhoan_DAO;
	private JLabel lblTop;
	private JPasswordField txtMatkhauConfirm;
	private JTextField txtTendangNhap;
	private JPasswordField txtMatkhau;
	private AbstractButton btn_DangNhap;
	private FixButton btn_Thoat;
	private Frm_DangNhap tC;

	/**
	 * Create the frame.
	 * 
	 * @throws NotBoundException
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public Frm_DoiMatKhau() throws MalformedURLException, RemoteException, NotBoundException {
		setTitle("Quên mật khẩu");
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
		pnl_top.add(lblTop = new JLabel("Quên mật khẩu"));
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
		b.setBounds(37, 21, 320, 171);
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

		Box b2_1 = Box.createHorizontalBox();
		b.add(b2_1);

		JLabel lblMatKhauConfirm = new JLabel("Nhập lại mật khẩu: ");
		b2_1.add(lblMatKhauConfirm);

		Component horizontalStrut = Box.createHorizontalStrut(40);
		b2_1.add(horizontalStrut);

		txtMatkhauConfirm = new JPasswordField(20);
		b2_1.add(txtMatkhauConfirm);
		b.add(b5);
		b.add(Box.createVerticalStrut(10));
		pnl_mid.add(b);

		JLabel lblTenDangNhap, lblMatKhau, lblQuyenTruyCap, lblNhoMatKhau, lblQuenMatKhau;
		b1.add(lblTenDangNhap = new JLabel("Tên Đăng Nhập: "));
		b1.add(Box.createHorizontalStrut(50));
//		b1.add(Box.createHorizontalGlue());
		b1.add(txtTendangNhap = new JTextField(20));

		b2.add(lblMatKhau = new JLabel("Mật Khẩu: "));
		b2.add(Box.createHorizontalStrut(80));
		b2.add(txtMatkhau = new JPasswordField(20));

		b5.add(btn_DangNhap = new FixButton("Đăng Nhập", "img/dangnhap.png", 28, 22));
		btn_DangNhap.setText("Đổi mật khẩu");
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
		txtMatkhau.addKeyListener(new KeyAdapter() {
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
		btn_DangNhap.setBackground(SystemColor.textHighlight);
		btn_DangNhap.setForeground(Color.white);
		b5.add(Box.createRigidArea(new Dimension(50, 0)));
		b5.add(btn_Thoat = new FixButton("Thoát", "img/thoathethong.png", 28, 22));
		btn_Thoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btn_Thoat.setText("Quay lại");
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

	}

	public void dangNhap() throws RemoteException {
		String tenDangNhap = txtTendangNhap.getText();
		String matKhau = txtMatkhau.getText();
		System.out.println("tk: " + tenDangNhap + " mat khau: " + matKhau);

		try {
			TaiKhoan_DAO taiKhoan_DAO = ClientDAO.getTaiKhoanDAO();
			TaiKhoan tk1 = new TaiKhoan(tenDangNhap,matKhau);
			Boolean tk = taiKhoan_DAO.doiMatKhau(tenDangNhap,matKhau);
			if (tk != false) {
				this.hide();
				tC = new Frm_DangNhap();
				tC.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Sai tên đăng nhập "+tk);
			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
}
