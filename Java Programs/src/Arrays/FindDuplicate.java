package Arrays;

// using floyd-cycle method
public class FindDuplicate {
    public int findDuplicateNumber(int[] nums){
        // using fast & slow pointers
        int slow = nums[0];
        int fast = nums[0];

        // detecting cycle
        do{

            slow = nums[slow];
            fast = nums[nums[slow]];

        }while(slow != fast);

        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
