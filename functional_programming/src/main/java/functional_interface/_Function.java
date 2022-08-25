package functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

	public static void main(String[] args) {
		
		//Function takes 1 argument and produces 1 result
		int increment = incermentByOne(0);
		System.out.println(increment);

		int increment2 = incrementByOneFunction.apply(0);
		System.out.println(increment2);

		int multiply = multiplyBy10.apply(increment2);
		System.out.println(multiply);

		/* chaining 2 lambda functions */
		Function<Integer, Integer> addBy1AndMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10);
		System.out.println(addBy1AndMultiplyBy10.apply(0));

		// BiFunction takes 2 argument and produces 1 result
		System.out.println( incermentByOneAndMultiplyBiFunction.apply(4,100) );
		
	}

	static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

	static Function<Integer, Integer> multiplyBy10 = num -> num * 10;

	static int incermentByOne(int number) {
		return number + 1;
	}

	static BiFunction<Integer, Integer, Integer> incermentByOneAndMultiplyBiFunction = 
			(num, multiply) -> (num + 1) * multiply;

	static int incermentByOneAndMultiply(int number, int multiply) {
		return (number + 1) * multiply;
	}

}
