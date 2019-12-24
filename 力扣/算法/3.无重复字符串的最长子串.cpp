#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
    	int max=0;
    	map<char,int> m;
    	//左右指针法
        for(int l=0,r=0; l<s.size() && r<s.size(); r++){
        	//如果右指针发现当前元素已存在，判断它是否在本区间，在则更新 
        	if(m.find(s[r]) != m.end()){
        		l = l < m[s[r]] ? m[s[r]]: l;
			}
			//更新最大长度，为了计算长度1的字符串，此处加1 
			max = max < r-l+1 ? r-l+1 : max;
			//因为上一处加一，所以右指针位置也要加一 
			m[s[r]] = r+1;
		}
		return max;
    }
};

int main(){
	
	Solution *s = new Solution();
	string str = "a";
//	string str = "aab";
//	string str = "pwwkew";
	int len = s->lengthOfLongestSubstring(str);
	printf("%d\n", len);
	return 0;
}
