package in.co.rays.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundleApp_hi {

	public static void main(String[] args) {

		// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");
		// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app_hi");

		// ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new
		// Locale("hi"));

		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("jp"));

		System.out.println(rb.getString("greeting"));

	}

}
