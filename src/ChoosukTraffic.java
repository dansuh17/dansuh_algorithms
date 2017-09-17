import java.io.*;
import java.time.LocalTime;
import java.util.*;

/**
 * 2017 카카오 1차 코딩테스트 #7
 * 추석 트래픽
 *
 * 추석에 서버의 로드를 기록한 로그 파일이 있다.
 * 1분 간격 사이에 가장 많은 처리량을 가진 시기의 처리량을 구하는 문제.
 *
 * 그 외 여러 조건이 있는데 너무 복잡해서 기억이 안남.
 * 암튼 이게 답.
 */
public class ChoosukTraffic {
  public int solution(String[] lines) {
    List<Req> jobQueue = new LinkedList<>();

    for (String completeTime : lines) {
      String[] parsed = completeTime.trim().split(" ");
      LocalTime complete = LocalTime.parse(parsed[1]); // "20:59:57.421"
      float durationSeconds = Float.parseFloat(parsed[2].replace("s", ""));
      long durInNano = (((long) (durationSeconds * 1000)) * 1000000) - 1000000;

      LocalTime start = complete.isAfter(LocalTime.parse("00:00:00").plusNanos(durInNano))
          ? complete.minusNanos(durInNano) : LocalTime.parse("00:00:00");

      jobQueue.add(new Req(start, complete));
    }

    Collections.sort(jobQueue);

    LinkedList<Req> running = new LinkedList<>();

    int maxProcessing = 0;
    for (Req newReq : jobQueue) {
      running.addLast(newReq);
      List<Req> toReap = new ArrayList<>();

      LocalTime secondBefore = newReq.start.isAfter(LocalTime.parse("00:00:00.999")) ?
          newReq.start.minusNanos(999000000) : LocalTime.parse("00:00:00");

      for (Req runningReq : running) {
        if (runningReq.end.isBefore(secondBefore)) {
          toReap.add(runningReq);
        }
      }

      running.removeAll(toReap);

      // update max processing
      int currentProcessing = running.size();
      if (maxProcessing < currentProcessing) {
        maxProcessing = currentProcessing;
      }
    }

    return maxProcessing;
  }

  class Req implements Comparable<Req> {
    LocalTime start;
    LocalTime end;
    Req(LocalTime start, LocalTime end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Req req) {
      if (start.isAfter(req.start)) {
        return 1;
      } else if (start.equals(req.start)) {
        return 0;
      } else {
        return -1;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    ChoosukTraffic ct = new ChoosukTraffic();
    int n = ct.solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"});
    bw.write(n + "\n");
    bw.close();
  }

}