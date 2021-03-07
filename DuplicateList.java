package jai.demo.java8;

public class DuplicateList {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String in="goodmorning";
		
		in.chars().distinct().forEach(c -> sb.append((char) c));
		System.out.println(sb.toString());
	}

}
