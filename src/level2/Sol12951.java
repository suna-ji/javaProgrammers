package level2;

public class Sol12951 {
    public String solution(String s) {
        String answer = "";
        String[] array = s.split(" ", -1);
        for (int i = 0; i < array.length; i++) {
            array[i] = change(array[i]);
        }
        return String.join(" ", array);
    }

    private String change(String s) {
        if (s.equals("")) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        Sol12951 sol = new Sol12951();
        System.out.println(sol.solution("3people   unFollowed me   "));
        System.out.println(sol.solution("for the last week"));
    }
}
