class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}

// 0 + 1+ 2+ ...+ 9 = 10 n=1
// _ _ = 9 * 9(second time 0 choosable) =81
// hence n=2 = 81+10
// when n==3 = ___ = 9*9*8(9*9 is already there in prev iteration)+ 91+10(all
// upto 1 digit)
// ......
