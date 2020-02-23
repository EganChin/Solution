//begin at 2020/2/23 12:46:07
class Solution {
    public int[] closestDivisors(int num) {
        int []ans1 = cal(num+1);
        int []ans2 = cal(num+2);
        return Math.abs(ans1[0] - ans1[1]) > Math.abs(ans2[0] - ans2[1]) ? ans2 : ans1;
    }

    int[] cal(int num) {
        int sq = (int) Math.sqrt(num), i;
        if(sq * sq == num)
            return new int[]{sq, sq};
        for (i = sq + 1; i > 0; i--) {
            if (num % i == 0)
                break;
        }
        return new int[]{i, num / i};
    }
}

//finish at 2020-02-23 13:07:08