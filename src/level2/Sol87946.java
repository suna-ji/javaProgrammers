package level2;
// 최소 피로도와 소모 피로도가 있다.
// 최대한 많은 던전을 탐험하려고 한다.
// 유저가 탐험할 수 있는 최대 던전 수를 구하라.
public class Sol87946 {
    public int answer = -1;
    public boolean[] visit;

    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }

    public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && dungeons[i][0] <= k) {
                visit[i] = true;
                dfs(depth + 1, k-dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        answer = Math.max(answer,depth);
    }


    public static void main(String[] args) {
        Sol87946 sol = new Sol87946();
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int k = 80;
        System.out.println(sol.solution(k, dungeons));
    }
}

// 모든 경우의 수로 던전을 방문하는 방법?
// 모든 조합을 구하는 순열을 이용!
// dfs로 모든 경우의 수를 탐색 (재귀)

