package ch.fhnw.richards.topic04_ClassDesign.staticDynamicExample;

public class C extends B {
	  void f() { System.out.println("C::f"); g(); }
	  void g() { System.out.println("C::g"); super.f(); }
}
