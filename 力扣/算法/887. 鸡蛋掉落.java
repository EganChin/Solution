//2020-03-16 17:49:18
class Solution {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int superEggDrop(int K, int N) {
        if(N==0) return 0;
        if(K==1) return N;
        int key = N*1000 + K;
        if(!memo.containsKey(key)){
            int high = N, low = 1;
            while(low+1<high){
                int mid = (low+high)/2;
                int broken = superEggDrop(K-1, mid-1);
                int unbroken = superEggDrop(K, N-mid);
                if(broken < unbroken){
                    low = mid;
                }else if(broken > unbroken){
                    high = mid;
                }else{
                    low = high = mid;
                }
            }
            memo.put(key, 1+Math.min(
                Math.max(superEggDrop(K-1, low-1), superEggDrop(K, N-low)),
                Math.max(superEggDrop(K-1, high-1), superEggDrop(K, N-high))
            ));
            // System.out.println("put:" + key+":"+memo.get(key));
        }
        // System.out.println("get:" + key+":"+memo.get(key));
        return memo.get(key);
    }
}
//2020-03-16 18:10:52