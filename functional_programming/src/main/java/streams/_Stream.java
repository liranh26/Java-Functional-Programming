package streams;

import java.util.List;
import java.util.stream.Collectors;


public class _Stream {
	public static void main(String[] args) {

		List<Person> people = List.of(
				new Person("Liran", Gender.MALE), new Person("Sapir", Gender.FEMALE),
				new Person("Snir", Gender.MALE), new Person("Rotem", Gender.FEMALE));
		
		people.stream()
			.map(person -> person.gender)
			.collect(Collectors.toSet()).forEach(System.out::println);
		
		people.stream().map(person -> person.name)
			.map(name -> name.length())
			.forEach(System.out::println);
		
		boolean containsOnlyFemale = people.stream().allMatch(person -> Gender.FEMALE.equals(person.gender));
		System.out.println(containsOnlyFemale); //false
		
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
