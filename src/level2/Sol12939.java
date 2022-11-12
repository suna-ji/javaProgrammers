package level2;

import java.util.ArrayList;
import java.util.Comparator;
// 최댓값과 최솟값
public class Sol12939 {
    public String solution(String s) {
        String[] array = s.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(Integer.valueOf(array[i]));
        }
        list.sort(Comparator.naturalOrder());
        return String.valueOf(list.get(0)) + " " +  String.valueOf(list.get(list.size()-1));

    }

    public static void main(String[] args) {
        Sol12939 sol = new Sol12939();
        System.out.println(sol.solution("1 2 3 4"));
    }
}

// join 배열을 하나의 문자열로
// split 문자열을 배열로