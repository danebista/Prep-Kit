class Solution {

    public int countGoodStrings(int low, int high, int zero, int one) {
       String z = str('0', zero);
       String o = str('1', one);
       Map<Integer, Integer> dp = new HashMap<>();
       return rec(low, high, z, o, new StringBuilder(), dp);
   }

   private int rec(int low, int high, String zero, String one, StringBuilder sb, Map<Integer, Integer> dp) {
       int mod = (int)1e9+7;
       // base case
       if (sb.length() > high) return 0;
       if (dp.containsKey(sb.length())) return dp.get(sb.length());
       int tz = 0, to = 0;
       // take zero
       sb.append(zero);
       tz += ((valid(sb, low, high) ? 1 : 0) + rec(low, high, zero, one, sb, dp)) % mod;

       // backtrack;
       sb.delete(sb.length() - zero.length(), sb.length());

       // take one
       sb.append(one);
       to += ((valid(sb, low, high) ? 1 : 0) + rec(low, high, zero, one, sb, dp)) % mod;
       // backtrack
       sb.delete(sb.length() - one.length(), sb.length());

       int ans = (tz + to) % mod;
       dp.put(sb.length(), ans);
       return ans;

   }

   private String str(char c, int times) {
       char[] repeat = new char[times];
       Arrays.fill(repeat, c);
       return new String(repeat);
   }
   
   private boolean valid(StringBuilder sb, int low, int high) {
       return sb.length() >= low && sb.length() <= high;
   }
}
