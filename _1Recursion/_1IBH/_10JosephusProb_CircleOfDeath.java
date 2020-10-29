package ds_algo._1Recursion._1IBH;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/ULUNeD0N9yI?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _10JosephusProb_CircleOfDeath {

    public static void main(String[] args) {
        int k = 2;
        List<Integer> integerList = new ArrayList<>();
        int noOfPersons = 5;
        for (int i = 0; i < noOfPersons; i++) {
            integerList.add(i + 1);
        }
        k = k - 1;    //  since index starts from 0
        int swordPos = 0;
        int pos = solve(integerList, k, swordPos);
        System.out.println("yup: pos: " + pos);
    }

    private static int solve(List<Integer> personList, int k, int swordPos) {
        //  bc
        if (personList.size() == 1) {
//            System.out.println("yup: final pos: " + personList.get(0));
            return personList.get(0);
        }
        swordPos = (swordPos + k) % personList.size(); //  watch video for beautiful explanation
        personList.remove(swordPos);
        return solve(personList, k, swordPos);
    }
}
