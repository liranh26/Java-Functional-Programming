package before_combinator_pattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

	private boolean isEmailValid(String email) {
		return email.contains("@");
	}
	
	private boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("05");
	}
	
	private boolean isAdult(LocalDate dob) {
		return Period.between(dob, LocalDate.now()).getYears() > 16;
	}
	
	public boolean isValid(Customer customer) {
		return isAdult(customer.getBirthdate()) 
				&& isEmailValid(customer.getEmail()) 
					&& isPhoneNumberValid(customer.getPhoneNumber());
	}
}
