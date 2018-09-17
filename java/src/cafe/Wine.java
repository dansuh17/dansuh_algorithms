package cafe;

public class Wine {
  String grapeType;
  int vintage;
  private int price;

  // 생성자 -  1. class랑 이름이 같다
  Wine(String grapeType, int vintage) {
    this.grapeType = grapeType;
    this.vintage = vintage;
  }

  // SETTER - 멤버 변수에 값을 할당하는 용도로 사용되는 메소드
  public void setPrice(int price) {
    this.price = price;
  }

  // GETTER - 멤버 변수의 값을 가져오는 용도
  public int getPrice() {
    return this.price;
  }

  public int getVintage() {
    return this.vintage;
  }

  public String getGrapeType() {
    return this.grapeType;
  }
}
