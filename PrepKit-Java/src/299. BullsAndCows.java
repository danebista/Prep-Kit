class Solution {
    public String getHint(String secret, String guess) {
        int[] secretA = new int[10];
        int[] guessA = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                continue;
            }
            secretA[secret.charAt(i) - '0']++;
            guessA[guess.charAt(i) - '0']++;
        }
        // guess: 1807 //secret: 7810
        // 0 1 2 3 4 5 6 7 8
        // [1,1,0,0,0,0,1,0,8]
        // 0 1 2 3 4 5 6 7 8
        // [0,1,0,0,0,0,1,0,0] ]
        // 1807
        // 7810
        // Assign places of encounter and take the minimum among them

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretA[i], guessA[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
