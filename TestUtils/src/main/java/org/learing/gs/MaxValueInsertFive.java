package org.learing.gs;

public class MaxValueInsertFive {
    public static void main(String[] args) {
       System.out.println("Result"+ solution(268));
    }
    public static int solution(int N) {
        // Convert int to String
        String strN = Integer.toString(N);

        // determine the sign of the number -/+
        int sign = (strN.charAt(0) == '-') ? -1 : 1;

        // Find the first digit greater than 5 (or the last digit if all are 5 or less)
        int index = 0;
        for (int i = sign; i < strN.length(); i++) {
            if (sign * Character.getNumericValue(strN.charAt(i)) < 5) {
                index = i;
                break;
            }
        }

        // Insert the digit 5 at the determined index
        StringBuilder resultStr = new StringBuilder(strN);
        resultStr.insert(index, '5');

        // Convert the result back to an integer
        int result = Integer.parseInt(resultStr.toString());

        return result;
    }
}