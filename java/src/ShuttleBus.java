import java.time.LocalTime;
import java.util.*;

/**
 * 2017 카카오 1차 코딩테스트 #6
 * 셔틀버스
 *
 * 9시부터 n회 t분 간격으로 m명씩 태울 수 있는 셔틀버스가 운영됨.
 * 직원들은 도착한 순서대로 버스에 탑승함.
 *
 * 게으른 한 직원이 버스를 타고 갈 수 있는 가장 늦은 시간대를 계산하는 문제.
 */
public class ShuttleBus {
  public String solution(int n, int t, int m, String[] timetable) {
    // 직원들 정류장 도착 시간 순서대로 정렬
    PriorityQueue<LocalTime> crews = new PriorityQueue<>();
    for (String arriveTime : timetable) {
      crews.add(LocalTime.parse(arriveTime));
    }

    // 버스 도착 시간 순서대로
    List<LocalTime> timeSlots = new ArrayList<>();
    LocalTime busStartTime = LocalTime.parse("09:00");
    for (int i = 0; i < n; i++) {
      timeSlots.add(busStartTime.plusMinutes(t * i));
    }

    LocalTime latestTimeNotFull = null;  // 마지막 버스가 꽉차지 않는다면 그 시간을 담는다
    LocalTime latestPersonThatRidesLastBus = null;  // 마지막 만차 버스를 타는 마지막 사람이 도착한 시간
    for (LocalTime slot : timeSlots) {
      int capacity = m;  // 새로운 버스
      while (!crews.isEmpty() && capacity > 0) {
        LocalTime firstInLine = crews.peek();

        if (firstInLine.isBefore(slot) || firstInLine.equals(slot)) {  // 정시도착도 태워줌
          if (capacity == 1) {
            latestPersonThatRidesLastBus = firstInLine;
          }
          capacity--;
          crews.poll();
        } else {
          // 순서대로 들어있기에 뒤에걸 볼 필요 없음
          break;
        }
      }

      if (capacity > 0) {
        latestTimeNotFull = slot;  // 딱 정시도착하면 된다
      } else {
        latestTimeNotFull = null;
      }
    }

    if (latestTimeNotFull != null) {  // 마지막 버스가 만차가 아니었다
      return latestTimeNotFull.toString();
    } else {  // 버스가 모두 만차로 끊긴다
      // 마지막 버스 탄 사람 중에 마지막으로 탄 사람보다 1분 일찍 와야 한다
      return latestPersonThatRidesLastBus.minusMinutes(1).toString();
    }
  }
}