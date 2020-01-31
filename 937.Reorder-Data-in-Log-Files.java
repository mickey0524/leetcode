// https://leetcode.com/problems/reorder-data-in-log-files/
//
// algorithms
// Easy (53.65%)
// Total Accepted: 78,176
// Total Submissions: 145,704
// beats 100.0% of java submissions


class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int len = logs.length;
        int idx = 0;
        Log[] logArr = new Log[len];
        for (String s : logs) {
            logArr[idx++] = new Log(s);
        }

        idx = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (logArr[i].isDigitLog()) {
                swap(logArr, i, idx--);
            }
        }

        int tmp = 1;

        Arrays.sort(logArr, 0, idx + 1);

        for (int i = 0; i < len; i++) {
            logs[i] = logArr[i].getOriginalLog();
        }

        return logs;
    }

    private <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private class Log implements Comparable<Log> {

        private String originalLog;
        private String flag;
        private String content;
        private boolean isDigitLog;

        Log(String originalLog) {
            this.originalLog = originalLog;

            initLog();
        }

        boolean isDigitLog() {
            return isDigitLog;
        }

        String getOriginalLog() {
            return this.originalLog;
        }

        private void initLog() {
            int delimiterIdx = originalLog.indexOf(' ');

            this.flag = originalLog.substring(0, delimiterIdx);
            this.content = originalLog.substring(delimiterIdx + 1);
            if (Character.isDigit(this.content.charAt(0))) {
                this.isDigitLog = true;
            }
        }

        @Override
        public int compareTo(Log log) {
            if (this.isDigitLog() || log.isDigitLog()) {
                return 0;
            }

            int tmp = this.content.compareTo(log.content);
            if (tmp == 0) {
                return this.flag.compareTo(log.flag);
            }

            return tmp;
        }

    }
}