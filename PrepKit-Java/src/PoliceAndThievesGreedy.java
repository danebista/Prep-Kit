public class PoliceAndThievesGreedy {
    { 
        static int catchThieves(char arr[], int n, int k) 
        { 
            // Code here
            int count=0;
        
            for (int i=0; i<arr.length; i++){
                if (arr[i]=='P'){
                    int low=Math.max(0, i-k);
                    int high=Math.min(i+k, arr.length-1);
                    for (int j=low; j<=high; j++){
                        if (arr[j]=='T') {
                            arr[j]='$';
                            count++;
                            break;
                        }
                    }
                }
            }
            
            return count;
        } 
    }
}
