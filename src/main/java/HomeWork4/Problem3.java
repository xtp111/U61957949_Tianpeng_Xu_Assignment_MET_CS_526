package HomeWork4;

import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Problem3 {

    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();

        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\aw\\Downloads\\rightangles_3.txt"));
        int n = Integer.parseInt(reader.readLine().trim());
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().trim().split("\\s+");
            double x = Double.parseDouble(parts[0]);
            double y = Double.parseDouble(parts[1]);
            points[i] = new Point(x, y);
        }
        reader.close();

        long readEndTime = System.nanoTime();
        System.out.println("Read file time: " + (readEndTime - startTime) / 1_000_000.0 + " ms");

        long calcStartTime = System.nanoTime();
        long count = countRightTriangles(points);
        long calcEndTime = System.nanoTime();

        System.out.println("Calculation time: " + (calcEndTime - calcStartTime) / 1_000_000.0 + " ms");
        System.out.println("Total time: " + (calcEndTime - startTime) / 1_000_000.0 + " ms");
        System.out.println("The number of right triangles is: " + count);
    }

    // === Heart for algorithm：Polar coordinate + angle difference method ===
    public static long countRightTriangles(Point[] points) {
        int n = points.length;
        long total = 0; // I use long to prevent integer overflow, because when n > 1000, number of triangles might beyond range of int.
        double EPS = 1e-9;// EPS: small tolerance to handle floating-point precision errors when comparing angles
        // values within ±1e-9 are considered equal
        // Constant representing a right angle (π/2 radians)
        double RIGHT_ANGLE = Math.PI / 2;

        for (int i = 0; i < n; i++) {
            Point origin = points[i];
            List<Double> angles = new ArrayList<>();

            // Step 1: compute polar angle from origin to every other point
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double dx = points[j].x - origin.x;
                double dy = points[j].y - origin.y;
                double angle = Math.atan2(dy, dx); // This is the heart for this algorithm, it Computes the direction angle (in radians) of the vector (dx, dy) relative to the x-axis
                angles.add(angle);
            }

            // Step 2: sort the angles
            Collections.sort(angles);

            //For each pair of direction angles from the current point,
            //check if the angle between them is approximately 90° (π/2).
            //If so, it forms a right triangle with the current point as the vertex.
            int m = angles.size();
            for (int a = 0; a < m; a++) {
                for (int b = a + 1; b < m; b++) {
                    double diff = Math.abs(angles.get(b) - angles.get(a));
                    if (diff > Math.PI) diff = 2 * Math.PI - diff; // Normalize the angle difference to [0, π] so that we always measure the smaller angle
                    if (Math.abs(diff - RIGHT_ANGLE) < EPS) {
                        total++;
                    }
                }
            }
        }

        // Each right triangle is detected twice — once for each of its right-angle vertices.
        // Divide by 2 to remove duplicate counts.
        return total/2;
    }
}


