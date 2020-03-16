//2020-03-16 16:51:04
/*
F(1) = 1
F(2) = F(1) * C(2, 4)
F(3) = F(2) * C(2,6)
F(n) = F(n-1) * C(2, 2*n)
     = F(n-1) * 2n!/2!(2n-2)! = F(n-1) * (2n-1)2n/2 = F(n-1) * 4n^2-2n/2
     = F(n-1) * n(2n-1)
*/
class Solution {
    public int countOrders(int n) {
        long ans = 1;
        for(int i=2; i<=n; i++){
            ans = (ans*i*(2*i-1)) % 1000000007;
        }
        return (int)ans;
    }
}
//2020-03-16 17:02:54