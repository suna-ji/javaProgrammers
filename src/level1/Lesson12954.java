package level1;

public class Lesson12954 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;
        for (int i = 0; i < n; i++) {
            answer[i] = num;
            num+=x;
        }
        return answer;
    }
    public static void main(String[] args) {
        Lesson12954 lesson12954 = new Lesson12954();
        long[] answer = lesson12954.solution(2, 5);
    }
}
