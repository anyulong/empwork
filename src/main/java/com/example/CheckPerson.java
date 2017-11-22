package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CheckPerson {

	public static void main(String[] args) {
		
		
		//测试findMatchPerson
		Person people = new Person();
		people.setId(10);
		people.setSalary(9999.0);
		System.out.println(findMatchPerson(people, p -> p.getId() == 10));
		System.out.println(findMatchPerson(people, p -> p.getSalary() > 10000.0));
		
		//测试findMatchPersons
		List<Person> persons = new ArrayList<Person>();
		for(int i=0;i<100;i++) {
			
			persons.add(new Person());
			persons.get(i).setId(i);
			
		}
		//匹配条件id=10
		System.out.println(findMatchPersons(persons, p -> p.getId() == 10));
		
		//Stream实现 findMatchPerson
		System.out.println(findMatchPersonsByStream(persons, p -> p.getId() == 20));
		

	}
	
	//查看是否匹配
	public static boolean findMatchPerson(Person p, Predicate<Person> pre) {
		
		return pre.test(p);	
	}
	
	//把匹配的person打印出来并返回在List中
	public static <T> List<T> findMatchPersons(List<T> persons , Predicate<T> pre) {
		
		List<T> matchPersons = new ArrayList<T>();
		
		 for (T person: persons) {
			 if(pre.test(person)) {
				 matchPersons.add(person);
			 }
			 
		    }
		
		 return matchPersons;	
	}
	
	//使用Stream完成findMatchPerson
	public static <T> List<T> findMatchPersonsByStream(List<T> persons , Predicate<T> pre) {
		
		 return persons.stream().filter(pre).collect(Collectors.toList());
	}
	
	
}
