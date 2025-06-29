package _3Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//refer for updated soln: https://youtu.be/zx5Sw9130L0

//  https://youtu.be/J2X70jj_I1o?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
public class _6MaxAreaOfHistogram_aka_MAH {

    //  img @ https://photos.google.com/photo/AF1QipMrFBX7Dlxkeq5D3R5D-ygilHS9srC7M0kTo5pn

    private static class ItemWithIndex {
        private int item, index;

        public ItemWithIndex(int item, int index) {
            this.item = item;
            this.index = index;
        }
    }

    private int[] arr = {6, 2, 5, 4, 5, 1, 6};  //  heights of buildings

    private List<Integer> computeNSL() {
        List<Integer> nslList = new ArrayList<>();
        int pseudoIndex = -1;   //  make a dummy index
        Stack<ItemWithIndex> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())
                nslList.add(pseudoIndex);
            else if (stack.peek().item < arr[i])
                nslList.add(stack.peek().index);
            else if (stack.peek().item > arr[i]) {
                while (!stack.isEmpty() && stack.peek().item >= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    nslList.add(pseudoIndex);
                else
                    nslList.add(stack.peek().index);
            }
            stack.push(new ItemWithIndex(arr[i], i));
        }
        return nslList;
    }

    private List<Integer> computeNSR() {
        List<Integer> nsrList = new ArrayList<>();
        int pseudoIndex = arr.length;   //  make a dummy index
        Stack<ItemWithIndex> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty())
                nsrList.add(pseudoIndex);
            else if (stack.peek().item < arr[i])
                nsrList.add(stack.peek().index);
            else if (stack.peek().item > arr[i]) {
                while (!stack.isEmpty() && stack.peek().item >= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    nsrList.add(pseudoIndex);
                else
                    nsrList.add(stack.peek().index);
            }
            stack.push(new ItemWithIndex(arr[i], i));
        }
        Collections.reverse(nsrList);
        return nsrList;
    }

    private int computeMAH() {
        List<Integer> nslList = computeNSL();
        List<Integer> nsrList = computeNSR();
        System.out.println("yup: nsl: " + nslList);
        System.out.println("yup: nsr: " + nsrList);
        List<Integer> widthArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            widthArray.add(i, nsrList.get(i) - nslList.get(i) - 1);   //  right - left - 1 - https://youtu.be/J2X70jj_I1o?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&t=1335
        System.out.println("yup: widthArray: " + widthArray);
        //  find area
        int areaMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            areaMax = Math.max(areaMax, (arr[i] * widthArray.get(i)));
        return areaMax;
    }

    public static void main(String[] args) {
        _6MaxAreaOfHistogram_aka_MAH prob = new _6MaxAreaOfHistogram_aka_MAH();
        System.out.println("yup: computeMAH() : " + prob.computeMAH());
    }


}
