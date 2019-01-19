package leetcode;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 */
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        if (A.length == 0 || A.length == 1) return 0;

        boolean[] deleted = new boolean[A[0].length()];
        int numDeleted = 0;

        for (int i = 1; i < A.length; i++) {
            String prevStr = A[i-1];
            String str = A[i];
            for (int j = 0; j < str.length(); j++) {
                if (deleted[j]) continue;
                if (str.charAt(j) < prevStr.charAt(j)) {
                    deleted[j] = true;
                    numDeleted++;
                }
            }
            if (numDeleted == A.length) break;
        }

        return numDeleted;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted d = new DeleteColumnsToMakeSorted();

//        String[] arr = {
//                "abc",
//                "dbf"
//        };

        String[] arr = {
                "rrjk","furt","guzm"
        };

        System.out.println(d.minDeletionSize(arr));
    }
}
