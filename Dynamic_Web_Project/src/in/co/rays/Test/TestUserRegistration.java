package in.co.rays.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.Bean.UserRegistrationBean;
import in.co.rays.Model.UserRegistrationModel;

public class TestUserRegistration {
	
	public static void main(String[] args) throws Exception {
			
		testAdd();
		
		//testNextPk();
	//	testUpdate();
	//	testDelete();
	// testFindByPk();
		// testAuthenticate();
	//	 testSearch();
	}
	
	public static void testNextPk() throws Exception{
		
		UserRegistrationModel model = new UserRegistrationModel();
		
		int pk = model.nextPk();
		
		System.out.println("pk"+ pk);
		
		
	}
	
	public static void testAdd() throws Exception{
		
		
		
		UserRegistrationModel model = new UserRegistrationModel();
		
		UserRegistrationBean bean = new UserRegistrationBean();
		
		Date d = new Date("1999/08/25");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		String str = sdf.format(d);
		
	
		bean.setId(1);
		bean.setfName("sourabh");
		bean.setlName("mandloi");
		bean.setLoginId("sourabh@gmail.com");
		bean.setPassword("sourabh111");
		bean.setDob(new Date(str));
		bean.setAddress("indore");
		
		model.add(bean);
		
	
	}
	
	public static void testUpdate() throws Exception{
		
UserRegistrationModel model = new UserRegistrationModel();
		
		UserRegistrationBean bean = new UserRegistrationBean();
		
		Date d = new Date("1999/08/25");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		String str = sdf.format(d);
		
		bean.setId(2);
		bean.setfName("muskan");
		bean.setlName("mandloi");
		bean.setLoginId("muskan@gmail");
		bean.setPassword("sourabh111");
		bean.setDob(new Date(str));
		bean.setAddress("indore");
		
		model.update(bean);
		
	}
	public static void testDelete() throws  Exception{
		
		UserRegistrationModel model = new UserRegistrationModel();
		
		UserRegistrationBean bean = new UserRegistrationBean();
		
		model.delete(bean, "Sourabh");
		
	}
	
	public static void testFindByPk() throws Exception{
		
		UserRegistrationModel model = new UserRegistrationModel();
		
		UserRegistrationBean bean = model.findByPk(2);
		
		if(bean != null) {
			
			System.out.println("find data succsesfully");
			
		System.out.print("\t"+ bean.getId());
		System.out.print("\t"+ bean.getfName());
		System.out.print("\t"+ bean.getlName());
		System.out.print("\t"+ bean.getLoginId());
		System.out.print("\t"+ bean.getPassword());
		System.out.print("\t"+ bean.getAddress());
		System.out.println("\t"+ bean.getDob());
		
		}
		
		else {
			
			System.out.println("user input invalid values");
		}
		
		
	}
	
	public static void testAuthenticate() throws Exception{
		
				
		UserRegistrationModel model = new UserRegistrationModel();
		UserRegistrationBean bean = model.authenticate("sourabh@gmail.com","sourabh111");
		
		if(bean != null) {
			System.out.print("\t"+ bean.getId());
			System.out.print("\t"+ bean.getfName());
			System.out.print("\t"+ bean.getlName());
			System.out.print("\t"+ bean.getLoginId());
			System.out.print("\t"+ bean.getPassword());
			System.out.print("\t"+ bean.getAddress());
			System.out.println("\t"+ bean.getDob());
			
			
		}
		else {
			System.out.println("user enter invalid values");
		}
		
		
	}
	public static void testSearch() throws Exception{
		
		UserRegistrationModel model = new UserRegistrationModel();
		
		UserRegistrationBean bean = new UserRegistrationBean();
		
		Date d = new Date("1996/08/25");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		String str = sdf.format(d);
		
	//bean.setId(2);
		//bean.setlName("m");
		bean.setDob(new Date(str));
		
		
		List list = model.search(bean, 1, 5);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			
			bean = (UserRegistrationBean) it.next();
			
			System.out.print("\t"+ bean.getId());
			System.out.print("\t"+ bean.getfName());
			System.out.print("\t"+ bean.getlName());
			System.out.print("\t"+ bean.getLoginId());
			System.out.print("\t"+ bean.getPassword());
			System.out.print("\t"+ bean.getAddress());
			System.out.println("\t"+ bean.getDob());
			
			
		}
				
	}
}

