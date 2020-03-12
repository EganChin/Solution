//2020-03-12 22:36:02
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        String max = str1.length() >= str2.length() ? str1 : str2;
        String min = str1.length() < str2.length() ? str1 : str2;
        return max.substring(0,  gcd(max.length(), min.length()));
    }

    int gcd(int a, int b){
        if(b==0)
            return a;
        return gcd(b, a%b);
    }
}
//2020-03-12 22:54:11