package level1;
import java.util.Arrays;
// arr에서 가장 작은 수를 제거한 배열을 리턴
// 리턴하려는 배열이 빈 배열일때는 -1 채워

public class Lesson12945 {

    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            int[] anawer = {-1};
            return anawer;
        } else {
            int[] originArr = arr.clone();
            Arrays.sort(arr);
            return removeElement(originArr, arr[0]);
        }
    }

    public static int[] removeElement(int[] arr, int item) {
        return Arrays.stream(arr)
                .filter(i -> i != item)
                .toArray();
    }

    public static void main(String[] args) {
        Lesson12945 lesson12945 = new Lesson12945();
        int[] arr = {10};
        System.out.println(Arrays.toString(lesson12945.solution(arr)));
    }
}
