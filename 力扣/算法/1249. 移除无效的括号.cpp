//
// Created by Administrator on 2019/12/26.
//

// begin at 2019/12/26 14:58

#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string minRemoveToMakeValid(string s) {
        int left = 0, right = 0;
        for(int i=0; i<s.size(); i++){
        	if(s[i] == ')') {
                if(left > 0) left-=1;
                else s.erase(i--, 1);
            }else if(s[i] == '('){
            	left++;
			}
		}
		
		if(left > 0){
			for(int i=s.size()-1; i>=0; i--){
				if(s[i] == '('){
					if(right>0) right-=1;
					else{
						s.erase(i, 1);
					}
				}else if(s[i] == ')'){
					right++;
				}
			}
		}
		return s;
    }
};

int main(){
	Solution *s = new Solution();
	string result = s->minRemoveToMakeValid("))((");
	cout << result;
	return 0;
}

// finish at 2019/12/26 16:04