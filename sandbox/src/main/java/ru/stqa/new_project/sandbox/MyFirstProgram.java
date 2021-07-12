package ru.stqa.new_project.sandbox;

public class MyFirstProgram {

 public static void main(String[] args) {
	hello("I'm robot");
	hello("I'm your friend");
	hello("I'm crazy human");


	Square s =  new Square(5);
	System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

	 Rectangle r = new Rectangle(4,6);
	 System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
 }
 public static void hello(String somebody) {
	 System.out.println("Hello, New_world! " + somebody + "!");
 }

}