import java.util.Random;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as
 * a result of the shuffling.
 *
 * Implement the Solution class:
 *
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 *
 *
 * Example 1:
 *
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
 *                        // Any permutation of [1,2,3] must be equally likely to be returned.
 *                        // Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 *
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -106 <= nums[i] <= 106
 * All the elements of nums are unique.
 * At most 5 * 104 calls in total will be made to reset and shuffle.
 */
public class ShuffleAnArray {
    class Solution {
        int [] array;
        int [] copy;
        Random random;
        public Solution(int[] nums) {
            this.array = nums.clone();
            this.copy = nums.clone();
            random = new Random();
        }

        public int[] reset() {
            this.array = copy.clone();
            this.copy = copy.clone();
            return this.array;
        }

        public int[] shuffle() {
            for(int i = 0; i<array.length; i++) {
                int s = getRandomRange(array.length, i);
                swap(i, s);
            }
            return this.array;
        }

        private int getRandomRange(int max, int min) {
            return random.nextInt(max - min) + min;
        }

        private void swap(int i, int j) {
            int temp = this.array[i];
            this.array[i] = this.array[j];
            this.array[j] = temp;
        }
    }
}
class Solution {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        //The min parameter (the origin) is inclusive, whereas the upper bound max is exclusive.
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        array = nums;
        //premitive is copy but if it is object in the array, it is shallow copy
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}