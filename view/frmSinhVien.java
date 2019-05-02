package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.sinhVienBean;
import bo.sinhVienBo;
import dao.sinhVienDao;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmSinhVien extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSinhVien frame = new frmSinhVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	DefaultTableModel dfTab;
	sinhVienBo sv = new sinhVienBo();
	sinhVienDao cn = new sinhVienDao();
	void napBang() {
		try {
			cn.ketNoi();
			dfTab = new DefaultTableModel();
			dfTab.addColumn("MaSinhVien");
			dfTab.addColumn("TenSinhVien");
			dfTab.addColumn("GioiTinh");
			dfTab.addColumn("DiemTrungBinh");
			Object []tam  =  new Object[4];
			ResultSet rs = cn.getBang("sinhVien");
			while(rs.next()) {
				tam[0] = rs.getString(1);
				tam[0] = rs.getString(2);
				tam[0] = rs.getString(3);
				tam[0] = rs.getString(4);
				dfTab.addRow(tam);
			}
			rs.close();
			table.setModel(dfTab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public frmSinhVien() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				napBang();
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 89, 755, 328);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Sinh vien trong co so du lieu", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnImport.setBounds(58, 36, 89, 23);
		contentPane.add(btnImport);
		
		JButton btnTimkiem = new JButton("TimKiem");
		btnTimkiem.setBounds(221, 36, 89, 23);
		contentPane.add(btnTimkiem);
	}
}
