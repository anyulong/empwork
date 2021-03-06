package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class HelloLambda {
  public static void main(String[] args) {
    String[] strs = {"world", "hello", "what", "hi","that","abou","blac"};
    Arrays.sort(strs, new LengthComparator());
    for (String str : strs) {
      System.out.println(str);
    }

//    Comparator<String> c1  = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
//    Comparator<String> c2  = (String s1, String s2) -> s1.compareTo(s2);
//    Comparator<String> c3  = (s1, s2) -> s2.compareTo(s1);
//    Comparator<String> c4 = String::compareTo;

    Arrays.sort(strs, (s1, s2) -> s2.compareTo(s1));
    Arrays.sort(strs, String::compareToIgnoreCase);
//    Arrays.sort(strs, c3);
    for (String str : strs) {
      System.out.println(str);
    }

    List<Integer> lst = Arrays.asList(new Integer[]{3,6,4});
    lst.forEach(System.out::println);
    //a形参 "Daniel"为实参，"Daniel"调用字符串的方法,该方法作为Funtion中apply()的实现
    System.out.println(transform("Daniel", a->a.concat("abc")));
    
    
    
    
    
  }
  //Funtion中第一个String是参数，后者为返回值
  public static String transform(String s, Function<String, String> f) {
    return f.apply(s);
  }

  public static <T> int mapSum(List<T> entries, Function<T, Integer> f) {
    int sum = 0;
    for (T entry: entries) {
      sum += f.apply(entry);
    }
    return sum;
  }
}

// https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
