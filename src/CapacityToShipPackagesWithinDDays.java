import java.util.stream.Stream;

/**
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 *
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor
 * belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 *
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped
 * within days days.
 *
 *
 *
 * Example 1:
 *
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages
 * into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * Example 2:
 *
 * Input: weights = [3,2,2,4,1,4], days = 3
 * Output: 6
 * Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * Example 3:
 *
 * Input: weights = [1,2,3,1,1], days = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 *
 *
 * Constraints:
 *
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 *
 * Example 1:
 *
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 *
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * Example 2:
 *
 * Input: weights = [3,2,2,4,1,4], days = 3
 * Output: 6
 * Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * Example 3:
 *
 * Input: weights = [1,2,3,1,1], days = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 *
 *
 * Constraints:
 *
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 */
public class CapacityToShipPackagesWithinDDays {
//    public int shipWithinDays(int[] weights, int days) {
//        int left = Integer.MIN_VALUE;
//        int right = 0;
//        for(int i : weights) {
//            left = Math.max(i, left);
//            right += i;
//        }
//        while(left < right) {
//            int mid = left + (right - left)/2;
//            if(canShip(weights, days, mid)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return right;
//    }
//
//    public boolean canShip(int [] weight, int days, int capacity) {
//        int cost = 1, sum = 0, i = 0;
//        while(i<weight.length) {
//            sum += weight[i];
//            if(sum > capacity) {
//                cost++;
//                sum=0;
//            } else {
//                i++;
//            }
//        }
//        return cost <= days;
//    }

    public static void main(String [] args) {
        CapacityToShipPackagesWithinDDays obj = new CapacityToShipPackagesWithinDDays();
        //int [] weights = {1,2,3,4,5,6,7,8,9,10};
        //int [] weights = {3,3,3,3,3,3};
        int [] weights = {1 ,2, 3, 1, 1};
        int target = 2;
        //obj.shipWithinDays(weights, target);
        System.out.println(obj.canShip(weights, target, 4));
    }

    public int shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE, end=0;
        for(int i=0; i<weights.length; i++) {
            end+=weights[i];
            start = Math.max(weights[i], start);
        }
        while(start < end) {
            int mid = start + (end - start)/2;
            if(canShip(weights, mid, days)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public boolean canShip(int [] weights, int k, int days) {
        int actualShippingDay = 0;
        int i=0, tempSum = 0;
        while(i < weights.length) {
            tempSum+=weights[i];
            if(tempSum >= k) {
                actualShippingDay++;
                if(tempSum > k) {
                    tempSum=weights[i];
                } else {
                    tempSum = 0;
                }
            }
            i++;
        }
        if(tempSum != 0) actualShippingDay++;
        return actualShippingDay <= days;
    }
}
