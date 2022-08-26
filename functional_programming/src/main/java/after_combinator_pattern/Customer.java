package after_combinator_pattern;

import java.time.LocalDate;

public class Customer {

	private final String name;
	private final String email;
	private final String phoneNumber;
	private final LocalDate birthdate;
	
	public Customer(String name, String email, String phoneNumber, LocalDate birthdate) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	
	
}
