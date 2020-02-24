// begin at 2020/2/24 11:11
/**
 * n = 1，F(1)=1
 * n = 2, F(2)=1*C(2, 4)
 * n = 3, F(3)=1*C(2, 4)*C(2, 6)
 * n = 4, F(4)=1*C(2, 4)*C(2, 6)*C(2, 8)
 * F(n) = F(n-1)*C*(2,2n) = F(n-1)*n*(2*n-1)
 **/
class Solution {
    public int countOrders(int n) {
        long cnt = 1;
        for(int i=1;i<=n; i++){
            cnt = (cnt * i * (2*i-1)) % 1000000007;
        }
        return (int)cnt;
    }
}

// finish at 2020/2/24 11:28