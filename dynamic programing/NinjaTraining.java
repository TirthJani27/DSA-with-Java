import java.util.Arrays;

public class NinjaTraining {
    public static int ninjaTraining(int[][] activities) {
        int m = 0;
        int[][] dp = new int[activities.length][activities[0].length+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        m = fun(activities.length - 1, activities, -1, dp);
        return m;
    }

    // Improved: cleaner logic, better variable names, and fixed DP indexing for 'prev'
    public static int fun(int day, int[][] activities, int prevActivity, int[][] dp) {
        if (day == 0) {
            int maxPoints = 0;
            for (int activity = 0; activity < 3; activity++) {
                if (activity != prevActivity) {
                    maxPoints = Math.max(maxPoints, activities[0][activity]);
                }
            }
            return maxPoints;
        }

        int dpPrev = prevActivity == -1 ? 3 : prevActivity;
        if (dp[day][dpPrev] != -1) {
            return dp[day][dpPrev];
        }

        int maxPoints = 0;
        for (int activity = 0; activity < 3; activity++) {
            if (activity != prevActivity) {
                int points = activities[day][activity] + fun(day - 1, activities, activity, dp);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        dp[day][dpPrev] = maxPoints;
        return maxPoints;
    }

    public static void main(String[] args) {
        int[][] activities = { { 1, 50, 10 }, { 20, 100, 25 } };
        System.out.println(ninjaTraining(activities));
    }
}