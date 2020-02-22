//begin at 2020-02-22 10:41:35 

#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;



 struct ListNode {
     int val;
     ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    vector<int> reversePrint(ListNode* head) {
    	vector<int> num;
    	while(head){
    		num.push_back(head->val);
    		head = head->next;
		}
		reverse(num.begin(), num.end());
		return num;
    }
    
};

ListNode* add(ListNode* h, int a[], int n){
	h = new ListNode(a[0]);
	ListNode* l = h;
	for(int i=1;i<n;i++){
		ListNode* n = new ListNode(a[i]);
		l->next = n;
		l = l->next;
	}
	return h;
}

int main(){
	vector<int> nums {3,3};
	Solution *s = new Solution();
	ListNode* l = add(l, new int[3]{1,3,2}, 3);
	vector<int> result = s->reversePrint(l);
	for(auto & i : result){
		cout << i << endl;
	}
	return 0;
}

// finish at 2020-02-22 10:54:26 
