package kit.graph;

import java.util.*;

// 항상 ICN 공항에서 출발합니다 -> ICN찾아서 bfs시작.
// 경로가 2개 이상 존재할때, 알파벳 순서로 리턴
// answer에 더한 후 정렬해서 가장 처음거를 리턴
public class Sol43164 {

    private static boolean[][] visited;
    Queue<String> queue = new LinkedList<>();
    ArrayList<String> answer;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length][2];
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            else {
                return o1[0].compareTo(o2[0]);
            }
        });
        answer = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i][0] && tickets[i][0].equals("ICN")) {
                visited[i][0] = true;
                answer.add(tickets[i][0]);
                bfs("ICN", tickets);
                break;
            }
        }
        return answer.toArray(new String[0]);
    }

    public void bfs(String deperture, String[][] tickets) {
        queue.offer(deperture);
        while(!queue.isEmpty()) {
            String cn = queue.poll();
            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i][1] && tickets[i][0].equals(cn)) {
                    visited[i][1] = true;
                    answer.add(tickets[i][1]);
                    queue.add(tickets[i][1]);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Sol43164 sol = new Sol43164();

        String[][] tickets1 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        String[][] tickets2 = {{"ICN", "A"}, {"A", "B"}, {"A", "C"}, {"C", "A"}, {"B", "D"}};

        System.out.println(sol.solution(tickets2));
    }
}
