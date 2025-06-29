package _3Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//  https://youtu.be/St0Jf_VmG_g?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
public class _7MaxAreaRectangleInBinaryMatrix {

    //  img @ https://photos.google.com/photo/AF1QipNTCGuzWRFVKGTytTQ6Zr_U4AJPfJqxqKiEiZRX

    private int[][] binMatrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};

    private static class ItemWithIndex {
        private int item, index;

        public ItemWithIndex(int item, int index) {
            this.item = item;
            this.index = index;
        }
    }

    private int maxAreaRectInBinMatrix() {
        //  hist 1
        List<Integer> histGram = new ArrayList<>();
        for (int col = 0; col < binMatrix[0].length; col++)
            histGram.add(binMatrix[0][col]);
        int mxArea = mah(histGram);
        for (int row = 1; row < binMatrix.length; row++) {
            for (int col = 0; col < binMatrix[row].length; col++) {
                if (binMatrix[row][col] == 0)
                    histGram.set(col, 0);
                else
                    histGram.set(col, histGram.get(col) + binMatrix[row][col]);
            }
            mxArea = Math.max(mxArea, mah(histGram));
        }
        return mxArea;
    }

    private int mah(List<Integer> histogram) {
        System.out.println("yup: histogram: " + histogram);
        List<Integer> nslList = computeNSL(histogram);
        List<Integer> nsrList = computeNSR(histogram);
        System.out.println("yup: nslIndexList: " + nslList);
        System.out.println("yup: nsrIndexList: " + nsrList);
        List<Integer> widthArray = new ArrayList<>();
        for (int i = 0; i < histogram.size(); i++)
            widthArray.add(i, nsrList.get(i) - nslList.get(i) - 1);   //  right - left - 1
        System.out.println("yup: widthArray: " + widthArray);
        //  find area
        int areaMax = Integer.MIN_VALUE;
        for (int i = 0; i < histogram.size(); i++)
            areaMax = Math.max(areaMax, (histogram.get(i) * widthArray.get(i)));
        return areaMax;
    }

    private List<Integer> computeNSR(List<Integer> histogram) {
        List<Integer> nsrIndexList = new ArrayList<>();
        int pseudoIndex = histogram.size();   //  make a dummy index
        Stack<ItemWithIndex> stack = new Stack<>();
        for (int i = histogram.size() - 1; i >= 0; i--) {
            if (stack.isEmpty())
                nsrIndexList.add(pseudoIndex);
            else if (stack.peek().item <= histogram.get(i)) //  <= is because of binary no 0,1
                nsrIndexList.add(stack.peek().index);
            else if (stack.peek().item >= histogram.get(i)) {   //  <= is because of binary no 0,1
                while (!stack.isEmpty() && stack.peek().item >= histogram.get(i))
                    stack.pop();

                if (stack.isEmpty())
                    nsrIndexList.add(pseudoIndex);
                else
                    nsrIndexList.add(stack.peek().index);
            }
            stack.push(new ItemWithIndex(histogram.get(i), i));
        }
        Collections.reverse(nsrIndexList);
        return nsrIndexList;
    }

    private List<Integer> computeNSL(List<Integer> histogram) {
        List<Integer> nslIndexList = new ArrayList<>();
        int pseudoIndex = -1;   //  make a dummy index
        Stack<ItemWithIndex> stack = new Stack<>();
        for (int i = 0; i < histogram.size(); i++) {
            if (stack.isEmpty())
                nslIndexList.add(pseudoIndex);
            else if (stack.peek().item <= histogram.get(i)) //  <= is because of binary no 0,1
                nslIndexList.add(stack.peek().index);
            else if (stack.peek().item >= histogram.get(i)) {   //  <= is because of binary no 0,1
                while (!stack.isEmpty() && stack.peek().item >= histogram.get(i))
                    stack.pop();

                if (stack.isEmpty())
                    nslIndexList.add(pseudoIndex);
                else
                    nslIndexList.add(stack.peek().index);
            }
            stack.push(new ItemWithIndex(histogram.get(i), i));
        }
        return nslIndexList;
    }

    private void printBinaryMatrix() {
        for (int row = 0; row < binMatrix.length; row++) {
            for (int col = 0; col < binMatrix[row].length; col++) {
                System.out.print(" " + binMatrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        _7MaxAreaRectangleInBinaryMatrix prob = new _7MaxAreaRectangleInBinaryMatrix();
        System.out.println("yup: Mx area: " + prob.maxAreaRectInBinMatrix());
    }
}
