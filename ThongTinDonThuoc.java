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



public class ThongTinDonThuoc extends Ketnoidulieu {
	private JLabel mhd,bskd,k,tbn,t,gt,cn,cmnd,bhyt,dc,Ngh,cdb;
	private JTextField mahoadon, bacsikedon,khoa,tenbenhnhan
	,tuoi,cannang,CMND,BHYT,diachi,nguoigiamho,chuandoanbenh,ngaylapdon;
	private JComboBox gioitinh,dongdau;
	private DefaultTableModel dm;
	private JTable tbl ; 
	
	public ThongTinDonThuoc() {
		JFrame jframe = new JFrame("Quản lý cấp phát thuốc");
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		jframe.setSize(1470, 750);
		
		JPanel cot1trai = new JPanel();
		cot1trai.setBackground(new Color(210, 255, 255));
		cot1trai.setLayout(new GridLayout(4, 1, 0, 15));
		mhd = new JLabel("Mã đơn thuốc ", 0);
		bskd = new JLabel("Bác sĩ kê đơn", 0);
		k = new JLabel("Khoa", 0);
		tbn = new JLabel("Tên bệnh nhân", 0);
		cot1trai.add(mhd);
		cot1trai.add(bskd);
		cot1trai.add(k);
		cot1trai.add(tbn);

		JPanel cot1phai = new JPanel();
		cot1phai.setBackground(new Color(210, 255, 255));
		cot1phai.setLayout(new GridLayout(4, 1, 0, 15));
		mahoadon = new JTextField();
		bacsikedon = new JTextField();
		khoa = new JTextField();
		tenbenhnhan = new JTextField();
		cot1phai.add(mahoadon);
		cot1phai.add(bacsikedon);
		cot1phai.add(khoa);
		cot1phai.add(tenbenhnhan);

		JPanel baocot1 = new JPanel();
		baocot1.setLayout(new GridLayout(1, 2));
		baocot1.add(cot1trai);
		baocot1.add(cot1phai);
		JPanel cotnhat = new JPanel();
		cotnhat.add(baocot1);

		JPanel cot2trai = new JPanel();
		cot2trai.setBackground(new Color(210, 255,255));
		cot2trai.setLayout(new GridLayout(4, 1, 0, 15));
		t = new JLabel("Tuổi", 0);
		gt = new JLabel("Giới tính", 0);
		cn = new JLabel("Cân nặng", 0);
		cmnd = new JLabel("CMND/CCCD",0);

		cot2trai.add(t);
		cot2trai.add(gt);
		cot2trai.add(cn);
		cot2trai.add(cmnd);

		JPanel cot2phai = new JPanel();
		cot2phai.setBackground(new Color(210, 255, 255));
		cot2phai.setLayout(new GridLayout(4, 1, 0, 15));
		tuoi = new JTextField();
		String arr[] = { " ","Nam", "Nữ" };
		gioitinh = new JComboBox(arr);
		cannang = new JTextField();
		CMND = new JTextField();

		cot2phai.add(tuoi);
		cot2phai.add(gioitinh);
		cot2phai.add(cannang);
		cot2phai.add(CMND);

		JPanel baocot2 = new JPanel();
		baocot2.setLayout(new GridLayout(1, 2));
		baocot2.add(cot2trai);
		baocot2.add(cot2phai);
		JPanel cotnhi = new JPanel();
		cotnhi.add(baocot2);

		JPanel cot3trai = new JPanel();
		cot3trai.setBackground(new Color(210, 255, 255));
		cot3trai.setLayout(new GridLayout(4, 1, 0, 15));
		bhyt = new JLabel("Bảo hiểm y tế", 0);
		dc = new JLabel("Địa chỉ", 0);
		Ngh = new JLabel("Người giám hộ", 0);
		cdb = new JLabel("Chuẩn đoán bệnh", 0);
		cot3trai.add(bhyt);
		cot3trai.add(dc);
		cot3trai.add(Ngh);
		cot3trai.add(cdb);

		JPanel cot3phai = new JPanel();
		cot3phai.setBackground(new Color(210, 255, 255));
		cot3phai.setLayout(new GridLayout(4, 1, 0, 15));
		BHYT = new JTextField();
		diachi = new JTextField();
		nguoigiamho = new JTextField();
		chuandoanbenh = new JTextField();
		
		cot3phai.add(BHYT);
		cot3phai.add(diachi);
		cot3phai.add(nguoigiamho);
		cot3phai.add(chuandoanbenh);

		JPanel baocot3 = new JPanel();
		baocot3.setLayout(new GridLayout(1, 2));
		baocot3.add(cot3trai);
		baocot3.add(cot3phai);
		JPanel cotba = new JPanel();
		cotba.add(baocot3);
		
		JPanel denthuoc= new JPanel();
		denthuoc.setBackground(new Color(210, 255, 255));
		JButton denthongtinthuoc= new JButton("Đến thông tin thuốc bệnh nhân");
		denthuoc.add(denthongtinthuoc);
		denthongtinthuoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			     new ThongTinThuoc();
			jframe.setVisible(false);
			}});
			
		JPanel nlddd = new JPanel();
		nlddd.setBackground(new Color(210, 255, 255));
		nlddd.setLayout(new GridLayout(1,2) );
		JLabel nld = new JLabel("Ngày lập phiếu",0);
		JLabel dd= new JLabel("Đóng dấu",0);
		nlddd.add(nld);
		nlddd.add(dd);
		
		JPanel NLDDD = new JPanel();
		NLDDD.setBackground(new Color(210, 255, 255));
		NLDDD.setLayout(new GridLayout(1,2,5,0));
		ngaylapdon = new JTextField();
		String array[] = { "  ","Đã ký", "Chưa ký" };
		dongdau = new JComboBox(array);
		NLDDD.add(ngaylapdon);
		NLDDD.add(dongdau);
		JLabel a = new JLabel();
		JLabel b = new JLabel();
		
		JPanel baongaylapdondongdau= new JPanel();
		baongaylapdondongdau.setBackground(new Color(210, 255, 255));
		baongaylapdondongdau.setLayout(new GridLayout(4,1));
		baongaylapdondongdau.add(nlddd);
		baongaylapdondongdau.add(NLDDD);
		baongaylapdondongdau.add(a);
		baongaylapdondongdau.add(b);
		
		JPanel cot4 = new JPanel();
		cot4.setLayout(new BorderLayout());
		cot4.add(denthuoc, BorderLayout.NORTH);
		cot4.add(baongaylapdondongdau, BorderLayout.CENTER);
		
		JPanel bao1234 = new JPanel();
		bao1234.setBackground(new Color(210, 255, 255));
		bao1234.setLayout(new GridLayout(1, 4,10,10));
		bao1234.add(baocot1);
		bao1234.add(baocot2);
		bao1234.add(baocot3);
		bao1234.add(cot4);
		
		JLabel tieude = new JLabel("ĐƠN THUỐC", 0);
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
				mahoadon.setText("");
				bacsikedon.setText("");
				khoa.setText("");
				tenbenhnhan.setText("");
				tuoi.setText("");
				gioitinh.setSelectedItem(null);
				cannang.setText("");
				CMND.setText("");
				BHYT.setText("");
				diachi.setText("");
				nguoigiamho.setText("");
				chuandoanbenh.setText("");
				ngaylapdon.setText("");
				
				
			}});
		JButton them = new JButton("   Thêm    ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\T.PNG"));
		them.setBackground(Color.WHITE);	
		them.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				try {
					
					stmt.executeUpdate("insert into DONTHUOC values (\'"+mahoadon.getText()+"\',"
							+ "N\'"+bacsikedon.getText()+"\',"
						    + "N\'"+khoa.getText()+"\',N\'"+tenbenhnhan.getText()+"\',"
						    + " \'"+tuoi.getText()+"\',"	
						    + "N\'"+((String)gioitinh.getSelectedItem())+"\',"												
							+ " \'"+ cannang.getText()+"\',"
							+ " \'" +CMND.getText()+"\',\'"+BHYT.getText()+"\',"
							+ "N\'" +diachi.getText()+"\',N\'"+nguoigiamho.getText()+"\',"
							+ "N\'" +chuandoanbenh.getText()+"\',\'"+ngaylapdon.getText()+"\',"
							+ "N\'"+((String)dongdau.getSelectedItem())+"\')");
				
				dm.addRow(new String[] { mahoadon.getText(), bacsikedon.getText(), khoa.getText()
						,tenbenhnhan.getText(), tuoi.getText()
						,((String) gioitinh.getSelectedItem())
						,cannang.getText() , CMND.getText(),BHYT.getText()
						,diachi.getText() , nguoigiamho.getText(),chuandoanbenh.getText()
						,ngaylapdon.getText() , ((String) dongdau.getSelectedItem())});
		
				}catch(SQLException e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
				mahoadon.setText("");
				bacsikedon.setText("");
				khoa.setText("");
				tenbenhnhan.setText("");
				tuoi.setText("");
				gioitinh.setSelectedItem(null);
				cannang.setText("");
				CMND.setText("");
				BHYT.setText("");
				diachi.setText("");
				nguoigiamho.setText("");
				chuandoanbenh.setText("");
				ngaylapdon.setText("");
				
								   	
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

				dm.addRow(new String[] { mahoadon.getText(), bacsikedon.getText(), khoa.getText()
						,tenbenhnhan.getText(), tuoi.getText()
						,((String) gioitinh.getSelectedItem())
						,cannang.getText() , CMND.getText(),BHYT.getText()
						,diachi.getText() , nguoigiamho.getText(),chuandoanbenh.getText()
						,ngaylapdon.getText() , ((String) dongdau.getSelectedItem())});
		try {
					/*System.out.println("update DONTHUOC set BACSIKEDON=N\'"+bacsikedon.getText()+"\',"
						    + "KHOA=N\'"+khoa.getText()+"\',TENBENHNHAN=N\'"+tenbenhnhan.getText()+"\',"
						    + "TUOIBENHNHAN=\'"+tuoi.getText()+"\',"	
						    + "GIOITINH=N\'"+((String)gioitinh.getSelectedItem())+"\',"												
							+ "CANNANG=\'"+ cannang.getText()+"\',"
							+ " CMND=\'" +CMND.getText()+"\',BHYT=\'"+BHYT.getText()+"\',"
							+ "DIACHI=N\'" +diachi.getText()+"\',NGUOIGIAMHO=N\'"+nguoigiamho.getText()+"\',"
							+ "CHUANDOANBENH=N\'" +chuandoanbenh.getText()+"\',NGAYLAPDON=\'"+ngaylapdon.getText()+"\',"
							+ "DONGDAU=N\'"+((String)dongdau.getSelectedItem())+"\'"
							+ "where MADONTHUOC=\'"+mahoadon.getText()+"\'");
				*/	stmt.executeUpdate("update DONTHUOC set BACSIKEDON=N\'"+bacsikedon.getText()+"\',"
						    + "KHOA=N\'"+khoa.getText()+"\',TENBENHNHAN=N\'"+tenbenhnhan.getText()+"\',"
						    + "TUOIBENHNHAN=\'"+tuoi.getText()+"\',"	
						    + "GIOITINH=N\'"+((String)gioitinh.getSelectedItem())+"\',"												
							+ "CANNANG=\'"+ cannang.getText()+"\',"
							+ " CMND=\'" +CMND.getText()+"\',BHYT=\'"+BHYT.getText()+"\',"
							+ "DIACHI=N\'" +diachi.getText()+"\',NGUOIGIAMHO=N\'"+nguoigiamho.getText()+"\',"
							+ "CHUANDOANBENH=N\'" +chuandoanbenh.getText()+"\',NGAYLAPDON=\'"+ngaylapdon.getText()+"\',"
							+ "DONGDAU=N\'"+((String)dongdau.getSelectedItem())+"\'"
							+ "where MADONTHUOC=\'"+mahoadon.getText()+"\'");
				}catch(SQLException e1) {
					System.out.print(e1);
				}			
				
				mahoadon.setText("");
				bacsikedon.setText("");
				khoa.setText("");
				tenbenhnhan.setText("");
				tuoi.setText("");
				cannang.setText("");
				CMND.setText("");
				BHYT.setText("");
				diachi.setText("");
				nguoigiamho.setText("");
				chuandoanbenh.setText("");
				ngaylapdon.setText("");
				
				
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
							
					stmt.executeUpdate("delete from DONTHUOC where (MADONTHUOC = \'"+mahoadon.getText()+"\')");
					JOptionPane.showMessageDialog(null,"Xóa thành công ! ");
				}catch(SQLException e1) {
					System.out.print(e1);
				}			
				mahoadon.setText("");
				bacsikedon.setText("");
				khoa.setText("");
				tenbenhnhan.setText("");
				tuoi.setText("");
				cannang.setText("");
				CMND.setText("");
				BHYT.setText("");
				diachi.setText("");
				nguoigiamho.setText("");
				chuandoanbenh.setText("");
				ngaylapdon.setText("");
			}});
		
		JButton timkiem = new JButton("   Tìm kiếm    ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\TK.PNG"));
		timkiem.setBackground(Color.WHITE);	
		timkiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String s=JOptionPane.showInputDialog("Nhập mã hoặc tên cần tìm :");	
				if(s==null ) {
					return;
				}
					else  {
						timkiem(s);
						jframe.setVisible(false);
					}
				
				
			}});

		baojbutton.add(e1);
		baojbutton.add(lammoi);
		baojbutton.add(them); 
		baojbutton.add(sua);
		baojbutton.add(xoa);
		baojbutton.add(timkiem);
		baojbutton.add(e2);
		
		JPanel tren = new JPanel();
		tren.setLayout(new BorderLayout());
		tren.add(baotdthoat,BorderLayout.NORTH);
		tren.add(bao1234,BorderLayout.CENTER);
		tren.add(baojbutton,BorderLayout.SOUTH);
		
		dm = new DefaultTableModel();
		dm.setColumnIdentifiers(new String[] { "Mã đơn thuốc ", "Bác sĩ kê đơn", "Khoa","Tên bệnh nhân"
				,"Tuổi bệnh nhân", "Giới tính","Cân nặng", "CMND/Thẻ căn cước",
				"Bảo hiểm y tê", "Địa chỉ","Người giám hộ","Chuẩn đoán bệnh",
				"Ngày lập đơn","Đóng dấu" });
		tbl = new JTable(dm);
		tbl.setBackground(Color.white);
		Ketnoidulieu dbcon = new Ketnoidulieu();
		ResultSet rs = dbcon.THONGTINDONTHUOC();
		try {
			while(rs.next()) {
				dm.addRow(new String[]{rs.getString(1), rs.getString(2),rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6),
						rs.getString(7), rs.getString(8),rs.getString(9),
						rs.getString(10), rs.getString(11),rs.getString(12),
						rs.getString(13), rs.getString(14)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollPane sc = new JScrollPane(tbl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		
		  sc.setViewportView(tbl); sc.setBackground(new Color(210, 255, 255));
		  tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  tbl.getColumnModel().getColumn(0).setPreferredWidth(120);
		  tbl.getColumnModel().getColumn(1).setPreferredWidth(120);
		  tbl.getColumnModel().getColumn(2).setPreferredWidth(120);
		  tbl.getColumnModel().getColumn(3).setPreferredWidth(120);
		  tbl.getColumnModel().getColumn(4).setPreferredWidth(80);
		  tbl.getColumnModel().getColumn(5).setPreferredWidth(80);
		  tbl.getColumnModel().getColumn(6).setPreferredWidth(80);
		  tbl.getColumnModel().getColumn(7).setPreferredWidth(120);
		  tbl.getColumnModel().getColumn(8).setPreferredWidth(120);
		  tbl.getColumnModel().getColumn(9).setPreferredWidth(120);
		  tbl.getColumnModel().getColumn(10).setPreferredWidth(130);
		  tbl.getColumnModel().getColumn(11).setPreferredWidth(120);
		  tbl.getColumnModel().getColumn(12).setPreferredWidth(120);
		  tbl.getColumnModel().getColumn(13).setPreferredWidth(120);
		
		tbl.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				mahoadon.setText((String) tbl.getValueAt(row, 0));
				bacsikedon.setText((String) tbl.getValueAt(row, 1));
				khoa.setText((String) tbl.getValueAt(row, 2));
				tenbenhnhan.setText((String) tbl.getValueAt(row, 3));
				tuoi.setText((String) tbl.getValueAt(row, 4));
				gioitinh.setSelectedItem((String) tbl.getValueAt(row, 5));		
				cannang.setText((String) tbl.getValueAt(row, 6));					
				CMND.setText((String) tbl.getValueAt(row, 7));
				BHYT.setText((String) tbl.getValueAt(row, 8));
				diachi.setText((String) tbl.getValueAt(row, 9));					
				nguoigiamho.setText((String) tbl.getValueAt(row, 10));
				chuandoanbenh.setText((String) tbl.getValueAt(row, 11));
				ngaylapdon.setText((String) tbl.getValueAt(row, 12));	
				dongdau.setSelectedItem((String) tbl.getValueAt(row, 13));
		
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
		giua.setLayout(new BorderLayout());
		giua.add(sc,BorderLayout.CENTER);	
		
		
		JLabel sldt1n = new JLabel("Số lượng đơn ",0);	
		JTextField soluongtrong1ngay = new JTextField(1);	
		soluongtrong1ngay.setEditable(false);
		
		JPanel nnslt1n = new JPanel();
		nnslt1n.setLayout(new GridLayout(1,1));
		nnslt1n.add(sldt1n);
		nnslt1n.add(soluongtrong1ngay);
		
		
		JPanel rong1 = new JPanel();    
		JPanel rong2 = new JPanel();
		JPanel rong3 = new JPanel();    
		JPanel rong4 = new JPanel();
		JPanel rong5 = new JPanel();    
		JPanel rong6 = new JPanel();
		
		
		JPanel thongtinthongke = new JPanel();
		thongtinthongke.setLayout(new GridLayout(1,9));
		thongtinthongke.add(rong1);
		thongtinthongke.add(rong2);
		thongtinthongke.add(rong3);		
		thongtinthongke.add(nnslt1n);
		thongtinthongke.add(rong4);
		thongtinthongke.add(rong5);
		thongtinthongke.add(rong6);
		
		
		JLabel TD = new JLabel("THỐNG KÊ ĐƠN THUỐC TRONG MỘT NGÀY", 0);
		TD.setFont(new Font("Tahoma", Font.BOLD, 20));
		TD.setForeground(Color.red);
		
		
		
		JPanel tk = new JPanel();
		JButton thongke = new JButton("  THỐNG KÊ  ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\TKE.PNG"));
		thongke.setBackground(Color.WHITE);	
		tk.add(thongke);	
		thongke.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s=JOptionPane.showInputDialog("Nhập mã hoặc tên cần tìm :");
				try {   
					ResultSet rs = null;
					rs = stmt.executeQuery("SELECT COUNT (MADONTHUOC) FROM DONTHUOC "
							+ "WHERE NGAYLAPDON = \'"+s+"\' ");
					 
					while(rs.next()) {				
						soluongtrong1ngay.setText(rs.getString(1));	
					}
				}
					catch (Exception e3) {
				}
			}});
		
		JLabel R1 =new JLabel();
		JLabel R2 =new JLabel();
		JLabel R3 =new JLabel();
		JLabel R4 =new JLabel();
		
		JPanel TTTKVATD = new JPanel();
		TTTKVATD.setLayout(new GridLayout(7,1));
		TTTKVATD.add(R1);
		TTTKVATD.add(R2);
		TTTKVATD.add(TD);
		TTTKVATD.add(thongtinthongke);
		TTTKVATD.add(tk);	
		TTTKVATD.add(R3);
		TTTKVATD.add(R4);
		
		JPanel duoi = new JPanel();
		duoi.setLayout(new BorderLayout());
		duoi.add(TTTKVATD,BorderLayout.CENTER);
		
		
		JPanel baoquat = new JPanel();
		baoquat.setLayout(new GridLayout(3,1));
		baoquat.add(tren);
		baoquat.add(giua);
		baoquat.add(duoi);
		
		jframe.add(baoquat);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}
	public void timkiem(String biendetim) {
		JFrame tk = new JFrame("Quản lý cấp phát thuốc");
		tk.setDefaultCloseOperation(tk.EXIT_ON_CLOSE);
		tk.setSize(1470, 150);
		tk.setLocationRelativeTo(null);
		tk.setVisible(true);
		
		JButton trove = new JButton("");
		trove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ThongTinDonThuoc();
				tk.setVisible(false);
				
			}
			
		});
		
		JPanel jptk = new JPanel();
		jptk.setLayout(new BorderLayout());
		jptk.add(trove,BorderLayout.SOUTH);	

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(new String[] { "Mã đơn thuốc ", "Bác sĩ kê đơn", "Khoa","Tên bệnh nhân"
				,"Tuổi bệnh nhân", "Giới tính","Cân nặng", "CMND/Thẻ căn cước",
				"Bảo hiểm y tê", "Địa chỉ","Người giám hộ","Chuẩn đoán bệnh",
				"Ngày lập đơn","Đóng dấu" });
		JTable tble = new JTable(dtm);
		tble.setBackground(Color.YELLOW);
		JScrollPane sc = new JScrollPane(tble, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		 sc.setViewportView(tble); sc.setBackground(new Color(210, 255, 255));
		  tble.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  tble.getColumnModel().getColumn(0).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(1).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(2).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(3).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(4).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(5).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(6).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(7).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(8).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(9).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(10).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(11).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(12).setPreferredWidth(120);
		  tble.getColumnModel().getColumn(13).setPreferredWidth(120);
		Ketnoidulieu dbcon = new Ketnoidulieu();
		ResultSet rs = dbcon.THONGTINDONTHUOC();
		try {
			rs = stmt.executeQuery("select * from DONTHUOC where MADONTHUOC= N'"+biendetim+"' or TENBENHNHAN= N'"+biendetim+"' ");
			while(rs.next()) {
				dtm.addRow(new String[]{rs.getString(1), rs.getString(2),rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6),
						rs.getString(7), rs.getString(8),rs.getString(9),
						rs.getString(10), rs.getString(11),rs.getString(12),
						rs.getString(13), rs.getString(14)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jptk.add(sc,BorderLayout.CENTER);
		tk.add(jptk);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new ThongTinDonThuoc();
	}

}
