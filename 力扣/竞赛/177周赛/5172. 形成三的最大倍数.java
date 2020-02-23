// begin at 2020/2/23 13:10
/*
如果数组和模三为零，则说明可以任意组成三的倍数
如果余2，去掉一个2或两个1使其模三为零
如果与1，去掉一个1或两个2使其模三为零
*/
class Solution {
    private int []cnt = new int[10];
    boolean delete( int x){
        for(int i=x; i<=9; i+=3)
            //没有目标数，就跨三删除下一个，结果一致
            if(cnt[i] != 0){
                cnt[i]--;
                return true;
            }
        return false;
    }
    public String largestMultipleOfThree(int[] digits) {
        int sum = 0;
        for(int i : digits){
            cnt[i]++;
            sum += i;
        }
        if(sum == 0)
            return "0";
        if(sum%3 == 2){
            if(!delete(2)){
                delete(1);
                delete(1);
            }
        }
        if(sum%3 == 1){
            if(!delete(1)){
                delete(2);
                delete(2);
            }
        }
        String ans = "";
        for(int i=9; i>=0; i--){
            while(cnt[i] != 0){
                ans += i;
                cnt[i]--;
            }
        }
        return ans;
    }
}

// finish at 2020/2/23 13:41
