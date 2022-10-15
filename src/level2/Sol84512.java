package level2;

import java.util.ArrayList;
import java.util.List;

// 모음 사전
// 사전에 모음 AEIOU 만을 사용하여 만들 수 있는 길이 5 이하의 모든 단어가 있다.
// 단어가 주어일 떼, 이 단어가 사전에서 몇번쨰 단어인지 구해라
public class Sol84512 {
    List<String> dictionary = new ArrayList<>();
    String letters = "AEIOU";
    public int solution(String word) {
        dfs("", 0);
        return dictionary.indexOf(word);
    }

    private void dfs(String str, int length) {
        if (length > 5) {
            return;
        }
        dictionary.add(str);
        for (int i = 0; i < letters.length(); i++) {
            dfs(str + letters.charAt(i), length + 1);
        }
    }

    public static void main(String[] args) {
        Sol84512 sol = new Sol84512();
        System.out.println(sol.solution("EIO"));
    }
}

