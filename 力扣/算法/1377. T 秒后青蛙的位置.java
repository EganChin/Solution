//2020-03-09 19:27:19
class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        int []father = new int[n+1], sonNum = new int[n+1];
        int targetCount=0;
        for(int []e : edges){
            int f = Math.min(e[0], e[1]), s = Math.max(e[0], e[1]);
            //判断目标是否有后继
            if(f==target || s==target)
                targetCount++;
            father[s] = f;
            sonNum[f]++;
        }
        double ans = 1.0;
        int index = target,  count=0;
        while(father[index]>0){
            index = father[index];
            ans /= sonNum[index];
            count++;

        }
        if((count<t && targetCount==1 && target!=1) || t==count || edges.length==0)
            return ans;
        return 0.0;
    }
}
//2020-03-09 20:32:54