package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ReorderLogFiles {

    private class Log {

        String logString;
        String id;
        String logs;

        public Log(String logString) {
            this.logString = logString;

            String[] str = logString.split(" ");
            id = str[0];
            logs = logString.substring(logString.indexOf(' ') + 1);
        }

        boolean isLetterLog() {
            return Character.isLetter(logs.charAt(0));
        }

        public String toString() {
            return logString;
        }
    }

    private class LogComparer implements Comparator<Log> {
        @Override
        public int compare(Log l1, Log l2) {
            if (l1.isLetterLog() && l2.isLetterLog()) {
                int res = l1.logs.compareTo(l2.logs);
                if (res == 0) {
                    return l1.id.compareTo(l2.id);
                }
                return res;
            } else if (l1.isLetterLog() && !l2.isLetterLog()) {
                return -1;
            } else if (! l1.isLetterLog() && l2.isLetterLog()) {
                return 1;
            }
            return 0;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        /*
            Time Complexity - O(n * log(n)) where n is the number of logs
            Space Complexity - O(n)
         */
        LinkedList<Log> l = new LinkedList<>();

        for (int i = 0; i < logs.length; i++) {
            l.add(new Log(logs[i]));
        }
        l.sort(new LogComparer());

        String[] ret = new String[logs.length];
        for (int i = 0; i < l.size(); i++) {
            ret[i] = l.get(i).logString;
        }
        return ret;
    }

    public static void main(String[] args) {
        ReorderLogFiles r = new ReorderLogFiles();
        String[] s = {
                "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"
        };
        System.out.println(Arrays.toString(r.reorderLogFiles(s)));
    }
}
