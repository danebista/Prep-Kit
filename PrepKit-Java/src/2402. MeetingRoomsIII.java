class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->(a[0]-b[0]));
        int[] answer = new int[n];
        long[] roomUsed = new long[n];

        for (int i=0; i< meetings.length; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            int maxIndex = -1;
            boolean flag = false;
            long value = Long.MAX_VALUE;
            for (int j=0; j<roomUsed.length; j++){
                
                if (roomUsed[j]< value) {
                    value=roomUsed[j];
                    maxIndex = j;
                }
               
                if (roomUsed[j]<= start){
                    flag= true;
                    answer[j]++;
                    roomUsed[j]=end;
                    break;
                }
            }
            if (!flag){
                answer[maxIndex]++;
                roomUsed[maxIndex]+=(end-start);
            }
        }

        int maxAns = -1;
        int index = -1;
        for (int i=0; i< answer.length; i++){
            if (answer[i]> maxAns){
                maxAns= answer[i];
                index= i;
            }
        }

        return index;
    }
}
