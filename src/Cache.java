import java.util.*;

/**
 * 2017 카카오 1차 코딩테스트 #2
 *
 * Simple cache having size cacheSize, where cities are given as input.
 * Eviction policy = least recently used (LRU)
 */
public class Cache {
  public int solution(int cacheSize, String[] cities) {
    LinkedList<String> cache = new LinkedList<>();
    int overhead = 0;

    if (cacheSize == 0) {
      // full miss
      return 5 * cities.length;
    }

    for (String city : cities) {
      city = city.toLowerCase();

      int indexOfCity = cache.indexOf(city);
      if (indexOfCity != -1) {
        // cache hit
        overhead++;
        cache.remove(indexOfCity);  // update most recently used
      } else {
        overhead += 5;  // cache miss

        if (cache.size() == cacheSize) {
          cache.removeLast();  // evict least recently used
        }
      }

      cache.addFirst(city);
    }

    return overhead;
  }

  public static void main(String[] args) {
    Cache cache = new Cache();
    cache.solution(3,
        new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
  }
}