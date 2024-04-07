package in.co.rays.Test;

import in.co.rays.Bean.FoodOrderBean;
import in.co.rays.Model.FoodOrderModel;
import in.co.rays.Model.UserModel;

public class TestFoodOrder {
	
	
	public static void main(String[] args)  throws Exception{
		
		textNextPk();
		
	}
	
	public static void textNextPk() throws Exception{
		
		FoodOrderModel model = new FoodOrderModel();
		
		int pk = model.nextPk();
		
		System.out.println("pk =" + pk);
	}

}
