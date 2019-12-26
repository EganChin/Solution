//
// Created by Administrator on 2019/12/26.
//

// begin at 2019/12/26 17:06

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
    ListNode *detectCycle(ListNode *head) {
    	if(!head|| !head->next)
    		return NULL;
    	ListNode* inter = getIntersect(head), *h = head;
    	if(!inter)
    		return inter;
    	while(inter != h){
    		inter = inter->next;
    		h = h->next;
		}
		return inter;
    }
    
    ListNode *getIntersect(ListNode* head){
    	ListNode* fast=head, *slow = head;
    	while(fast && fast->next){
    		fast = fast->next->next;
    		slow = slow->next;
    		if(fast == slow){
    			return fast;
			}
		}
		return NULL;
	}
};

ListNode* add(ListNode* h, int a[], int n, int pos){
    h = new ListNode(a[0]);
    ListNode* l = h;
    ListNode* p = NULL;
    for(int i=1;i<n;i++){
        ListNode* n = new ListNode(a[i]);
        l->next = n;
        l = l->next;
        if(i==pos){
        	p = l;
		}


    }
    if(pos==0){
    	p = h;
	}
    l->next = p;
    return h;
}

int main(){
    Solution *s = new Solution();
    ListNode* l1 = add(l1, new int[10]{-1,-7,7,-4,19,6,-9,-5,-2,-5}, 10, 6);
    ListNode* result = s->detectCycle(l1);
    cout << result->val << endl;
    return 0;
}

// finish at 2019/12/26 17:32 (map)
// finish at 2019/12/26 17:44 (floyd)