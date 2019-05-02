package view;

import dao.sinhVienDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sinhVienDao sv = new sinhVienDao();
		try {
			sv.ketNoi();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
