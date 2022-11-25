//package level2;
//
//import java.util.ArrayList;
//
//// 숫자의 표현
//// 아이디어 노트
//// 1) 1~n까지의 숫자를 배열에 담는다.
//// 2) 배열을 순회하면서 더해본다.
//// 3) 더한값이 n이 되거나 넘치면 멈추고 n인 경우에는 cnt+1한다.
//// 4) cnt 리턴
//public class Sol12924 {
//    public int solution(int n) {
//        int answer = 0;
//        int iend = n/2;
//        for (int i = 1; i <= iend; i++) {
//            for (int j = 2; j < n; j++) {
//                int sum = add(i, j);
//                if (sum == n) {
//                    answer+=1;
//                    break;
//                }
//                if (sum > n) {
//                    break;
//                }
//            }
//        }
//        return answer + 1;
//    }
//
//    private int add(int start, int end, ) {
//        int sum = 0;
//        for (int i = start; i <= end; i++) {
//            sum += i;
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) {
//        Sol12924 sol = new Sol12924();
//        System.out.println(sol.solution(15));
//    }
//}
