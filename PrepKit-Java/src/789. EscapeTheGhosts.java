class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
      // if ghost reaches goal before player ghost can always catch us;
      //we use mahnattan distance because bfs will give us tle due to big size
      int playerDistance = Math.abs(0-target[0])+Math.abs(0-target[1]);
      for (int i=0; i< ghosts.length; i++){
        int curr = Math.abs(ghosts[i][0]-target[0])+Math.abs(ghosts[i][1]-target[1]);
        if (curr<=playerDistance) return false;
      }

      return true;

    }

}
