// begin at 2020-02-28 09:47:01
class Solution {
    public boolean isPalindrome(String s) {

        s = s.toUpperCase();
        char []str = s.toCharArray();
        int left = 0, right = str.length-1;
        while(left<right){
            if(isValid(str[left])){
                if(isValid(str[right])){
                    if(str[left] != str[right]){
                        return false;
                    }else{
                        left++;
                        right--;
                    }
                }else{
                    right--;
                }
            }else{
                left++;
            }
        }
        return true;
    }

    public boolean isValid(char ch){
        return (ch>='0' && ch <= '9') || (ch>='A' && ch <='Z');
    }
}
//finish at 2020-02-28 10:37:09