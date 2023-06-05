class Solution {
    public boolean checkStraightLine(int[][] nums) {
        
         if (nums.length==2) return true;
         Double slope = null;
         boolean inf= false;
         
         for(int i = 0; i < nums.length-1; i++) {
             int[] curr = nums[i];
             int[]next =nums[i+1];
             double y1 = next[1]-curr[1];
             double x1 = next[0]-curr[0];
             if (inf && x1!=0) return false;
             if (x1==0){
                 if (i!=0 && !inf) return false;
                 inf = true;
                 continue;
             }
             double gcd = gcd(x1, y1);
             Double s1 = (y1/gcd)/(x1/gcd);
             if (slope!=null && slope.doubleValue()!=s1.doubleValue()) return false;
             slope =s1;
         }
         return true;
     }
     
     public double gcd(double a, double b){
         if (b==0) return a;
         return gcd(b, a%b);
     }
 
 }
 