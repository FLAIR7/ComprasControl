package model.validation;

public class ProductValidation {
	
	
	public static Double isPriceValid(Double price) {
		return price == null ? 0.0 : price;
	}
	
	public static boolean isNameValid(String name) {
		if(name == null || name.trim().isEmpty()) {
			return false;
		}
		return true;
	}
	
	

}
