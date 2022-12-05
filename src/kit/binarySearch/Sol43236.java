package kit.binarySearch;

import java.util.Arrays;
// 징검다리
// https://school.programmers.co.kr/learn/courses/30/lessons/43236?language=java
// 출발지에서 distance만큼 떨어진곳에 도착지점이 있습니다.
// 그 사이에는 바위들이 놓여있습니다.
// 바위 중 몇개를 제거하려고 합니다.
// 바위 n개를 제거한 후 각 지점 사이의 거리의 최솟값 중 가장 큰 값을 return하세요.
// 이분 탐색 대상: 바위 사이의 간격 중 최솟값
public class Sol43236 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int min = 0;
        int max = distance;
        while(min <= max) {
            int mid = (min + max) / 2;
            if (check(rocks, mid, distance, n)) {
                min = mid + 1; // 간격 중 최솟값을 더 키울 수 있다.
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        return answer;
    }
    // 바위를 제거해보자.
    // 제거한 바위 개수가 n개를 초과하면 false를 리턴한다.
    // 바위를 제거한 후 바위 사이의 간격이 mid를 초과하게 된다면 해당 바위는 제거하지 않는다.
    private boolean check(int[] rocks, int mid, int distance, int n) {
        int start = 0;
        int end = distance;
        int removeCnt = 0;
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - start < mid) {
                removeCnt++;
                continue;
            }
            start = rocks[i];
            if (removeCnt > n) {
                return false;
            }
        }
        if (end - start < mid) {
            removeCnt++;
        }
        if (removeCnt > n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Sol43236 sol = new Sol43236();
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        System.out.println(sol.solution(distance, rocks, n));
    }
}
