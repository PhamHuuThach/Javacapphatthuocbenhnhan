package DuAnQuanLyCapPhatThuoc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class DanhSachBN extends Ketnoidulieu {
	private DefaultTableModel dm;
	private JLabel mbn, tbn, dc, t, gt, dt, Nng, Ngh, nlv, sdt;
	private JTextField mabenhnhan, tenbenhnhan, diachi, tuoi, dantoc, sodienthoai, nghenghiep, noilamviec, quanhe;
	private JTable tbl;
	private JComboBox gioitinh;
	private String invalid1 ;

	public DanhSachBN() {
		JFrame jframe = new JFrame("Quản lý cấp phát thuốc");
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		jframe.setSize(1470, 750);

		JPanel cot1trai = new JPanel();
		cot1trai.setBackground(new Color(210, 255, 255));
		cot1trai.setLayout(new GridLayout(3, 1, 0, 3));
		mbn = new JLabel("Mã bệnh nhân ", 0);
		tbn = new JLabel("Họ và tên BN", 0);
		Nng = new JLabel("Nghề nghiệp", 0);
		cot1trai.add(mbn);
		cot1trai.add(tbn);
		cot1trai.add(Nng);

		JPanel cot1phai = new JPanel();
		cot1phai.setBackground(new Color(210, 255, 255));
		cot1phai.setLayout(new GridLayout(3, 1, 0, 3));
		mabenhnhan = new JTextField();
		tenbenhnhan = new JTextField();
		nghenghiep = new JTextField();
		cot1phai.add(mabenhnhan);
		cot1phai.add(tenbenhnhan);
		cot1phai.add(nghenghiep);

		JPanel baocot1 = new JPanel();
		baocot1.setLayout(new GridLayout(1, 2));
		baocot1.add(cot1trai);
		baocot1.add(cot1phai);
		JPanel cotnhat = new JPanel();
		cotnhat.add(baocot1);

		JPanel cot2trai = new JPanel();
		cot2trai.setBackground(new Color(210, 255, 255));
		cot2trai.setLayout(new GridLayout(3, 1, 0, 3));
		Ngh = new JLabel("Người giám hộ", 0);
		dt = new JLabel("Dân tộc", 0);
		nlv = new JLabel("Nơi làm việc", 0);

		cot2trai.add(Ngh);
		cot2trai.add(dt);
		cot2trai.add(nlv);

		JPanel cot2phai = new JPanel();
		cot2phai.setBackground(new Color(210, 255, 255));
		cot2phai.setLayout(new GridLayout(3, 1, 0, 3));
		quanhe = new JTextField();
		dantoc = new JTextField();
		noilamviec = new JTextField();

		cot2phai.add(quanhe);
		cot2phai.add(dantoc);
		cot2phai.add(noilamviec);

		JPanel baocot2 = new JPanel();
		baocot2.setLayout(new GridLayout(1, 2));
		baocot2.add(cot2trai);
		baocot2.add(cot2phai);
		JPanel cotnhi = new JPanel();
		cotnhi.add(baocot2);

		JPanel cot3trai = new JPanel();
		cot3trai.setBackground(new Color(210, 255, 255));
		cot3trai.setLayout(new GridLayout(3, 1, 0, 3));
		t = new JLabel("Tuổi", 0);
		sdt = new JLabel("Số điện thoại", 0);
		gt = new JLabel("Giới tính", 0);
		cot3trai.add(t);
		cot3trai.add(sdt);
		cot3trai.add(gt);

		JPanel cot3phai = new JPanel();
		cot3phai.setBackground(new Color(210, 255, 255));
		cot3phai.setLayout(new GridLayout(3, 1, 0, 3));
		tuoi = new JTextField();
		sodienthoai = new JTextField();
		String arr[] = { "","Nam", "Nữ" };
		gioitinh = new JComboBox(arr);
		cot3phai.add(tuoi);
		cot3phai.add(sodienthoai);
		cot3phai.add(gioitinh);

		JPanel baocot3 = new JPanel();
		baocot3.setLayout(new GridLayout(1, 2));
		baocot3.add(cot3trai);
		baocot3.add(cot3phai);
		JPanel cotba = new JPanel();
		cotba.add(baocot3);

		JLabel tieude = new JLabel("DANH SÁCH BỆNH NHÂN", 0);
		tieude.setFont(new Font("Tahoma", Font.BOLD, 20));
		tieude.setForeground(Color.red);
		
		JButton thoat = new JButton("Thoát");
		thoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int hoi = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát chương trình?", null,
						JOptionPane.YES_NO_OPTION);
				if (hoi == JOptionPane.YES_OPTION) {
					System.exit(0);

				}
			}
		});
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				     new HOME();
				jframe.setVisible(false);
				}});
		JPanel baotdthoat = new JPanel();
		baotdthoat.setBackground(new Color(210, 255, 255));
		baotdthoat.setLayout(new BorderLayout());
		baotdthoat.add(back, BorderLayout.WEST);
		baotdthoat.add(tieude, BorderLayout.CENTER);
		baotdthoat.add(thoat, BorderLayout.EAST);

		JPanel bao123 = new JPanel();
		bao123.setLayout(new GridLayout(1, 3));
		bao123.add(baocot1);
		bao123.add(baocot2);
		bao123.add(baocot3);

		
		JPanel dchi = new JPanel();
		dchi.setBackground(new Color(210, 255, 255));
		dchi.setLayout(new GridLayout(1, 1));
		dc = new JLabel("                                                                        "
				+ "                                                                                                              Địa chỉ");
		diachi = new JTextField();
		dchi.add(dc);
		dchi.add(diachi);
		JPanel chuhuawsdc  =new JPanel();
		JPanel rongdchi = new JPanel();
		rongdchi.setBackground(new Color(210, 255, 255));
		chuhuawsdc.setLayout(new GridLayout(2,1));
		chuhuawsdc.add(dchi);
		chuhuawsdc.add(rongdchi);
		
		JPanel a2 = new JPanel();
		a2.setBackground(new Color(210, 255, 255));
		
		JPanel baojbutton = new JPanel();
		baojbutton.setBackground(new Color(210, 255, 255));

		JLabel e1 = new JLabel();
		JLabel e2 = new JLabel();
		JButton lammoi = new JButton("Làm mới",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\LM.PNG"));
		lammoi.setBackground(Color.WHITE);
		lammoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mabenhnhan.setText("");
				tenbenhnhan.setText("");
				diachi.setText("");
				tuoi.setText("");
				nghenghiep.setText("");
				noilamviec.setText("");
				quanhe.setText("");
				dantoc.setText("");
				sodienthoai.setText("");
				
			}});
		JButton them = new JButton("   Thêm    ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\T.PNG"));
		them.setBackground(Color.WHITE);	
		them.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				String sodt = sodienthoai.getText();
				try {
					
					if (sodt.equalsIgnoreCase("")) {
			 invalid1 += "Vui lòng nhập số điện thoại !\n";
        } else if (!sodt.matches("^0[0-9]+$")) {
             invalid1 += "Số điện thoại không hợp lệ !(10 số và bắt đầu là 0)\n";
        }
					try {
						Integer.parseInt(sodienthoai.getText());
					stmt.executeUpdate("insert into BENHNHAN values (\'"+mabenhnhan.getText()+"\',"
							+ "N\'"+tenbenhnhan.getText()+"\',N\'"+diachi.getText()+"\',"							
							+ "\'"+tuoi.getText()+"\',N\'"+((String)gioitinh.getSelectedItem())+"\',"
							+ "N\'"+nghenghiep.getText()+"\',"
							+ "N\'"+ noilamviec.getText()+"\',"
							+ "N\'"+quanhe.getText()+"\',N\'"+dantoc.getText()+"\',\'"+sodienthoai.getText()+"\')");
					
					dm.addRow(new String[] { mabenhnhan.getText(), tenbenhnhan.getText(), diachi.getText()
						, tuoi.getText(),((String) gioitinh.getSelectedItem()), nghenghiep.getText()
						,noilamviec.getText() , quanhe.getText(),dantoc.getText(),sodienthoai.getText()});
					
					} catch (Exception e3) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Số điện thoại phải là số!");
					}
				}catch(Exception e1) {
					System.out.print(e1);
				}
				mabenhnhan.setText("");
				tenbenhnhan.setText("");
				diachi.setText("");
				tuoi.setText("");
				nghenghiep.setText("");
				noilamviec.setText("");
				quanhe.setText("");
				dantoc.setText("");
				sodienthoai.setText("");
				
				
			}});
		JButton sua = new JButton("    Sửa     ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\S.PNG"));
		sua.setBackground(Color.WHITE);	
		sua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
			    dm = (DefaultTableModel)tbl.getModel();
				dm.removeRow( row );

				dm.addRow(new String[] { mabenhnhan.getText(), tenbenhnhan.getText(), diachi.getText()
						, tuoi.getText(),((String) gioitinh.getSelectedItem()), nghenghiep.getText()
						,noilamviec.getText() , quanhe.getText(),dantoc.getText(),sodienthoai.getText()});
			
				try {
					stmt.executeUpdate("update BENHNHAN set TENBENHNHAN=\'"+tenbenhnhan.getText()+"\',"
							+ "DIACHI=N\'"+diachi.getText()+"\',"							
							+ "TUOI=\'"+tuoi.getText()+"\',GIOITINH=N\'"+((String)gioitinh.getSelectedItem())+"\',"
							+ "NGHENGHIEP=N\'"+nghenghiep.getText()+"\',"
							+ "NOILAMVIEC=N\'"+ noilamviec.getText()+"\',"
							+ "NGUOIGIAMHO=N\'"+quanhe.getText()+"\',DANTOC=N\'"+dantoc.getText()+"\',SODIENTHOAI=\'"+sodienthoai.getText()+"\'"	
							+ "where MABENHNHAN=\'"+mabenhnhan.getText()+"\'");
					
				}catch(SQLException e1) {
					System.out.print(e1);
				}			
			
				mabenhnhan.setText("");
				tenbenhnhan.setText("");
				diachi.setText("");
				tuoi.setText("");
				nghenghiep.setText("");
				noilamviec.setText("");
				quanhe.setText("");
				dantoc.setText("");
				sodienthoai.setText("");
				
			}});
		JButton xoa = new JButton("    Xóa     ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\X.PNG"));
		xoa.setBackground(Color.WHITE);	
		xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				dm = (DefaultTableModel)tbl.getModel();
				dm.removeRow( row );
				try {
							
					stmt.executeUpdate("delete from BENHNHAN where (MABENHNHAN = \'"+mabenhnhan.getText()+"\')");
					JOptionPane.showMessageDialog(null,"Xóa thành công ! ");
				}catch(SQLException e1) {
					System.out.print(e1);
				}			
				
				mabenhnhan.setText("");
				tenbenhnhan.setText("");
				diachi.setText("");
				tuoi.setText("");
				nghenghiep.setText("");
				noilamviec.setText("");
				quanhe.setText("");
				dantoc.setText("");
				sodienthoai.setText("");
				 
			}});
		
		baojbutton.add(e1);
		baojbutton.add(lammoi);
		baojbutton.add(them);
		baojbutton.add(sua);
		baojbutton.add(xoa);
		baojbutton.add(e2);

		JPanel a12dchi = new JPanel();
	/*	a12dchi.setLayout(new GridLayout(2, 1,0,9));*/
		a12dchi.setLayout(new BorderLayout());
		a12dchi.setBackground(new Color(210, 255, 255));
		a12dchi.add(chuhuawsdc,BorderLayout.CENTER);			     
        a12dchi.add(baojbutton,BorderLayout.SOUTH);
        
		JPanel mau = new JPanel();
		mau.setBackground(new Color(210, 255, 255));

		Border baotr = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder baotren = BorderFactory.createTitledBorder(baotr, "Thông tin bệnh nhân");

		JPanel BAO123DIACHI = new JPanel();
		BAO123DIACHI.setBackground(new Color(210, 255, 255));
		BAO123DIACHI.setLayout(new GridLayout(2, 1, 0,10));
		
		BAO123DIACHI.add(bao123);
		BAO123DIACHI.add(a12dchi);
		BAO123DIACHI.setBorder(baotren);

		JPanel tren = new JPanel();
		tren.setLayout(new BorderLayout());
		tren.add(baotdthoat, BorderLayout.NORTH);
		tren.add(BAO123DIACHI, BorderLayout.CENTER);

		dm = new DefaultTableModel();
		dm.setColumnIdentifiers(new String[] { "Mã bệnh nhân ", "Họ và tên bệnh nhân", "Địa chỉ", "Tuổi", "Giới tính",
				"Nghề ngiệp", "Nơi làm việc", "Người giám hộ", "Dân tộc", "Số điện thoại" });
		tbl = new JTable(dm);
		tbl.setBackground(Color.white);
		Ketnoidulieu dbcon = new Ketnoidulieu();
		ResultSet rs = dbcon.THONGTINBENHNHAN();
		try {
			while(rs.next()) {
				dm.addRow(new String[]{rs.getString(1), rs.getString(2),rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6),
						rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollPane sc = new JScrollPane(tbl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				mabenhnhan.setText((String) tbl.getValueAt(row, 0));
				tenbenhnhan.setText((String) tbl.getValueAt(row, 1));
				diachi.setText((String) tbl.getValueAt(row, 2));
				tuoi.setText((String) tbl.getValueAt(row, 3));
				gioitinh.setSelectedItem((String) tbl.getValueAt(row, 4));		
				nghenghiep.setText((String) tbl.getValueAt(row,5));					
				noilamviec.setText((String) tbl.getValueAt(row, 6));
				quanhe.setText((String) tbl.getValueAt(row, 7));
				dantoc.setText((String) tbl.getValueAt(row, 8));					
				sodienthoai.setText((String) tbl.getValueAt(row, 9));
				
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
		});

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách bệnh nhân");
		sc.setBorder(borderTitle);

		

		JPanel giua = new JPanel();
		giua.setBackground(new Color(210, 255, 255));
		giua.setLayout(new BorderLayout());
		giua.add(sc, BorderLayout.CENTER);

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(new String[] { "Mã bệnh nhân ", "Họ và tên bệnh nhân", "Địa chỉ", "Tuổi", "Giới tính",
				"Nghề ngiệp", "Nơi làm việc", "Người giám hộ", "Dân tộc", "Số điện thoại" });
		JTable tble = new JTable(dtm);
		tble.setBackground(Color.YELLOW);
		JScrollPane scp = new JScrollPane(tble, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Border BORDER = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder BORDERTITLE = BorderFactory.createTitledBorder(BORDER, "Bệnh nhân tìm kiếm");
		scp.setBorder(BORDERTITLE);

		
		JButton timkiem = new JButton("   Tìm kiếm    ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\TK.PNG"));
		timkiem.setBackground(Color.WHITE);	
		timkiem.addActionListener(new ActionListener() {
 
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) 
						tble.getModel();
				model.setRowCount(0);
				ResultSet rs;
				String s=JOptionPane.showInputDialog("Nhập mã hoặc tên bệnh nhân cần tìm :");	
				try {
					rs = stmt.executeQuery("select * from BENHNHAN where MABENHNHAN= N'"+s+"' or TENBENHNHAN= N'"+s+"' ");
					while(rs.next()) {
						dtm.addRow(new String[]{rs.getString(1), rs.getString(2),rs.getString(3),
								rs.getString(4), rs.getString(5),rs.getString(6),
								rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10)});
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		JPanel tk = new JPanel();
		tk.setBackground(new Color(210, 255, 255));
		tk.add(timkiem);
		
		
		JPanel duoi = new JPanel();
		duoi.setLayout(new BorderLayout());
		duoi.add(tk, BorderLayout.NORTH);
		duoi.add(scp, BorderLayout.CENTER);

		JPanel baoquat = new JPanel();
		baoquat.setLayout(new GridLayout(3, 1));
		baoquat.add(tren);
		baoquat.add(giua);
		baoquat.add(duoi);

		jframe.add(baoquat);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new DanhSachBN();
	}

}
