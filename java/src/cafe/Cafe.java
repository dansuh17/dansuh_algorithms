package cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cafe {
  List<Wine> wineCellar;
  int revenue;

  Cafe() {
    wineCellar = new ArrayList<>();
    revenue = 0;
  }

  public void buyWine(String grapeType, int vintage) {
    Wine newWine = new Wine(grapeType, vintage);
    newWine.setPrice(15000);
    wineCellar.add(newWine);
  }

  public void sellWine() {
    // 맨 끝 와인
    Wine recentWine = wineCellar.get(wineCellar.size() - 1);
    int price = recentWine.getPrice();  // 가격을 알아냈어
    // int price = recentWine.price;  // 같은 문장이야

    // revenue += price;  // 매출에 추가
    addRevenue(price);
    int view = getRevenue();
    System.out.println("오늘의 매출은 : " + view);

    wineCellar.remove(recentWine);  // 와인을 셀러에서 뺀다
  }

  /**
   * 어떤 와인을 랜덤하게 고르는 메소드.
   * @return
   */
  public Wine pickMe() {
    Random random = new Random();
    int selectIndex = random.nextInt(wineCellar.size());

    return wineCellar.get(selectIndex);
  }

  public void talk() {
    Wine randomWine = pickMe();  // 랜덤하게 하나 골라주세요

    int vintage = randomWine.getVintage();
    String grapeType = randomWine.getGrapeType();

    System.out.println("빈티지는요 :  " + vintage);
    System.out.println("포도 품종은 : " + grapeType);
  }

  public void addRevenue(int price) {
    revenue += price;
  }

  public int getRevenue() {
    return revenue;
  }

  public static void main(String[] args) {
    Cafe wineCafe = new Cafe();

    wineCafe.buyWine("까쇼", 1990);
    wineCafe.buyWine("로제", 2006);
    wineCafe.talk();
    wineCafe.sellWine();
    wineCafe.sellWine();


  }
}
