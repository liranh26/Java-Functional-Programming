package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Runner {

	public static void main(String[] args) {
		List<Person> people = List.of(
				new Person("Liran", Gender.MALE), new Person("Sapir", Gender.FEMALE),
				new Person("Snir", Gender.MALE), new Person("Rotem", Gender.FEMALE));

		// Imperative approach
		List<Person> females = new ArrayList<>();
		for (Person person : people)
			if (person.gender.equals(Gender.FEMALE))
				females.add(person);

		for (Person female : females)
			System.out.println(female);

		// Declarative approach
		Predicate<? super Person> predicatePerson = p -> p.gender.equals(Gender.FEMALE);
		people.stream()
				.filter(predicatePerson)
				.forEach(System.out::println);
		
	}

	static class Person {
		private final String name;
		private final Gender gender;

		Person(String name, Gender gender) {
			this.gender = gender;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}

	}

	static enum Gender {
		MALE, FEMALE;
		
	}
}
