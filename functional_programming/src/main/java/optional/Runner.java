package optional;

import java.util.Optional;

public class Runner {

	public static void main(String[] args) {

		Object value = Optional.ofNullable("Hello").orElseGet(() -> "Default value");
		Object value2 = Optional.ofNullable("Hello").orElseThrow(() -> new IllegalStateException("Exception"));

		System.out.println(value);
		System.out.println(value2);

		Optional.ofNullable("liran@gmail.com").ifPresent(l -> {
			// logic
			System.out.println("Send email to: " + l);
		});
		
		Optional.ofNullable(null)
			.ifPresentOrElse(
					l -> System.out.println("Send email to: " + l)
					, () -> System.out.println("Could not send email!")
			);
		
		
	}

}
