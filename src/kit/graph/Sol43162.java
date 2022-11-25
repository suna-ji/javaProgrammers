package kit.graph;

import java.util.LinkedList;
import java.util.Queue;

// 어려웠음
public class Sol43162 {
    private static Queue<Integer> queue = new LinkedList<>();
    private static boolean visit[];

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                bfs(i, computers, n);
                answer += 1;
            }
        }
        return answer;
    }


    private void bfs(int i, int[][] computers, int n) {
        queue.offer(i);
        while(!queue.isEmpty()) {
            int cn = queue.poll();
            for (int j = 0; j < n; j++) {
                if (!visit[j] && computers[cn][j] == 1) {
                    queue.offer(j);
                    visit[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Sol43162 sol = new Sol43162();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(sol.solution(n, computers));
    }
}
