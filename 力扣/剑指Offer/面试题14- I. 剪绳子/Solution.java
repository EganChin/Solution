//2020-03-16 16:21:59
/*
9%3==0 3*3*3=3^3=27
108%3==1 3*3*3*4=3^3*4=108
11%3==2 3*3*3*2 = 3^3*2
*/
class Solution {
    public int cuttingRope(int n) {
        if(n<=3) return n-1;
        if(n%3==0) return (int)Math.pow(3, n/3);
        if(n%3==1) return (int)Math.pow(3, n/3-1) * 4;
        return (int)Math.pow(3, n/3)*2;
    }
}
//2020-03-16 16:36:15