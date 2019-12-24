#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
    	int max=0;
    	map<char,int> m;
    	//����ָ�뷨
        for(int l=0,r=0; l<s.size() && r<s.size(); r++){
        	//�����ָ�뷢�ֵ�ǰԪ���Ѵ��ڣ��ж����Ƿ��ڱ����䣬������� 
        	if(m.find(s[r]) != m.end()){
        		l = l < m[s[r]] ? m[s[r]]: l;
			}
			//������󳤶ȣ�Ϊ�˼��㳤��1���ַ������˴���1 
			max = max < r-l+1 ? r-l+1 : max;
			//��Ϊ��һ����һ��������ָ��λ��ҲҪ��һ 
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
