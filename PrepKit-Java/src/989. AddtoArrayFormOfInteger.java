    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> list = new ArrayList();
            int n = A.length;
            int carry = 0;
            for(int i=n-1; i>=0; i--){
                carry += K%10 + A[i];
                list.add(carry%10);
                carry/=10;
                K/=10;
            }
            while(K!=0){
                carry+=K%10;
                list.add(carry%10);
                carry/=10;
                K/=10;
            }
            if(carry>0){
                list.add(carry);
            }
            int size = list.size();
            int l = 0, r = size-1;
            while(l<r){
                int tmp = list.get(l);
                list.set(l,list.get(r));
                list.set(r,tmp);
                l++;r--;
            }
            return list;
        }
    }
