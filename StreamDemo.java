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

        //Chain Function
        Function<String, Integer> func = String::length;
        Function<Integer, Integer> func2 = x -> x * 2;
        Integer result = func.andThen(func2).apply("mkyong");   // 12
        System.out.println(result);

        //random numbers y generate()
        Stream.generate(new Random()::nextInt).limit(6).forEach(System.out::println);

        //iterate stream
        Stream.iterate(3, n -> n * 10).limit(6).forEach(System.out::println);

        //BiFunction<T, U, R> + Function<T, R>
        BiFunction<Integer, Integer, Double> func1 = Math::pow;
        Function<Double, String> fun2 = (input) -> "Result : " + input;
        String res = func1.andThen(fun2).apply(2, 4);
        System.out.println(res);

        //string in stream to builder
        StringBuilder sb = new StringBuilder();
        "in".chars().distinct().forEach(c -> sb.append((char) c));
        System.out.println(sb.toString());

        //list to map
        StreamDemo obj = new StreamDemo();
        List<String> list = Arrays.asList("node", "c++", "java", "javascript");
        Map<String, Integer> map = obj.convertListToMap(list, String::length);    // lambda
        Map<String, Integer> map2 = obj.convertListToMap(list, obj::getLength);  // method reference
        System.out.println(map);    // {node=4, c++=3, java=4, javascript=10}
        System.out.println(map2);

        //within stream
        Map<String, Integer> resultMap = list.stream().collect(
                Collectors.toMap(String::new, String::length));
        resultMap.forEach((k, v) -> System.out.println(k + " == " + v));

        //sort map based on key/value
        //.sorted(Map.Entry.comparingByKey())
        //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))

        //Join String by a delimiter.
        String joinStr = String.join("-", "2015", "10", "31");

        //Join a List by a delimiter.
        List<String> strList = Arrays.asList("java", "python", "nodejs", "ruby");
        String rjoin = String.join(", ", list);
        //java | python | nodejs | ruby
        String ljoin = strList.stream().collect(Collectors.joining(" | "));

        // String -> Date and Date -> String
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "7-Jun-2013";
        Date date = formatter.parse(dateInString);  // String -> Date
        System.out.println(date);
        System.out.println(formatter.format(date));   // Date -> String


// to  avoid duplicate value exception
        Map<Integer, String> duplicateOverMap = list.stream()
                .collect(Collectors.toMap(String::length, String::new, (oldValue, newValue) -> newValue));// we need LinkedHashMap to keep the order.
        duplicateOverMap.forEach((k, v) -> System.out.println(k + " == " + v));
      /*  Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));*/

// map<stirng,list<string>>
        List<String> locations = Arrays.asList("US:5423", "US:6321", "CA:1326", "AU:5631");
        Map<String, List<String>> locationMap = locations.stream()
                .map(s -> s.split(":"))
                //map(DELIMITER::split)
                .collect(Collectors.groupingBy(a -> a[0],
                        Collectors.mapping(a -> a[1], Collectors.toList())));
        locationMap.forEach((k, v) -> System.out.println(k + " ==== " + v));

        //convert a List of String to another String list, which was hashed with SHA256.            
        List<String> result1 = obj.listToList(list, obj::sha256);
        result1.forEach(System.out::println);

        //Atomic Integer
        AtomicInteger count = new AtomicInteger(0);

        //int array to list<iINteger> and viceversa
        int[] numbers = {32, 21, 3, 36, 11, 22, 12, 1};
        int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum); // reduce sum of int array
        List<Integer> numList = Arrays.stream(numbers).boxed().sorted().collect(Collectors.toList());
        int[] num = numList.stream().mapToInt(Integer::new).toArray();//i->i

        //concat string arrays via stream
        String[] s1 = new String[]{"a", "b", "c"};
        String[] s2 = new String[]{"d", "e", "f"};
        String[] s3 = new String[]{"g", "h", "i"};
        String[] threestr = Stream.of(s1, s2, s3).flatMap(Stream::of).toArray(String[]::new);
        System.out.println(Arrays.toString(threestr));//arraystoString

        // Convert String Array to List
        List<String> arrlist = Arrays.asList(s1);
        List<String> arrlis = Arrays.stream(s1).collect(Collectors.toList());

        // Convert to stream and test it
        boolean re = Arrays.stream(s1).anyMatch("a"::equals);

        //concat int arrays via stream
        int[] int1 = new int[]{1, 2, 3};
        int[] int2 = new int[]{4, 5, 6};
        int[] resInt = IntStream.concat(Arrays.stream(int1), Arrays.stream(int2)).toArray();

        //IntStream
        IntStream.range(1, 3);//1,2
        IntStream.rangeClosed(1, 3);//1,2,3
        IntStream.range(1, 5).max().getAsInt();
        IntStream.range(1, 5).min().getAsInt();

      /*  In Java 8, we can use the flatMap to convert the above 2 levels Stream into one Stream level
      or a 2d array into a 1d array.*/
      // 2 levels Stream examples
    /*  Stream<String[]>
Stream<Stream<String>>
 String[][]*/
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        String[] rstr = Stream.of(array)  // Stream<String[]>
                .flatMap(Stream::of)        // Stream<String>
                .toArray(String[]::new);

        //flatmap example
        Stream<String> words =  Stream.of("hello","hell","jai").flatMap(line -> Stream.of(line.split(" +")));
        System.out.println( "i am"+  words.collect(Collectors.joining(" , ")));
     //   long noOfWords = words.count();        // count the number of words.


        //Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = Stream.of(int2).flatMapToInt(x -> Arrays.stream(x));
        intStream.forEach(x -> System.out.println(x));

        //last element of stream using reduce
        String rlt = list.stream().reduce((first, second) -> second).orElse("no last element");
        System.out.println(rlt);

        //last element of stream using skip
        String rtl = list.stream().skip(list.size() - 1).findFirst().orElse("no last element");
        System.out.println(rtl);

    }

    private <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func) {
        Map<T, R> result = new HashMap<>();
        for (T t : list) {
            result.put(t, func.apply(t));
        }
        return result;
    }

    private Integer getLength(String str) {
        return str.length();
    }

    private <T, R> List<R> listToList(List<T> list, Function<T, R> func) {
        List<R> result = new ArrayList<>();
        for (T t : list) result.add(func.apply(t));
        return result;
    }

    // sha256 a string import org.apache.commons.codec.digest.DigestUtils;   DigestUtils.sha256Hex(str);
    private String sha256(String str) {
        return str + str;
    }
}