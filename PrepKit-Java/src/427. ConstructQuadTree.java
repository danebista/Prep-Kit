/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return constructTree(grid, 0,0, grid.length);
    }

    public Node constructTree(int[][] grid, int x, int y, int size){
        Node curr = new Node();
        if (isLeaf(grid, x, y, size)){
            curr.isLeaf = true;
            curr.val = grid[x][y]==1? true: false;
            
            return curr;
        }
        curr.val = true;
        curr.topLeft= constructTree(grid, x, y, size/2);
        curr.topRight = constructTree(grid, x, y+size/2, size/2);
        curr.bottomLeft = constructTree(grid, x+size/2, y, size/2);
        curr.bottomRight = constructTree(grid, x+size/2,y+size/2, size/2);

        return curr;

    }

    public boolean isLeaf(int[][]grid, int x, int y, int size){
        int initial = grid[x][y];
        if (size==1) return true;
        for (int i=x; i< x+size; i++){
            for (int j=y; j<y+size; j++){
                if (grid[i][j]!=initial) return false;
            }
        }

        return true;
    }
}
