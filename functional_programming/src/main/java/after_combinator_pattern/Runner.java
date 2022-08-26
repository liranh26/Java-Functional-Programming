package after_combinator_pattern;

import static after_combinator_pattern.CustomerRegisterationValidator.isAdult;
import static after_combinator_pattern.CustomerRegisterationValidator.isEmailValid;
import static after_combinator_pattern.CustomerRegisterationValidator.isPhoneNumberValid;

import java.time.LocalDate;

public class Runner {

	public static void main(String[] args) {
		Customer customer = new Customer("Liran", "Liranh6@gmail.com", "0545123123", LocalDate.of(1990, 1, 1));
		
		ValidationResult result = isEmailValid().and(isAdult()).and(isPhoneNumberValid()).apply(customer); 
		
		if(result != ValidationResult.SUCCESS)
			throw new IllegalStateException(result.name());

	}

}
