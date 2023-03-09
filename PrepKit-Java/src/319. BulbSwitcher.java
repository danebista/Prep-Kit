class Solution {
    public int bulbSwitch(int n) {
       int count = 0;
       
       for (int i=1; i*i<=n; i++){
           count++;
       }

       return count;
    }   
}



/*1 1 1 1 1-1
1 0 1 0 1-2
1 0 0 0 0-3
1 0 0 1 0-4
1 0 0 1 1-5
*/
//if (number of factors is odd then on, else off)
// only square numbers have odd factors, because of the fact that they are accessed thrice in this case
// prime numbers don't account for a solution because lets say 5, it gets turned on at 1 , off at 5
