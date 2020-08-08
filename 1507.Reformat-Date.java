// https://leetcode.com/problems/reformat-date/
// algorithms
// Easy (60.18%)
// Total Accepted: 5,638
// Total Submissions: 9,368
// beats 100.0% of java submissions


class Solution {

    private static final Map<String, String> monthMap = new HashMap<>(12);

    static {
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");
    }

    private static final char SEPARATOR = '-';

    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        String[] arr = date.split(" ");

        String year = arr[2];
        String month = monthMap.get(arr[1]);
        String day = takeOutNum(arr[0]);

        sb.append(year).append(SEPARATOR).append(month).append(SEPARATOR).append(day);

        return sb.toString();
    }

    private String takeOutNum(String day) {
        if (Character.isDigit(day.charAt(1))) {
            return day.substring(0, 2);
        }

        return '0' + day.substring(0, 1);
    }
}