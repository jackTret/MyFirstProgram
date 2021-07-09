package ru.stqa.new_project.sandbox;

public class MyFirstProgram {

 public static void main(String[] args) {
	hello("I'm robot");
	hello("I'm your friend");
	hello("I'm crazy human");

	double l = 5;
	 System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

	 double a = 4;
	 double b = 6;
	 System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area(a, b));
 }
 public static void hello(String somebody) {
	 System.out.println("Hello, New_world! " + somebody + "!");
 }

 public static double area(double l) {
 	return l * l;
 }

 public static double area(double a, double b) {
 	return a * b;
 }
}