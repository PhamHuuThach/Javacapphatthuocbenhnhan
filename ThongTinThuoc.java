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

public class ThongTinThuoc  extends Ketnoidulieu {
	private DefaultTableModel dm;
	private JTable tbl;
	private JLabel mt,tthuoc,tbn,sl,dg,ttien,dvt,ld,lk;
	private JTextField mathuoc,tenthuoc, tenbenhnhan,soluong,dongia,tongtien,donvithuoc,lieudung,loikhuyen;
	
	int	tt;
	
	public ThongTinThuoc() {
		JFrame jframe = new JFrame("Quản lý cấp phát thuốc");
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		jframe.setSize(1470, 750);
		
		JLabel a1 = new JLabel();
		JLabel a2 = new JLabel();
		JLabel a3 = new JLabel();
		JLabel a4 = new JLabel();
		
		JPanel cot1trai = new JPanel();
		cot1trai.setBackground(new Color(210, 255, 255));
		cot1trai.setLayout(new GridLayout(5, 1, 0, 15));
		mt = new JLabel("Mã thuốc ", 0);
		tthuoc = new JLabel("Tên thuốc", 0);
		tbn = new JLabel("Tên bệnh nhân", 0);
		cot1trai.add(a1);
		cot1trai.add(mt);
		cot1trai.add(tthuoc);
		cot1trai.add(tbn);
		cot1trai.add(a2);
		
		JPanel cot1phai = new JPanel();
		cot1phai.setBackground(new Color(210, 255, 255));
		cot1phai.setLayout(new GridLayout(5, 1, 0, 15));
		mathuoc = new JTextField();
		tenthuoc = new JTextField();
		tenbenhnhan = new JTextField();
		cot1phai.add(a3);
		cot1phai.add(mathuoc);
		cot1phai.add(tenthuoc);
		cot1phai.add(tenbenhnhan);
		cot1phai.add(a4);
		
		JPanel baocot1 = new JPanel();
		baocot1.setLayout(new GridLayout(1, 2));
		baocot1.add(cot1trai);
		baocot1.add(cot1phai);
		
		JLabel b1 = new JLabel();
		JLabel b2 = new JLabel();
		JLabel b3 = new JLabel();
		JLabel b4 = new JLabel();

		JPanel cot2trai = new JPanel();
		cot2trai.setBackground(new Color(210, 255,255));
		cot2trai.setLayout(new GridLayout(5, 1, 0, 15));
		sl = new JLabel("Số lượng", 0);
		dg = new JLabel("Đơn giá", 0);
		ttien = new JLabel("Tổng tiền", 0);
		
		cot2trai.add(b1);
		cot2trai.add(sl);
		cot2trai.add(dg);
		cot2trai.add(ttien);
		cot2trai.add(b2);
		
		JPanel cot2phai = new JPanel();
		cot2phai.setBackground(new Color(210, 255, 255));
		cot2phai.setLayout(new GridLayout(5, 1, 0, 15));
		soluong = new JTextField();
		dongia = new JTextField();
		tongtien = new JTextField();
		tongtien.setEditable(false);
		tongtien.setBackground(new Color(210, 255, 255));
		
		cot2phai.add(b3);
		cot2phai.add(soluong);
		cot2phai.add(dongia);
		cot2phai.add(tongtien);
		cot2phai.add(b4);
		

		JPanel baocot2 = new JPanel();
		baocot2.setLayout(new GridLayout(1, 2));
		baocot2.add(cot2trai);
		baocot2.add(cot2phai);
		

		JLabel c1 = new JLabel();
		JLabel c2 = new JLabel();
		JLabel c3 = new JLabel();
		JLabel c4 = new JLabel();

		JPanel cot3trai = new JPanel();
		cot3trai.setBackground(new Color(210, 255, 255));
		cot3trai.setLayout(new GridLayout(5, 1, 0, 15));
		dvt = new JLabel("ĐVT", 0);
		ld = new JLabel("Liều dùng", 0);
		lk = new JLabel("Lời khuyên", 0);
		cot3trai.add(c1);
		cot3trai.add(dvt);
		cot3trai.add(ld);
		cot3trai.add(lk);
		cot3trai.add(c2);

		JPanel cot3phai = new JPanel();
		cot3phai.setBackground(new Color(210, 255, 255));
		cot3phai.setLayout(new GridLayout(5, 1, 0, 15));
		donvithuoc = new JTextField();
		lieudung = new JTextField();
		loikhuyen = new JTextField();
		
		cot3phai.add(c3);
		cot3phai.add(donvithuoc);
		cot3phai.add(lieudung);
		cot3phai.add(loikhuyen);
		cot3phai.add(c4);

		JPanel baocot3 = new JPanel();
		baocot3.setLayout(new GridLayout(1, 2));
		baocot3.add(cot3trai);
		baocot3.add(cot3phai);
		
		
		JPanel bao123 = new JPanel();
		bao123.setLayout(new GridLayout(1, 3));
		bao123.add(baocot1);
		bao123.add(baocot2);
		bao123.add(baocot3);
		
	
		
		
		
		
		JLabel tieude = new JLabel("DANH SÁCH BỆNH NHÂN NHẬN THUỐC", 0);
		tieude.setFont(new Font("Tahoma", Font.BOLD, 20));
		tieude.setForeground(Color.red);
		JButton thoat = new JButton("Thoát");
		thoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int hoi = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát chuong trình?", null,
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
				     new ThongTinDonThuoc();
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
				mathuoc.setText("");
				tenthuoc.setText("");
				tenbenhnhan.setText("");
				soluong.setText("");
				dongia.setText("");
				tongtien.setText("");
				donvithuoc.setText("");
				lieudung.setText("");
				loikhuyen.setText("");
				
			}});
		JButton them = new JButton("   Thêm    ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\T.PNG"));
		them.setBackground(Color.WHITE);	
		them.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			tongtien();	
			
				
				try {
					
					stmt.executeUpdate("insert into THUOC values (\'"+mathuoc.getText()+"\',"
							+ "N\'"+tenthuoc.getText()+"\',N\'"+tenbenhnhan.getText()+"\',"							
							+ "\'"+soluong.getText()+"\',\'"+dongia.getText()+"\',"
							+ "\'"+tongtien.getText()+"\',"
							+ "N\'"+ donvithuoc.getText()+"\',"
							+ "\'"+lieudung.getText()+"\',\'"+loikhuyen.getText()+"\')");
					
					dm.addRow(new String[] { mathuoc.getText(), tenthuoc.getText(), tenbenhnhan.getText()
						, soluong.getText(),dongia.getText(), tongtien.getText()
						,donvithuoc.getText() , lieudung.getText(),loikhuyen.getText()});
					
				}catch(SQLException e1) {
					System.out.print(e1);
				}
				mathuoc.setText("");
				tenthuoc.setText("");
				tenbenhnhan.setText("");
				soluong.setText("");
				dongia.setText("");
				tongtien.setText("");
				donvithuoc.setText("");
				lieudung.setText("");
				loikhuyen.setText("");
				
				
			}});
		JButton sua = new JButton("    Sửa     ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\S.PNG"));
		sua.setBackground(Color.WHITE);	
		sua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tongtien();
				int row = tbl.getSelectedRow();
			    dm = (DefaultTableModel)tbl.getModel();
				dm.removeRow( row );

				
				dm.addRow(new String[] { mathuoc.getText(), tenthuoc.getText(), tenbenhnhan.getText()
							, soluong.getText(),dongia.getText(), tongtien.getText()
							,donvithuoc.getText() , lieudung.getText(),loikhuyen.getText()});
					
				try {
			
					stmt.executeUpdate("update THUOC set TENTHUOC=N\'"+tenthuoc.getText()+"\',"							
							+ "TENBENHNHAN=N\'"+ tenbenhnhan.getText()+"\',SOLUONG=\'"+soluong.getText()+"\',"
							+ "DONGIA=\'"+dongia.getText()+"\',TONGTIEN=\'"+tongtien.getText()+"\',"
							+ "DVT=N\'"+ donvithuoc.getText()+"\',LIEUDUNG=\'"+lieudung.getText()+"\',LOIKHUYEN=\'"+loikhuyen.getText()+"\'"	
							+ "where MATHUOC=\'"+mathuoc.getText()+"\'");
				}catch(SQLException e1) {
					System.out.print(e1);
				}			
				
				mathuoc.setText("");
				tenthuoc.setText("");
				tenbenhnhan.setText("");
				soluong.setText("");
				dongia.setText("");
				tongtien.setText("");
				donvithuoc.setText("");
				lieudung.setText("");
				loikhuyen.setText("");
				
				
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
							
					stmt.executeUpdate("delete from THUOC where (MATHUOC = \'"+mathuoc.getText()+"\')");
					JOptionPane.showMessageDialog(null,"Xóa thành công ! ");
				}catch(SQLException e1) {
					System.out.print(e1);
				}			
				
				mathuoc.setText("");
				tenthuoc.setText("");
				tenbenhnhan.setText("");
				soluong.setText("");
				dongia.setText("");
				tongtien.setText("");
				donvithuoc.setText("");
				lieudung.setText("");
				loikhuyen.setText("");
				
			}});
		

		baojbutton.add(e1);
		baojbutton.add(lammoi);
		baojbutton.add(them);
		baojbutton.add(sua);
		baojbutton.add(xoa);
		baojbutton.add(e2);
		
		JPanel tren = new JPanel();
		tren.setBackground(new Color(210, 255, 255));
		tren.setLayout(new BorderLayout());
		tren.add(baotdthoat,BorderLayout.NORTH);
		tren.add(bao123,BorderLayout.CENTER);
		tren.add(baojbutton,BorderLayout.SOUTH);
		
		dm = new DefaultTableModel();
		dm.setColumnIdentifiers(new String[] {  "Mã thuốc ","Tên thuốc","Tên bệnh nhân"
												,"Số lượng ", "Đơn giá","Tổng tiền", 
												"ĐVT","Liều dùng","Lời khuyên" });
		tbl = new JTable(dm);
		tbl.setBackground(Color.white);
		Ketnoidulieu dbcon = new Ketnoidulieu();
		ResultSet rs = dbcon.THONGTINTHUOC();
		try {
			while(rs.next()) {
				dm.addRow(new String[]{ rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6),
						rs.getString(7), rs.getString(8),rs.getString(9)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollPane sc = new JScrollPane(tbl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		
		  sc.setViewportView(tbl); sc.setBackground(new Color(210, 255, 255));
		
		tbl.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				mathuoc.setText((String) tbl.getValueAt(row, 0));
				tenthuoc.setText((String) tbl.getValueAt(row, 1));
				tenbenhnhan.setText((String) tbl.getValueAt(row, 2));
				soluong.setText((String) tbl.getValueAt(row, 3));
				dongia.setText((String) tbl.getValueAt(row, 4));
				tongtien.setText((String) tbl.getValueAt(row, 5));
				donvithuoc.setText((String) tbl.getValueAt(row, 6));					
				lieudung.setText((String) tbl.getValueAt(row, 7));
				loikhuyen.setText((String) tbl.getValueAt(row, 8));
				
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


		JPanel tk = new JPanel();
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
		tk.add(timkiem);
		
		JPanel giua = new JPanel();
		giua.setLayout(new BorderLayout());
		giua.add(sc,BorderLayout.CENTER);
		giua.add(tk,BorderLayout.SOUTH);
		
		
	
		
		JPanel baoquat = new JPanel();
		baoquat.setLayout(new GridLayout(2,1));
		baoquat.add(tren);
		baoquat.add(giua);
	
		
		jframe.add(baoquat);
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
		
		
	}
	
	public void tongtien() {
		tt=  Integer.parseInt(soluong.getText())*  Integer.parseInt(dongia.getText());
		 tongtien.setText(String.valueOf(tt));
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
				new ThongTinThuoc();
				tk.setVisible(false);
				
			}
			
		});
		
		JPanel jptk = new JPanel();
		jptk.setLayout(new BorderLayout());
		jptk.add(trove,BorderLayout.SOUTH);	

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(new String[] {"Mã thuốc ", "Tên thuốc","Tên bệnh nhân"
				,"Số lượng ", "Đơn giá","Tổng tiền", 
				"ĐVT","Liều dùng","Lời khuyên" });
		JTable tble = new JTable(dtm);
		tble.setBackground(Color.YELLOW);
		JScrollPane sc = new JScrollPane(tble, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Ketnoidulieu dbcon = new Ketnoidulieu();
		ResultSet rs = dbcon.THONGTINDONTHUOC();
		try {
			rs = stmt.executeQuery("select * from THUOC where MATHUOC= N'"+biendetim+"' or TENTHUOC= N'"+biendetim+"' ");
			while(rs.next()) {
				dtm.addRow(new String[]{rs.getString(1), rs.getString(2),rs.getString(3),
						rs.getString(4), rs.getString(5),rs.getString(6),
						rs.getString(7), rs.getString(8),rs.getString(9)});
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

		new  ThongTinThuoc();
	}

}
