/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        Map<Integer, List<TreeNode>> map = new HashMap();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);
        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            if(!list.isEmpty()) {
                map.put(level, list);
            }
            level++;
            
        }

        return getResult(result, map);
        
    }

    private List<Integer> getResult(List<Integer> result, Map<Integer, List<TreeNode>> map) {

        for(Map.Entry<Integer, List<TreeNode>> entry : map.entrySet()) {
            result.add(entry.getValue().get(entry.getValue().size() - 1).val);
        }
        return result;
    }
}
