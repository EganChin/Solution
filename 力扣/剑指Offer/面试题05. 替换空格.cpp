//begin at 2020-02-22 10:34:11 

#include <iostream>
#include <string>
#include <map>
using namespace std;

class Solution {
public:
    string replaceSpace(string s) {
    	string str = "";
    	for(auto ch : s){
    		if(ch == ' '){
    			str += "%20";
			}else{
				str += ch;
			}
		}
		return str;
    }
};

int main(){
	string str = "1 23";
	Solution *s = new Solution();
	string result = s->replaceSpace(str);
	cout << result << endl;
	return 0;
}

// finish at 2020-02-22 10:39:30 
