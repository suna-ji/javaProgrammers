package level2;

import java.util.Stack;

public class Sol12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
           return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Sol12909 sol = new Sol12909();
        System.out.println(sol.solution("(()("));
    }

}

//    시간초과 발생한 코드
// Stack<String> stack = new Stack<>(); -> Stack<Character> stack = new Stack;
// if ("(".equals(String.valueOf(c))) { -> '(' ==  s.charAt(i);