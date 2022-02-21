/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 *
 * Find the kth positive integer that is missing from this array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * Example 2:
 *
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 *
 * 0 1 2 3 4 5
 * 1 2 3 4 5 7 8 9 10 11
 */
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int len = arr.length;
        int check = arr[len -1] - len;
        if(check < k) {
            return arr[len-1] + (k - check);
        }
        check = 0;
        for(int i = 0; i<len; i++) {
            check = arr[i] - i -1;
            if(check >= k) {
                check = i-1;
                break;
            }
        }
        if(check < 0) {
            return k;
        }
        return arr[check] + (k - (arr[check] - check -1));
    }

    public static int findKthPositiveBinarySearch(int[] arr, int k) {
        int len = arr.length;
        if(checkMissing(arr, len -1) < k) {
            return arr[len -1] + k - checkMissing(arr, len-1);
        }
        if(checkMissing(arr, 0) >= k) {
            return k;
        }
        int start = 0, end = len-1;
        while(start < end) {
            int mid = start + (end - start)/2;
            int currentMissing = checkMissing(arr, mid);
            if(currentMissing < k) {
                start = mid +1;
            } else {
                end = mid;
            }
        }
        //System.out.println(arr[start]);
        //System.out.println(k);
        //System.out.println(checkMissing(arr, start));
        return arr[start-1] + k - checkMissing(arr, start-1);
    }

    public static int checkMissing(int [] arr, int index) {
        return arr[index] - index -1;
    }

    public static void main(String [] args) {
        int [] test = {2, 3, 4, 7, 11};
        System.out.println(findKthPositiveBinarySearch(test, 5));
    }
}
