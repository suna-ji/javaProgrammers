package level2;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.LinkedList;
import java.util.Queue;

// n개의 송전탑이 하나의 트리 형태로 연결되어 있다.
// 전선 중 하나를 끊어서 2개로 분할하려고 한다.
// 두 전력망이 갖게되는 송전탑 개수를 최대한 비슷하게 맞추려고한다.
// 이때 두 송전탑 개수의 차이를 구하세요.
// 전선 끊고 -> 송전탑 개수 구하고 -> 최소개수 업데이트하기
public class Sol86971 {
    int[][] map;

    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n+1][n+1];

        // 송전탑 연결 정보를 map에 넣기
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            // 송전탑 끊고
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 0;
            map[b][a] = 0;

            // 끊긴부분의 송전탑 개수 구하고 최소값 갱신
            answer = Math.min(answer, bfs(n, i + 1));

            // 송전탑 다시 연결하고
            map[a][b] = 1;
            map[b][a] = 1;
        }
        return answer;

    }

    // 연결된 송전탑의 개수를 구함
    private int bfs(int n, int start) {
       int cnt = 1;
       Queue<Integer> queue = new LinkedList<>();
       boolean[] checked = new boolean[n+1];
       queue.add(start);
       checked[start] = true;
       while(!queue.isEmpty()) {
           int now = queue.poll();
           for (int i = 1; i < n + 1; i++) {
               if (map[now][i] == 1 && !checked[i]) {
                   cnt++;
                   queue.add(i);
                   checked[i] = true;
               }
           }
       }
       return Math.abs(n - 2 * cnt);
    }

    public static void main(String[] args) {
        Sol86971 sol = new Sol86971();
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(sol.solution(9, wires));
    }
}
