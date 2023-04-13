class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int[]value = new int[10];
        int hr1=-1;
        int hr2=-1;
        int min1=-1;
        int min2=-1;
        for (int a: arr){
            value[a]++;
        }
        // cases like 07:26 caused me problems cause my code tried to make 20: first;
        int count =0;
        for (int i=6; i<=9; i++){
            count+=value[i];
        }

    
        if (value[2]>0 && count<=1){
            System.out.println(count);
            hr1=2;
            value[2]-=1;
    
            for (int i=3; i>=0; i--){
                if (value[i]>0){
                    hr2=i;
                    value[i]-=1;
                    break;
                }
            }
        }
        else if (value[1]>0){
               
            hr1=1;
            value[1]-=1;
            for (int i=9; i>=0; i--){
                if (value[i]>0){
                    hr2=i;
                    value[i]-=1;
                    break;
                }
            }
        }
        else if (value[0]>0){
            System.out.println("hello");
            hr1=0;
            value[0]-=1;
            for (int i=9; i>=0; i--){
                if (value[i]>0){
                    hr2=i;
                    value[i]-=1;
                    break;
                }
            }
        }
        else return "";

        for (int i=5; i>=0; i--){
            if (value[i]>0){
                min1=i;
                value[i]-=1;
                break;
            }
        }
        for (int i=9; i>=0; i--){
            if (value[i]>0){
                min2=i;
                value[i]-=1;
                break;
            }
        }

        if (hr1!=-1 && hr2!=-1 && min1!=-1 && min2!=-1) return ""+hr1+hr2+":"+min1+min2;
        else return "";
    }
}


/// Better solution from better people


class Solution {
    int max=0;
    public String largestTimeFromDigits(int[] arr) {
        boolean[] finals = new boolean[arr.length];
        permutation(arr, finals,0, 0);
        
        if (max==0){
           int count=0;
           for (int i=0; i< arr.length; i++){
               if (arr[i]==0)count++;
           }
           if (count==4) return "00:00";
           else return "";
        }

        StringBuilder strs=new StringBuilder();
        strs.append(max/1000);
        max=max%1000;
        strs.append(max/100);
        max=max%100;
        strs.append(":");
        strs.append(max/10);
        max=max%10;
        strs.append(max);
        
        return strs.toString();
    }

    public void permutation(int[]arr, boolean[]finals, int index, int permutation){
        if (index>=arr.length){
            if(permutation<2399 && permutation%100<60){
                max = Math.max(permutation, max);
            }
            return;
        }

        for (int i=0; i< arr.length; i++){
            if (finals[i]!=true){
                finals[i]=true;
                permutation(arr, finals, index+1, permutation*10+arr[i]);
                finals[i]=false;
            }
        }
    }
}
