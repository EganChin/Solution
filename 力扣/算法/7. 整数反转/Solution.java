/*
7. 整数反转 re.0 i E
T: 2020-09-09 10:11:33 - 2020-09-09 17:05:28

Q:给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。如果反转后整数溢出那么就返回 0。

A:参考77.组合，使用dfs通过选当前数和不选当前数两条路线实现搜索回溯。
*/
class Solution {
    public int reverse(int x) {
        char[] str = String.valueOf(x).substring(x<0? 1: 0).toCharArray();
        for(int i=0; i<str.length/2; i++){
            char temp = str[i];
            str[i] = str[str.length-i-1];
            str[str.length-i-1] = temp;
        }
        //System.out.println(String.valueOf(str));
        try{
            String s = x<0? "-"+String.valueOf(str):String.valueOf(str); 
            return Integer.parseInt(s);
        }catch(Exception e){
            return 0;
        }
    }
}
//2020-09-09 10:24:54 a:-10 e:-1 未通过
//2020-09-09 17:05:28 ac