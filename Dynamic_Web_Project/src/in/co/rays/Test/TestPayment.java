package in.co.rays.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.Bean.PaymentBean;
import in.co.rays.Model.PaymentModel;



public class TestPayment {
	
	public static void main(String[] args) throws Exception{
		
		//testNextPk();
		//testAdd();
		testUpdate();
		//testFindByPk();
		//testSearch(); 
		
		//testDelete();
	//	testFindByLogin();
		//testAuthenticate();
	}
	
	public static void testAuthenticate() throws Exception{
		

		PaymentModel model = new PaymentModel();
		
		
		PaymentBean bean = model.authenticate("vijay@gmail.com", "vijay123");
		
		
		System.out.print("\t"+ bean.getId());
		System.out.print("\t"+ bean.getPayementDate());
		System.out.print("\t"+ bean.getDescription());
		System.out.print("\t"+ bean.getAmmount());
		System.out.print("\t"+ bean.getPaymentMethod());
		System.out.print("\t"+ bean.getStatus());
		System.out.print("\t"+ bean.getPayer());
		System.out.print("\t"+ bean.getEmailId());
		System.out.print("\t"+ bean.getPassword());
		
		
	}

	
	public static void testNextPk() throws Exception{
		
		PaymentBean bean = new PaymentBean();
		
		PaymentModel model = new PaymentModel();
		
		int pk = model.nextPk();
		
		System.out.println("pk= "+ pk);
	}
	
	public static void testAdd() throws Exception{
		
		PaymentBean bean = new PaymentBean();
		
		PaymentModel model = new PaymentModel();
		
	
		bean.setPayementDate(new Date());
		bean.setDescription("PayemttosendaAshwin");
		bean.setAmmount(10000);
		bean.setPaymentMethod("Paytm");
		bean.setStatus("Payment done");
		bean.setPayer("Kunal");
		bean.setEmailId("kunal@123");
		bean.setPassword("pass123");
		
		model.add(bean);
	}
	public static void testUpdate() throws Exception{
		
		PaymentBean bean = new PaymentBean();
		
		PaymentModel model = new PaymentModel();
		

		bean.setId(4);
		bean.setPayementDate(new Date());
		bean.setDescription("PayemttosendaAshwin");
		bean.setAmmount(10000);
		bean.setPaymentMethod("Paytm");
		bean.setStatus("Payment done");
		bean.setPayer("Shivam");
		bean.setEmailId("shivam@123");
		bean.setPassword("shivam123");
		
		
		model.update(bean);
	
}
	public static void testFindByPk() throws Exception{
	
		
		PaymentModel model = new PaymentModel();
		
		
		PaymentBean bean = model.findByPk(2);
		
		
		System.out.print("\t"+ bean.getId());
		System.out.print("\t"+ bean.getPayementDate());
		System.out.print("\t"+ bean.getDescription());
		System.out.print("\t"+ bean.getAmmount());
		System.out.print("\t"+ bean.getPaymentMethod());
		System.out.print("\t"+ bean.getStatus());
		System.out.print("\t"+ bean.getPayer());
		System.out.print("\t"+ bean.getEmailId());
		System.out.print("\t"+ bean.getPassword());
		
		
	}
	
	public static void testSearch() throws Exception{
		
		PaymentModel model = new PaymentModel();
		
		PaymentBean bean = new PaymentBean();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//bean.setId(1);
		bean.setPayer("a");
		
		List list = model.search(bean, 1, 5);
		
		Iterator it = list.iterator();
		
		
		while(it.hasNext()) {
			
			bean = (PaymentBean) it.next();
			
			
			System.out.print("\t"+ bean.getId());
			System.out.print("\t"+ bean.getPayementDate());
			System.out.print("\t"+ bean.getDescription());
			System.out.print("\t"+ bean.getAmmount());
			System.out.print("\t"+ bean.getPaymentMethod());
			System.out.print("\t"+ bean.getStatus());
			System.out.print("\t"+ bean.getPayer());
			System.out.print("\t"+ bean.getEmailId());
			System.out.print("\t"+ bean.getPassword());
	}
		
}
	public static void testDelete() throws Exception{
		
		PaymentBean bean = new PaymentBean();
		
		PaymentModel model = new PaymentModel();
		
		model.delete(4);
	}
public static void testFindByLogin() throws Exception {
	
		
		PaymentModel model = new PaymentModel();
		
		
		PaymentBean bean = model.findByLogin("vijay@gmail.com");
		
		
		System.out.print("\t"+ bean.getId());
		System.out.print("\t"+ bean.getPayementDate());
		System.out.print("\t"+ bean.getDescription());
		System.out.print("\t"+ bean.getAmmount());
		System.out.print("\t"+ bean.getPaymentMethod());
		System.out.print("\t"+ bean.getStatus());
		System.out.print("\t"+ bean.getPayer());
		System.out.print("\t"+ bean.getEmailId());
		System.out.print("\t"+ bean.getPassword());
		
		
	}
}

