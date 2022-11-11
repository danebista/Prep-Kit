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

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretA[i], guessA[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
