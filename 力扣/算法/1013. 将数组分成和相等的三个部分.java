//2020-03-11 17:51:20
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int time=1, len = A.length-1;
        for(int i=1; i<=len; i++) A[i] += A[i-1];
        if(A[len]%3!=0) return false;
        for(int i=0; i<len && time < 3; i++){

            if(A[i]==(A[len]/3)*time){
                // System.out.println(" " + i);
                time++;
            }
        }

        return time==3;
    }
}
// 2020-03-11 18:16:59