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

public class ThongTinBacSi extends Ketnoidulieu {
	private DefaultTableModel dm;
	private JTable tbl;
	private JLabel mbs, tbs, gt, ck, trd, nct, dc, sdt, ema;
	private JTextField mabacsi, tenbacsi, chuyenkhoa, trinhdo, noicongtac, diachi, sodienthoai, email;
	private String invalid1;
	private JComboBox gioitinh;

	public ThongTinBacSi() {

		JFrame jframe = new JFrame("Quản lý cấp phát thuốc");
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		jframe.setSize(1470, 750);

		JPanel cot1trai = new JPanel();
		cot1trai.setBackground(new Color(210, 255, 255));
		cot1trai.setLayout(new GridLayout(3, 1, 0, 15));
		mbs = new JLabel("Mã bác sĩ ", 0);
		tbs = new JLabel("Tên bác sĩ", 0);
		gt = new JLabel("Giới tính", 0);
		cot1trai.add(mbs);
		cot1trai.add(tbs);
		cot1trai.add(gt);

		JPanel cot1phai = new JPanel();
		cot1phai.setBackground(new Color(210, 255, 255));
		cot1phai.setLayout(new GridLayout(3, 1, 0, 15));
		mabacsi = new JTextField();
		tenbacsi = new JTextField();
		String arr[] = { "", "Nam", "Nữ" };
		gioitinh = new JComboBox(arr);
		cot1phai.add(mabacsi);
		cot1phai.add(tenbacsi);
		cot1phai.add(gioitinh);

		JPanel baocot1 = new JPanel();
		baocot1.setLayout(new GridLayout(1, 2));
		baocot1.add(cot1trai);
		baocot1.add(cot1phai);
		JPanel cotnhat = new JPanel();
		cotnhat.add(baocot1);

		JPanel cot2trai = new JPanel();
		cot2trai.setBackground(new Color(210, 255, 255));
		cot2trai.setLayout(new GridLayout(3, 1, 0, 15));
		ck = new JLabel("Chuyên khoa", 0);
		trd = new JLabel("Trình độ", 0);
		nct = new JLabel("Nơi công tác", 0);

		cot2trai.add(ck);
		cot2trai.add(trd);
		cot2trai.add(nct);

		JPanel cot2phai = new JPanel();
		cot2phai.setBackground(new Color(210, 255, 255));
		cot2phai.setLayout(new GridLayout(3, 1, 0, 15));
		chuyenkhoa = new JTextField();
		trinhdo = new JTextField();
		noicongtac = new JTextField();

		cot2phai.add(chuyenkhoa);
		cot2phai.add(trinhdo);
		cot2phai.add(noicongtac);

		JPanel baocot2 = new JPanel();
		baocot2.setLayout(new GridLayout(1, 2));
		baocot2.add(cot2trai);
		baocot2.add(cot2phai);
		JPanel cotnhi = new JPanel();
		cotnhi.add(baocot2);

		JPanel cot3trai = new JPanel();
		cot3trai.setBackground(new Color(210, 255, 255));
		cot3trai.setLayout(new GridLayout(3, 1, 0, 15));
		dc = new JLabel("Địa chỉ", 0);
		sdt = new JLabel("Số điện thoại", 0);
		ema = new JLabel("Email", 0);

		cot3trai.add(dc);
		cot3trai.add(sdt);
		cot3trai.add(ema);

		JPanel cot3phai = new JPanel();
		cot3phai.setBackground(new Color(210, 255, 255));
		cot3phai.setLayout(new GridLayout(3, 1, 0, 15));
		diachi = new JTextField();
		sodienthoai = new JTextField();
		email = new JTextField();

		cot3phai.add(diachi);
		cot3phai.add(sodienthoai);
		cot3phai.add(email);

		JPanel baocot3 = new JPanel();
		baocot3.setLayout(new GridLayout(1, 2));
		baocot3.add(cot3trai);
		baocot3.add(cot3phai);
		JPanel cotba = new JPanel();
		cotba.add(baocot3);

		JPanel bao123 = new JPanel();
		bao123.setLayout(new GridLayout(1, 3));
		bao123.add(baocot1);
		bao123.add(baocot2);
		bao123.add(baocot3);

		JLabel tieude = new JLabel("DANH SÁCH BÁC SĨ", 0);
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
			}
		});

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
				mabacsi.setText("");
				tenbacsi.setText("");
				chuyenkhoa.setText("");
				trinhdo.setText("");
				noicongtac.setText("");
				diachi.setText("");
				sodienthoai.setText("");
				email.setText("");

			}
		});
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
						stmt.executeUpdate("insert into BACSI values (\'" + mabacsi.getText() + "\'," + "N\'"
								+ tenbacsi.getText() + "\',N\'" + ((String) gioitinh.getSelectedItem()) + "\'," + "N\'"
								+ chuyenkhoa.getText() + "\',N\'" + trinhdo.getText() + "\'," + "N\'"
								+ noicongtac.getText() + "\'," + "N\'" + diachi.getText() + "\'," + "\'"
								+ sodienthoai.getText() + "\',\'" + email.getText() + "\')");

						dm.addRow(new String[] { mabacsi.getText(), tenbacsi.getText(),
								((String) gioitinh.getSelectedItem()), chuyenkhoa.getText(), trinhdo.getText(),
								noicongtac.getText(), diachi.getText(), sodienthoai.getText(), email.getText() });
					} catch (Exception e3) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Số điện thoại phải là số!");
					}

				} catch (Exception e1) {
					System.out.print(e1);
				}

				mabacsi.setText("");
				tenbacsi.setText("");
				chuyenkhoa.setText("");
				trinhdo.setText("");
				noicongtac.setText("");
				diachi.setText("");
				sodienthoai.setText("");
				email.setText("");

			}
		});
		JButton sua = new JButton("    Sửa     ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\S.PNG"));
		sua.setBackground(Color.WHITE);
		sua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				dm = (DefaultTableModel) tbl.getModel();
				dm.removeRow(row);

				dm.addRow(new String[] { mabacsi.getText(), tenbacsi.getText(), ((String) gioitinh.getSelectedItem()),
						chuyenkhoa.getText(), trinhdo.getText(), noicongtac.getText(), diachi.getText(),
						sodienthoai.getText(), email.getText() });

				try {

					stmt.executeUpdate("update BACSI set TENBACSI=N\'" + tenbacsi.getText() + "\'," + "GIOITINH=N\'"
							+ ((String) gioitinh.getSelectedItem()) + "\',CHUYENKHOA=N\'" + chuyenkhoa.getText() + "\',"
							+ "TRINHDO=N\'" + trinhdo.getText() + "\',NOICONGTAC=N\'" + noicongtac.getText() + "\',"
							+ "DIACHI=N\'" + diachi.getText() + "\',SODIENTHOAI=\'" + sodienthoai.getText()
							+ "\',EMAIL=\'" + email.getText() + "\'" + "where MABACSI=\'" + mabacsi.getText() + "\'");
				} catch (SQLException e1) {
					System.out.print(e1);
				}

				mabacsi.setText("");
				tenbacsi.setText("");
				chuyenkhoa.setText("");
				trinhdo.setText("");
				noicongtac.setText("");
				diachi.setText("");
				sodienthoai.setText("");
				email.setText("");

			}
		});
		JButton xoa = new JButton("    Xóa     ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\X.PNG"));
		xoa.setBackground(Color.WHITE);
		xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				dm = (DefaultTableModel) tbl.getModel();
				dm.removeRow(row);
				try {

					stmt.executeUpdate("delete from BACSI where (MABACSI = \'" + mabacsi.getText() + "\')");
					JOptionPane.showMessageDialog(null,"Xóa thành công ! ");
				} catch (SQLException e1) {
					System.out.print(e1);
				}

				mabacsi.setText("");
				tenbacsi.setText("");
				chuyenkhoa.setText("");
				trinhdo.setText("");
				noicongtac.setText("");
				diachi.setText("");
				sodienthoai.setText("");
				email.setText("");
			}
		});

		baojbutton.add(e1);
		baojbutton.add(lammoi);
		baojbutton.add(them);
		baojbutton.add(sua);
		baojbutton.add(xoa);
		baojbutton.add(e2);

		JPanel tren = new JPanel();
		tren.setLayout(new BorderLayout());
		tren.add(baotdthoat, BorderLayout.NORTH);
		tren.add(bao123, BorderLayout.CENTER);
		tren.add(baojbutton, BorderLayout.SOUTH);

		dm = new DefaultTableModel();
		dm.setColumnIdentifiers(new String[] { "Mã bác sĩ  ", "Tên bác sĩ", "Giới tính", "Chuyên khoa ", "Trình độ",
				"Nơi công tác", "Địa chỉ", "Số điện thoại", "Email" });
		tbl = new JTable(dm);
		tbl.setBackground(Color.white);
		Ketnoidulieu dbcon = new Ketnoidulieu();
		ResultSet rs = dbcon.THONGTINBACSI();
		try {
			while (rs.next()) {
				dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollPane sc = new JScrollPane(tbl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		sc.setBackground(new Color(210, 255, 255));
		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				mabacsi.setText((String) tbl.getValueAt(row, 0));
				tenbacsi.setText((String) tbl.getValueAt(row, 1));
				gioitinh.setSelectedItem((String) tbl.getValueAt(row, 2));
				chuyenkhoa.setText((String) tbl.getValueAt(row, 3));
				trinhdo.setText((String) tbl.getValueAt(row, 4));
				noicongtac.setText((String) tbl.getValueAt(row, 5));
				diachi.setText((String) tbl.getValueAt(row, 6));
				sodienthoai.setText((String) tbl.getValueAt(row, 7));
				email.setText((String) tbl.getValueAt(row, 8));

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
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách bác sĩ");
		sc.setBorder(borderTitle);

		JPanel giua = new JPanel();
		giua.setLayout(new BorderLayout());
		giua.add(sc, BorderLayout.CENTER);

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(new String[] { "Mã bác sĩ  ", "Tên bác sĩ", "Giới tính", "Chuyên khoa ", "Trình độ",
				"Nơi công tác", "Địa chỉ", "Số điện thoại", "Email" });
		JTable tble = new JTable(dtm);
		tble.setBackground(Color.YELLOW);
		JScrollPane scp = new JScrollPane(tble, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		Border BORDER = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder BORDERTITLE = BorderFactory.createTitledBorder(BORDER, "Bác sĩ tìm kiếm");
		scp.setBorder(BORDERTITLE);

		JButton timkiem = new JButton("   Tìm kiếm    ",
				new ImageIcon("D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\TK.PNG"));
		timkiem.setBackground(Color.WHITE);
		timkiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tble.getModel();
				model.setRowCount(0);
				ResultSet rs;
				String s = JOptionPane.showInputDialog("Nhập mã hoặc tên bệnh nhân  cần tìm :");
				try {
					rs = stmt
							.executeQuery("select * from BACSI where MABACSI= N'" + s + "' or TENBACSI= N'" + s + "' ");
					while (rs.next()) {
						dtm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		JPanel tk = new JPanel();
		tk.setLayout(new BorderLayout());
		tk.add(timkiem, BorderLayout.WEST);

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

		new ThongTinBacSi();
	}

}
