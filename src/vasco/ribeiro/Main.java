package vasco.ribeiro;


import java.util.HashSet;
import java.util.Set;

/*
    2 <= coordinates.length <= 1000
	coordinates[i].length == 2
	-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
	coordinates contains no duplicate point.
 */
public class Main {
    //[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    //
    static int[][] test_true = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
    static int[][] test_false = {{1,1}, {2,2}, {3,4}, {4,5}, {5,6}, {7,7}};

    public static void main(String[] args) {
        System.out.print(checkStraightLine(test_false));
    }

    public static boolean checkDuplicates(int[][] cordinates)
    {
        Set<int[]> set = new HashSet<int[]>();
        for (int[] cords : cordinates)
            {
                if (set.contains(cords)) {
                    return true;
                }
                if (cords != null) {
                    set.add(cords);
                }
            }
        return false;
    }

    public static boolean checkStraightLine(int[][] coordinates)
    {
        //-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
        if (!(coordinates.length <= 1000 && coordinates.length >= 2))
            return false;
        if (checkDuplicates(coordinates))
            return false;
        for (int index = 0; index < coordinates.length; index++)
        {
            if (coordinates[index].length != 2)
                return false;
            if (Math.pow(-10, 4) <= coordinates[index][0])
                return false;
            if (!(coordinates[index][1] <= Math.pow(10, 4)))
                return false;
           return checkLine(coordinates);
        }
        return false;
    }

    public static boolean checkLine(int[][] coordinates) {
        int x = 0;
        while (x < coordinates.length - 1)
        {
            if (!(coordinates[x][0] + 1 == coordinates[x + 1][0] &&
                    coordinates[x][1] + 1 == coordinates[x + 1][1])) {
                return false;
            }
            x++;
        }
        return true;
    }
}
