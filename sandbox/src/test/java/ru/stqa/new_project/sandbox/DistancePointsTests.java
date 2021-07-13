package ru.stqa.new_project.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.stqa.new_project.sandbox.Distance.distance;

public class DistancePointsTests {

  @Test
  public void testViewDistance() {
    Point p1 = new Point(4,9);
    Point p2 = new Point(3,5);

    double distance = p1.distance(p2);
    System.out.println("Расстояние между точками " + p1 + " и " + p2 + " = " + p1.distance(p2));
  }
  @Test
  public void testViewDistance2() {
    Point p1 = new Point(4,9);
    Point p2 = new Point(3,5);

    double distance = p1.distance(p2);
    System.out.println("Расстояние между точками Point {x=4.0, y=9.0} и Point {x=3.0, y=5.0} = 4.123105625617661");
  }
  @Test
  public void testResultDistance1() {
    Point p1 = new Point(4,9);
    Point p2 = new Point(3,5);

    double distance = p1.distance(p2);
    Assert.assertEquals(distance,4.123105625617661);
    Assert.assertNotNull(distance);
  }
  @Test
  public void testResultDistance3() {
    Point p1 = new Point(7,1);
    Point p2 = new Point(1,7);

    double distance = p1.distance(p2);
    Assert.assertEquals(distance,8.48528137423857);
    Assert.assertNotNull(distance);
  }
  @Test
  public void testMainDistance() {
    String[] args = new String[] {};
    Distance.main(args);
  }
  @Test
  public void testResultDistance4() {
    Point p1 = new Point(1,1);
    Point p2 = new Point(1,1);

    double distance = p1.distance(p2);
    Assert.assertEquals(distance,0.0);
  }
}
