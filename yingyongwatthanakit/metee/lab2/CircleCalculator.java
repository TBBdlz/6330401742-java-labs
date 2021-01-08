/*
  This CircleCalculator program 1 argument: <radius of the circle>
  The program calculate the area and circumference of the circle.
  And round them to 2 decimal places.
  Next, program print output to the screen.
  output format is:
  An area of a circle with radius of <radius> is <roundedArea>
  A circumference is <roundedCircumference>
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 8 January 2021
*/
package yingyongwatthanakit.metee.lab2;

import java.lang.Math;

public class CircleCalculator {
    public static void main(String[] args) {
        if (args.length == 1 && Double.parseDouble(args[0]) > 0) {
            double radius = Double.parseDouble(args[0]);
            double area = Math.PI * Math.pow(radius, 2);
            double circumference = 2 * Math.PI * radius;
            // round up area and circumference to 2 decimal places
            String roundedArea = String.format("%.2f", area);
            String roundedCircumference = String.format("%.2f", circumference);
            System.out.println("An area of a circle with radius of " + radius + " is " + roundedArea);
            System.out.println("A circumference is " + roundedCircumference);
        } else {
            System.err.println("CircleCalculator <radius of a circle>");
        }
    }
}
