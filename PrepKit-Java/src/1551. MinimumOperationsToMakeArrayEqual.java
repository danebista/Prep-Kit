class Solution {
    public int minOperations(int n) {
        int mid = n/2;
        if (n%2==0){
            return mid * mid;
        }
        else {
            return mid * (mid+1);
        }
    }
}

//[1,3, 5]
//[2,3,4]
//[3,3,3]

//[1,3,5,7,9]
// 4 2   2  4
//     6// n/2*(n/2+1)
//4+2 = 6
//2(1+2)
//since mid is 2 
// Hence 2*(sum(mid));
// 2* mid*(mid+1)/2
//mid * (mid+1);

//[1,3,5,7]
// 3 1 1  3 //changing to 4
 //n/2 * n/2
//3+1 = 4
//(mid)^2
 
