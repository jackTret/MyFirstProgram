package ru.stqa.new_project.sandbox;

public class Point {

  public double x;
  public double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }


  public double distance(Point p) {
    return Math.sqrt((x - p.x) * (x - p.x) + (y-p.y) *(y-p.y));
  }
  //public static double distance2(Point p1, Point p2) {
  //  return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y-p2.y) *(p1.y-p2.y));
  //}

  @Override
  public String toString() {
    return "Point {" +
            "x=" + x +
            ", y=" + y +
            '}';
  }
}
