package _8Trees.advanced;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=TOmf-utC7G0&list=PLNxqWc8Uj2LTupAJUeWvWzRTVT9NX36lY&index=6
//  notes @ https://photos.google.com/photo/AF1QipPgzqO6kuoyw4KuEfy3YT7Bllv_aFrIMVEINKU2
public class _4DiameterOfN_Ary {

    static class TreeNode {
        int value;
        List<TreeNode> children;

        public TreeNode(int value, List<TreeNode> children) {
            this.value = value;
            this.children = children;
        }
    }

    static class IntWrapper {
        int diameter;
    }

    private static int height(TreeNode root, IntWrapper wrapper) {
        if (root == null)
            return 0;

        int max1 = 0, max2 = 0; //  max2 < max1 = both are maximum values
        for (TreeNode child : root.children) {
            int temp = height(child, wrapper);
            if (temp > max1) {
                max2 = max1;
                max1 = temp;
            } else if (temp > max2) {
                max2 = temp;
            }
        }
        wrapper.diameter = Math.max(wrapper.diameter, 1 + max1 + max2);
        return 1 + max1;
    }

    private static int diameter(TreeNode root) {
        if (root == null)
            return 0;

        IntWrapper wrapper = new IntWrapper();
        int height = height(root, wrapper);
        System.out.println("yup: max height: " + height);   //  yup: max height: 6
        return wrapper.diameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new ArrayList<>());
        root.children.add(new TreeNode(2, new ArrayList<>()));
        root.children.add(new TreeNode(3, new ArrayList<>()));
        root.children.add(new TreeNode(4, new ArrayList<>()));

        root.children.get(0).children.add(new TreeNode(5, new ArrayList<>()));
        root.children.get(0).children.add(new TreeNode(6, new ArrayList<>()));

        root.children.get(0).children.get(0).children.add(new TreeNode(7, new ArrayList<>()));
        root.children.get(0).children.get(0).children.add(new TreeNode(8, new ArrayList<>()));

        root.children.get(0).children.get(1).children.add(new TreeNode(9, new ArrayList<>()));

        root.children.get(0).children.get(0).children.get(0).children.add(new TreeNode(15, new ArrayList<>()));

        root.children.get(0).children.get(1).children.get(0).children.add(new TreeNode(11, new ArrayList<>()));
        root.children.get(0).children.get(1).children.get(0).children.add(new TreeNode(10, new ArrayList<>()));
        root.children.get(0).children.get(1).children.get(0).children.add(new TreeNode(12, new ArrayList<>()));

        root.children.get(0).children.get(0).children.get(0).children.get(0).children.add(new TreeNode(13, new ArrayList<>()));
        root.children.get(0).children.get(1).children.get(0).children.get(0).children.add(new TreeNode(14, new ArrayList<>()));

        System.out.println("diamter of n-ary: " + diameter(root));  //  diamter of n-ary: 9
    }
}
