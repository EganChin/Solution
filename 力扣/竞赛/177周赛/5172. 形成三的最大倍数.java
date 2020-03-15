//2020-03-15 17:30:43
/*
8+1+9 == 18
18%3 == 0，任意数组合可模三为零
8+1+9+2 % 3 == 2, 去掉一个2可模三为零
8+1+1+1+9 % 3 == 2，去掉两个1可模三为零
8+1+1+9 % 3 == 1，去掉一个1可模三为零
2+2+9+9 % 3 == 1，去掉两个2可模三为零

得出结论：
模三为零时，不需要处理
模三为2时，去掉两个1或一个2
模三为1时，去掉两个2或一个1
*/
class Solution {
    int []cnt = new int[10];

    private boolean delete(int x){
        //如果目标不存在，跨三删除下一个
        for(int i=x; i<=9; i+=3){
            if(cnt[i] != 0){
                cnt[i]--;
                return true;
            }
        }
        return false;
    }

    public String largestMultipleOfThree(int[] digits) {
        int sum = 0;
        for(int i: digits){
            sum+=i;
            cnt[i]++;
        }
        if(sum == 0) return "0";
        if(sum%3==2){
            if(!delete(2)){
                delete(1);
                delete(1);
            }
        }
        if(sum%3==1){
            if(!delete(1)){
                delete(2);
                delete(2);
            }
        }
        String ans = "";
        for(int i=9; i>=0; i--){
            while(cnt[i]-- != 0){
                ans+=i;
            }
        }
        return ans;
    }
}
//2020-03-15 17:49:25