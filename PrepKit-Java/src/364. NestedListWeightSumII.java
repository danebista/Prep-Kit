/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {

    int maxDepth = Integer.MIN_VALUE;

    class Node{

        private NestedInteger ni;
        private int depth;

        public Node(NestedInteger ni, int depth){

            this.ni = ni;
            this.depth = depth;

        }
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {

        int ans = 0;

        for(NestedInteger ni : nestedList)
            dfs(ni, 1);
        
        Queue<Node> queue = new LinkedList();
        for(NestedInteger ni : nestedList){

            queue.offer(new Node(ni,1));

            while(!queue.isEmpty()){

               Node c = queue.poll();               
               if(c.ni.isInteger()){
                   ans += (maxDepth - c.depth + 1)*c.ni.getInteger();
               }else{
                   for(NestedInteger ni2 : c.ni.getList()){
                       queue.offer(new Node(ni2, c.depth + 1));
                   }
               }
            }
        }

        return ans;
        
    }

    private void dfs(NestedInteger curr, int currDepth){

        if(curr.isInteger() || curr.getList().size()==0){
            maxDepth = Math.max(currDepth, maxDepth);
            return;
        }

        for(NestedInteger ni : curr.getList()){
            dfs(ni, currDepth + 1);
        }

    }
}