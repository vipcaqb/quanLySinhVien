package bo;

import java.util.ArrayList;

import bean.sinhVienBean;
import dao.sinhVienDao;

public class sinhVienBo {
	sinhVienDao sv = new sinhVienDao();
	public ArrayList<sinhVienBean> getSinhVien (){
		return sv.getSinhVien();
	}

}
