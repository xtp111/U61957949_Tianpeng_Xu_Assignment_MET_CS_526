package HomeWork3.Problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.*;

public class GhostBusters {

    // Cross product to determine relative orientation, this is core code for this program.
    // if two line start from same point, it still can be marked as eliminated
    public static double cross(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    // Check if two line segments intersect
    static boolean isIntersect(Point a1, Point a2, Point b1, Point b2) {
        double d1 = cross(a1, a2, b1);
        double d2 = cross(a1, a2, b2);
        double d3 = cross(b1, b2, a1);
        double d4 = cross(b1, b2, a2);
        return (d1 * d2 <= 0) && (d3 * d4 <= 0);
    }

    public static boolean checkAllIntersections(List<Pair> pairs) {
        for (int i = 0; i < pairs.size(); i++) {
            for (int j = i + 1; j < pairs.size(); j++) {
                if (isIntersect(pairs.get(i).b, pairs.get(i).g, pairs.get(j).b, pairs.get(j).g)) {
                    return true;
                }
            }
        }
        return false
                ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Pair> pairs = new ArrayList<>();

        System.out.println("Enter coordinates in format: B bx by G gx gy (Press Ctrl+D or Ctrl+Z to stop)");

        while (sc.hasNext()) {
            String label1 = sc.next(); // Read "B"
            double bx = sc.nextDouble();
            double by = sc.nextDouble();
            String label2 = sc.next(); // Read "G"
            double gx = sc.nextDouble();
            double gy = sc.nextDouble();

            Pair newPair = new Pair(new Point(bx, by), new Point(gx, gy));
            pairs.add(newPair);
            boolean hasCross = checkAllIntersections(pairs);

        if (hasCross)
            System.out.println("Ghosts were NOT eliminated");
        else
            System.out.println("Ghosts can be eliminated");
    }
}}

