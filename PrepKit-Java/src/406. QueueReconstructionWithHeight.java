class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        for (int i=0; i< people.length; i++){
            System.out.println(people[i][0]+"-"+people[i][1]);
        }
        List<int[]> list = new ArrayList<>();
        for(int[] p : people) {
            list.add(p[1], p);
            System.out.println(p[1]);
        }
        return list.toArray(new int[people.length][2]);
    }
}

//[7,0][7,1][6,1][5,0][5,2][4,4]
//[7,0]//filling index 0
//[7,0][7,1]//filling index 1
//[7,0][6,1],[7,1]// again filling index1
//[5,0][7,0][6,1][7,1]//filling index0
//[5,0][7,0][5,2][6,1][7,1]//filling index 2
//[5,0][7,0][5,2][6,1][4,4],[7,1]

