package level1;
// 탐욕법 (부분적인 최적해가 전체적인 최적해가 되는 문제, 미리 정한 기준에 따라 매번 가장 좋아보이는 다을 선택)
// 미래를 생각하지 않고 각 단계에서 가장 최선의 선택을 하는 기법
// todo reverse에 있는 학생 앞뒤의 학생에게 빌려주기 (각 단계에서 가장 최선의 선택)
// 체육복
public class Sol42862 {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
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
        int[] lost = {1, 2};
        int[] reverse = {2, 3};
        System.out.println(sol.solution(5, lost, reverse));
    }
}
