package com.note4j.algorithm;

import java.util.StringTokenizer;

class Person {
	int a = 9;
	public static int b = 10;

	public int getA() {
		return a;
	}

	public String print() {
		return "fa";
	}

	public void setA(int a) {
		this.a = a;
	}
}

class Student extends Person {
	int a = 5;
	public static int b = 7;

	public Student() {
		// a = 111;
	}

	public int getA() {
		return a;
	}

	public String print() {
		return "so";
	}

	public void setA(int a) {
		this.a = a;
	}
}

class A {
	public String show(D obj) {
		return "A and D";
	}

	public String show(A obj) {
		return "A and A";
	}
}

class B extends A {
	public String show(B obj) {
		return "B and B";
	}

	public String show(A obj) {
		return "B and A";
	}
}

class C extends B {
}

class D extends B {
}

public class Test {
	public static void main(String[] args) {
		// StringTokenizer st = new StringTokenizer("This is a string demo.");
		// while (st.hasMoreElements()) {
		// System.out.println(st.nextElement());
		// }
		// st = new StringTokenizer("This is a string demo.");
		// while (st.hasMoreTokens()) {
		// System.out.println(st.nextElement());
		// }
		// Person p = new Student();
		// System.out.println(p.getA());
		// System.out.println(p.print());
		// Student s = (Student) p;
		// System.out.println(s.b);
		A a1 = new A();
		A a2 = new B();
		B b = new B();
		C c = new C();
		D d = new D();
		System.out.println(a1.show(b));
		System.out.println(a1.show(c));
		System.out.println(a1.show(d));
		
		System.out.println(a2.show(b));
		System.out.println(a2.show(c));
		System.out.println(a2.show(d));
		
		System.out.println(b.show(b));
		System.out.println(b.show(c));
		System.out.println(b.show(d));
		
		Person p = new Student();
		System.out.print(((Person)p).print());
	}
}