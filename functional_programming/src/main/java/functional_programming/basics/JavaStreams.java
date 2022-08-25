package functional_programming.basics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		// printing 1-10 with int stream
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();

		// printing 5-10 by skip
		IntStream.range(1, 10).skip(5).forEach(System.out::print);
		System.out.println();

		// summing 1-5
		System.out.println(IntStream.range(1, 10).sum());

		// Stream of
		Stream.of("Snir", "Sapir", "Liran").sorted() // uses the basic compareTo , optional to pass a custom comparator
				.findFirst().ifPresent(System.out::print);
		System.out.println();

		// filtering and then sorting
		String[] names = { "Al", "Ankit", "Kushal", "Brent", "Sarika", "Amanda", "Hans", "Shivika", "Sarah" };
		Arrays.stream(names).filter(n -> n.startsWith("A")).sorted().forEach(System.out::println); // Al, Amanda, Ankit

		// map
		Arrays.stream(new int[] { 1, 2, 4, 6, 8, 10 }).map(x -> x * x).average().ifPresent(System.out::println);

		// Stream a list
		List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika", "Amanda", "Hans", "Shivika",
				"Sarah");
		people.stream().map(String::toLowerCase).filter(s -> s.startsWith("s")).forEach(System.out::println);

		// Stream from a file, filter and print
		Stream<String> bands = Files.lines(Path.of("myFiles/bands.txt"));
		bands.filter(b -> b.length() > 12).sorted().forEach(System.out::println);
		bands.close(); // closing to avoid memory leaks

		// Stream rows from text file and save to List
		bands = Files.lines(Path.of("myFiles/bands.txt"));
		bands.filter(b -> b.contains("Jack")).collect(Collectors.toList()).forEach(System.out::println);
		bands.close();

		// Stream rows from CSV file, parse data from rows
		Stream<String> rows = Files.lines(Path.of("myFiles/data.txt"));
		long legalRows = rows.map(l -> l.split(",")).filter(l -> l.length == 3).count();
		System.out.println("Legal rows: " + legalRows);
		rows.close();

		// Stream rows from CSV file, parse data from rows
		rows = Files.lines(Path.of("myFiles/data.txt"));
		rows.map(l -> l.split(","))
			.filter(l -> l.length == 3).filter(l -> Integer.parseInt(l[1]) > 15)
			.forEach(l -> System.out.println(l[0] + " : " + l[1] + " , " + l[2]));
		rows.close();

		
		// Stream rows from CSV file, store fields in HashMap
		rows = Files.lines(Path.of("myFiles/data.txt"));
		Map<String, Integer> map = new HashMap<>();
		
		map = rows.map(l -> l.split(","))
				.filter(l -> l.length == 3).filter(l -> Integer.parseInt(l[1]) > 15)
				.collect(Collectors.toMap(l -> l[0], l -> Integer.parseInt(l[1])));
				
		rows.close();
		
		for (String key : map.keySet()) 
			System.out.println(key);
		
		
		// Reduction - summary statistics
				IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
					.summaryStatistics();
				System.out.println(summary); //{count=7, sum=203, min=2, average=29.000000, max=88}
		
	}
}
