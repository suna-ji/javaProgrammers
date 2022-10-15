package level1;
import java.lang.Math;
// 1. 카드를 하나씩 돌면서 긴쪽이 가로로 오게(바닥으로 오게) 회전을 시킨다.
// 2. 그 다음 가로에서 가장 긴거, 세로에서 가장 긴거를 찾아서 둘의 크기로 지갑을 만든다.

public class Sol86491 {

    public int solution(int[][] sizes) {
        int widthMax = 1;
        int heightMax = 1;

        for (int i = 0; i < sizes.length; i++) { // 카드를 하나씩 돌면서
            int width = Math.max(sizes[i][0], sizes[i][1]); // 가로, 세로 중 긴걸 가로가 되게 회전시킴
            int height = Math.min(sizes[i][0], sizes[i][1]); // 가로, 세로 중 짧은걸 세로가 되게 회잔시킴

            if (widthMax < width) {
                widthMax = width;
            }

            if (heightMax < height) {
                heightMax = height;
            }

        }
        // 둘의 크기로 지갑을 만든다.
        return widthMax * heightMax;
    }

    public static void main(String[] args) {
        Sol86491 sol = new Sol86491();
        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(sol.solution(sizes));
    }
}


