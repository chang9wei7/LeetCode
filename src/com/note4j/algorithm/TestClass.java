package com.note4j.algorithm;

import java.util.Map;

public class TestClass {
	private String name;
	private int age;

	public TestClass(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) {
		TestClass t1 = new TestClass("changwei", 212);
		TestClass t2 = t1;
		System.out.println(t1);
		t2.name = "fad";
		System.out.println(t2);
	}

//	@Override
//	public String toString() {
//		return "TestClass [name=" + name + ", age=" + age + "]";
//	}
}
