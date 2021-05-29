package ex03;

import java.util.ArrayList;

public class ex03 {
    public static void main(String[] args) {
        int[] values = {9,2,2,3,4,4,3};
        System.out.println(singleNumber(values));
    }
    public static int singleNumber(int[] nums) {
        int value = 0;
        if (!(1 <= nums.length && nums.length <= (3 * 104))) {
            System.exit(84);
        }
        for (int i : nums)
        {
            if (Math.pow((-3 * 10), 4) <= i && i <= Math.pow((3 * 10), 4))
                System.exit(84);
            value ^= i;
        }
        return value;
    }
}