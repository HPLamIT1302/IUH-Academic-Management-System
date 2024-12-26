package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.UserDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField text_tenDangNhap;
	private JPasswordField passwordField;
	private JCheckBox chkHienThiMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setTitle("Đăng nhập hệ thống quản lí học vụ");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginDialog.class.getResource("/icons/LogoIUH.png")));
		
		setBounds(100, 100, 609, 639);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(238, 238, 238));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		chkHienThiMatKhau = new JCheckBox("Hiển thị mật khẩu");
		chkHienThiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiMatKhau();
			}
		});
		
		JButton btnNewButton = new JButton("\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showHoTroQuenMatKhau();
			}
		});
		btnNewButton.setIcon(new ImageIcon(LoginDialog.class.getResource("/icons/search-icon-16.png")));
		btnNewButton.setBounds(155, 354, 33, 26);
		contentPanel.add(btnNewButton);
		
		JLabel lbl_titleDangNhapHeThong = new JLabel("ĐĂNG NHẬP HỆ THỐNG");
		lbl_titleDangNhapHeThong.setForeground(new Color(0, 128, 255));
		lbl_titleDangNhapHeThong.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titleDangNhapHeThong.setFont(new Font("DialogInput", Font.BOLD, 28));
		lbl_titleDangNhapHeThong.setBounds(135, 120, 330, 79);
		contentPanel.add(lbl_titleDangNhapHeThong);
		chkHienThiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkHienThiMatKhau.setBounds(312, 354, 138, 25);
		contentPanel.add(chkHienThiMatKhau);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordField.setBackground(new Color(235, 235, 235));
		passwordField.setBounds(155, 306, 295, 40);
		contentPanel.add(passwordField);
		
		JLabel lbl_tenDangNhap = new JLabel("Tên đăng nhập");
		lbl_tenDangNhap.setIcon(new ImageIcon(LoginDialog.class.getResource("/icons/Apps-preferences-desktop-user-password-icon-24.png")));
		lbl_tenDangNhap.setBackground(new Color(128, 128, 255));
		lbl_tenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_tenDangNhap.setBounds(155, 175, 295, 50);
		contentPanel.add(lbl_tenDangNhap);
		
		text_tenDangNhap = new JTextField();
		text_tenDangNhap.setFont(new Font("Dialog", Font.PLAIN, 18));
		text_tenDangNhap.setBackground(new Color(235, 235, 235));
		text_tenDangNhap.setBounds(154, 223, 296, 40);
		contentPanel.add(text_tenDangNhap);
		text_tenDangNhap.setColumns(10);
		
		JLabel lblmatKhau = new JLabel("Mật khẩu");
		lblmatKhau.setBackground(Color.CYAN);
		lblmatKhau.setIcon(new ImageIcon(LoginDialog.class.getResource("/icons/gpa-icon-24.png")));
		lblmatKhau.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblmatKhau.setBounds(155, 265, 302, 50);
		contentPanel.add(lblmatKhau);
		
		JButton btn_dangNhap = new JButton("Đăng nhập");
		btn_dangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 login();
			}
		});

		btn_dangNhap.setBackground(new Color(255, 123, 60));
		btn_dangNhap.setFont(new Font("Dialog", Font.BOLD, 25));
		btn_dangNhap.setBounds(155, 387, 295, 73);
		contentPanel.add(btn_dangNhap);
		
		JButton btn_backgound2 = new JButton("");
		btn_backgound2.setEnabled(false);
		btn_backgound2.setFont(new Font("Dialog", Font.BOLD, 25));
		btn_backgound2.setBackground(new Color(240, 240, 240));
		btn_backgound2.setBounds(135, 120, 330, 360);
		contentPanel.add(btn_backgound2);
		
		JLabel lbl_backgrond = new JLabel("");
		lbl_backgrond.setIcon(new ImageIcon(LoginDialog.class.getResource("/icons/Thiết kế chưa có tên.png")));
		lbl_backgrond.setBounds(0, 0, 600, 600);
		contentPanel.add(lbl_backgrond);
		
		addEnterKeyListeners();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public boolean checkValForm() {
		if(text_tenDangNhap.getText().isEmpty() 
			|| passwordField.getText().isEmpty()) {
			return false;
		}
		return true;
	}
	
	private void addEnterKeyListeners() {
	    text_tenDangNhap.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Chuyển trỏ đến passwordField khi Enter được nhấn trên text_tenDangNhap
	            passwordField.requestFocusInWindow();
	        }
	    });

	    passwordField.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Thực hiện đăng nhập khi Enter được nhấn trên passwordField
	            login();
	        }
	    });
	}
	
	private void login() {
	    if (checkValForm()) {
	        String name = text_tenDangNhap.getText();
	        String pass = new String(passwordField.getPassword());
	        UserDao dao = new UserDao();
	        if (dao.checkLogin(name, pass)) {
	            MainForm main = new MainForm();
	            main.setVisible(true);
	            dispose();
	        } else {
	            showCanhBaoSaiThongTin();
	        }
	    } else {
	        showCanhBao();
	    }
	}
	
	public void xoaFormLogin() {
		text_tenDangNhap.setText("");
		passwordField.setText("");
	}
	
	
	private void hienThiMatKhau() {
	    if (chkHienThiMatKhau.isSelected()) {
	        passwordField.setEchoChar((char) 0); // Hiển thị mật khẩu
	    } else {
	        passwordField.setEchoChar('\u2022'); // Ẩn mật khẩu bằng ký tự dấu chấm (•)
	    }
	}
	public void showCanhBao() {
		JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông tin");
	}
	public void showCanhBaoSaiThongTin() {
		JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu! \r\n Vui lòng kiểm tra lại!");
	}
	public void showHoTroQuenMatKhau() {
	    //nếu quên mật khẩu thì nhập vào tên tk và dò trong userPassword)//chưa xử lý vấn đề này

	    String text = "admin      		 12345\n" +
	                  "22680401   		 2004\n" +
	                  "A1         		 12345\n" +
	                  "A2       		 12345\n" +
	                  "A3       		 12345\n";
	    JOptionPane.showMessageDialog(this, text);
	}
}
