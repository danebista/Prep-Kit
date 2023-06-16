class Solution {
    int mod=1000000007;
    long[][]pascalsTriangle;
    public int numOfWays(int[] nums) {
        buildPascalsTriangle();
        
        List<Integer> result = new ArrayList<>();
        for (int n:nums){
            result.add(n);
        }
        return (int)noOfWay(result)-1;
    }

    public long noOfWay(List<Integer> nums){
        if (nums.size()<=2) return 1;//<=2 because watch youtube lol.
        int curr = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int n:nums){
            if (n< curr)left.add(n);
            else if (n> curr)right.add(n);
        }
        return pascalsTriangle[right.size()+left.size()][left.size()]%mod * noOfWay(left)%mod * noOfWay(right)%mod;
    }

    public void buildPascalsTriangle(){
        int n=1000;
        pascalsTriangle=new long[n][n];
        for (int i=0;i<n; i++){
            pascalsTriangle[i][0] = 1;
        }
        
        for (int i=1; i<n; i++){
            for (int j=1; j<=i; j++){
                pascalsTriangle[i][j] = (pascalsTriangle[i-1][j]+pascalsTriangle[i-1][j-1])%mod;
            }
        }
    }
}


// Pascals triangle gives us combination easily
