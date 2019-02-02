import java.util.HashMap;

public class TwoSum_1 {

    /**
     * 第一反应就是遍历所有可能组合，找到两数相加为target的一组数，返回其坐标。
     * 但是很明显这样做的话，时间复杂度为O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twosum_1(int[] nums, int target){
        int[] res = new int[2];
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if(target==nums[i]+nums[j]){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }

    /**
     * 仔细思考能否降低时间复杂度，那就只能用空间复杂度来换。
     * 使用HashMap建立一个坐标与数值之间的映射，然后搜索另一个数值，去寻找target-这个数值的坐标。
     * 整体步骤：1. 遍历一遍数组；2. 建立HashMap映射；3. 再遍历一遍，查找差值坐标。
     * @param nums
     * @param target
     * @return
     */
    public int[] twosum_2(int[] nums, int target){
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        for (int i=0; i<nums.length; ++i){
            m.put(nums[i], i);
        }
        for (int i=0; i<nums.length; ++i){
            int t = target - nums[i];
            if(m.containsKey(t)&&m.get(t)!=i){
                res[0] = i;
                res[1] = m.get(t);
                break;
            }
        }
        return res;
    }

    /**
     * 将两个循环合成一个for。精简Code。
     * @param nums
     * @param target
     * @return
     */
    public int[] twosum_3(int[] nums, int target){
        HashMap<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];
        for (int i=0; i<nums.length; i++){
            if (m.containsKey(target-nums[i])){
                res[0]=i;
                res[1]=m.get(target-nums[i]);
                break;
            }
            m.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        TwoSum_1 leetcode = new TwoSum_1();
        System.out.println("The result of twosum_1 is ["+leetcode.twosum_1(nums, target)[0]+", "+leetcode.twosum_1(nums, target)[1]+"].");
        System.out.println("The result of twosum_2 is ["+leetcode.twosum_2(nums, target)[0]+", "+leetcode.twosum_2(nums, target)[1]+"].");
        System.out.println("The result of twosum_3 is ["+leetcode.twosum_3(nums, target)[0]+", "+leetcode.twosum_3(nums, target)[1]+"].");
    }
}
