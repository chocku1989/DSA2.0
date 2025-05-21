package org.training.trees;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);

        while(!queue.isEmpty()){
            ArrayList<Integer> subList = new ArrayList<>();
            int curreSize= queue.size();
            for(int i=0;i<curreSize;i++){
                TreeNode removedElement=queue.poll();
                subList.add(removedElement.val);

                TreeNode right =removedElement.right;
                TreeNode left =removedElement.left;
                if(left!=null) queue.add(left);
                if(right!=null) queue.add(right);

            }
            resultList.add(subList);

        }
        return resultList;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Create an instance of Solution
        LevelOrder solution = new LevelOrder();

        // Call the solve method
        ArrayList<ArrayList<Integer>> result = solution.solve(root);

        // Print the result
        System.out.println("Level Order Traversal:");
        for (ArrayList<Integer> level : result) {
            System.out.println(level);
        }
    }
}
