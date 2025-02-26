package com.java.streams.printHashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Functional programming: using Predicate

public class IterateMapList {

	static Predicate<User> p = e -> e.getAge() > 10;
	
	static List<User> users = Arrays.asList(
				new User(20, "Alan",Sex.MALE),
				new User(18, "Helen",Sex.FEMALE),
				new User(45, "Joy",Sex.FEMALE),
				new User(45, "George",Sex.MALE),
				new User(25, "Jennifer",Sex.FEMALE),
				new User(11, "LittleAngle",Sex.FEMALE),
				new User(15, "Sam",Sex.MALE)
				);

	
	public static void main(String[] args) {
	
		List<User> people = filterUsers(users, p);		
		
		System.out.println("================================");
		System.out.println(filterUsers(users, e -> e.getAge() >11));
		
			
		System.out.println("x================================");

		Map<Integer, List<User>> map = people.stream()
			.filter(e -> e.getAge() > 18)
			.collect( Collectors.groupingBy(User::getAge, Collectors.toList()) );
		
		
		
		map.forEach( (Integer k, List<User> v) -> {
		    System.out.print(k + " = ");
		    v.forEach(w -> System.out.print(w.getName() + ","));
		    System.out.println();
			
		});
		
		
//		parameterMap.forEach( (String k, String[] v) -> {
//	    System.out.print(k + " = ");
//	    Stream<String> vs = Arrays.stream(v);
//	    vs.forEach(w -> System.out.print(w.getName() + ","));
//	    System.out.println();
//		
//	});
//
//	OR:
//
//		parameterMap.forEach( (String k, String[] v) -> {
//	    System.out.print(k + " = ");
//	    Stream<String> vs = Stream.of(v);
//	    vs.forEach(w -> System.out.print(w + ","));
//	    System.out.println();
//		
//	});

		
		
	}
	
	
	
	public static List<User> filterUsers(List<User> allUsers, Predicate<User> predicate) {
		List<User> result = new ArrayList<>();
		for (User user : allUsers) {
			if (predicate.test(user)) {
				result.add(user);
			}
		}
		return result;
	}	
	
	
}
