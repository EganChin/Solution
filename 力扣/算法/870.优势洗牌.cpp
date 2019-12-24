#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;
struct Node{
	int value;
	int index;
	Node(int v, int i){
		value = v;
		index = i;
	}
};
int cmp(Node n1, Node n2){
	return n1.value < n2.value;
}
class Solution {
public:
    vector<int> advantageCount(vector<int>& A, vector<int>& B) {
        vector<Node> b;
        for(int i=0; i<B.size(); i++)
        	b.push_back(Node(B.at(i), i));
		sort(b.begin(), b.end(), cmp);
		sort(A.begin(), A.end());
		int first = 0, last = b.size() - 1;
		//�������������Сֵ�Ƚ϶Է���Сֵ������������滻������Ƚ϶Է����ֵ 
		for(auto &i : A){
			Node node = b.at(first);
			if(i>node.value){
				B[node.index] = i;
				//ע��˴�����Ҫ�ƶ�ָ�� 
                first++;
            	//erase��ʱ���������׳�ʱ������˫ָ�� 
				// b.erase(b.begin());
			}else{
				B[b.at(last--).index] = i;
				// b.erase(b.end());
			}
		}
		return B;
    }
};

int main(){

	Solution *s = new Solution();
	vector<int> a {12,24,8,32};
	vector<int> b {13,25,32,11};
	vector<int> result = s->advantageCount(a, b);
	for(auto & i : result){
		cout << i << endl;
	}
	return 0;
}
