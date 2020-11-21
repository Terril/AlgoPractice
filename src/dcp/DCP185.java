package dcp;

public class DCP185 {
    public static void main(String args[]) {

        Point pos1 = new Point(1, 4);
        Point dim1 = new Point(3, 3);
        Point pos2 = new Point(0, 5);
        Point dim2 = new Point(4, 3);
        int area = findAreaOfIntersectingPoint(pos1, dim1, pos2, dim2);

        System.out.println("Area: " + area);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int findAreaOfIntersectingPoint(Point pos1, Point dim1, Point pos2, Point dim2) {
        int area1 = Math.abs(pos1.x - dim1.x) * Math.abs(pos1.y - dim1.y);
        int area2 = Math.abs(pos2.x - dim2.x) * Math.abs(pos2.y - dim2.y);

        int areaInt = (Math.min(dim1.x, dim2.x) - Math.max(pos1.x, pos2.x))
                * (Math.min(dim1.y, dim2.y)
                - Math.max(pos1.y, pos2.y));

        return (area1 + area2 - areaInt);
    }
}
