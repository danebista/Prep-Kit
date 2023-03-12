class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a,b)->a[1]==b[1]? a[0]-b[0]: a[1]-b[1]);
        int res=0;
        int[] v=new int[2001];

        for (int i=0; i<tasks.length; i++){
            for (int j=tasks[i][0]; j<= tasks[i][1]; j++){
                if (v[j]!=0) {
                    tasks[i][2]-=1;
                }
            }
            if (tasks[i][2]>0){
                res+=tasks[i][2];
                
                for (int k=tasks[i][1]; k>=0; k--){
                    if (v[k]==0 && tasks[i][2]>0){
                        v[k]-=1;
                        tasks[i][2]-=1;
                    }
                }
            }
        }

        return res;
    }
}

// always sort by endtime in such overlapping questions
