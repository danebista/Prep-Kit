class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int totalNo = s.length;
        if (totalNo == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int maxNo = 0;
        int cookiesIndex = totalNo - 1;
        int childIndex = g.length - 1;

        while (childIndex >=0 && cookiesIndex >=0){
            if (s[cookiesIndex] >= g[childIndex]){
                maxNo++;
                cookiesIndex--;
                childIndex--;
            }
            else {
                childIndex--;
            }
        }
        
        return maxNo;
    }
}
