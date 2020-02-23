// begin at 2020-02-23 10:30:45
class Solution {
    public int daysBetweenDates(String date1, String date2){
        return Math.abs(getDay(date2) - getDay(date1));
    }

    public int getDay(String date){
        String d[] = date.split( "-");
        int year = Integer.parseInt(d[0]), month = Integer.parseInt(d[1]), day = Integer.parseInt(d[2]);
        int m[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(isLeap(year)){
            m[2]++;
        }
        for(int i=0; i<year; i++){
            if(isLeap(i)) day += 366;
            else day += 365;
        }
        for(int i=0; i<month; i++){
            day += m[i];
        }
        return day;
    }

    public boolean isLeap(int year){
        return (year%4==0 && year%100!=0) || year%400 == 0;
    }
}
// finish at 2020-02-23 11:12:31