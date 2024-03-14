package in.co.rays.Test;

import in.co.rays.Bean.StudentFormBean;
import in.co.rays.Model.StudentFormModel;

public class TestStudentForm {
	
	public static void main(String[] args) throws Exception{
		
		testNextPk();
		
	}
	
	public static void testNextPk() throws Exception{
		
		StudentFormModel model = new StudentFormModel();
		
		int pk =model.nextPk();
		
		System.out.println("Pk=" + pk);
	}

}
