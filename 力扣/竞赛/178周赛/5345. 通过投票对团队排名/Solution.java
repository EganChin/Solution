//2020/3/18 17:12:14
class Solution {
    public String rankTeams(String[] votes) {
        int rankNum = votes[0].length();
        //stat[i][j]代表j队在第i名获得的票数
        int[][] stat = new int[rankNum][26];
        for (int i = 0; i < rankNum; i++)
            for (String v : votes) {
                stat[i][v.charAt(i) - 'A']++;
            }

        //为每一队分配一个数字id
        TreeSet<Integer> ids = new TreeSet<>();
        for (int i = 0; i < rankNum; i++) {
            ids.add(votes[0].charAt(i) - 'A');
        }

        //循环找出当前的第一，然后删除第一的排名数据和id
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rankNum; i++) {
            int index = findMost(stat, 0, ids);
            //清空index队的排名数据
            for (int j = 0; j < rankNum; j++)
                stat[j][index] = 0;
            //删除index队
            ids.remove(index);
            builder.append((char) (index + 'A'));
        }
        return builder.toString();
    }

    private int findMost(int[][] stat, int level, TreeSet<Integer> ids) {
        int top = ids.first();
        if (ids.size() == 1 || level == stat.length)
            return top;

        for (int id : ids) {
            if (stat[level][id] > stat[level][top]) top = id;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int id : ids) {
            //如果该字母最大排名的票数最多，将其加入队列中
            if (stat[level][id] == stat[level][top]) {
                set.add(id);
            }
        }
        return findMost(stat, level + 1, set);
    }

}
//2020-03-18 18:25:05