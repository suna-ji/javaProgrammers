package level1;
import java.util.Arrays;

public class Sol12915 {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        String[] rotatedStr = add (strings, n);
        Arrays.sort(rotatedStr);
        return remove(rotatedStr, n);
    }

    private String[] add(String[] str, int n) {
        for(int i = 0; i < str.length; i++) {
            String indexChar = String.valueOf(str[i].charAt(n));
            str[i] =  indexChar + str[i];
        }
        return str;
    }
    private String[] remove(String[] str, int n) {
        for(int i = 0; i < str.length; i++) {
            int len = str[i].length();
            str[i] =  str[i].substring(1, len);
        }
        return str;
    }

    public static void main(String[] args) {
        Sol12915 sol12915 = new Sol12915();
        String[] strings = {"sun", "bed", "car"};
        String[] ans = sol12915.solution(strings, 1);
    }
}
