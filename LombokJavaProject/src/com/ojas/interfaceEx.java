package com.ojas;

interface m1 extends m2{
	void a();
	default void log(String str) {
		System.out.println("Loging 1 : "+str);
	}
}

interface m2{
	void b();
	
}
public class interfaceEx implements m1,m2{
public static void main(String[] args) {
	interfaceEx e = new interfaceEx();
	e.log("pallavi");
}
	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}
	

}
