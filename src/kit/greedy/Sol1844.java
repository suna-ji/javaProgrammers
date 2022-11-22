package kit.greedy;

import java.util.LinkedList;
import java.util.Queue;

// 게임 맵 최단거리
// 최단거리니까 bfs
// bfs는 queue!
public class Sol1844 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length]; // 각 칸에 도달하기까지 얼마나 걸렸는지 기록

        bfs(maps, visited); // bfs로 탐색하면서 visited에 기록
        answer = visited[maps.length-1][maps[0].length-1];
        if (answer == 0) { // 도달하지 못했다면 -1을 리턴
            answer = -1;
        }
        return answer;
    }

    public void bfs(int[][] maps, int[][] visited) { // 큐에 넣어가면서 4방향 탐색
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] current = queue.remove();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx > maps.length-1 || ny < 0 || ny > maps[0].length - 1) {
                    continue;
                }
                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) { //그래프 탐색의 경우 어떤 노드를 방문했었는지 여부를 반드시 검사해야 한다. (이를 검사하지 않을 경우 무한루프에 빠질 위험이 있다.)
                    visited[nx][ny] = visited[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) {
        int ma
        Sol1844 sol = new Sol1844();

    }
}
