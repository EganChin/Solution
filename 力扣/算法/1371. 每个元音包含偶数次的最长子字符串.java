//2020-03-09 20:34:04
class Solution {
    public int findTheLongestSubstring(String s) {
        //lenght[i]=元音出现i次时的长度
        int []length = new int[32];
        for(int i=0;i<32;i++)
            length[i] = -10;
        int ans=0, cur=0;
        length[0] = -1;
        for(int i=0; i<s.length();i++){
            switch(s.charAt(i)){
                case 'a':cur^=1;break;
                case 'e':cur^=2;break;
                case 'i':cur^=4;break;
                case 'o':cur^=8;break;
                case 'u':cur^=16;break;
            }
            if(length[cur] == -10) length[cur] = i;
            else{
                ans = Math.max(ans, i-length[cur]);
            }

            //     System.out.print(length[cur]+"-"+i);
            //     if(length[cur]!=-1)
            //         System.out.println(":"+s.charAt(length[cur])+"-"+s.charAt(i));
            //     else
            //         System.out.println("");
        }
        return ans;
    }
}

//2020-03-09 21:05:45