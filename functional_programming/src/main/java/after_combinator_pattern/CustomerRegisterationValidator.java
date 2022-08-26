package after_combinator_pattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegisterationValidator extends Function<Customer, ValidationResult> {

	static CustomerRegisterationValidator isPhoneNumberValid() {
		return customer -> customer.getPhoneNumber().startsWith("05") 
				? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
	}
	
	static CustomerRegisterationValidator isEmailValid() {
		return customer -> customer.getEmail().contains("@") 
				? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
	}
	
	static CustomerRegisterationValidator isAdult() {
		return customer -> Period.between(customer.getBirthdate(), LocalDate.now()).getYears() > 16 
				? ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
	}
	
	default CustomerRegisterationValidator and (CustomerRegisterationValidator other) {
		return customer -> {
			ValidationResult result = this.apply(customer);
			return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
		};
	}
	
}


