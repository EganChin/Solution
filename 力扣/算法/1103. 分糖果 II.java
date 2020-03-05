// begin at 2020-03-05 13:35:27
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int round = candies/(num_people + (num_people*(num_people-1)/2));
        int []ans = new int[num_people];
        for(int i=1;;i++){
            if(candies < i){
                ans[(i-1)%num_people] += candies;
                break;
            }
            ans[(i-1)%num_people] += i;
            candies -= i;
        }
        return ans;
    }
}

// finish at 2020-03-05 13:56:21