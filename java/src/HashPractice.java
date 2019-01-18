import java.io.*;
import java.util.*;

public class HashPractice {
  private class Student {
    int id;
    int getId() {
      return id;
    }
  }

  public String makeSentence(String[] words) {
    String sentence = "";
    for (String w : words) {
      sentence = sentence + w;
    }
    return sentence;
  }

  public static HashMap<Integer, Student> buildMap(Student[] students) {
    HashMap<Integer, Student> map = new HashMap<Integer, Student>();
    for (Student s : students) {
      map.put(s.getId(), s);
    }
    return map;
  }

  public static void main(String[] args) {
  }
}
