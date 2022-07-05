package DuAnQuanLyCapPhatThuoc;

import java.awt.event.ActionEvent;   
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;

public class HOME {
	

	public HOME() {
		JFrame giaodienchinh = new JFrame("Chương trình cấp phát thuốc bệnh nhân");
		JPanel bao = new JPanel();
		bao.setLayout(new BorderLayout());
		JPanel home = new JPanel();
		ImageIcon myImage = new ImageIcon(
				"D:\\NHỮNG TÀI LIỆU CỦA TÈO\\LẬP TRÌNH HƯỚNG ĐỐI TƯỢNG\\đò án cuối kỳ\\mmmm.PNG");
		home.add(new JLabel(myImage));
		bao.add(home, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
        toolBar.setBackground(new Color(194, 232, 39));
        toolBar.setFont(new Font("Open Sans", Font.PLAIN, 25));
        toolBar.setFloatable(false);
        toolBar.setEnabled(false);
        giaodienchinh.add(toolBar, BorderLayout.NORTH);

        JMenuBar  menuBarBenhnhan = new JMenuBar();
        menuBarBenhnhan.setBackground(new Color(194, 232, 39));
        toolBar.add(menuBarBenhnhan);
    
        JMenu benhnhan = new JMenu("      Danh sách bệnh nhân     ");
        benhnhan.setForeground(Color.BLACK);
        benhnhan.setFont(new Font(null, Font.PLAIN, 15));
       
        menuBarBenhnhan.add(benhnhan);
        
        JMenuItem DenBenhnhan = new JMenuItem("Đến danh sách bệnh nhân");
        DenBenhnhan.setFont(new Font(null, Font.PLAIN, 15));
        DenBenhnhan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.ALT_MASK));
        DenBenhnhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			     new DanhSachBN();
			giaodienchinh.setVisible(false);
			}});
        benhnhan.add(DenBenhnhan);
        
        
        JMenuBar  menuBarDonThuoc = new JMenuBar();
        menuBarDonThuoc.setBackground(new Color(194, 232, 39));
        toolBar.add(menuBarDonThuoc);
    
        JMenu donthuoc = new JMenu("      Thông tin đơn thuốc     ");
        donthuoc.setForeground(Color.BLACK);
        donthuoc.setFont(new Font(null, Font.PLAIN, 15));
       
        menuBarDonThuoc.add(donthuoc);
        

        JMenuItem  DenDonhuoc = new JMenuItem("Đến thông tin đơn thuốc");
        DenDonhuoc.setFont(new Font(null, Font.PLAIN, 15));
        DenDonhuoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.ALT_MASK));
        donthuoc.add(DenDonhuoc);
        DenDonhuoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			     new ThongTinDonThuoc();
			giaodienchinh.setVisible(false);
			}});
		
        JMenuBar  menuBarBacSi = new JMenuBar();
        menuBarBacSi.setBackground(new Color(194, 232, 39));
        toolBar.add(menuBarBacSi);
    
        JMenu bacsi = new JMenu("   Thông tin bác sĩ  ");
        bacsi.setForeground(Color.BLACK);
        bacsi.setFont(new Font(null, Font.PLAIN, 15));
       
        menuBarBacSi.add(bacsi);
        

        JMenuItem  DenBacSi = new JMenuItem("Đến thông tin bác sĩ");
        DenBacSi.setFont(new Font(null, Font.PLAIN, 15));
        DenBacSi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.ALT_MASK));
        bacsi.add(DenBacSi);
        DenBacSi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			     new ThongTinBacSi();
			giaodienchinh.setVisible(false);
			}});
        
        JMenuBar  menuBarThoat = new JMenuBar();
        menuBarThoat.setBackground(new Color(194, 232, 39));
        toolBar.add(menuBarThoat);
    
        JMenu thoat = new JMenu("   Thoát chương trình  ");
        thoat.setForeground(Color.BLACK);
        thoat.setFont(new Font(null, Font.PLAIN, 15));
        menuBarThoat.add(thoat);
        
        JMenuItem  thoatchuongtrinh = new JMenuItem("Thoát");
        thoatchuongtrinh.setFont(new Font(null, Font.PLAIN, 15));
        thoatchuongtrinh.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        thoat.add(thoatchuongtrinh);
        
        thoatchuongtrinh.addActionListener(new ActionListener() {
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
        
		giaodienchinh.add(bao);
		giaodienchinh.setSize(700,490);
		giaodienchinh.setVisible(true);
		giaodienchinh.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HOME();
	}

	public void display() {
		// TODO Auto-generated method stub

	}

}
