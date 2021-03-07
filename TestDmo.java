package jai.demo.java8;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestDmo {

	public static void main(String[] args) {
		String str="this is level 71";
	
		AtomicInteger count=new AtomicInteger(0);
		 BiFunction<String, String, Integer> func = (x1, x2) -> x1.equalsIgnoreCase(x2)?count.getAndIncrement():0;
        List<String> lis = Stream.of(str.split(" "))
        	      .map (String::new)
        	      .collect(Collectors.toList());
     lis.forEach(st->func.apply(st, new StringBuilder(st).reverse().toString()));
       System.out.println("size"+count.intValue());
	}
}