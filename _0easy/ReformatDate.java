package _0easy;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate {

  public static String reformatDate(String date) {
    if (date == null) {
      return null;
    }

    Map<String, String> map = new HashMap<>();
    map.put("Jan", "01");
    map.put("Feb", "02");
    map.put("Mar", "03");
    map.put("Apr", "04");
    map.put("May", "05");
    map.put("Jun", "06");
    map.put("Jul", "07");
    map.put("Aug", "08");
    map.put("Sep", "09");
    map.put("Oct", "10");
    map.put("Nov", "11");
    map.put("Dec", "12");
    String[] gDate = date.split(" ");
    StringBuilder sBuilder = new StringBuilder();
    sBuilder.append(gDate[gDate.length - 1]);
    sBuilder.append("-");
    sBuilder.append(map.get(gDate[1]));
    sBuilder.append("-");
    sBuilder.append(
        String.format("%02d", Integer.valueOf(gDate[0].substring(0, gDate[0].length() - 2))));

    return sBuilder.toString();
  }

  public static void main(String[] args) {
    System.out.println("yup: date: " + reformatDate("1st Jan 2021"));   //  yup: date: 2021-01-01
    System.out.println("yup: date: " + reformatDate("21st Oct 2021"));  //  yup: date: 2021-10-21
    System.out.println("yup: date: " + reformatDate("6th Jun 1933"));   //  yup: date: 1933-06-06
  }
}
