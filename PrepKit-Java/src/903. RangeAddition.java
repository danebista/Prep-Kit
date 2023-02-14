public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[]res= new int[length];
        for (int [] upd: updates){
            int start = upd[0];
            int end = upd[1];
            int delta = upd[2];
            for (int i=start; i<=end; i++){
                res[i]+=delta;
            }
        }

        return res;
    }
}

// bETTER SOLUTION HERE:


public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[]res= new int[length];
        for (int [] upd: updates){
            int start = upd[0];
            int end = upd[1];
            int delta = upd[2];
            res[start]+=delta;
            if (end+1< length){
                res[end+1]-=delta;
            }
        }

        for (int i=1; i<length; i++){
            res[i]+=res[i-1];
        }

        return res;
    }
}
