package in.co.rays.Test;

import java.util.Date;

import in.co.rays.Bean.CompanyBean;
import in.co.rays.Model.CompanyModel;

public class TestCompany {
	
	
	public static void main(String[] args) throws Exception {
		
		//testNextPk();
		testAdd();
		
	}
	public static void testNextPk() throws Exception{
		
		CompanyModel model = new CompanyModel();
		
		int pk = model.nextPk();
		
		
		System.out.println("nextPk =" + pk);
		
	}
	public static void testAdd() throws Exception{
		
		CompanyModel model = new CompanyModel();
		
		CompanyBean bean = new CompanyBean();
		
		bean.setFirstName("sourabh");
		bean.setLastName("mandloi");
		bean.setLoginId("sourabh04@gmail.com");
		bean.setPassword("1234");
		bean.setDob(new Date());
		bean.setAddress("indore");
		
		model.add(bean);
	}
}

