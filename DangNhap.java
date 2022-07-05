package DuAnQuanLyCapPhatThuoc;

import java.awt.BorderLayout;   
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DangNhap extends Ketnoidulieu implements ActionListener{

	private JTextField dn;
	private JPasswordField mk;
	private JFrame giaodien;
	static JFrame JFRAME;
	static JProgressBar JPROGRESSBAR;
	private String invalid1;
	private JTextField sodienthoai;

	
	ResultSet rs;
	

	public DangNhap() {
		giaodien = new JFrame("Quản lý cấp phát thuốc");
		giaodien.setDefaultCloseOperation(giaodien.EXIT_ON_CLOSE);
		giaodien.setSize(320,298);

		
		JPanel bao = new JPanel();
		bao.setBackground(Color.WHITE);
		bao.setLayout(new BorderLayout());
    
		
		JPanel chuatieude = new JPanel();
		chuatieude.setLayout(new GridLayout(2,1));
		chuatieude.setBackground(Color.WHITE);
		JLabel tieude = new JLabel(" QUẢN LÝ CẤP PHÁT THUỐC BỆNH NHÂN", 0);
		tieude.setFont(new Font("Tahoma", Font.BOLD, 13));
		tieude.setForeground(Color.red);
		chuatieude.add(tieude);
		
		ImageIcon myImagelogo = new ImageIcon(
				"D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\xxxx.PNG");
		chuatieude.add(new JLabel(myImagelogo,0));
		
		
		JPanel giua = new JPanel();
		giua.setLayout(new BorderLayout());
		giua.setBackground(Color.WHITE);

		JPanel baotraiphai = new JPanel();
		baotraiphai.setLayout(new BorderLayout());

		JPanel trai = new JPanel();
		trai.setBackground(Color.WHITE);
		trai.setLayout(new GridLayout(3, 1));
		JLabel dangnhap = new JLabel(" Đăng nhập ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\hhhh.PNG"), 0);
		JLabel matkhau = new JLabel(" Mật Khẩu   ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\jjjj.PNG"), 0);
		trai.add(dangnhap);
		trai.add(matkhau);

		JPanel phai = new JPanel();
		phai.setBackground(Color.WHITE);
		phai.setLayout(new GridLayout(4, 1, 0, 5));
		dn = new JTextField();
		mk = new JPasswordField();
		phai.add(dn);
		phai.add(mk);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Hiển thị mật khẩu");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		phai.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					mk.setEchoChar((char) 0);
				} else {
					mk.setEchoChar('*');
				}
			}
		});
		
		JRadioButton toidangky = new JRadioButton("Muốn đăng ký hãy nhấn");
		toidangky.setBackground(Color.WHITE);
		toidangky.setFont(new Font("Times New Roman", Font.BOLD, 14));
		phai.add(toidangky);
		toidangky.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			      Dangky();
			giaodien.setVisible(false);
			}});
		
		

		JPanel thucthi = new JPanel();
		thucthi.setBackground(Color.WHITE);
		JButton vao = new JButton("ĐĂNG NHẬP",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\kkkk.PNG"));
		vao.addActionListener(this);
	
		
		JButton thoat = new JButton("     THOÁT     ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\llll.PNG"));
		thoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int hoi = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát đăng ký?", null,
						JOptionPane.YES_NO_OPTION);
				if (hoi == JOptionPane.YES_OPTION) {
					System.exit(0);

				}
			}
		});

		thucthi.add(vao);
		thucthi.add(thoat);

		baotraiphai.add(trai, BorderLayout.WEST);
		baotraiphai.add(phai, BorderLayout.CENTER);
		giua.add(baotraiphai, BorderLayout.NORTH);

		bao.add(chuatieude, BorderLayout.NORTH);
		bao.add(giua, BorderLayout.CENTER);
		bao.add(thucthi, BorderLayout.SOUTH);

		giaodien.add(bao);
		giaodien.setLocationRelativeTo(null);
		giaodien.setVisible(true);
	}

	
	  public void actionPerformed(ActionEvent e) {
	 

	  try {
		  	rs= stmt.executeQuery("SELECT*FROM DANGNHAP WHERE USEER= '"+dn.getText()+"' and PASSWORD = '"+mk.getText()+"'");	  

		  if(rs.next()) { 

		  String USEER =rs.getString(1);
		  String PASSWORD = rs.getString(2);
	
		  	 new HOME(); 
		  	 giaodien.setVisible(false);
		  	 
	  }else { 
		  JOptionPane.showMessageDialog(null,"Tài khoản hoặc mật khẩu bị sai ! ");
		  }
	  
	  }
	  catch (SQLException e1) {
		  // TODO Auto-generated catch block
	  e1.printStackTrace(); 
	  }
	 
	 
 }
	  public void Dangky() {
		      
		  JFrame giaodiendangky = new JFrame("Quản lý cấp phát thuốc");
		  giaodiendangky.setDefaultCloseOperation(giaodien.EXIT_ON_CLOSE);
		  giaodiendangky.setSize(350,220);
		  
		  JLabel ntk = new JLabel("     Tài khoản  ",
					new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\hhhh.PNG"), 0);
		  JTextField nhaptaikhoan = new JTextField();
		 
		  
		  JLabel nmk = new JLabel("      Mật khẩu   ",
					new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\jjjj.PNG"), 0);
		  JPasswordField nhapmatkhau = new JPasswordField();
		 
		  
			JCheckBox JNewCheckBox = new JCheckBox("Hiển thị mật khẩu");
			JNewCheckBox.setBackground(Color.WHITE);
			JNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
			
			JNewCheckBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (JNewCheckBox.isSelected()) {
						nhapmatkhau.setEchoChar((char) 0);
					} else {
						nhapmatkhau.setEchoChar('*');
					}
				}
			});
			
		
			
		  
		  JLabel sdt= new JLabel("  Số điện thoại",
					new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\SODIENTHOAI.PNG"),0);
		   sodienthoai = new JTextField();
		
		  
		  JPanel baojlabel = new JPanel();
		  baojlabel.setBackground(Color.white);
		  baojlabel.setLayout(new GridLayout(3,1));
		  baojlabel.add(ntk);
		  baojlabel.add(nmk);
		  baojlabel.add(sdt);
		  
		  JPanel baojtextfile = new JPanel();
		  baojtextfile.setLayout(new GridLayout(4,1));
		  baojtextfile.add(nhaptaikhoan);
		  baojtextfile.add(nhapmatkhau);
		  baojtextfile.add(JNewCheckBox);
		  baojtextfile.add(sodienthoai);
		  
			
		  JPanel baolabeljtextfile = new JPanel();
		  baolabeljtextfile.setBackground(Color.white);
		  baolabeljtextfile.setLayout(new GridLayout(1,2));
		  baolabeljtextfile.add(baojlabel);
		  baolabeljtextfile.add(baojtextfile);
		  
	
		  
		  JButton nutDangky = new JButton("Đăng ký",
					new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\kkkk.PNG"));
			
		  nutDangky.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(nhaptaikhoan.getText().equals("")) {
						JOptionPane.showMessageDialog(null , " Cần nhập tài khoản");
						return;
					}
					if(nhapmatkhau.getText().equals("")) {
						JOptionPane.showMessageDialog(null , " Cần nhập mật khẩu");
						return;
					}
					if(sodienthoai.getText().equals("")) {
						JOptionPane.showMessageDialog(null , " Cần nhập số điện thoại");
						return;
					}
					String sodt = sodienthoai.getText();
					try {
						if (sodt.equalsIgnoreCase("")) {
							invalid1 += "Vui lòng nhập số điện thoại !\n";
						} else if (!sodt.matches("^0[0-9]+$")) {
							invalid1 += "Số điện thoại không hợp lệ !(10 số và bắt đầu là 0)\n";
						}

						try {
							Integer.parseInt(sodienthoai.getText());
						stmt.executeUpdate("insert into DANGNHAP values (\'"+nhaptaikhoan.getText()+"\',"
								+ "\'"+nhapmatkhau.getText()+"\',N\'"+sodienthoai.getText()+"\')");
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công !");
						giaodiendangky.dispose();
						 new DangNhap(); 
					  	 giaodien.setVisible(false);
						} catch (Exception e3) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "Số điện thoại phải là số!");
						}

					} catch (Exception e1) {
						System.out.print(e1);
					}
					nhaptaikhoan.setText("");
					nhapmatkhau.setText("");
					sodienthoai.setText("");
		
				}});
		  JButton thoatdk = new JButton("  Thoát  ",
					new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\llll.PNG"));
		  thoatdk.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int hoi = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát khỏi đăng ký?", null,
							JOptionPane.YES_NO_OPTION);
					if (hoi == JOptionPane.YES_OPTION) {
						
						giaodiendangky.dispose();
						 new DangNhap();
						giaodien.setVisible(false);
                          
					}
				}
			});
		  JPanel chuanutdangky = new JPanel();
		  chuanutdangky.setBackground(Color.white);
		  chuanutdangky.add(nutDangky);
		  chuanutdangky.add(thoatdk);
		  
		  
		  JLabel tieudedangky = new JLabel("ĐĂNG KÝ",0);
		  tieudedangky.setFont(new Font("Tahoma", Font.BOLD, 13));
		  tieudedangky.setForeground(Color.red);
		  
		  JPanel  baoquatdangky = new JPanel();
		  baoquatdangky.setBackground(Color.white);
		  baoquatdangky.setLayout(new BorderLayout());
		  baoquatdangky.add(tieudedangky,BorderLayout.NORTH);
		  baoquatdangky.add(baolabeljtextfile,BorderLayout.CENTER);
		  baoquatdangky.add(chuanutdangky,BorderLayout.SOUTH);
		  
		  
		  
		  giaodiendangky.add(baoquatdangky);
		  giaodiendangky.setLocationRelativeTo(null);
		  giaodiendangky.setVisible(true);
		  
	  };
	 
	protected void dispose() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFRAME = new JFrame("Chương trình cấp phát thuốc bệnh nhân");
		JFRAME.setSize(621,535);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		ImageIcon myImage = new ImageIcon(
				"D:\\NHỮNG TÀI LIỆU CỦA TÈO\\KY1NAM1\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\ssss.PNG");
		p.add(new JLabel(myImage),BorderLayout.CENTER);

		
		JPROGRESSBAR = new JProgressBar();
		JPROGRESSBAR.setBackground(Color.black);
		JPROGRESSBAR.setForeground(Color.GREEN);
		
		JPROGRESSBAR.setValue(0);
		JPROGRESSBAR.setStringPainted(true);
		// add progressbar
		p.add(JPROGRESSBAR,BorderLayout.SOUTH);
		// add panel
		JFRAME.add(p);
		// thiết lập kích thước của khung
		
		JFRAME.setVisible(true);
		JFRAME.setLocationRelativeTo(null);
		int i = 0;
		try {
			while (i <= 100) {
				if (i > 30 && i < 70)
					JPROGRESSBAR.setString("loading........ ");
				else if (i > 70)
					JPROGRESSBAR.setString("loading........... ");
				else
					JPROGRESSBAR.setString("loading..... ");
				// điền vào thanh menu
				JPROGRESSBAR.setValue(i + 10);
				// trì hoãn luồng
				Thread.sleep(1000);
				i += 20;
			}
		} catch (Exception e) {
		}
		new DangNhap();
		exit(0);

	}

	private static void exit(int i) {
		JFRAME.setVisible(false);

	}

}
