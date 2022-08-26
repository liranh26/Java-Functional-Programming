package before_combinator_pattern;

import java.time.LocalDate;

public class Runner {

	public static void main(String[] args) {
		Customer customer = new Customer("Liran", "Liranh6@gmail.com", "0545123123", LocalDate.of(1990, 1, 1));
		
		//using combinator pattern
		System.out.println(new CustomerValidatorService().isValid(customer));
		
	}

}
