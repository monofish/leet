/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * @author Wei
 * @since 11/30/15
 *
 */
public class PlusOne {

    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        int i;
        for (i = 1; i <= digits.length && digits[digits.length - i] == 9; i++) {
            digits[digits.length - i] = 0;
        }

        if (i > digits.length) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        } else {
            digits[digits.length - i]++;
            return digits;
        }
    }
}
