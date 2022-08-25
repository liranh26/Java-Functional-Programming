package functional_interface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
	static final int PHONE_NUMBER_LENGTH = 9;
	
	public static void main(String[] args) {
		
		System.out.println(isPhoneNumberValid("054848484")); //true
		System.out.println(isPhoneNumberValid("0562348")); //false
		
		System.out.println( isPhoneNumberValidPredicate.test("054848484") ); //true
		System.out.println( isPhoneNumberValidPredicate.test("0562348") ); //false
		
		// chaining predicates
		System.out.println( isPhoneNumberValidPredicate.and(isPhoneNumberContains3).test("054848484") ); //false
		System.out.println( isPhoneNumberValidPredicate.and(isPhoneNumberContains3).test("054838484") ); //true
		System.out.println( isPhoneNumberValidPredicate.or(isPhoneNumberContains3).test("054848484") ); //true
		
		//BiPredicate
		System.out.println(isPhoneNumValidAndContainNumber.test("054838484", "3"));
	}

	static Predicate<String> isPhoneNumberValidPredicate = num -> num.startsWith("05") && num.length() == PHONE_NUMBER_LENGTH;
	
	static Predicate<String> isPhoneNumberContains3 = num -> num.contains("3");
	
	static BiPredicate<String, String> isPhoneNumValidAndContainNumber = 
			(num, numToContain) -> num.startsWith("05") 
				&& num.length() == PHONE_NUMBER_LENGTH 
					&& num.contains(numToContain);
	
	static boolean isPhoneNumberValid(String number) {
		return number.startsWith("05") && number.length() == PHONE_NUMBER_LENGTH;
	}
}
