package com.ojas;

interface IO {
	default void show() {
		System.out.println("IO");
	}
}

interface II {
	default void show() {
		System.out.println("II");
	}
}

interface xy {
	public void abc();

	public boolean equals(Object o);

	public String toString();
}

class D {
	public void show() {
		System.out.println("CC");
	}
}

class E {
	public void show() {
		System.out.println("E");
	}
}

public class JavaPro extends D implements II, IO {
	public static void main(String[] args) {
		Alien al = new Alien();
		JavaPro jj = new JavaPro();
	}

}
