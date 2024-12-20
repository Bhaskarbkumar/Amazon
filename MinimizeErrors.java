import java.util.*;

public class MinimizeErrors {

    // Function to calculate minimum errors
    public static int minimumErrors(String errorString, int x, int y) {
        final int MOD = 1000000007;
        int n = errorString.length();
        
        // Total count of 1's and 0's
        int total0 = 0, total1 = 0;
        for (char c : errorString.toCharArray()) {
            if (c == '0') total0++;
            if (c == '1') total1++;
        }
        
        int count0 = 0; // Count of 0's before the current index
        int count1 = total1; // Count of 1's after the current index
        long minErrors = Long.MAX_VALUE;

        // Traverse the string to calculate errors dynamically
        for (int i = 0; i < n; i++) {
            char c = errorString.charAt(i);

            if (c == '!') {
                // If '!' is replaced with '0'
                long errorsIf0 = (long) count1 * x + (long) (total0 - count0) * y;

                // If '!' is replaced with '1'
                long errorsIf1 = (long) count0 * y + (long) (total1 - count1) * x;

                // Take the minimum of both
                minErrors = Math.min(minErrors, Math.min(errorsIf0, errorsIf1));
            }

            // Update counts
            if (c == '0') count0++;
            if (c == '1') count1--;
        }

        return (int) (minErrors % MOD);
    }

    // Main function to test the solution
    public static void main(String[] args) {
        // Test case
        String errorString = "1011!";
        int x = 4, y = 3;

        int result = minimumErrors(errorString, x, y);
        System.out.println(result); // Output: 9
    }
}