package level2;

// 조이스틱으로 알파벳 이름을 완성하세요.
// 만들고자 하는 이름이 주어질 때. 이름에 대한 조이스틱 조작 횟수의 최대값을 구하세요.
// 위 : 다음 알파벳
// 아래: 이전 알파벳
// 왼:  커서를 왼쪽으로 이동
// 오: 커서를 오른쪽으로 이동
// JAZ : 9번 조작 A ->(9번위로) J -> (커서 왼)JA -> ㅋ
public class Sol42860 {
    public int solution(String name) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Sol42860 sol = new Sol42860();
        System.out.println(sol.solution("JEROEN"));
        System.out.println(sol.solution("JAN"));
    }
}
