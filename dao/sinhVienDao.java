package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.sinhVienBean;

public class sinhVienDao {
	public static Connection cn;
	public ResultSet getBang(String tenBang) {
		try {
			String sql = "select * from "+tenBang;
			PreparedStatement cmd = cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<sinhVienBean> getSinhVien() {
		ArrayList<sinhVienBean> ds = new ArrayList<sinhVienBean>();
		try {
			//bat dau doc du lieu
			FileReader f = new FileReader("sv.txt");
			BufferedReader in = new BufferedReader(f);
			while(true) {
				String st = in.readLine();
				if(st == null || st == "") 
					break;
				//tach du lieu
				String []tam = st.split("[;]");
				ds.add(new sinhVienBean(tam[0], tam[1], Boolean.parseBoolean(tam[2]), Double.parseDouble(tam[3])));
			}
			in.close();
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public void ketNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Da xac dinh he quan tri co so du lieu");
			cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-J4H20NA\\MSSQLSV:1433;databaseName=testGiuaKy;user=sa;password=123");
			System.out.println("Da ket noi !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
