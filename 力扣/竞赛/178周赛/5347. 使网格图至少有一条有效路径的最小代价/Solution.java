import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// begin at 2020/3/1 13:36
class Solution {
    public Integer minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int direct[][] = new int[][]{{}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean visit[][] = new boolean[m][n];

        Queue<Tuple> queue = new PriorityQueue<>();
        queue.add(new Tuple(0, 0, 0));
        while (queue.size() != 0) {
            Tuple t = queue.poll();
            ;
            if (visit[t.x][t.y]) continue;
            visit[t.x][t.y] = true;
            if (t.x == m - 1 && t.y == n - 1)
                return t.cost;
            for (int i = 1; i <= 4; i++) {
                int dx = direct[i][0] + t.x, dy = direct[i][1] + t.y;
                if (dx >= 0 && dx < m && dy >= 0 && dy < n && !visit[dx][dy]) {
                    if (grid[t.x][t.y] == i) {
//                        System.out.println( "(" + t.x + "," + t.y +")->" + "(" + dx + "," + dy +") 不改变");
                        queue.add(new Tuple(dx, dy, t.cost));
                    } else {
//                        System.out.println( "i=" + i +" (" + t.x + "," + t.y +")->" + "(" + dx + "," + dy +") 改变");
                        queue.add(new Tuple(dx, dy, t.cost + 1));
                    }
                }

            }
        }
        return -1;
    }

    static class Tuple implements Comparable<Tuple> {
        Integer x, y, cost;

        public Tuple(Integer x, Integer y, Integer cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Tuple o) {
            return cost.compareTo(o.cost);
        }
    }

    public static void main(String[] args) {
        System.out.printf(new Solution().minCost(new int[][]{{1, 1, 3}, {3, 2, 2}, {1, 1, 4}}).toString());
    }
}

// finish at 2020/3/1 14:26