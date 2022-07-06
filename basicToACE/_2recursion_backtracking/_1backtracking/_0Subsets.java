package basicToACE._2recursion_backtracking._1backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://youtu.be/exyxf_ihbhI?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=2949
public class _0Subsets {

  //  for dry run: https://youtu.be/exyxf_ihbhI?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=4385
  /*
    2^3 = subsets
  * (1,2,3) -> (),(1),(2),(3),(1,2),(2,3),(1,3),(1,2,3)

  refer: _0FindAllSubsetsOfSet.java
  */
  private static void getAllSubsets(int index,
      List<Integer> list,
      List<Integer> temp,
      List<List<Integer>> subsetList) {
    if (index == list.size()) {
      subsetList.add(new ArrayList<>(temp));
    } else {
      //  ignoring the item
      getAllSubsets(index + 1, list, temp, subsetList);
      //  considering the item
      temp.add(list.get(index));
      getAllSubsets(index + 1, list, temp, subsetList);
      //  backtracking
      temp.remove(temp.size() - 1);
    }
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3);
    List<List<Integer>> subsetList = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    getAllSubsets(0, list, temp, subsetList);
    //  yup: all the subsets are:
    //  [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
    System.out.println("yup: all the subsets are: ");
    System.out.println(subsetList);
  }
}
