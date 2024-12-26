package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;


import model.HocPhan;
import model.SinhVien;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MainForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu menuFile;
	
	//tab1
	private JTextField text1_mssv;
	private JTextField text1_hovaten;
	private JTextField text1_namsinh;
	private JTextField text1_lopdanhnghia;
	private JTable table1_ddsv;
	private JRadioButton rdbtn1_nam;
	private JRadioButton rdbtn1_nu;
	private ButtonGroup btn_gioiTinh;
	private JButton btn1_luuSV;

	
	//tab2
	private JTextField text2_mahp;
	private JTextField text2_tenhp;
	private JTextField text2_sotinchi;
	private JTextField text2_giangvien;
	private JTable table2_dshp;
	
	//tab3
	private JTextField text3_mahp;
	private JTextField text3_tenhp;
	private JTextField text3_hovaten;
	private JTable table_3QLdiem;
	private JTextField text3_thuongki;
	private JTextField text3_giuaki;
	private JTextField text3_cuoiki;
	private JButton btn3_reset;
	private JComboBox comboBox3_mssv;
	
	//tab4
	private JTextField text4_hovaten;
	private JTextField text4_gioitinh;
	private JTextField text4_lopdanhnghia;
	private JTextField text4_namsinh;
	private JTextField text4_tongtinchi;
	private JTextField text4_diemTB;
	private JTextField text4_xeploai;
	private JTable table4_ketqua;
	private JComboBox comboBox4_mssv;
	private JButton btn4_reset;
	
	//tab5
	private JTextField text5_hovaten;
	private JTextField text5_hpDangChon;
	private JTextField text5_namsinh;
	private JTable table5_hpdadangki;
	private JComboBox comboBox5_mssv;
	private JTable table5_hpchodangki;
	
	//khai báo các biến static
	private static int check =0;
	private static int index =0;
	private String tenFile = "";
	List<SinhVien> list = new ArrayList<SinhVien>();
	List<HocPhan> dshp = new ArrayList<HocPhan>();
	SinhVien sv;
	HocPhan hp;
	private JTabbedPane tabbedPane;
	private JPanel panel1_QLsinhvien;
	private JButton btn5_dangkiHP;
	private JButton btn5_huyHocPhan;
	private JButton btn1_xoaSV;
	private JButton btn1_suaSV;
	private JButton btn1_huyboSV;
	private JButton btn1_themSV;
	private JButton btn2_themHP;
	private JButton btn2_suaHP;
	private JButton btn2_xoaHP;
	private JButton btn2_huyboHP;
	private JButton btn2_luuHP;
	private JButton btn3_nhapdiem;
	private JButton btn3_suadiem;
	private JButton btn3_xoadiem;
	private JButton btn3_huybodiem;
	private JButton btn3_luudiem;
	
	
	/**
	 * Launch the application.
	 * * Launch the application.
	 * * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 * * Create the frame.
	 * * Create the frame.
	 */
	public MainForm() {
		setResizable(false);
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setTitle("Quản lý học vụ IUH - by Hồ Phúc Lâm ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainForm.class.getResource("/icons/LogoIUH.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 640);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuFile.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Folder.png")));
		menuFile.setFont(new Font("Dialog", Font.PLAIN, 18));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open file");
		menuOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienOpenFile();
			}
		});
		menuOpen.setFont(new Font("Dialog", Font.BOLD, 15));
		menuOpen.setIcon(new ImageIcon(MainForm.class.getResource("/icons/open-file-icon-16.png")));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save file");
		menuSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienSaveFile();
			}
		});
		menuSave.setFont(new Font("Dialog", Font.BOLD, 15));
		menuSave.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Save-icon.png")));
		menuFile.add(menuSave);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setFont(new Font("Dialog", Font.BOLD, 15));
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thoatKhoiChuongTrinh();
			}
		});
		menuExit.setIcon(new ImageIcon(MainForm.class.getResource("/icons/logout-icon-16.png")));
		menuFile.add(menuExit);
		
		JMenu menuAboutMe = new JMenu("About me");
		menuAboutMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienThiAboutMe();
			}
		});
		menuAboutMe.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Actions-help-about-icon-32.png")));
		menuAboutMe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hienThiAboutMe();
			}
		});
		menuAboutMe.setFont(new Font("Dialog", Font.PLAIN, 18));
		menuBar.add(menuAboutMe);
		
		JMenu menuHelp = new JMenu("Help");
		menuHelp.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Help.png")));
		menuHelp.setFont(new Font("Dialog", Font.PLAIN, 18));
		menuBar.add(menuHelp);
		
		JMenuItem menuhelp_qlsv = new JMenuItem("Quản lý sinh viên");
		menuhelp_qlsv.setIcon(new ImageIcon(MainForm.class.getResource("/icons/10207-man-student-light-skin-tone-icon-16.png")));
		menuhelp_qlsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMenuHelpQLSV();
			}
		});
		menuhelp_qlsv.setFont(new Font("Dialog", Font.BOLD, 15));
		menuHelp.add(menuhelp_qlsv);
		
		JMenuItem menuhelp_qlhocphan = new JMenuItem("Quản lý học phần");
		menuhelp_qlhocphan.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Actions-document-edit-icon-16.png")));
		menuhelp_qlhocphan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMenuHelpQLHP();
			}
		});
		menuhelp_qlhocphan.setFont(new Font("Dialog", Font.BOLD, 15));
		menuHelp.add(menuhelp_qlhocphan);
		
		JMenuItem menuhelp_qldiem = new JMenuItem("Quản lý điểm");
		menuhelp_qldiem.setIcon(new ImageIcon(MainForm.class.getResource("/icons/gpa-icon-24.png")));
		menuhelp_qldiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMenuHelpQLDiem();
			}
		});
		menuhelp_qldiem.setFont(new Font("Dialog", Font.BOLD, 15));
		menuHelp.add(menuhelp_qldiem);
		
		JMenuItem menuhelp_kqht = new JMenuItem("Kết quả học tập");
		menuhelp_kqht.setIcon(new ImageIcon(MainForm.class.getResource("/icons/ketquahoctap.png")));
		menuhelp_kqht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMenuHelpKQHT();
			}
		});
		menuhelp_kqht.setFont(new Font("Dialog", Font.BOLD, 15));
		menuHelp.add(menuhelp_kqht);
		
		JMenuItem menuhelp_dkhp = new JMenuItem("Đăng kí học phần");
		menuhelp_dkhp.setIcon(new ImageIcon(MainForm.class.getResource("/icons/hocphan.png")));
		menuhelp_dkhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMenuHelpDKHP();
			}
		});
		menuhelp_dkhp.setFont(new Font("Dialog", Font.BOLD, 15));
		menuHelp.add(menuhelp_dkhp);
		
		JMenu menuDangXuat = new JMenu("Đăng xuất");
		menuDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handleLogout();
			}
		});
		menuDangXuat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleLogout();	
			}
		});
		menuDangXuat.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Exit.png")));
		menuDangXuat.setFont(new Font("Dialog", Font.PLAIN, 18));
		menuBar.add(menuDangXuat);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 85, 702, 475);
		contentPane.add(tabbedPane);
		
		/*
		 * tab 1 quan ly sinh vien
		 * tab 1 quan ly sinh vien
		 * tab 1 quan ly sinh vien
		 * 
		 */
		
		JPanel panel1_QLsinhvien = new JPanel();
		tabbedPane.addTab("Quản lý sinh viên", new ImageIcon(MainForm.class.getResource("/icons/10207-man-student-light-skin-tone-icon-16.png")), panel1_QLsinhvien, null);
		panel1_QLsinhvien.setLayout(null);
		
		JLabel lbl1_mssv = new JLabel("Mã số sinh viên");
		lbl1_mssv.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl1_mssv.setBounds(37, 26, 140, 30);
		panel1_QLsinhvien.add(lbl1_mssv);
		
		text1_mssv = new JTextField();
		text1_mssv.setFont(new Font("Dialog", Font.PLAIN, 15));
		text1_mssv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1_hovaten.requestFocusInWindow();
			}
		});
		text1_mssv.setBounds(182, 28, 247, 30);
		panel1_QLsinhvien.add(text1_mssv);
		text1_mssv.setColumns(10);
		
		JLabel lbl1_hoten = new JLabel("Họ và Tên");
		lbl1_hoten.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl1_hoten.setBackground(new Color(238, 238, 238));
		lbl1_hoten.setBounds(37, 68, 90, 30);
		panel1_QLsinhvien.add(lbl1_hoten);
		
		text1_hovaten = new JTextField();
		text1_hovaten.setFont(new Font("Dialog", Font.PLAIN, 15));
		text1_hovaten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1_namsinh.requestFocusInWindow();
			}
		});
		text1_hovaten.setBounds(182, 70, 247, 30);
		panel1_QLsinhvien.add(text1_hovaten);
		text1_hovaten.setColumns(10);
		
		JLabel lbl1_namsinh = new JLabel("Năm sinh");
		lbl1_namsinh.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl1_namsinh.setBounds(37, 152, 84, 30);
		panel1_QLsinhvien.add(lbl1_namsinh);
		
		text1_namsinh = new JTextField();
		text1_namsinh.setFont(new Font("Dialog", Font.PLAIN, 15));
		text1_namsinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1_lopdanhnghia.requestFocusInWindow();
			}
		});
		text1_namsinh.setBounds(182, 154, 247, 30);
		panel1_QLsinhvien.add(text1_namsinh);
		text1_namsinh.setColumns(10);
		
		JLabel lbl1_gioitinh = new JLabel("Giới tính");
		lbl1_gioitinh.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl1_gioitinh.setBounds(37, 110, 79, 30);
		panel1_QLsinhvien.add(lbl1_gioitinh);	
		
		rdbtn1_nam = new JRadioButton("Nam");
		rdbtn1_nam.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        text1_namsinh.requestFocusInWindow();
		    }
		});

		rdbtn1_nam.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtn1_nam.setBounds(181, 110, 66, 30);
		panel1_QLsinhvien.add(rdbtn1_nam);
		
		rdbtn1_nu = new JRadioButton("Nữ");
		rdbtn1_nu.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        text1_namsinh.requestFocusInWindow();
		    }
		});
		rdbtn1_nu.setFont(new Font("Dialog", Font.BOLD, 15));
		rdbtn1_nu.setBounds(313, 111, 57, 30);
		panel1_QLsinhvien.add(rdbtn1_nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(rdbtn1_nam);
		btn_gioiTinh.add(rdbtn1_nu);
		
		JLabel lbl1_lopdanhnghia = new JLabel("Lớp danh nghĩa");
		lbl1_lopdanhnghia.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl1_lopdanhnghia.setBounds(37, 197, 142, 24);
		panel1_QLsinhvien.add(lbl1_lopdanhnghia);
		
		text1_lopdanhnghia = new JTextField();
		text1_lopdanhnghia.setFont(new Font("Dialog", Font.PLAIN, 15));
		text1_lopdanhnghia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienLuuSV1();
			}
		});
		text1_lopdanhnghia.setBounds(182, 196, 247, 30);
		panel1_QLsinhvien.add(text1_lopdanhnghia);
		text1_lopdanhnghia.setColumns(10);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(0, 233, 697, 199);
		panel1_QLsinhvien.add(scrollPane1);
		
		table1_ddsv = new JTable();
		table1_ddsv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				index = table1_ddsv.getSelectedRow();
				view1();
			}
		});
		table1_ddsv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table1_ddsv.getSelectedRow();
				view1();
			}
		});
		table1_ddsv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table1_ddsv.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "MSSV", "H\u1ECD v\u00E0 t\u00EAn", "Gi\u1EDBi t\u00EDnh", "N\u0103m sinh", "L\u1EDBp danh ngh\u0129a"
			}
		));
		table1_ddsv.setRowHeight(25);
		table1_ddsv.getColumnModel().getColumn(0).setPreferredWidth(32);
		table1_ddsv.getColumnModel().getColumn(2).setPreferredWidth(180);
		table1_ddsv.getColumnModel().getColumn(3).setPreferredWidth(60);
		table1_ddsv.getColumnModel().getColumn(4).setPreferredWidth(55);
		table1_ddsv.getColumnModel().getColumn(5).setPreferredWidth(100);
		table1_ddsv.setFont(new Font("Dialog", Font.PLAIN, 15));
		scrollPane1.setViewportView(table1_ddsv);
		
		btn1_themSV = new JButton("Thêm");
		btn1_themSV.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Add.png")));
		btn1_themSV.setBounds(486, 26, 138, 30);
		panel1_QLsinhvien.add(btn1_themSV);
		
		btn1_suaSV = new JButton("Sửa");
		btn1_suaSV.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Equipment.png")));
		btn1_suaSV.setBounds(486, 70, 138, 30);
		panel1_QLsinhvien.add(btn1_suaSV);
		
		btn1_xoaSV = new JButton("Xóa");
		btn1_xoaSV.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Eraser.png")));
		btn1_xoaSV.setBounds(486, 112, 138, 30);
		panel1_QLsinhvien.add(btn1_xoaSV);
		
		btn1_huyboSV = new JButton("Hủy bỏ");
		btn1_huyboSV.setEnabled(false);
		btn1_huyboSV.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Close.png")));
		btn1_huyboSV.setBounds(486, 154, 138, 30);
		panel1_QLsinhvien.add(btn1_huyboSV);
		
		btn1_luuSV = new JButton("Lưu");
		btn1_luuSV.setEnabled(false);
		btn1_luuSV.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Apply.png")));
		btn1_luuSV.setBounds(486, 196, 138, 30);
		panel1_QLsinhvien.add(btn1_luuSV);
		
		
		
		btn1_themSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        batNutLuuHuyBo1(true, false);
				check=1;
				xoaForm1();
				text1_mssv.requestFocusInWindow();

			}
		});
		btn1_suaSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				batNutLuuHuyBo1(true, false);
				check =-1;
			}
		});
		btn1_xoaSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienXoaSV1();	
			}
		});
		btn1_huyboSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view1();
				batNutLuuHuyBo1(false, true);
			}
		});
		btn1_luuSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienLuuSV1();
			}
		});
	
		
		/*
		 * tab 2 quan ly hoc phan
		 * tab 2 quan ly hoc phan
		 * tab 2 quan ly hoc phan
		 */
		
		JPanel panel2_QLhocphan = new JPanel();
		tabbedPane.addTab("Quản lý học phần", new ImageIcon(MainForm.class.getResource("/icons/Actions-document-edit-icon-16.png")), panel2_QLhocphan, null);
		panel2_QLhocphan.setLayout(null);
		
		JLabel lbl2_mshp = new JLabel("Mã học phần");
		lbl2_mshp.setBounds(37, 26, 140, 30);
		lbl2_mshp.setFont(new Font("Dialog", Font.BOLD, 18));
		panel2_QLhocphan.add(lbl2_mshp);
		
		text2_mahp = new JTextField();
		text2_mahp.setFont(new Font("Dialog", Font.PLAIN, 15));
		text2_mahp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text2_tenhp.requestFocusInWindow();
			}
		});
		text2_mahp.setBounds(182, 28, 220, 30);
		text2_mahp.setColumns(10);
		panel2_QLhocphan.add(text2_mahp);
		
		JLabel lbl2_tenhp = new JLabel("Tên học phần");
		lbl2_tenhp.setBounds(37, 68, 140, 30);
		lbl2_tenhp.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl2_tenhp.setBackground(UIManager.getColor("Button.background"));
		panel2_QLhocphan.add(lbl2_tenhp);
		
		text2_tenhp = new JTextField();
		text2_tenhp.setFont(new Font("Dialog", Font.PLAIN, 15));
		text2_tenhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text2_sotinchi.requestFocusInWindow();
			}
		});
		text2_tenhp.setBounds(182, 70, 220, 30);
		text2_tenhp.setColumns(10);
		panel2_QLhocphan.add(text2_tenhp);
		
		JLabel lbl2_sotinchi = new JLabel("Số tín chỉ");
		lbl2_sotinchi.setBounds(37, 112, 140, 30);
		lbl2_sotinchi.setFont(new Font("Dialog", Font.BOLD, 18));
		panel2_QLhocphan.add(lbl2_sotinchi);
		
		text2_sotinchi = new JTextField();
		text2_sotinchi.setFont(new Font("Dialog", Font.PLAIN, 15));
		text2_sotinchi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text2_giangvien.requestFocusInWindow();
			}
		});
		text2_sotinchi.setBounds(182, 114, 220, 30);
		text2_sotinchi.setColumns(10);
		panel2_QLhocphan.add(text2_sotinchi);
		
		JLabel lbl2_giangvien = new JLabel("Giảng viên");
		lbl2_giangvien.setBounds(35, 157, 142, 24);
		lbl2_giangvien.setFont(new Font("Dialog", Font.BOLD, 18));
		panel2_QLhocphan.add(lbl2_giangvien);
		
		text2_giangvien = new JTextField();
		text2_giangvien.setFont(new Font("Dialog", Font.PLAIN, 15));
		text2_giangvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienLuuHP2();
			}
		});
		text2_giangvien.setBounds(182, 156, 220, 30);
		text2_giangvien.setColumns(10);
		panel2_QLhocphan.add(text2_giangvien);
		
		JScrollPane scrollPane2_QLHocPhan = new JScrollPane();
		scrollPane2_QLHocPhan.setBounds(0, 190, 697, 230);
		panel2_QLhocphan.add(scrollPane2_QLHocPhan);
		
		table2_dshp = new JTable();
		table2_dshp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				index = table2_dshp.getSelectedRow();
				viewHP2();
			}
		});
		table2_dshp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table2_dshp.getSelectedRow();
				viewHP2();
			}
		});
		table2_dshp.setFont(new Font("Dialog", Font.PLAIN, 15));
		table2_dshp.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 HP", "T\u00EAn HP", "S\u1ED1 t\u00EDn ch\u1EC9", "Gi\u1EA3ng vi\u00EAn"
			}
		));
		table2_dshp.getColumnModel().getColumn(0).setPreferredWidth(40);
		table2_dshp.getColumnModel().getColumn(2).setPreferredWidth(180);
		table2_dshp.getColumnModel().getColumn(3).setPreferredWidth(50);
		table2_dshp.getColumnModel().getColumn(4).setPreferredWidth(100);
		table2_dshp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2_dshp.setRowHeight(25);
		scrollPane2_QLHocPhan.setViewportView(table2_dshp);
		
		btn2_themHP = new JButton("Thêm");
		btn2_themHP.setHorizontalAlignment(SwingConstants.LEADING);
		btn2_themHP.setBounds(419, 28, 110, 30);
		btn2_themHP.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Add.png")));
		panel2_QLhocphan.add(btn2_themHP);
		
		btn2_suaHP = new JButton("Sửa");
		btn2_suaHP.setBounds(418, 70, 252, 30);
		btn2_suaHP.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Equipment.png")));
		panel2_QLhocphan.add(btn2_suaHP);
		
		btn2_xoaHP = new JButton("Xóa");
		btn2_xoaHP.setBounds(555, 28, 110, 30);	
		btn2_xoaHP.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Cut.png")));
		panel2_QLhocphan.add(btn2_xoaHP);
		
		btn2_huyboHP = new JButton("Hủy bỏ");
		btn2_huyboHP.setEnabled(false);
		btn2_huyboHP.setBounds(555, 114, 110, 30);
		btn2_huyboHP.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Close.png")));
		panel2_QLhocphan.add(btn2_huyboHP);
		
		btn2_luuHP = new JButton("Lưu");
		btn2_luuHP.setEnabled(false);
		btn2_luuHP.setBounds(419, 114, 110, 30);
		btn2_luuHP.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Apply.png")));
		panel2_QLhocphan.add(btn2_luuHP);
		
		
		btn2_themHP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check =1;
				xoaForm2();
				hienThiMessHayThaoTac();
				text2_mahp.requestFocusInWindow();
				batNutLuuHuyBo2(true, false);
			}
		});
		btn2_suaHP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check=-1;
				hienThiMessHayThaoTac();
				batNutLuuHuyBo2(true, false);
			}
		});
		btn2_xoaHP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienXoaHP2();			
			}
		});
		btn2_huyboHP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewHP2();
				batNutLuuHuyBo2(false, true);
			}
		});
		btn2_luuHP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienLuuHP2();
			}
		});
		/*
		 * 
		 * tab3 quan ly diem
		 * tab3 quan ly diem
		 * tab3 quan ly diem
		 * 
		 */
		
		JPanel panel3_QLdiem = new JPanel();
		panel3_QLdiem.setLayout(null);
		tabbedPane.addTab("Quản lý điểm", new ImageIcon(MainForm.class.getResource("/icons/gpa-icon-24.png")), panel3_QLdiem, null);
		
		JLabel lbl3_mshp = new JLabel("Mã học phần");
		lbl3_mshp.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl3_mshp.setBounds(20, 86, 140, 30);
		panel3_QLdiem.add(lbl3_mshp);
		
		text3_mahp = new JTextField();
		text3_mahp.setFont(new Font("Dialog", Font.PLAIN, 15));
		text3_mahp.setEditable(false);
		text3_mahp.setColumns(10);
		text3_mahp.setBounds(163, 87, 163, 30);
		panel3_QLdiem.add(text3_mahp);
		
		JLabel lbl3_tenhp = new JLabel("Tên học phần");
		lbl3_tenhp.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl3_tenhp.setBackground(UIManager.getColor("Button.background"));
		lbl3_tenhp.setBounds(390, 85, 124, 30);
		panel3_QLdiem.add(lbl3_tenhp);
		
		text3_tenhp = new JTextField();
		text3_tenhp.setFont(new Font("Dialog", Font.PLAIN, 15));
		text3_tenhp.setEditable(false);
		text3_tenhp.setColumns(10);
		text3_tenhp.setBounds(517, 87, 163, 30);
		panel3_QLdiem.add(text3_tenhp);
		
		JScrollPane scrollPane3_dsdiem = new JScrollPane();
		scrollPane3_dsdiem.setBounds(0, 251, 697, 181);
		panel3_QLdiem.add(scrollPane3_dsdiem);
		
		table_3QLdiem = new JTable();
		table_3QLdiem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_3QLdiem.setFont(new Font("Dialog", Font.PLAIN, 15));
		table_3QLdiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				index = table_3QLdiem.getSelectedRow();
				viewHP3();
			}
		});
		table_3QLdiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table_3QLdiem.getSelectedRow();
				viewHP3();
			}
		});
		table_3QLdiem.setRowHeight(25);
		table_3QLdiem.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 HP", "T\u00EAn HP", "T\u00EDn ch\u1EC9", "TK", "GK", "CK", "Final", "Rank"
			}
		));
		table_3QLdiem.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_3QLdiem.getColumnModel().getColumn(1).setPreferredWidth(120);
		table_3QLdiem.getColumnModel().getColumn(2).setPreferredWidth(200);
		table_3QLdiem.getColumnModel().getColumn(3).setPreferredWidth(50);
		table_3QLdiem.getColumnModel().getColumn(4).setPreferredWidth(50);
		table_3QLdiem.getColumnModel().getColumn(5).setPreferredWidth(50);
		table_3QLdiem.getColumnModel().getColumn(6).setPreferredWidth(50);
		table_3QLdiem.getColumnModel().getColumn(7).setPreferredWidth(50);
		table_3QLdiem.getColumnModel().getColumn(8).setPreferredWidth(50);
		scrollPane3_dsdiem.setViewportView(table_3QLdiem);
		
		btn3_nhapdiem = new JButton("Nhập điểm");
		btn3_nhapdiem.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Actions-document-edit-icon-16.png")));
		btn3_nhapdiem.setFont(new Font("Dialog", Font.BOLD, 12));
		btn3_nhapdiem.setBounds(20, 194, 120, 30);
		panel3_QLdiem.add(btn3_nhapdiem);
		
		btn3_suadiem = new JButton("Sửa");
		btn3_suadiem.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Eraser.png")));
		btn3_suadiem.setBounds(152, 194, 120, 30);
		panel3_QLdiem.add(btn3_suadiem);
		
		btn3_xoadiem = new JButton("Xóa");
		btn3_xoadiem.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Cut.png")));
		btn3_xoadiem.setBounds(288, 194, 120, 30);
		panel3_QLdiem.add(btn3_xoadiem);
		
		btn3_huybodiem = new JButton("Hủy bỏ");
		btn3_huybodiem.setEnabled(false);
		btn3_huybodiem.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Close.png")));
		btn3_huybodiem.setBounds(424, 194, 120, 30);
		panel3_QLdiem.add(btn3_huybodiem);
		
		btn3_luudiem = new JButton("Lưu");
		btn3_luudiem.setEnabled(false);
		btn3_luudiem.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Save-icon.png")));
		btn3_luudiem.setBounds(560, 194, 120, 30);
		panel3_QLdiem.add(btn3_luudiem);
		
		btn3_reset = new JButton("");
		btn3_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetDuLieuSauThaoTac();
			}
		});
		btn3_reset.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Diagram.png")));
		btn3_reset.setFont(new Font("Dialog", Font.BOLD, 12));
		btn3_reset.setBounds(329, 30, 43, 30);
		panel3_QLdiem.add(btn3_reset);
		
		JLabel lbl3_mssv = new JLabel("Mã số sinh viên");
		lbl3_mssv.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl3_mssv.setBounds(20, 30, 140, 30);
		panel3_QLdiem.add(lbl3_mssv);
		
		JLabel lbl3_hovaten = new JLabel("Họ và tên");
		lbl3_hovaten.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl3_hovaten.setBounds(394, 30, 120, 30);
		panel3_QLdiem.add(lbl3_hovaten);
		
		text3_hovaten = new JTextField();
		text3_hovaten.setFont(new Font("Dialog", Font.PLAIN, 15));
		text3_hovaten.setEditable(false);
		text3_hovaten.setColumns(10);
		text3_hovaten.setBounds(517, 30, 163, 30);
		panel3_QLdiem.add(text3_hovaten);
		
		JLabel lbl3_thuongki = new JLabel("Thường kì");
		lbl3_thuongki.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl3_thuongki.setBounds(20, 139, 94, 30);
		panel3_QLdiem.add(lbl3_thuongki);
		
		JLabel lbl3_giuaki = new JLabel("Giữa kì");
		lbl3_giuaki.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl3_giuaki.setBounds(288, 139, 94, 30);
		panel3_QLdiem.add(lbl3_giuaki);
		
		JLabel lbl3_cuoiki = new JLabel("Cuối kì");
		lbl3_cuoiki.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl3_cuoiki.setBounds(492, 139, 94, 30);
		panel3_QLdiem.add(lbl3_cuoiki);
		
		text3_thuongki = new JTextField();
		text3_thuongki.setFont(new Font("Dialog", Font.PLAIN, 15));
		text3_thuongki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text3_giuaki.requestFocusInWindow();
			}
		});
		text3_thuongki.setBounds(120, 139, 120, 30);
		panel3_QLdiem.add(text3_thuongki);
		text3_thuongki.setColumns(10);
		
		text3_giuaki = new JTextField();
		text3_giuaki.setFont(new Font("Dialog", Font.PLAIN, 15));
		text3_giuaki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text3_cuoiki.requestFocusInWindow();
			}
		});
		text3_giuaki.setColumns(10);
		text3_giuaki.setBounds(354, 140, 120, 30);
		panel3_QLdiem.add(text3_giuaki);
		
		text3_cuoiki = new JTextField();
		text3_cuoiki.setFont(new Font("Dialog", Font.PLAIN, 15));
		text3_cuoiki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienLuuDiemHP3();
			}
		});
		text3_cuoiki.setColumns(10);
		text3_cuoiki.setBounds(560, 140, 120, 30);
		panel3_QLdiem.add(text3_cuoiki);
		
		comboBox3_mssv = new JComboBox();
		comboBox3_mssv.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
                    int selectedMssv = (int) e.getItem();
                    hienThiSVTab3(selectedMssv);
                    viewTableHP3(timSinhVienSeclet3(selectedMssv).getHocPhans());
                }
			}
		});
	
		comboBox3_mssv.setFont(new Font("Dialog", Font.BOLD, 15));
		comboBox3_mssv.setBounds(163, 30, 163, 30);
		panel3_QLdiem.add(comboBox3_mssv);
		
		
		btn3_nhapdiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				batNutLuuHuyBo3(true, false);
				check = 1;
				xoaForm3();
				text3_thuongki.requestFocusInWindow();
			}
		});
		
		btn3_suadiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				batNutLuuHuyBo3(true, false);
				check =-1;
			}
		});

		btn3_xoadiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedMssv = (int) comboBox3_mssv.getSelectedItem();
				xoaDiemHP3();
				viewTableHP3(timSinhVienSeclet3(selectedMssv).getHocPhans());
			}
		});	
		btn3_huybodiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				batNutLuuHuyBo3(false, true);
				viewHP3();
				xoaForm3();
			}
		});
		btn3_luudiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thucHienLuuDiemHP3();
			}
		});

		/*
		 * tab 4 ket qua học tập
		 * tab 4 ket qua học tập
		 * tab 4 ket qua học tập
		 * 
		 */
		
		JPanel panel4_ketquahoctap = new JPanel();
		panel4_ketquahoctap.setLayout(null);
		tabbedPane.addTab("Kết quả học tập", new ImageIcon(MainForm.class.getResource("/icons/ketquahoctap.png")), panel4_ketquahoctap, null);
		
		JScrollPane scrollPane4_ketqua = new JScrollPane();
		scrollPane4_ketqua.setBounds(0, 241, 697, 191);
		panel4_ketquahoctap.add(scrollPane4_ketqua);
		
		table4_ketqua = new JTable();
		table4_ketqua.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table4_ketqua.setFont(new Font("Dialog", Font.PLAIN, 15));
		table4_ketqua.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 HP", "T\u00EAn HP", "T\u00EDn ch\u1EC9", "TK", "GK", "CK", "Final", "Rank"
			}
		));
		table4_ketqua.getColumnModel().getColumn(0).setPreferredWidth(35);
		table4_ketqua.getColumnModel().getColumn(0).setMinWidth(1);
		table4_ketqua.getColumnModel().getColumn(2).setPreferredWidth(200);
		table4_ketqua.getColumnModel().getColumn(2).setMinWidth(20);
		table4_ketqua.getColumnModel().getColumn(3).setPreferredWidth(47);
		table4_ketqua.getColumnModel().getColumn(4).setPreferredWidth(50);
		table4_ketqua.getColumnModel().getColumn(5).setPreferredWidth(50);
		table4_ketqua.getColumnModel().getColumn(6).setPreferredWidth(50);
		table4_ketqua.getColumnModel().getColumn(7).setPreferredWidth(50);
		table4_ketqua.getColumnModel().getColumn(8).setPreferredWidth(50);
		table4_ketqua.setRowHeight(25);
		scrollPane4_ketqua.setViewportView(table4_ketqua);
		
		JLabel lbl4_mssv = new JLabel("Mã số sinh viên");
		lbl4_mssv.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl4_mssv.setBounds(22, 28, 156, 30);
		panel4_ketquahoctap.add(lbl4_mssv);
		
		JLabel lbl4_hovaten = new JLabel("Họ và tên");
		lbl4_hovaten.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl4_hovaten.setBounds(22, 72, 130, 30);
		panel4_ketquahoctap.add(lbl4_hovaten);
		
		JLabel lbl4_gioitinh = new JLabel("Giới tính");
		lbl4_gioitinh.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl4_gioitinh.setBounds(22, 114, 140, 30);
		panel4_ketquahoctap.add(lbl4_gioitinh);
		
		JLabel lbl4_lopdanhnghia = new JLabel("Lớp danh nghĩa");
		lbl4_lopdanhnghia.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl4_lopdanhnghia.setBounds(22, 195, 156, 30);
		panel4_ketquahoctap.add(lbl4_lopdanhnghia);
		
		JLabel lbl4_namsinh = new JLabel("Năm sinh");
		lbl4_namsinh.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl4_namsinh.setBounds(22, 157, 156, 30);
		panel4_ketquahoctap.add(lbl4_namsinh);
		
		JLabel lbl4_diemTB = new JLabel("Điểm Trung bình tích lũy");
		lbl4_diemTB.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl4_diemTB.setBounds(345, 74, 220, 30);
		panel4_ketquahoctap.add(lbl4_diemTB);
		
		JLabel lbl4_xeploai = new JLabel("Xếp loại tích lũy");
		lbl4_xeploai.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl4_xeploai.setBounds(346, 116, 217, 30);
		panel4_ketquahoctap.add(lbl4_xeploai);
		
		JLabel lbl4_tongtinchi = new JLabel("Tổng tín chỉ tích lũy");
		lbl4_tongtinchi.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl4_tongtinchi.setBounds(343, 30, 218, 30);
		panel4_ketquahoctap.add(lbl4_tongtinchi);
		
		btn4_reset = new JButton("");
		btn4_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetDuLieuSauThaoTac();
			}
		});
		btn4_reset.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Diagram.png")));
		btn4_reset.setFont(new Font("Dialog", Font.BOLD, 12));
		btn4_reset.setBounds(282, 30, 43, 30);
		panel4_ketquahoctap.add(btn4_reset);
		
		text4_hovaten = new JTextField();
		text4_hovaten.setFont(new Font("Dialog", Font.PLAIN, 15));
		text4_hovaten.setEditable(false);
		text4_hovaten.setColumns(10);
		text4_hovaten.setBounds(164, 72, 163, 30);
		panel4_ketquahoctap.add(text4_hovaten);
		
		comboBox4_mssv = new JComboBox();
		comboBox4_mssv.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
                    int selectedMssv = (int) e.getItem();
                    hienThiSVTab4(selectedMssv);
					viewTableHP4(timSinhVienSeclet3(selectedMssv).getHocPhans());
                }
			}
		});
		comboBox4_mssv.setFont(new Font("Dialog", Font.BOLD, 15));
		comboBox4_mssv.setBounds(164, 30, 116, 30);
		panel4_ketquahoctap.add(comboBox4_mssv);
		
		text4_gioitinh = new JTextField();
		text4_gioitinh.setFont(new Font("Dialog", Font.PLAIN, 15));
		text4_gioitinh.setEditable(false);
		text4_gioitinh.setColumns(10);
		text4_gioitinh.setBounds(164, 116, 163, 30);
		panel4_ketquahoctap.add(text4_gioitinh);
		
		text4_lopdanhnghia = new JTextField();
		text4_lopdanhnghia.setFont(new Font("Dialog", Font.PLAIN, 15));
		text4_lopdanhnghia.setEditable(false);
		text4_lopdanhnghia.setColumns(10);
		text4_lopdanhnghia.setBounds(164, 199, 163, 30);
		panel4_ketquahoctap.add(text4_lopdanhnghia);
		
		text4_namsinh = new JTextField();
		text4_namsinh.setFont(new Font("Dialog", Font.PLAIN, 15));
		text4_namsinh.setEditable(false);
		text4_namsinh.setColumns(10);
		text4_namsinh.setBounds(164, 158, 163, 30);
		panel4_ketquahoctap.add(text4_namsinh);
		
		text4_tongtinchi = new JTextField();
		text4_tongtinchi.setFont(new Font("Dialog", Font.PLAIN, 15));
		text4_tongtinchi.setEditable(false);
		text4_tongtinchi.setColumns(10);
		text4_tongtinchi.setBounds(576, 30, 72, 30);
		panel4_ketquahoctap.add(text4_tongtinchi);
		
		text4_diemTB = new JTextField();
		text4_diemTB.setFont(new Font("Dialog", Font.PLAIN, 15));
		text4_diemTB.setEditable(false);
		text4_diemTB.setColumns(10);
		text4_diemTB.setBounds(576, 72, 72, 30);
		panel4_ketquahoctap.add(text4_diemTB);
		
		text4_xeploai = new JTextField();
		text4_xeploai.setFont(new Font("Dialog", Font.PLAIN, 15));
		text4_xeploai.setEditable(false);
		text4_xeploai.setColumns(10);
		text4_xeploai.setBounds(576, 121, 72, 30);
		panel4_ketquahoctap.add(text4_xeploai);
		
		/*
		 * tab 5 đăng kí học phần
		 * tab 5 đăng kí học phần
		 * tab 5 đăng kí học phần
		 * 
		 */
		
		JPanel panel5_dangkihocphan = new JPanel();
		panel5_dangkihocphan.setLayout(null);
		tabbedPane.addTab("Đăng kí học phần", new ImageIcon(MainForm.class.getResource("/icons/hocphan.png")), panel5_dangkihocphan, null);
		
		JScrollPane scrollPane5_hpchodangki = new JScrollPane();
		scrollPane5_hpchodangki.setBounds(12, 126, 673, 127);
		panel5_dangkihocphan.add(scrollPane5_hpchodangki);
		
		table5_hpchodangki = new JTable();
		table5_hpchodangki.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table5_hpchodangki.setFont(new Font("Dialog", Font.PLAIN, 15));
		table5_hpchodangki.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table5_hpchodangki.getSelectedRow();
				viewHPcuaDSHP5();
				btn5_dangkiHP.setEnabled(true);
				btn5_huyHocPhan.setEnabled(false);
				table5_hpdadangki.clearSelection();
			}
		});
		table5_hpchodangki.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				index = table5_hpchodangki.getSelectedRow();
				viewHPcuaDSHP5();
				btn5_dangkiHP.setEnabled(true);
				btn5_huyHocPhan.setEnabled(false);
				table5_hpdadangki.clearSelection();
			}
		});
		table5_hpchodangki.setRowHeight(25);
		table5_hpchodangki.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 HP", "T\u00EAn HP", "T\u00EDn ch\u1EC9", "Gi\u1EA3ng vi\u00EAn"
			}
		));
		table5_hpchodangki.getColumnModel().getColumn(0).setPreferredWidth(40);
		table5_hpchodangki.getColumnModel().getColumn(1).setPreferredWidth(90);
		table5_hpchodangki.getColumnModel().getColumn(2).setPreferredWidth(200);
		table5_hpchodangki.getColumnModel().getColumn(3).setPreferredWidth(50);
		table5_hpchodangki.getColumnModel().getColumn(4).setPreferredWidth(90);
		scrollPane5_hpchodangki.setViewportView(table5_hpchodangki);
		
		JLabel lbl5_mssv = new JLabel("Mã số sinh viên");
		lbl5_mssv.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl5_mssv.setBounds(22, 12, 156, 30);
		panel5_dangkihocphan.add(lbl5_mssv);
		
		JLabel lbl5_hovaten = new JLabel("Họ và tên");
		lbl5_hovaten.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl5_hovaten.setBounds(351, 12, 130, 30);
		panel5_dangkihocphan.add(lbl5_hovaten);
		
		JLabel lbl5_hpDangChon = new JLabel("Học phần đang chọn");
		lbl5_hpDangChon.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl5_hpDangChon.setBounds(351, 54, 186, 30);
		panel5_dangkihocphan.add(lbl5_hpDangChon);
		
		JLabel lbl5_namsinh = new JLabel("Năm sinh");
		lbl5_namsinh.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl5_namsinh.setBounds(22, 53, 156, 30);
		panel5_dangkihocphan.add(lbl5_namsinh);
		
		text5_hovaten = new JTextField();
		text5_hovaten.setFont(new Font("Dialog", Font.PLAIN, 15));
		text5_hovaten.setEditable(false);
		text5_hovaten.setColumns(10);
		text5_hovaten.setBounds(540, 14, 145, 30);
		panel5_dangkihocphan.add(text5_hovaten);
		
		comboBox5_mssv = new JComboBox();
		comboBox5_mssv.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
                    int selectedMssv = (int) e.getItem();
                    viewSV5();        
                    viewTableHP5(timSinhVienSeclet3(selectedMssv).getHocPhans());
                }
			}
		});
		comboBox5_mssv.setFont(new Font("Dialog", Font.BOLD, 15));
		comboBox5_mssv.setBounds(164, 14, 118, 30);
		panel5_dangkihocphan.add(comboBox5_mssv);
		
		text5_hpDangChon = new JTextField();
		text5_hpDangChon.setFont(new Font("Dialog", Font.PLAIN, 15));
		text5_hpDangChon.setEditable(false);
		text5_hpDangChon.setColumns(10);
		text5_hpDangChon.setBounds(540, 54, 145, 30);
		panel5_dangkihocphan.add(text5_hpDangChon);
		
		text5_namsinh = new JTextField();
		text5_namsinh.setFont(new Font("Dialog", Font.PLAIN, 15));
		text5_namsinh.setEditable(false);
		text5_namsinh.setColumns(10);
		text5_namsinh.setBounds(164, 54, 156, 30);
		panel5_dangkihocphan.add(text5_namsinh);
		
		JScrollPane scrollPane5_hpdadangki = new JScrollPane();
		scrollPane5_hpdadangki.setBounds(0, 291, 697, 141);
		panel5_dangkihocphan.add(scrollPane5_hpdadangki);
		
		table5_hpdadangki = new JTable();
		table5_hpdadangki.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table5_hpdadangki.setFont(new Font("Dialog", Font.PLAIN, 15));
		table5_hpdadangki.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				index = table5_hpdadangki.getSelectedRow();
                viewHPcuaSV5();   
                btn5_dangkiHP.setEnabled(false);
				btn5_huyHocPhan.setEnabled(true);
				table5_hpchodangki.clearSelection();
			}
		});
		table5_hpdadangki.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = table5_hpdadangki.getSelectedRow();
                viewHPcuaSV5();
                btn5_dangkiHP.setEnabled(false);
				btn5_huyHocPhan.setEnabled(true);
				table5_hpchodangki.clearSelection();
			}
		});
		table5_hpdadangki.setRowHeight(25);
		table5_hpdadangki.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 HP", "T\u00EAn HP", "T\u00EDn ch\u1EC9", "Gi\u1EA3ng vi\u00EAn"
			}
		));
		table5_hpdadangki.getColumnModel().getColumn(0).setPreferredWidth(40);
		table5_hpdadangki.getColumnModel().getColumn(1).setPreferredWidth(90);
		table5_hpdadangki.getColumnModel().getColumn(2).setPreferredWidth(200);
		table5_hpdadangki.getColumnModel().getColumn(3).setPreferredWidth(50);
		table5_hpdadangki.getColumnModel().getColumn(4).setPreferredWidth(90);
		scrollPane5_hpdadangki.setViewportView(table5_hpdadangki);
		
		JLabel lbl5_hocphandadangki = new JLabel("Học phần đã đăng kí");
		lbl5_hocphandadangki.setForeground(new Color(0, 128, 64));
		lbl5_hocphandadangki.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl5_hocphandadangki.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5_hocphandadangki.setBounds(12, 265, 673, 24);
		panel5_dangkihocphan.add(lbl5_hocphandadangki);
		
		btn5_dangkiHP = new JButton("Đăng kí");
		btn5_dangkiHP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangKiHocPhanSV5();
				
			}
		});
		btn5_dangkiHP.setFont(new Font("Dialog", Font.BOLD, 12));
		btn5_dangkiHP.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Apply.png")));
		btn5_dangkiHP.setBounds(12, 251, 112, 41);
		panel5_dangkihocphan.add(btn5_dangkiHP);
		
		btn5_huyHocPhan = new JButton("Hủy HP");
		btn5_huyHocPhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				huyHocPhanSV5();
			}
		});
		btn5_huyHocPhan.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Close.png")));
		btn5_huyHocPhan.setBounds(573, 251, 112, 41);
		panel5_dangkihocphan.add(btn5_huyHocPhan);
		
		JButton btn5_reset = new JButton("");
		btn5_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetDuLieuSauThaoTac();
			}
		});
		btn5_reset.setIcon(new ImageIcon(MainForm.class.getResource("/icons/Diagram.png")));
		btn5_reset.setBounds(281, 14, 39, 30);
		panel5_dangkihocphan.add(btn5_reset);
		
		JLabel lbl5_hocphandadangki_1 = new JLabel("Học phần đang chờ đăng kí");
		lbl5_hocphandadangki_1.setForeground(new Color(255, 128, 0));
		lbl5_hocphandadangki_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5_hocphandadangki_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lbl5_hocphandadangki_1.setBounds(12, 95, 673, 24);
		panel5_dangkihocphan.add(lbl5_hocphandadangki_1);
		
		JLabel lbl_title = new JLabel("");
		lbl_title.setBounds(12, 0, 702, 84);
		contentPane.add(lbl_title);
		lbl_title.setIcon(new ImageIcon(MainForm.class.getResource("/icons/screenshot_1702190548.png")));
		
		/*
		 * Thêm vào các đối tượng để xử lý chạy test case
		 * Thêm vào các đối tượng để xử lý chạy test case
		 */
		
		//tab1
		list.add(new SinhVien(22680012, "Ho Phuc Lam", true, 2004, "DHTH18C"));
		list.add(new SinhVien(22680034, "Nguyen Hoang Vy", false, 2004, "DHKQ18BTT"));
		list.add(new SinhVien(22680056, "Nguyen Van Anh", false, 2004, "DHQTKD18ATT"));
		list.add(new SinhVien(22680078, "Nguyen Tuan", true, 2004, "DHNL19B"));
		view1();
		viewTableSV();
		
		//tab2
		
		dshp.add(new HocPhan(420091, "Toán CC1", 3, "Cô Thu Hà"));
		dshp.add(new HocPhan(420092, "Toán CC2", 2, "Thầy Phan Hưng"));
		dshp.add(new HocPhan(420093, "Nhập môn CNTT", 3, "Cô Hồng"));
		dshp.add(new HocPhan(420094, "Nhập môn Lập trình", 2, "Thầy Tình"));
		dshp.add(new HocPhan(420095, "Lập trình CNTT trong JAVA", 4, "Thầy Phương"));
		viewHP2();
		viewTableHP2();
		
		//tab3
		list.get(0).getHocPhans().add(dshp.get(1));
		list.get(0).getHocPhans().add(dshp.get(2));
		list.get(0).getHocPhans().add(dshp.get(4));
		
		list.get(1).getHocPhans().add(dshp.get(4));
		list.get(1).getHocPhans().add(dshp.get(3));
		list.get(1).getHocPhans().add(dshp.get(2));
		
		list.get(2).getHocPhans().add(dshp.get(2));
		list.get(2).getHocPhans().add(dshp.get(0));
		
		list.get(3).getHocPhans().add(dshp.get(4));
		list.get(3).getHocPhans().add(dshp.get(1));
		

		viewTableHP3(dshp);
		showComboMSSV3(list);
		
		//tab4 ket qua hoc tap
		showComboMSSV4(list);
		
		//tab5 dang ki hoc phan
		showComboMSSV5(list);
		viewHPcuaSV5();
		viewTableHPAvaible5(dshp);
		
		
		setLocationRelativeTo(null);
		setVisible(true);
		//hết hàm mainForm();
	}


	/**
	 * viet ham void de xu ly su kien			viet ham void de xu ly su kien
	 * viet ham void de xu ly su kien			viet ham void de xu ly su kien
	 * viet ham void de xu ly su kien			viet ham void de xu ly su kien
	 * 
	 */
	
	
	/*
	 * tab 1 Xử lý sự kiện quản lý danh sách sinh viên
	 * tab 1 Xử lý sự kiện quản lý danh sách sinh viên
	 * tab 1 Xử lý sự kiện quản lý danh sách sinh viên
	 * 
	 */
	public void showCanhBao() {
		JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông tin");
	}
	
	public void xoaForm1() {
		text1_hovaten.setText("");
		text1_mssv.setText("");
		text1_namsinh.setText("");
		text1_lopdanhnghia.setText("");
		btn_gioiTinh.clearSelection();
	}
	
	public void view1() {
		sv = list.get(index);
		this.text1_mssv.setText(sv.getMssv()+"");
		this.text1_hovaten.setText(sv.getName());
		this.text1_namsinh.setText(sv.getAge()+"");
		this.text1_lopdanhnghia.setText(sv.getLopDanhNghia());
		
		if(sv.getGender()) {
			rdbtn1_nam.setSelected(true);
		}else {
			rdbtn1_nu.setSelected(true);
		}
	}
	
	public void viewTableSV() {
		DefaultTableModel model = (DefaultTableModel) this.table1_ddsv.getModel();
		model.setNumRows(0);
		int n=1;
		for (SinhVien x : list) {
			model.addRow(
					new Object[] { 
					n++, x.getMssv()+"", 
					x.getName(),
					x.getGender()?"Nam":"Nữ",
					x.getAge()+"", 
					x.getLopDanhNghia() 
					});
		}
	}

	public void thucHienXoaSV1() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Ban co muon Xoa?");
		if(luaChon == JOptionPane.YES_OPTION) {
			list.remove(index);
			if(index > list.size()-1) {
				index = index-1;
			}else if(index <0 ) {
				index=0;
			}
			view1();
			viewTableSV();
			hienThiMessDaThucHien();
		}
	}
	
	public boolean checkIsEmpty1() {
		if( text1_mssv.getText().isEmpty()
			|| text1_hovaten.getText().isEmpty()
			|| text1_namsinh.getText().isEmpty()
			|| text1_lopdanhnghia.getText().isEmpty()
		){
			return false;
		}
		return true;
	}
	
	public SinhVien getModelSV1() {
		SinhVien sv = new SinhVien();
		sv.setMssv(Integer.parseInt(text1_mssv.getText()));
		sv.setName(text1_hovaten.getText());
		boolean gioiTinh = true;
		if(this.rdbtn1_nam.isSelected()) {
			gioiTinh = true;
		}else if(this.rdbtn1_nu.isSelected()) {
			gioiTinh = false;
		}
		sv.setGender(gioiTinh);
		sv.setAge(Integer.parseInt(text1_namsinh.getText()));
		sv.setLopDanhNghia(text1_lopdanhnghia.getText());
		return sv;
	}
	
	public void thucHienLuuSV1() {
		if(checkIsEmpty1()) {
			getModelSV1();
			if(check ==1) {
				// them moi
				list.add(getModelSV1());
			}else if(check == -1) {
				//cap nhat lai
				list.set(index, getModelSV1());
			}	
			view1();
			viewTableSV();
			hienThiMessDaThucHien();
			batNutLuuHuyBo1(false, true);
		}else {
			showCanhBao();
			batNutLuuHuyBo1(true, false);
		}
	}
	
	public void batNutLuuHuyBo1(boolean a, boolean b) {
		btn1_huyboSV.setEnabled(a);
        btn1_luuSV.setEnabled(a);
        
        btn1_themSV.setEnabled(b);
        btn1_suaSV.setEnabled(b);
        btn1_xoaSV.setEnabled(b);
	}
	/*
	 * tab 2 Xử lý sự kiện quản lý danh sách học phần
	 * tab 2 Xử lý sự kiện quản lý danh sách học phần
	 * tab 2 Xử lý sự kiện quản lý danh sách học phần
	 * 
	 */
	
	public boolean checkIsEmpty2() {
		if( text2_mahp.getText().isEmpty()
			|| text2_tenhp.getText().isEmpty()
			|| text2_sotinchi.getText().isEmpty()
			|| text2_giangvien.getText().isEmpty()
		){
			return false;
		}
		return true;
	}
	
	public HocPhan getModeHPl2() {
		HocPhan hp = new HocPhan();
		hp.setMaHP(Integer.parseInt(text2_mahp.getText()));
		hp.setTenHP(text2_tenhp.getText());
		hp.setSoTinChi(Integer.parseInt(text2_sotinchi.getText()));
		hp.setGiangVien(text2_giangvien.getText());
		return hp;
	}
	
	public void viewTableHP2() {
		DefaultTableModel model = (DefaultTableModel) this.table2_dshp.getModel();
		model.setNumRows(0);
		int n=1;
		for (HocPhan x : dshp) {
			model.addRow(
					new Object[] { 
					n++, 
					x.getMaHP()+"", 
					x.getTenHP(),
					x.getSoTinChi(),
					x.getGiangVien() 
					});
		}
	}
	
	public void viewHP2() {
		hp = dshp.get(index);
		this.text2_mahp.setText(hp.getMaHP()+"");
		this.text2_tenhp.setText(hp.getTenHP());
		this.text2_sotinchi.setText(hp.getSoTinChi()+"");
		this.text2_giangvien.setText(hp.getGiangVien());
	}
	
	public void xoaForm2() {
		text2_mahp.setText("");
		text2_tenhp.setText("");
		text2_sotinchi.setText("");
		text2_giangvien.setText("");
	}
	
	public void thucHienXoaHP2() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?");
		if(luaChon == JOptionPane.YES_OPTION) {
			dshp.remove(index);
			if(index > list.size()-1) {
				index = index-1;
			}else if(index <0 ) {
				index=0;
			}
			viewHP2();
			viewTableHP2();
		}
	}
	
	public void thucHienLuuHP2() {
		if(checkIsEmpty2()) {
			getModeHPl2();
			if(check ==1) {
				// them moi
				dshp.add(getModeHPl2());
				
			}else if(check == -1) {
				//cap nhat lai
				dshp.set(index, getModeHPl2());
			}	
			viewHP2();;
			viewTableHP2();
			hienThiMessDaThucHien();
			batNutLuuHuyBo2(false, true);
		}else {
			batNutLuuHuyBo2(true, false);
			showCanhBao();
		}
	}

	public void batNutLuuHuyBo2(boolean a, boolean b) {
		btn2_huyboHP.setEnabled(a);
        btn2_luuHP.setEnabled(a);
        
        btn2_themHP.setEnabled(b);
        btn2_suaHP.setEnabled(b);
        btn2_xoaHP.setEnabled(b);
	}
	
	/*
	 * Xử lý sự kiện tab3 quan ly diem
	 * Xử lý sự kiện tab3 quan ly diem
	 * Xử lý sự kiện tab3 quan ly diem
	 * 
	 */
	public void batNutLuuHuyBo3(boolean a, boolean b) {
		btn3_huybodiem.setEnabled(a);
        btn3_luudiem.setEnabled(a);
        
        btn3_nhapdiem.setEnabled(b);
        btn3_suadiem.setEnabled(b);
        btn3_xoadiem.setEnabled(b);
	}
	
	public void showComboMSSV3(List<SinhVien> dssv3) {
		comboBox3_mssv.removeAllItems();
		for (SinhVien sinhVien : dssv3) {
			comboBox3_mssv.addItem(sinhVien.getMssv());
		}
	}
	
	public boolean checkIsEmpty3() {
		if( text3_thuongki.getText().isEmpty()
			|| text3_giuaki.getText().isEmpty()
			|| text3_cuoiki.getText().isEmpty()
		){
			return false;
		}
		return true;
	}
	
	public void  hienThiSVTab3(int selectedMssv) {
	 for (SinhVien sv : list) {
            if (sv.getMssv() == selectedMssv) {
                text3_hovaten.setText(sv.getName());
                break; 
            }
        }
	}
	
	public void viewHP3() {
		int selectedMssv = (int) comboBox3_mssv.getSelectedItem();
	    SinhVien sinhVien = timSinhVienSeclet3(selectedMssv);
	    List<HocPhan> dshpCuaSV3 = sinhVien.getHocPhans();
		hp = dshpCuaSV3.get(index);
		this.text3_mahp.setText(hp.getMaHP()+"");
		this.text3_tenhp.setText(hp.getTenHP());
		this.text3_thuongki.setText(hp.getScore1()+"");
		this.text3_giuaki.setText(hp.getScore2()+"");
		this.text3_cuoiki.setText(hp.getScore3()+"");
	}

	public void viewTableHP3(List<HocPhan> dshpSV3) {
		DefaultTableModel model = (DefaultTableModel) this.table_3QLdiem.getModel();
		model.setNumRows(0);
		int n=1;
		for (HocPhan x : dshpSV3) {
			model.addRow(
					new Object[] { 
					n++, 
					x.getMaHP(), 
					x.getTenHP(),
					x.getSoTinChi(),
					x.getScore1(),
					x.getScore2(),
					x.getScore3(),
					x.getScoreFinal(),
					x.getRankHP()
					});
		}	
	}
	
	public SinhVien timSinhVienSeclet3(int selectedMssv) {
		for (SinhVien sv : list) {
			if (sv.getMssv() == selectedMssv) {
				return sv;		 
		    }
		 }
		return null;
	}
	
	public void thucHienLuuDiemHP3() {
		if(checkIsEmpty3()) {
			if(check ==1) {
				// them moi
				luuDiemHP3();
				xoaForm3();
			}else if(check == -1) {
				//cap nhat lai
				luuDiemHP3();
			}
			batNutLuuHuyBo3(false, true);
			hienThiMessDaThucHien();
		}else {
			showCanhBao();
			batNutLuuHuyBo3(true, false);
		}
	}
	
	public void luuDiemHP3() {
	    int selectedMssv = (int) comboBox3_mssv.getSelectedItem();
	    SinhVien sinhVien = timSinhVienSeclet3(selectedMssv);

	    if (sinhVien != null) {
	        int selectedRowIndex = table_3QLdiem.getSelectedRow();
	        if (selectedRowIndex >= 0 && selectedRowIndex < sinhVien.getHocPhans().size()) {
	            HocPhan hp = sinhVien.getHocPhans().get(selectedRowIndex);

	            try {
	                double thuongki = Double.parseDouble(text3_thuongki.getText());
	                double giuaki = Double.parseDouble(text3_giuaki.getText());
	                double cuoiki = Double.parseDouble(text3_cuoiki.getText());

	                // Tạo một bản sao mới của HocPhan trước khi cập nhật điểm
	                HocPhan clonedHocPhan = new HocPhan(hp.getMaHP(), hp.getTenHP(), hp.getSoTinChi(), hp.getGiangVien());

	                clonedHocPhan.setScore1(thuongki);
	                clonedHocPhan.setScore2(giuaki);
	                clonedHocPhan.setScore3(cuoiki);

	                clonedHocPhan.setScoreFinal(thuongki, giuaki, cuoiki);
	                clonedHocPhan.setRankHP(clonedHocPhan.getScoreFinal());

	                sinhVien.getHocPhans().set(selectedRowIndex, clonedHocPhan);

	                viewTableHP3(sinhVien.getHocPhans());
	                viewHP3();
	            } catch (NumberFormatException e) {
	                // Xử lý nếu người dùng nhập dữ liệu không phải số
	                e.printStackTrace();
	                // Hiển thị thông báo lỗi nếu cần
	            }
	        }
	    }
	}


	public void xoaForm3() {
		text3_thuongki.setText("");
		text3_giuaki.setText("");
		text3_cuoiki.setText("");
	}
	
	public void xoaDiemHP3() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?");
		if(luaChon == JOptionPane.YES_OPTION) {
			int selectedMssv = (int) comboBox3_mssv.getSelectedItem();
		    SinhVien sinhVien = timSinhVienSeclet3(selectedMssv);
		    
			hp = sinhVien.getHocPhans().get(index);
			hp.setScore1(0);
			hp.setScore2(0);
			hp.setScore3(0);
			hp.setScoreFinal(0);
			hp.setRankHP("");
			
			viewTableHP3(sinhVien.getHocPhans());
			viewHP3();
			hienThiMessDaThucHien();
		}
	}
	
	/*
	 * xử lý sự kiện tab4 kết quả học tập
	 * xử lý sự kiện tab4 kết quả học tập
	 * xử lý sự kiện tab4 kết quả học tập
	 * 
	 */
	public void showComboMSSV4(List<SinhVien> dssv4) {
		comboBox4_mssv.removeAllItems();
		for (SinhVien sinhVien : dssv4) {
			comboBox4_mssv.addItem(sinhVien.getMssv());
		}
	}
	
	public void  hienThiSVTab4(int selectedMssv) {
	 for (SinhVien sv : list) {
            if (sv.getMssv() == selectedMssv) {
                text4_hovaten.setText(sv.getName());
                text4_gioitinh.setText(sv.getGender()?"Nam":"Nữ");
                text4_namsinh.setText(sv.getAge()+"");
                text4_lopdanhnghia.setText(sv.getLopDanhNghia());      
                sv.thongKeKetQua();
                text4_tongtinchi.setText(sv.getTongTinChiTichLuy()+"");
                text4_diemTB.setText(sv.getDiemTBTichLuy()+"");
                text4_xeploai.setText(sv.getXepLoaiTichLuy());
                break; 
            }
        }
	}

	public void viewTableHP4(List<HocPhan> danhSachHocPhan) {
		DefaultTableModel model = (DefaultTableModel) this.table4_ketqua.getModel();
		model.setNumRows(0);
		int n=1;
		for (HocPhan x : danhSachHocPhan) {
			model.addRow(
					new Object[] { 
					n++, 
					x.getMaHP(), 
					x.getTenHP(),
					x.getSoTinChi(),
					x.getScore1(),
					x.getScore2(),
					x.getScore3(),
					x.getScoreFinal(),
					x.getRankHP()
					});
		}
	}
	
	/*
	 * xử lý sự kiện tab5 đăng kí học phần
	 * xử lý sự kiện tab5 đăng kí học phần
	 * xử lý sự kiện tab5 đăng kí học phần
	 * 
	 */
	
	public void showComboMSSV5(List<SinhVien> dssv5) {
		comboBox5_mssv.removeAllItems();
		for (SinhVien sinhVien : dssv5) {
			comboBox5_mssv.addItem(sinhVien.getMssv());
		}
	}
	
	public void viewSV5() {
		int selectedMssv = (int) comboBox5_mssv.getSelectedItem();
	    SinhVien sinhVien = timSinhVienSeclet3(selectedMssv);
		this.text5_hovaten.setText(sinhVien.getName());
		this.text5_namsinh.setText(sinhVien.getAge()+"");
	}
	
	public void viewHPcuaDSHP5() {
		hp = dshp.get(index);
		this.text5_hpDangChon.setText(hp.getTenHP());
	}
	
	public void viewHPcuaSV5() {
		int selectedMssv = (int) comboBox5_mssv.getSelectedItem();
	    SinhVien sinhVien = timSinhVienSeclet3(selectedMssv);
	    List<HocPhan> dshpcuaSV5 = sinhVien.getHocPhans();
	    hp = sinhVien.getHocPhans().get(index);
		hp = dshpcuaSV5.get(index);
		this.text5_hpDangChon.setText(hp.getTenHP());
	}

	public void viewTableHP5(List<HocPhan> dshpcuaSV) {
		DefaultTableModel model = (DefaultTableModel) this.table5_hpdadangki.getModel();
		model.setNumRows(0);
		int n=1;
		for (HocPhan x : dshpcuaSV) {
			model.addRow(
					new Object[] { 
					n++, 
					x.getMaHP(), 
					x.getTenHP(),
					x.getSoTinChi(),
					x.getGiangVien()
					});
		}
	}
	
	// hoc phan co sẵn
	public void viewTableHPAvaible5(List<HocPhan> danhSachHocPhan) {
		DefaultTableModel model = (DefaultTableModel) this.table5_hpchodangki.getModel();
		model.setNumRows(0);
		int n=1;
		for (HocPhan x : danhSachHocPhan) {
			model.addRow(
					new Object[] { 
					n++, 
					x.getMaHP(), 
					x.getTenHP(),
					x.getSoTinChi(),
					x.getGiangVien()
					});
		}
	}

	public void huyHocPhanSV5() {
	    int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?");
	    if (luaChon == JOptionPane.YES_OPTION) {
	        int selectedRow = table5_hpdadangki.getSelectedRow();
	        int selectedMssv = (int) comboBox5_mssv.getSelectedItem();
	        SinhVien sinhVien = timSinhVienSeclet3(selectedMssv);

	        // Kiểm tra xem danh sách có chứa ít nhất một học phần không
	        if (!sinhVien.getHocPhans().isEmpty()) {
	            if (sinhVien.getHocPhans().size() == 1) {
	                // Nếu chỉ còn một học phần, xóa nó khỏi danh sách và cập nhật bảng
	                sinhVien.getHocPhans().remove(0);
	            } else if (selectedRow >= 0 && selectedRow < sinhVien.getHocPhans().size()) {
	                // Xóa học phần khỏi danh sách của sinh viên và cập nhật bảng
	                HocPhan selectedHP = sinhVien.getHocPhans().get(selectedRow);
	                sinhVien.getHocPhans().remove(selectedHP);
	            }

	            viewTableHP5(sinhVien.getHocPhans());
	            hienThiMessDaThucHien();
	        }
	    }
	}

	public void dangKiHocPhanSV5() {
	    int selectedRow = table5_hpchodangki.getSelectedRow();
	    if (selectedRow >= 0 && selectedRow < dshp.size()) {
	        HocPhan selectedHP = dshp.get(selectedRow);
	        int selectedMssv = (int) comboBox5_mssv.getSelectedItem();
	        SinhVien sinhVien = timSinhVienSeclet3(selectedMssv);

	        // Sử dụng hàm timHocPhanSV5 để kiểm tra xem học phần đã tồn tại trong danh sách của sinh viên hay chưa
	        HocPhan existingHP = timHocPhanSV5(sinhVien, selectedHP);

	        if (existingHP == null) {
	            // Nếu chưa, thêm vào danh sách của sinh viên và cập nhật bảng
	            sinhVien.getHocPhans().add(selectedHP);
	            viewTableHP5(sinhVien.getHocPhans());
	            hienThiMessDaThucHien();
	        } else {
	            hienThiMessHPTonTai();
	        }
	    }
	}
	public HocPhan timHocPhanSV5(SinhVien sinhVien, HocPhan hpsv) {
	    for (HocPhan hocPhan : sinhVien.getHocPhans()) {
	        if (hocPhan.getMaHP() == hpsv.getMaHP()) {
	            return hocPhan;
	        }
	    }
	    return null;
	}

	/*
	 * other xử lý sự kiện
	 * other xử lý sự kiện
	 * other xử lý sự kiện
	 * 
	 */
	
	public void resetDuLieuSauThaoTac() {
		showComboMSSV3(list);
		showComboMSSV4(list);
		showComboMSSV5(list);
		viewTableHPAvaible5(dshp);
	}
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
				this, 
				"Bạn có muốn thoát khỏi chương trình?",
				"Exit",
				JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void handleLogout() {
		int luaChon = JOptionPane.showConfirmDialog(
				this, 
				"Bạn có muốn đăng xuất không?",
				"Exit",
				JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION) {
			dispose();  // Đóng cửa sổ hiện tại
	        // Mở lại LoginDialog
	        LoginDialog loginDialog = new LoginDialog();
	        loginDialog.setVisible(true);
		}   
    }

	public void hienThiMessDaThucHien() {
		JOptionPane.showMessageDialog(this, "Đã thực hiện!");
	}
	public void hienThiMessHPTonTai() {
		JOptionPane.showMessageDialog(this, "Học phần đã tồn tại!");
	}
	public void hienThiMessHayThaoTac() {
		JOptionPane.showMessageDialog(this, "Mời Bạn thao tác!");
	}
	
