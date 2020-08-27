//2020-08-27 09:51:03
class Solution {
    public boolean isPalindrome(String s) {
        char str[] = s.toUpperCase().toCharArray();
        int left = 0, right = str.length-1;
        while(left < right){
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

    private boolean isValid(char ch){
        return (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
}
//2020-08-27 09:57:08