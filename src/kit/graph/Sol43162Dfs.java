package kit.graph;
// 네트워크 개수 구하기
// 이전에 BFS로 푼적이 있는데 DFS로도 풀어보려고 한다.
// 간선으로 이동할 수 있는 노드들은 1로 계산하고 각각 하나의 노드들도 1로 계산해서 더하는 문제
public class Sol43162Dfs {

    static boolean visit[];

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];

        for(int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(computers, i, n); // dfs가 한번 돌때 1증가 (연결된 노드들은 다 방문해야 dfs가 끝나기 때문에 하나의 네트워크로 계산할수가 있는거임)
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int[][] computers, int i, int n) {
        visit[i] = true;
        for (int j = 0; j < n; j++) {
            if(!visit[j] && computers[i][j] == 1) {
                dfs(computers, j, n); // 만약 i노드와 j노드가 연결되어 있다면 dfs를 또 한다.
            }
        }
    }

    public static void main(String[] args) {
        Sol43162Dfs sol = new Sol43162Dfs();
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(sol.solution(n, computers));
    }
}