package level2;

// 중앙에는 노란색 테두리 1줄은 갈색
// 가로 세로의 크기를 순서대로 배열에 담아 리턴.
// (가로 - 2) * (세로 - 2) = 노랑
// (가로) * (세로) - 노랑 = 브라운
// 근데 가로 세로 후보를 어떤식으로 구하지..? for문의 크기 설정이 어렵다..
public class Sol42842 {

    public int[] solution(int brown, int yellow) {
        for (int i = brown; i > 0; i--) {
            for (int j = brown; j > 0; j--) {
                if ((i-2) * (j-2) == yellow && i * j - yellow == brown) {
                    int[] answer = new int[]{i, j};
                    return answer;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Sol42842 sol = new Sol42842();
        int[] ans = sol.solution(8,1);
        System.out.println(ans[0] + ":" +ans[1]);

    }
}
