package DuAnQuanLyCapPhatThuoc;

import java.sql.*;   
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Ketnoidulieu {

	/*private JLabel sott, khoa, mabn, tenbn, diachi, tuoi, gioitinh,ngaynhanthuoc,loaithuoc,thanhtien;
	private JTextField stt, k, mbn, tbn, diac, t,gt,nnt,lt,TT;
	*/

	Connection con;
	protected Statement stmt;
	ResultSet rs;

	public Ketnoidulieu() {
		

		try {
			this.con = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-IU6OOSC\\SQLEXPRESS:1433;databaseName=QuanlycapphatthuocJava;user=sa;password=sa");
			this.stmt = con.createStatement();
			// stmt.executeUpdate();
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public ResultSet THONGTINBACSI() {
		 rs = null;
		try {
			rs = this.stmt.executeQuery("select * from BACSI");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet THONGTINBENHNHAN() {
		ResultSet rs = null;
		try {
			rs = this.stmt.executeQuery("select * from BENHNHAN");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

	
	public ResultSet THONGTINDONTHUOC() {
		ResultSet rs = null;
		try {
			rs = this.stmt.executeQuery("select * from DONTHUOC");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet THONGTINTHUOC() {
		ResultSet rs = null;
		try {
			rs = this.stmt.executeQuery("select * from THUOC");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet USERPASSWORD() {
		ResultSet rs = null;
		try {
			rs = this.stmt.executeQuery("select * from DANGNHAP");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void timkiem(String biendetim) {
		JFrame jframe = new JFrame("Quản lý cấp phát thuốc");
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		jframe.setSize(1000, 300);
		jframe.setLocationRelativeTo(null); 
		jframe.setVisible(true);
		
			JButton trove = new JButton("");
			trove.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				//	new Benhnhan();
					jframe.setVisible(false);
					
				}
				
			});
			
			JPanel jptk = new JPanel();
			jptk.setLayout(new BorderLayout());
			jptk.add(trove,BorderLayout.SOUTH);
			
			
			DefaultTableModel dm = new DefaultTableModel();
			dm.setColumnIdentifiers(new String[] { "Stt", "Khoa", "Mã bệnh nhân ", "Tên bệnh nhân",
					"Địa chỉ", "Tuổi","Giới tính", "Ngày nhận thuốc", "Loại thuốc" ,"Tổng tiền"});
			JTable tbl = new JTable(dm);
			JScrollPane sc = new JScrollPane(tbl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			try {
				rs = stmt.executeQuery("select * from THONGTINBENHNHAN where MABENHNHAN= N'"+biendetim+"' or TENBENHNHAN= N'"+biendetim+"' ");
				while(rs.next()) {
					dm.addRow(new String[]{rs.getString(1), rs.getString(2),rs.getString(3),
							rs.getString(4), rs.getString(5),rs.getString(6),
							rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10)});
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jptk.add(sc,BorderLayout.CENTER);
			jframe.add(jptk);
			

	}
		
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	}

}
