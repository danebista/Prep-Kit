public class FairDistributionOfCookies {
    class Solution {
        int globalMin = Integer.MAX_VALUE;

        public int distributeCookies(int[] cookies, int k) {
            int[] players = new int[k];
            helper(0, cookies, players);
            return globalMin;
        }

        public void helper(int index, int[] cookies, int[] players) {
            if (index == cookies.length) {
                int max = 0;
                for (int play : players)
                    max = Math.max(play, max);

                globalMin = Math.min(globalMin, max);
                return;
            }

            for (int i = 0; i < players.length; i++) {
                players[i] += cookies[index];
                helper(index + 1, cookies, players);
                players[i] -= cookies[index];
            }
        }
    }
}
