public class Day8 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int index = -1;
        
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            }
        }
        
        if (index < 0) {
            for (int i = 0; i < length; i++) {
                if (nums[i] > target) {
                    index = i;
                    break;
                } else if (nums[i] < target && (i == length - 1 || nums[i + 1] > target)) {
                    index = i + 1;
                    break;
                }
            }
        }
        
        return index;
    }

    public static void main(String[] args) {
        Day8 day8 = new Day8();
        int[] arr = {1, 3, 5, 6};
        int index = day8.searchInsert(arr, 5);
        System.out.println(index);
    }
}
