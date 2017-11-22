package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentManager {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		for(int i=0;i<1000;i++) {
			
			students.add(new Student());
			students.get(i).setId(i);
			students.get(i).setName("张三"+i);
			students.get(i).setScore((int)(Math.round(Math.random()*3)*5+85));
		}
		
		//列出不同成绩学生list
		System.out.println(checkStudent(students, s->s.getScore()==85));
		System.out.println(checkStudent(students, s->s.getScore()==90));
		System.out.println(checkStudent(students, s->s.getScore()==95));
		System.out.println(checkStudent(students, s->s.getScore()==100));
		
	}
	public static <T> List<T> checkStudent(List<T> students, Predicate<T> pre){
		
		return students.stream().filter(pre).collect(Collectors.toList());
	}
}
