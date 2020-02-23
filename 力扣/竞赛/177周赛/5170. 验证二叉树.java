//begin at 2020/2/23 11:14:18
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] father = new int[n+10];
        for(int i=0; i<n; i++){
            father[i] = -1;
        }
        for(int i=0; i<n; i++){
            if(leftChild[i] != -1){
                if(father[leftChild[i]] != -1) return false;
                father[leftChild[i]] = i;
                if(i == father[father[leftChild[i]]] ) return false;
            }
            if(rightChild[i] != -1){
                if(father[rightChild[i]] != -1) return false;
                father[rightChild[i]] = i;
                if(i== father[father[rightChild[i]]] ) return false;
            }
            if(father[i] != -1 && i == father[father[i]]) return false;
        }
        for(int i=0, root = 0; i<n; i++){
            if(father[i] == -1)
                root++;
            if(root > 1)
                return false;
        }
        return true;
    }
}

//finish at 2020/2/23 12:12:45