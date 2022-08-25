package functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

	public static void main(String[] args) {
		
		Customer liran = new Customer("Liran", "05453213213");
		greetCustomer(liran);
		
		// Consumer is like a void function, it takes an argument and return nothing.
		greetCustomerConsumer.accept(liran);
		
		// BiConsumer 
		greetCustomerBiConsumer.accept(liran, false);
	}

	static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println("Hello customer"
			+ customer.customerName + ", thanks for registering phone number " + customer.customerPhoneNumber);

	static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNum)-> System.out.println("Hello customer"
			+ customer.customerName + ", thanks for registering phone number " + (showPhoneNum ? customer.customerPhoneNumber : "***"));
	
	static void greetCustomer(Customer customer) {
		System.out.println("Hello customer" + customer.customerName + ", thanks for registering phone number "
				+ customer.customerPhoneNumber);
	}

	static class Customer {
		private final String customerName;
		private final String customerPhoneNumber;

		Customer(String customerName, String customerPhoneNumber) {
			this.customerName = customerName;
			this.customerPhoneNumber = customerPhoneNumber;
		}

	}
}
