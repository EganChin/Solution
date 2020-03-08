//2020-03-08 11:33:18
class Solution {
    public String generateTheString(int n) {
        String ans = "";
        int i=0;
        while(i++ < n){
            ans+='a';
            if(i%2!=0 && (n-i)%2!=0){
                break;
            }
        }
        for( ;i<n;i++){
            ans+='b';
        }
        return ans;
    }
}
//2020-03-08 11:43:21