//	public void hienThiAboutMe() {
//		String text = "Phần mền Quản lý học vụ IUH 5.0 By Hồ Phúc Lâm!\r\n\n"
//				+ "Đây là bài tập lớn thiết kết chương trình Quản lý học vụ IUH\r\n"
//				+ "Chương trình này có giao diện và làm việc với file .dat\r\n"
//				+ "Chương trình sử dụng JFrame và WindowBuilder!\r\n"
//				+ "Xin cảm ơn!";
//		JOptionPane.showMessageDialog(this, text);
//	}
	
	public void hienThiAboutMe() {
	    String text = "<html><body style='width: 300px; padding: 10px;'>" +
	                  "<h2>Phần mềm Quản lý học vụ IUH 5.0</h2>" +
	                  "<p>By Hồ Phúc Lâm!</p>" +
	                  "<p>Đây là bài tập lớn thiết kế chương trình Quản lý học vụ IUH.</p>" +
	                  "<p>Chương trình này có giao diện và làm việc với file .dat.</p>" +
	                  "<p>Chương trình sử dụng JFrame và WindowBuilder!</p>" +
	                  "<p>Xin cảm ơn!</p>" +
	                  "</body></html>";

	    JOptionPane.showMessageDialog(this, text, "About Me", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	public void showMenuHelpQLSV() {
		tabbedPane.setSelectedIndex(0);
		String text = "Quản lý sinh viên\r\n"
				+ "Bạn hãy nhấn nút thêm rồi mới nhập thông tin\r\n"
				+ "Bạn hãy nhấn nút lưu để thêm mới hoặc cập nhật\r\n"
				+ "Ngoài ra bạn có thể click vào table danh sách ở dưới để sửa xóa";
		JOptionPane.showMessageDialog(this, text);
	}
	
	public void showMenuHelpQLHP() {
		tabbedPane.setSelectedIndex(1);
		String text = "Quản lý học phần\r\n"
				+ "Bạn hãy nhấn nút thêm rồi mới nhập thông tin\r\n"
				+ "Bạn hãy nhấn nút lưu để thêm mới hoặc cập nhật\r\n"
				+ "Ngoài ra bạn có thể click vào table danh sách ở dưới để sửa xóa";
		JOptionPane.showMessageDialog(this, text);
	}
	
	public void showMenuHelpQLDiem() {
		tabbedPane.setSelectedIndex(2);
		String text = "Quản lý học phần\r\n"
				+ "Bạn hãy chọn sinh viên từ ô comboBox Mã số sinh viên\r\n"
				+ "Bạn nhấn nút thêm để nhập điểm cho HP đó của SV có MSSV đang chọn\r\n"
				+ "Bạn hãy nhấn nút lưu để nhập điểm mới hoặc cập nhật\r\n"
				+ "Ngoài ra bạn có thể click vào table danh sách ở dưới để chọn học phần cần nhập điểm";
		JOptionPane.showMessageDialog(this, text);
	}
	
	public void showMenuHelpKQHT() {
		tabbedPane.setSelectedIndex(3);
		String text = "Kết quả học tập\r\n"
				+ "Bạn hãy chọn sinh viên từ ô comboBox Mã số sinh viên\r\n"
				+ "Để xem Kết quả học tập của sinh viên đó";
		JOptionPane.showMessageDialog(this, text);
	}
	
	public void showMenuHelpDKHP() {
		tabbedPane.setSelectedIndex(4);
		String text = "Đăng kí học phần\r\n"
				+ "Bạn hãy chọn sinh viên từ ô comboBox Mã số sinh viên\r\n"
				+ "Hãy chọn học phần đang chờ đăng kí ở table\r\n"
				+ "\r\n"
				+ "Nhấn nút đăng kí để thêm học phần đó vào danh sách học phần đã đăng kí của sinh viên\r\n"
				+ "\r\n"
				+ "Nhấn nút Hủy HP để hủy học phần ra khỏi danh sách HP của SV";
		JOptionPane.showMessageDialog(this, text);
	}
	
	
	/**
	 * làm việc với file
	 * làm việc với file
	 * làm việc với file
	 * 
	 */

	 // Lưu danh sách sinh viên và học phần xuống file
    public void thucHienSaveFile() {
        if (this.tenFile.length() > 0) {
            saveFile(this.tenFile);
        } else {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                saveFile(file.getAbsolutePath());
            }
        }
    }

    public void saveFile(String path) {
        try {
            this.tenFile = path;
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Lưu danh sách sinh viên và học phần
            oos.writeObject(this.list);
            oos.writeObject(this.dshp);

            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mở file và tải dữ liệu lên chương trình
    public void thucHienOpenFile() {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            openFile(file);
            thucHienTaiLaiDuLieu();
        }
    }

    public void openFile(File file) {
        try {
            this.tenFile = file.getAbsolutePath();
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Đọc danh sách sinh viên và học phần
            this.list = (ArrayList<SinhVien>) ois.readObject();
            this.dshp = (ArrayList<HocPhan>) ois.readObject();

            ois.close();
        } catch (EOFException e) {
            // Đọc đến cuối file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hiển thị lại dữ liệu lên bảng
    public void thucHienTaiLaiDuLieu() {
    	showComboMSSV3(list);
    	showComboMSSV4(list);
    	showComboMSSV5(list);
        view1();
        viewHP2();
        viewHP3();
        viewHPcuaDSHP5();
        viewHPcuaSV5();
        viewSV5();
        viewTableHP2();
        viewTableHP3(dshp);
        viewTableHP4(dshp);
        viewTableHP5(dshp);
        viewTableHPAvaible5(dshp);
        viewTableSV();
    }
}