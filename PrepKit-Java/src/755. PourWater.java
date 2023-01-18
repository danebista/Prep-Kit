public class Solution {
    /**
     * @param heights: the height of the terrain
     * @param v: the units of water
     * @param k: the index
     * @return: how much water is at each index
     */
    public int[] pourWater(int[] heights, int v, int k) {
        // Write your code here
        for (int i=0; i<v; i++){
            int leftIndex= findLeftIndex(heights, k);
            int rightIndex= findRightIndex(heights, k);
            if (leftIndex!= k){
                heights[leftIndex]++;
            }
            else if (rightIndex!=k){
                heights[rightIndex]++;
            }
            else{
                heights[k]++;
            }
        }
        return heights;
    }
    
    public int findLeftIndex(int[] heights, int k){
        int currentHeight = heights[k];
        int currIndex = k;
        for (int i=k-1; i>=0; i--){
            if (heights[i]< currentHeight){
                currIndex = i;
                currentHeight = heights[i];
            }
            else if (heights[i]> currentHeight){
                break;
            }
        }
        return currIndex;
    }

     public int findRightIndex(int[] heights, int k){
        int currentHeight = heights[k];
        int currIndex = k;
        for (int i=k+1; i<heights.length; i++){
            if (heights[i] < currentHeight){
                currIndex = i;
                currentHeight = heights[i];
            }
            else if (heights[i]> currentHeight){
                break;
            }
        }
        return currIndex;
    }

}
