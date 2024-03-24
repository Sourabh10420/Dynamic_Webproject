package in.co.rays.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.Bean.StudentFormBean;
import in.co.rays.Bean.UserBean;
import in.co.rays.Model.StudentFormModel;
import in.co.rays.Model.UserModel;

public class TestStudentForm {
	
	public static void main(String[] args) throws Exception{
		
//		testNextPk();
		//testSearch();
	//	testAdd();
	testUpdate();
//		testDelete();
		//testFindByLogin();
//	testFindByPk();
	//	testAuthenticate();
	}
	
	public static void testNextPk() throws Exception{
		
		StudentFormModel model = new StudentFormModel();
		
		int pk =model.nextPk();
		
		System.out.println("Pk=" + pk);
	}
	public static void testAdd() throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		StudentFormModel model = new StudentFormModel();
		
		StudentFormBean bean = new StudentFormBean();
		
		bean.setFirstName("Hariom");
		bean.setLastName("Mandloi");
		bean.setLoginId("hariommandloi04@gmail.com)");
		bean.setPassword("hariom@1432");
		bean.setCourseName("Bsc Plain");
		bean.setEnrollment("DS2441044");
		bean.setDob(new Date());
		bean.setAddress("Indore");
		bean.setSemester("First");
		
		model.add(bean);
		
	}
	
	public static void testUpdate() throws Exception{
		
		
		StudentFormModel model = new StudentFormModel();
		
		StudentFormBean bean = new StudentFormBean();
		
		bean.setId(1);
		bean.setFirstName("Sourabh");
		bean.setLastName("Mandloi");
		bean.setLoginId("sourabhmandloi04@gmail.com");
		bean.setPassword("sourabh@1432");
		bean.setCourseName("Bsc Plain");
		bean.setEnrollment("DS2211044");
		bean.setDob(new Date());
		bean.setAddress("Indore");
		bean.setSemester("First");
		 
		model.update(bean);
		
	}
	
	public static void testDelete() throws Exception{
		
		StudentFormBean bean = new StudentFormBean();
		
		StudentFormModel model = new StudentFormModel();
		
		model.delete(2);
	}
	
	public static void testFindByPk() throws Exception{
		
		
		StudentFormModel model = new StudentFormModel();
		
		StudentFormBean bean= model.findByPk(1);
		
		System.out.print("\t" + bean.getId());
		System.out.print("\t" + bean.getFirstName());
		System.out.print("\t" + bean.getLastName());
		System.out.print("\t" + bean.getLoginId());
		System.out.print("\t" + bean.getPassword());
        System.out.print("\t" + bean.getCourseName());
        System.out.print("\t" + bean.getEnrollment());
        System.out.print("\t" + bean.getDob());
        System.out.print("\t" + bean.getAddress());
		System.out.print("\t" + bean.getSemester());
}

	public static void testFindByLogin() throws Exception{
		
		
		StudentFormModel model = new StudentFormModel();
		
		StudentFormBean bean= model.findByLogin("sohammandloi04@gmail.com)");
		
		System.out.print("\t" + bean.getId());
		System.out.print("\t" + bean.getFirstName());
		System.out.print("\t" + bean.getLastName());
		System.out.print("\t" + bean.getLoginId());
		System.out.print("\t" + bean.getPassword());
        System.out.print("\t" + bean.getCourseName());
        System.out.print("\t" + bean.getEnrollment());
        System.out.print("\t" + bean.getDob());
        System.out.print("\t" + bean.getAddress());
		System.out.print("\t" + bean.getSemester());
}
	
	public static void testAuthenticate() throws Exception{
		
			 	
			 StudentFormModel model = new StudentFormModel();
			 
			 StudentFormBean bean =model.authenticate("sourabhmandloi04@gmail.com)", "sourabh@1432");
			 
			 if(bean != null) {
				 
					
					System.out.print("\t" + bean.getId());
					System.out.print("\t" + bean.getFirstName());
					System.out.print("\t" + bean.getLastName());
					System.out.print("\t" + bean.getLoginId());
					System.out.print("\t" + bean.getPassword());
			        System.out.print("\t" + bean.getCourseName());
			        System.out.print("\t" + bean.getEnrollment());
			        System.out.print("\t" + bean.getDob());
			        System.out.print("\t" + bean.getAddress());
					System.out.print("\t" + bean.getSemester());
				}else {
					System.out.println("invalid login & password");
				}
	}
	
	private static void testSearch() throws Exception {

		StudentFormBean bean = new StudentFormBean();
		
		bean.setId(1);
		
		bean.setFirstName("s");

		StudentFormModel model = new StudentFormModel();

		List list = model.search(bean, 1, 5);
		
		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (StudentFormBean) it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
	        System.out.print("\t" + bean.getCourseName());
	        System.out.print("\t" + bean.getEnrollment());
	        System.out.print("\t" + bean.getDob());
	        System.out.print("\t" + bean.getAddress());
			System.out.println("\t" + bean.getSemester());
			

		}

	
	}
}