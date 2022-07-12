package leetcodeHot100;

/**
 * @author zhangyue
 * @date 2022/4/14
 * 只出现一次的数字：
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 位运算！！！
 **/
public class singleNumber {

    public static int singleNumber(int[] nums) {
        int tmp = 0;
        for (int num : nums) {
            tmp = tmp ^ num;
        }
        return tmp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        System.out.println(singleNumber(nums));
        int[] nums1 = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums1));
    }
}
