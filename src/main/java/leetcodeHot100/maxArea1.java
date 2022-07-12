package leetcodeHot100;

public class maxArea1 {

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int high = Math.min(height[left], height[right]);
            max = Math.max(max, high * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        height = new int[]{1, 1};
        System.out.println(maxArea(height));
    }
}
