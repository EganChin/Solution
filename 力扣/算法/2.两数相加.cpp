#include <iostream>
#include <vector>
#include <map>
using namespace std;



 struct ListNode {
     int val;
     ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* r = NULL, *h;
        int b = 0;
        while(l1 && l2){
        	int x = l1->val + l2->val + b;
			b = x/10,x = x%10; 
			ListNode* n = new ListNode(x);
			if(!r){
				h = r = n;
			}else{
				h->next = n;
				h = h->next;
			}
			l1 = l1->next;
			l2 = l2->next;
		}
		while(l1){
			int x = l1->val + b;
			b = x/10,x = x%10; 
			ListNode* n = new ListNode(x);
			h->next = n;
			h = h->next;	
			l1 = l1->next;		
		}
		while(l2){
			int x = l2->val + b;
			b = x/10,x = x%10; 
			ListNode* n = new ListNode(x);
			h->next = n;
			h = h->next;	
			l2 = l2->next;		
		}
		if(b){
			ListNode* n = new ListNode(b);
			h->next = n;
		}
		return r;
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
	ListNode* l1 = add(l1, new int[1]{1}, 1);
	ListNode* l2 = add(l2, new int[2]{9,9}, 2);
	ListNode* result = s->addTwoNumbers(l1, l2);
	while(result){
		cout << result->val << endl;
		result = result->next;
	}
	return 0;
}

