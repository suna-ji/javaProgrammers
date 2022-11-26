package kit.binarySearch;

// 조건1 : 디딤돌은 한번 건널때마다 1씩 줄어든다.
// 조건2: 한번에 점프할 수 있는 간격은 k이다.
// 이분탐색 대상: 징검다리를 건널 수 있는 니니즈 친구들
// 징검다리를 건널 수 있는 친구들의 범위 설정 (이분탐색 범위 설정)
//

public class Sol64062 {
    public int solution(int[] stones, int k) {
       int min = 1;
       int max = Integer.MAX_VALUE;
       int answer = 0;
       while(min <= max) {
           int mid = (min + max) / 2;
           if (check(mid, k, stones);) {
               min = mid + 1;
               answer = mid;
           } else {
               max = mid - 1;
           }
           return answer;
       }
    }

    public boolean check(int mid, int k, int[] stones) {
        int count = 0; // 0인 디딤돌의 연속 개수
        // 연속된 0인 디딤돌의 개수 -> 점프해야하는 수 -> k보다 작아야함
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < mid) { // mid명이 건너니까 stone[i]를 mid명이 건너기 위해서는 mid보다는 크거나 같아야한다. // 아닐경우 0인 디딤돌 +1
                count++;
            } else {
                count = 0; // 연속된 0인 디딤돌의 개수를 찾으므로 연속이 아니면 count 0으로 초기화
            }
            if (count == k) { // k가 되는 시점에 false를 리턴 (mid명은 못건넌다는 뜻)
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
