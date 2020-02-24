// https://leetcode.com/problems/number-of-days-between-two-dates/
// algorithms
// Easy (48.53%)
// Total Accepted: 4,981
// Total Submissions: 10,263
// beats 100.0% of java submissions


class Solution {

    private static final int NORMAL_YEAR_DAYS = 365;
    private static final int LEAP_YEAR_DAYS = 366;
    private static final int BIG_MONTH_DAYS = 31;
    private static final int SMALL_MONTH_DAYS = 30;
    private static final int FEBRUARY_DAYS = 28;
    private static final int BASE_YEAR = 1970;
    private static final HashMap<Integer, Integer> monthToDays = new HashMap<>();

    static {
        for (int month : new int[] { 1, 3, 5, 7, 8, 10, 12 }) {
            monthToDays.put(month, BIG_MONTH_DAYS);
        }
        for (int month : new int[] { 4, 6, 9, 11 }) {
            monthToDays.put(month, SMALL_MONTH_DAYS);
        }
        monthToDays.put(2, FEBRUARY_DAYS);
    }

    public int daysBetweenDates(String date1, String date2) {
        if (date1.compareTo(date2) > 0) {
            String tmp = date1;
            date1 = date2;
            date2 = tmp;
        }

        String[] arr1 = date1.split("-");
        String[] arr2 = date2.split("-");

        int days1 = computeDays(Integer.valueOf(arr1[0]), Integer.valueOf(arr1[1]), Integer.valueOf(arr1[2]));
        int days2 = computeDays(Integer.valueOf(arr2[0]), Integer.valueOf(arr2[1]), Integer.valueOf(arr2[2]));

        return days2 - days1;
    }

    private int computeDays(int year, int month, int day) {
        int years = year - BASE_YEAR;
        int leapYears = (years + 1) / 4;
        int res = leapYears * LEAP_YEAR_DAYS + (years - leapYears) * NORMAL_YEAR_DAYS;

        boolean isLeap = isLeapYear(year);
        for (int i = 1; i < month; i++) {
            res += monthToDays.get(i);
        }
        if (isLeap && month > 2) {
            res++;
        }

        res += day;

        return res;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

}