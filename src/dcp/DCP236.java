package dcp;

/*
 * This problem was asked by Nvidia.
 *
 * You are given a list of N points (x1, y1), (x2, y2), ..., (xN, yN) representing a polygon.
 * You can assume these points are given in order; that is,
 * you can construct the polygon by connecting point 1 to point 2,
 * point 2 to point 3, and so on, finally looping around to connect point N to point 1.
 *
 * Determine if a new point p lies inside this polygon.
 * (If p is on the boundary of the polygon, you should return False).
 * */
public class DCP236 {
    public static void main(String args[]) {
        Point polygon1[] = {new Point(0, 0),
                new Point(10, 0),
                new Point(10, 10),
                new Point(0, 10)};
        int n = polygon1.length;
        Point p = new Point(20, 20);
        p = new Point(5, 5);
        p = new Point(5, 1);
        Point polygon2[] = {new Point(0, 0),
                new Point(5, 5), new Point(5, 0)};
        p = new Point(3, 3);
        n = polygon2.length;
        p = new Point(5, 1);
 //       p = new Point(8, 1);
        Point polygon3[] = {new Point(0, 0),
                new Point(10, 0),
                new Point(10, 10),
                new Point(0, 10)};
//        p = new Point(-1, 10);
//        n = polygon3.length;
        if (isInside(polygon2, n, p)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isInside(Point polygon[], int n, Point p) {
        boolean inside = false;
        for (Point poly : polygon) {
            int xCor = poly.x;
            int yCor = poly.y;

            if (xCor > p.x && yCor > p.y) {
                inside = true;
                break;
            }
        }

        return inside;
    }
}
