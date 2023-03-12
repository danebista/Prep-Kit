class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);
        PriorityQueue<Pairs> used = new PriorityQueue<>((a,b)->a.endTime==b.endTime? a.roomNo-b.roomNo
        : a.endTime-b.endTime);
        int[]res = new int[n];

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>((a,b)-> a-b);
        
        for (int i=0; i< n; i++){
            freeRooms.offer(i);
        }

        for (int i=0; i<meetings.length; i++){
            while (!used.isEmpty() && used.peek().endTime <= meetings[i][0]){
                freeRooms.offer(used.poll().roomNo);
            }

            if (!freeRooms.isEmpty()){
                int roomNo = freeRooms.poll();
                res[roomNo]+=1;
                used.offer(new Pairs(meetings[i][1], roomNo));
            }
            else{
                Pairs room = used.poll();
               
                res[room.roomNo]+=1;
                room.endTime = room.endTime+(meetings[i][1]-meetings[i][0]);
                used.offer(room);
            }
        }
     
        int maxIndex = 0;
        int val =Integer.MIN_VALUE;
        for (int i=0; i< res.length; i++){
            if (res[i]> val){
                maxIndex=i;
                val = res[i];
            }
        }

        return maxIndex;
    }

    class Pairs{
        int endTime;
        int roomNo;

        Pairs(int endTime, int roomNo){
            this.endTime = endTime;
            this.roomNo = roomNo;
        }
    }
}
