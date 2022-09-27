package level1;

public class lesson_12903 {
    public static String solution(String s) {
        String answer = "";
        while(true) {
            if (s.length() == 2 || s.length() == 1) {
                return s;
            }
            s = popSide(s);
        }
    }

    private static String popSide(String answer) {
        int len = answer.length();
        if (len == 3) {
            answer = String.valueOf(answer.charAt(1));
        } if (len > 3) {
            answer = answer.substring(1, len-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("qwer"));
    }
}
