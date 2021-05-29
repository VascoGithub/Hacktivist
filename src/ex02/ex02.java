package ex02;


import java.util.*;

/*
    2 <= coordinates.length <= 1000
	coordinates[i].length == 2
	-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
	coordinates contains no duplicate point.
 */
public class ex02 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static int[][] test_test = {{1,1,1,1},{1,2,2,1},{1,2,2,1},{1,1,1,1}};
    static int[][] tets_true = {{1, 1, 1, 1}, {1, 1, 3, 3}, {1, 1, 3, 4}, {5, 5, 1, 4}};
    static int[][] test_false = {{1, 2, 1}, {2, 1, 2}, {1, 2, 1}};
    static int rows;
    static int cols;

    public static void main(String[] args) {
        //[[1,1,1,1],[1,1,3,3],[1,1,3,4],[5,5,1,4]]
        System.out.println(isPrintable(test_test));
        //System.out.println(isPrintable(test_false));
    }

    static void printTable(int[][] targetGrid) {
        for (int[] _n : targetGrid) {
            for (int x : _n) {
                //System.out.print(x);
                System.out.print(getColor(x) + "■\t");
            }
            System.out.print("\n");
        }
    }

    static String getColor(int x) {
        switch (x) {
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            case 3:
                return ANSI_WHITE;
            case 4:
                return ANSI_BLACK;
            case 5:
                return ANSI_YELLOW;
        }
        return "";
    }

    /*  Y
      X A A A A
        A A A A
        A A A A
        A A A A
     */

    /*  Y
      X 1 1 1 1
        1 1 3 3
        1 1 3 4
        5 5 1 4
     */

    static boolean findRectangle(int[][] targetGrid, int color) {
        // busca un puto cuadaro con color val
        int[][] rectangle = new int[rows][cols];
        int minx = rows;
        int maxx = -1;
        int miny = cols;
        int maxy = -1;
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                rectangle[x][y] = targetGrid[x][y];
                if (targetGrid[x][y] == color) {
                    minx = Math.min(minx, x);
                    maxx = Math.max(maxx, x);
                    miny = Math.min(miny, y);
                    maxy = Math.max(maxy, y);
                }
            }
        }
        //printTable(rectangle);
        //System.out.print("\n");

        for (int x = minx; x <= maxx; x++)
            for (int y = miny; y <= maxy; y++)
                if (targetGrid[x][y] != color && targetGrid[x][y] != 0)
                    return false;
        for (int x = minx; x <= maxx; x++)
            for (int y = miny; y <= maxy; y++)
                targetGrid[x][y] = 0;

        return true;
    }

    public static boolean isPrintable(int[][] targetGrid) {

        rows = targetGrid.length;
        cols = targetGrid[0].length;
        int[][] temp = new int[rows][cols];
        Set<Integer> grid = new HashSet<>();
        for (int x = 0; x < rows; x++)
            for (int y = 0; y < cols; y++)
            {
                grid.add(targetGrid[x][y]);
                temp[x][y] = targetGrid[x][y];
            }
        //printTable(temp);

        while (!grid.isEmpty()) {
            Iterator<Integer> iterator = grid.iterator();
            boolean flag = false;
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (findRectangle(targetGrid, next)) {
                    iterator.remove();
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
        return grid.isEmpty();
    }

}
