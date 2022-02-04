/**
 * Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
 *
 * Answers within 10-5 of the actual value will be accepted as correct.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: hour = 12, minutes = 30
 * Output: 165
 * Example 2:
 *
 *
 * Input: hour = 3, minutes = 30
 * Output: 75
 * Example 3:
 *
 *
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 *
 *
 * Constraints:
 *
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * diff/60 = res/360
 * res = 6 * diff
 * minutes/60 * 5
 */
public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        hour = (hour == 12) ? 0 : hour;
        double hourToMin = hour * 5 + ((double)minutes)/60 * 5;
        double diff = Math.abs(hourToMin - minutes);
        if(diff > 30) {
            diff = 60 -diff;
        }
       return  diff/60 * 360;
    }

    public static void main(String [] args) {
        AngleBetweenHandsOfAClock a = new AngleBetweenHandsOfAClock();
        System.out.println(a.angleClock(12, 30));
    }
}
