package level2;
// 2022 카카오 코테
// 주차 요금 계산
// 주차장의 요금표와 차량 기록이 주어졌을 때. 차량별로 요금을 계산하려고 한다.
// 차량번호가 작은 순서대로! 주차 요금을 정수 배열에 담아서 리턴

import java.util.*;

public class Sol92341 {

    public int[] solution(int[] fees, String[] records) {
        // 현재 주차중인 차
        Map<String, Integer> parking = new HashMap<>();
        // 요금
        Map<String, Integer> feeMap = new HashMap<>();

        for (String record : records) {
            String[] recordInfo = record.split(" ");
            // 만약 주차된 차라면 요금 계산해서 넣기
            if (parking.containsKey(recordInfo[1])) {
                int time = getTime(recordInfo[0]) - parking.get(recordInfo[1]);
                int money = calcFee(fees, time);
                feeMap.put(recordInfo[1], money);
            } else { // 아니면 주차시켜주기기
                parking.put(recordInfo[1], getTime(recordInfo[0]));
            }
        }
        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(feeMap);
        int[] ans = new int[sortedMap.size()];
        int idx = 0;
        for (Object value : sortedMap.values()) {
            ans[idx] = (int) value;
            idx++;
        }
        return ans;
    }
    private int calcFee(int[] fees, int time) {
        int basicTime = fees[0];
        int basicRate = fees[1];
        int unitTime = fees[2];
        int unitRate = fees[3];
        if (time < basicTime) {
            return basicRate;
        } else {
            return basicRate + unitRate * (time-basicTime) / unitTime;
        }
    }

    private int getTime(String time) {
        String[] hourmin = time.split(":");
        return Integer.valueOf(hourmin[0]) * 60 + Integer.valueOf(hourmin[1]);
    }

    public static void main(String[] args) {
        Sol92341 sol = new Sol92341();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(sol.solution(fees, records));
    }
}
