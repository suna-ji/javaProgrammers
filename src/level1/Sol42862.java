package level1;

import java.util.Arrays;

// 탐욕법 (부분적인 최적해가 전체적인 최적해가 되는 문제, 미리 정한 기준에 따라 매번 가장 좋아보이는 다을 선택)
// 미래를 생각하지 않고 각 단계에서 가장 최선의 선택을 하는 기법
// todo reverse에 있는 학생 앞뒤의 학생에게 빌려주기 (각 단계에서 가장 최선의 선택)
// 체육복
public class Sol42862 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
//        Arrays.sort(lost);
//        Arrays.sort(reserve);
        // todo 여벌 체육복을 가져온 학생이 도난 당한 경우 lost와 reverse에서 제거
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }
        int count = 0;
        // todo reverse앞뒤에 있다면 lost에서 제거
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    lost[i] = -1;
                    reserve[j] = -1;
                }
            }
        }
        // todo: n - lost의 개수
        int newLost = 0;
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] != -1) {
                newLost++;
            }
        }
        return n - newLost;
    }

    public static void main(String[] args) {
        Sol42862 sol = new Sol42862();
        int[] lost = {2, 4};
        int[] reverse = {3, 1};
        System.out.println(sol.solution(5, lost, reverse));
    }
}

// sort 하지 않을 때 13, 18 테스트케이스에서 실패했다.
// 왜 sort가 필요한지 찾아보았고 반례를 찾을 수 있었다.
// n = 5, lost = [2, 4], reserve = [3, 1] 정답: 5
// 1번 학생이 2번에게, 3번 학생이 4번에게 빌려줘서 모두가 수업에 참여할 수 있다는게 정답인데
// sort가 없는 내 코드에서는 기본적으로 앞에 학생부터 필요한지 확인하기 때문에
// 3 -> 2번에게 빌려주게 된다.