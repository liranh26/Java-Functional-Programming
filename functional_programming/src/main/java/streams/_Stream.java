package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import streams.model.Gender;
import streams.model.Person;

public class _Stream {
	public static void main(String[] args) {

		List<Person> people = createPeople();

		people.stream()
				.filter(p -> p.gender() == Gender.MALE)
				.filter(p -> p.age() > 18)
				.map(Person::name)
				.forEach(System.out::println);

		people.stream()
				.filter(p -> p.gender() == Gender.MALE)
				.filter(p -> p.age() > 18)
				.map(p -> new Person(p.name().toUpperCase(), p.gender(), p.age()))
				.forEach(System.out::println);
		
		// total ages of all people
		System.out.println( people.stream()
									.map(Person::age)
//									.reduce(0, (carry, age) -> carry + age) 
									.reduce(0, Integer::sum)
								);

		//min max: oldest , youngest man
		System.out.println( people.stream()
//									.max((p1, p2) -> (p1.age() > p2.age() ? 1 : -1)) 
									.min((p1, p2) -> (p1.age() > p2.age() ? 1 : -1)) 
								);
		
		//count: how many youth there is 
		System.out.println( people.stream()
									.filter(p -> p.age() < 18)
									.count()
								);
		
		//benefits of the stream collection process -> thread safe, is managed behind the scenes
		List<String> names = people.stream()
									.filter(p -> p.gender() == Gender.MALE)
									.map(p -> p.name())
									.toList();
		System.out.println(names); //double name snir
		
		Set<String> names2 = people.stream()
									.filter(p -> p.gender() == Gender.MALE)
									.map(Person::name)
									.collect(Collectors.toSet());
		System.out.println(names2);
		
		
		//deriving Map from stream
		Map<String, Person> map = people.stream()
										.collect(Collectors.toMap(
																p -> p.name() + ":" + p.age(), 
																p -> p));
		System.out.println(map);

		
		//groupBy 
		Map<String, List<Person>> namesMap = people.stream()
				.collect(Collectors.groupingBy(Person::name));
		System.out.println(namesMap);
		


	}

	public static List<Person> createPeople() {
		return Arrays.asList(
				new Person("Liran", Gender.MALE, 33), 
				new Person("Sapir", Gender.FEMALE, 30),
				new Person("Sapir", Gender.FEMALE, 26), 
				new Person("Snir", Gender.MALE, 29),
				new Person("Snir", Gender.MALE, 37), 
				new Person("Rotem", Gender.FEMALE, 27),
				new Person("Rotem", Gender.FEMALE, 54), 
				new Person("Hanenia", Gender.MALE, 111),
				new Person("Lavi", Gender.MALE, 12));
	}

}
