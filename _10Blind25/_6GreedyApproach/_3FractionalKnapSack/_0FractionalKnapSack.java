package _10Blind25._6GreedyApproach._3FractionalKnapSack;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/cVK62OqHOfE?list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&t=697
public class _0FractionalKnapSack {

  private static class Item {

    int wt, price, pricePerKg;

    public Item(int wt, int price, int pricePerKg) {
      this.wt = wt;
      this.price = price;
      this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString() {
      return "Item{" +
          "wt=" + wt +
          ", price=" + price +
          ", pricePerKg=" + pricePerKg +
          '}';
    }
  }

  private static int maxPriceProfit() {
    int knapSackMaxWt = 13, maxProfit = 0;
    int[] wt = {10, 2, 5};
    int[] price = {50, 30, 100};
    List<Item> itemList = new ArrayList<>();
    for (int i = 0; i < wt.length; i++) {
      itemList.add(new Item(wt[i], price[i], price[i] / wt[i]));
    }
    //  O (n log n) - descending sort
    itemList.sort((o1, o2) -> o2.pricePerKg - o1.pricePerKg);
    int wtTaken;
    for (Item item : itemList) {
      if ((knapSackMaxWt - item.wt) < 0) {
        wtTaken = item.wt -
            Math.abs(knapSackMaxWt
                - item.wt);  //  wtTaken = item.wt - (item.wt - knapSackMaxWt) or knapSackMaxWt
      } else {
        wtTaken = item.wt;
      }
      maxProfit += (wtTaken * item.pricePerKg);
      knapSackMaxWt -= wtTaken;
      if (knapSackMaxWt <= 0) {
        break;
      }
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    System.out.println("yup: maxPriceProfit(): " + maxPriceProfit()); //  yup: maxPriceProfit(): 160
  }
}
