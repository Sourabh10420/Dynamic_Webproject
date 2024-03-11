package in.co.rays.Test;

import java.util.List;
import java.util.Iterator;

import in.co.rays.Bean.MarksheetBean;
import in.co.rays.Model.MarksheetModel;

public class TestMarksheet {


	public static void main(String[] args) throws Exception {

		// testAdd();
		// testUpdate();
		// testDelete();
	//	testSearchBySimple();
		// testFindByPk();
		// testSearchOneByOne();
	testNextPk();

		//testSearchByDynamic();
	}

	private static void testNextPk() throws Exception {
		MarksheetModel model = new MarksheetModel();

		int pk = model.nextPk();

		System.out.println("pk" + pk);
	}

	public static void testAdd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		
		bean.setRollNo(107);
		bean.setName("Kamal");
		bean.setPhysics(66);
		bean.setChemistry(76);
		bean.setMaths(93);

		MarksheetModel model = new MarksheetModel();

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(7);
		bean.setRollNo(104);
		bean.setName("Soham");
		bean.setPhysics(75);
		bean.setChemistry(78);
		bean.setMaths(91);
		MarksheetModel model = new MarksheetModel();

		model.update(bean);
	}

	public static void testDelete() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();

		model.delete(7);
	}

	public static void testSearchBySimple() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();

		model.searchBySimple(bean);
	}

	public static void testSearchOneByOne() throws Exception {

		MarksheetModel model = new MarksheetModel();

		List list = model.searchByOneByOne();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			MarksheetBean bean = (MarksheetBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		}
	}

	public static void testSearchByDynamic() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		 bean.setId(4);
		// bean.setRollNo(101);
		bean.setName("s");
		// bean.setPhysics(99);
		// bean.setChemistry(87);
		// bean.setMaths(98);

		MarksheetModel model = new MarksheetModel();

		List list = model.searchByDynamic(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		}

	}

	public static void testFindByPk() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findByPK(3);

		System.out.println(bean.getId());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getName());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());

	}

}


