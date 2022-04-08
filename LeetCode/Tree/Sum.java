package Tree;

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Sum {
    public static void main(String[] args){
        TreeNode left = null;
        TreeNode right = new TreeNode(-3,null,null);
        TreeNode root = new TreeNode(-2,left,right);
        System.out.println(pathSum(root,-5));
    }

//this is my stupid solution.
    //add val to each list when tracing back(stupid!!!!)
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return new ArrayList<List<Integer>>();
        }
        int remainValue = targetSum - root.val;
        if ((remainValue == 0) && root.left == null &&root.right == null){
            List<Integer> l = new LinkedList<Integer>();
            l.add(0,root.val);
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(l);

            return lists;
        }
//        -5  -2
//        else if(targetSum < root.val){
//            return new ArrayList<List<Integer>>();
//        }
        else{ //targetSum < remaining
            int remain = targetSum -root.val;
            List<List<Integer>> left = pathSum(root.left,remain);
            List<List<Integer>> right = pathSum(root.right,remain);
            return combineLists(left,right,root.val);
        }
    }
    public static List<List<Integer>> combineLists(List<List<Integer>> left, List<List<Integer>> right, int val){

        List<List<Integer>> newLists = new ArrayList<List<Integer>>();
        if(left!=null){
            left.forEach((list)->{list.add(0,val);});
            left.forEach((list)->{newLists.add(list);});
        }
        if(right!=null){
            right.forEach((list)->{list.add(0,val);});
            right.forEach((list)->{newLists.add(list);});
        }

        return newLists;
    }



// below is a better solution from leetcode
    /*
    use cur to record current branch
    use ret to record alll posible branch
    add cur to ret when cur is a feasible one
    delete last node from cur when backing to the last layer*/
    public List<List<Integer>> pathSumPerfect(TreeNode root, int sum) {
        List<List<Integer>>ret = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        pathSumPerfect(root, sum, cur, ret);
        return ret;
    }

    public void pathSumPerfect(TreeNode root, int sum, List<Integer>cur, List<List<Integer>>ret){
        if (root == null){
            return;
        }
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            ret.add(new ArrayList(cur));
        }else{
            pathSumPerfect(root.left, sum - root.val, cur, ret);
            pathSumPerfect(root.right, sum - root.val, cur, ret);
        }
        cur.remove(cur.size()-1);
    }

}
