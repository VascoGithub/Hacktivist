package ex04;

public class ex04 {
    static int x1;
    static int x2;
    static int x3;
    static int y1;
    static int y2;
    static int y3;

    public static void main(String[] args) {
        int[][] values = {{1,1},{2,3},{3,2}};
        // x1 = 1 x2 = 2 x3 = 3
        // y1 = 1 y2 = 3 y3 = 2
        System.out.println(isBoomerang(values));
    }

    public static boolean isLine(int x1, int y1, int x2, int y2, int x3, int y3) {
        return !((y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2));
    }

    public static boolean isBoomerang(int[][] points) {
        parsePoints(points);
        return isLine(x1, y1, x2, y2, x3, y3);
    }

    public static void parsePoints(int[][] points)
    {
        int rows = points.length;
        int cols = points[0].length;

        if (cols != 2 && rows != 3) {
            System.out.println("Wrong args");
            System.exit(84);
        }

        x1 = points[0][0];
        x2 = points[1][0];
        x3 = points[2][0];

        y1 = points[0][1];
        y2 = points[1][1];
        y3 = points[2][1];

        if (x1 != y1 && x2 != y2 && x3 != y3) {
            System.exit(84);
        }
    }
}
