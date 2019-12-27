//
// Created by Administrator on 2019/12/27.
//

// begin at 2019/12/27 16:39
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
    ListNode* removeZeroSumSublists(ListNode* head) {
    	map<int, ListNode*> m;
    	
    	ListNode* h = new ListNode(0);
    	h->next = head;
    	ListNode* l = h;
    	
    	int sum=0;
    	while(l){
    		sum+=l->val;
    		m[sum] = l;
    		printf("%d:%d\n", sum, m[sum]->val);
    		l = l->next;
		}
		
    	l = h;
    	sum = 0;
		while(l){
			sum += l->val;
			l->next = m[sum]->next;
			printf("%d->",l->val);
			l = l->next;
		}
		printf("\n");
    	return h->next;
    }
};

ListNode* add(int a[], int n){
    ListNode* h = new ListNode(a[0]);
    ListNode* l = h;
    for(int i=1;i<n;i++){
        ListNode* n = new ListNode(a[i]);
        l->next = n;
        l = l->next;
    }
    return h;
}

int main(){

    Solution *s = new Solution();
    ListNode* l = add(new int[5]{-1,1,-2,-1}, 4);
    ListNode* result = s->removeZeroSumSublists(l);
    while(result){
        cout << result->val << endl;
        result = result->next;
    }
    return 0;
}

// finish at 2019/12/27 17:24