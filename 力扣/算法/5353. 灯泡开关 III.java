//2020-03-08 11:45:16
class Solution {
    public int numTimesAllBlue(int[] light) {
        int sum=0, target=0, time=0;
        for(int i=0; i<light.length; i++){
            sum += light[i];
            target += i+1;
            if(sum == target){
                time++;
            }

        }
        return time;
    }
}
//2020-03-08 11:56:57