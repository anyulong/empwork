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
		
//		System.out.println("成绩为85的学生有"+checkStudent(students, s->s.getScore()==85).size()+"人。分别是：");
//		List<Student> score85 = checkStudent(students, s->s.getScore()==85);
//		System.out.println(score85);
//		System.out.println("成绩为90的学生有"+checkStudent(students, s->s.getScore()==90).size()+"人。分别是：");
//		List<Student> score90 = checkStudent(students, s->s.getScore()==90);
//		System.out.println(score90);
//		System.out.println("成绩为95的学生有"+checkStudent(students, s->s.getScore()==95).size()+"人。分别是：");
//		List<Student> score95 = checkStudent(students, s->s.getScore()==95);
//		System.out.println(score95);
//		System.out.println("成绩为100的学生有"+checkStudent(students, s->s.getScore()==100).size()+"人。分别是：");
//		List<Student> score100 = checkStudent(students, s->s.getScore()==100);
//		System.out.println(score100);
		
//		printStudent(85,students);
//		printStudent(90,students);
//		printStudent(95,students);
//		printStudent(100,students);
		
		for(int score = 85;score<=100;) {
			printStudent(score,students);
			score=score+5;
		}
		
	}
	public static <T> List<T> checkStudent(List<T> students, Predicate<T> pre){
		
		return students.stream().filter(pre).collect(Collectors.toList());
	}
	//打印学生
	public static List<Student> printStudent(int score,List<Student> students) {
		
		List<Student> scoreStudent = checkStudent(students, s->s.getScore()==85);
		System.out.println("成绩为"+score+"的学生有"+checkStudent(students, s->s.getScore()==score).size()+"人。分别是：");
		System.out.println(scoreStudent);
		return scoreStudent;
		
	}
}
