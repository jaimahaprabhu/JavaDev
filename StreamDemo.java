package jai.demo.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//https://www.javaprogramto.com/2020/07/java-8-convert-list-to-map-handling-duplicate-keys.html
public class StreamDemo {

    public static void main(String[] args) throws ParseException {
        
       List<String> list = Arrays.asList("node", "c++", "java", "javascript");

        //Chain Function
        Function<String, Integer> func = String::length;
        Function<Integer, Integer> func2 = x -> x * 2;
        Integer result = func.andThen(func2).apply("mkyong");   // 12
        System.out.println(result);

         //char stream to string
        StringBuilder sb = new StringBuilder();
        "in".chars().distinct().forEach(c -> sb.append((char) c));
        System.out.println(sb.toString());

         //list<string> to map using collectors
        Map<String, Integer> resultMap = list.stream().collect(
                Collectors.toMap(String::new, String::length));
        resultMap.forEach((k, v) -> System.out.println(k + " == " + v));
        
         //Join String by a delimiter.
        String joinStr = String.join("-", "2015", "10", "31");
        //join list as string with delimiter
        String ljoin = strList.stream().collect(Collectors.joining(" | "));
        
        //Get the unique surnames in uppercase of the first 15 book authors that are 50 years old or over. library is List<Library>
        library.stream().map(book -> book.getAuthor()) 
               .filter(author -> author.getAge() >= 50) .distinct().limit(15)
               .map(Author::getSurname) .map(String::toUpperCase) .collect(toList());
        
        //Compute the sum of ages of all female authors younger than 25.
        library.stream().map(Book::getAuthor)
        .filter(a -> a.getGender() == Gender.FEMALE) .map(Author::getAge)
        .filter(age -> age < 25)
        .reduce(0, Integer::sum):
        
         //int array to list<Integer> and viceversa
        int[] numbers = {32, 21, 3, 36, 11, 22, 12, 1};
        int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum); // sum of int array with reduce
        List<Integer> numList = Arrays.stream(numbers).boxed().sorted().collect(Collectors.toList());//int array to list
        int[] num = numList.stream().mapToInt(Integer::new).toArray();//list to int array

        // Convert String Array to List
        List<String> arrlist = Arrays.asList(s1) || Arrays.stream(s1).collect(Collectors.toList());
        
        // map<stirng,list<string>>
        List<String> locations = Arrays.asList("US:5423", "US:6321", "CA:1326", "AU:5631");
        Map<String, List<String>> locationMap = locations.stream()
                .map(s -> s.split(":"))//map(DELIMITER::split)
                .collect(Collectors.groupingBy(a -> a[0],
                        Collectors.mapping(a -> a[1], Collectors.toList())));
        locationMap.forEach((k, v) -> System.out.println(k + " ==== " + v));
        //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        
        //iterate stream
        Stream.iterate(3, n -> n * 10).limit(6).forEach(System.out::println);

       //BiFunction<T, U, R> + Function<T, R>
        BiFunction<Integer, Integer, Double> func1 = Math::pow;
        Function<Double, String> fun2 = (input) -> "Result : " + input;
        String res = func1.andThen(fun2).apply(2, 4);
        System.out.println(res);
        
