import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Brut Force
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] { i, j };
            }
        }
        return null;
    }

    public static int[] mapWay(int[] nums, int target) {
        Map<Integer, Integer> mapps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var need = target - nums[i];
            if (!mapps.containsKey(need)) {
                mapps.put(nums[i], i);
            } else {
                return new int[] { mapps.get(need), i };
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(mapWay(nums, target)));

    }
}
