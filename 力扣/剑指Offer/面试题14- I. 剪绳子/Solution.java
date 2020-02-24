/**
 * @author Egan
 * @date 2020/2/24 10:19
 **/

// begin at 2020/2/24 10:38
class Solution {
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        if(n%3==0) return (int) Math.pow(3, n/3);
        if(n%3==1) return (int) Math.pow(3, n/3-1) * 2 * 2;
        return (int) (Math.pow(3, n/3) * 2);
    }
}
// finish at 2020/2/24 10:47