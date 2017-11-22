package com.example;

public class Fibon {

	public static void main(String[] args) {
		
		System.out.println(fibon(10));
	}
	//斐波那契数列实现
	public static int fibon(int num) {
		
		if(num==1) {
			return 1;
		}
		if(num==2) {
			return 2;
		}
		return fibon(num-1)+fibon(num-2);
	}
}
