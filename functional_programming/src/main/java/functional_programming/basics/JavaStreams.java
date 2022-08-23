package functional_programming.basics;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) {

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
	}
}
