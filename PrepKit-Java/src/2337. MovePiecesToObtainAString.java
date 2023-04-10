class Solution {
    public boolean canChange(String start, String target) {
        int l=0;
        int r=0;
        int l1 = 0;
        int r1=0;
        int l2=0;
        int r2=0;
        while (l<start.length()){
            if (start.charAt(l)=='L') l1++;
            if (start.charAt(l)=='R') r1++;
            l++;
        }

        while (r<target.length()){
            if (target.charAt(r)=='L') l2++;
            if (target.charAt(r)=='R') r2++;
            r++;
        }
        if (l1!=l2 || r1!=r2) return false;
        l=0;
        r=0;
        while (l<start.length() && r< target.length()){
         
            while (l<start.length()){
               if (l< start.length() && start.charAt(l)=='L' || start.charAt(l)=='R') break;
               l++;
            }

            while (r<target.length()){
                if( r<target.length() && (target.charAt(r)=='L' || target.charAt(r)=='R')) break;
                r++;
            }
           
            if (l<start.length() && r<target.length() && start.charAt(l)!=target.charAt(r)) return   false;
            else if (l<start.length() && r<target.length()){
                if (r>l && start.charAt(l)=='L') return false;
                else if (l>r && start.charAt(l)=='R') return false;
            }
            l++;
            r++;
        }

        return true;
    }
}
