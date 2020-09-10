/*
9. 回文数 re.0 i E
T: 2020-09-10 15:06:18 - 2020-09-10 15:09:43

Q:判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

A:略
*/
class Solution {
    public boolean isPalindrome(int x) {
        char[] str = String.valueOf(x).toCharArray();
        int len = str.length;
        for(int i=0; i<len/2; i++){
            if(str[i] != str[len-i-1]) return false;
        }
        return true;
    }
}
//2020-09-10 15:09:43 41.03% 53.96%