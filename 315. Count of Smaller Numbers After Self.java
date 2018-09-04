public class Solution {
    public List<Integer> countSmaller(int[] input) {
        if(input == null || input.length == 0){
            return new ArrayList<>();
        }
        Integer[] res = new Integer[input.length];
        res[input.length-1] = 0;
		// first tree root
		TreeNode root = new TreeNode(input[input.length - 1]);
		for (int i = input.length - 2; i >= 0; i--) {
			res[i] = buildTree(root, input[i]);
		}
		return Arrays.asList(res);
    }

	private int buildTree(TreeNode root, int input) {
		int count = 0;
		while (root != null) {
			if (input < root.val) {
			    root.leftSum++;
				if (root.left == null) {
					root.left = new TreeNode(input);
					break;
				}
				root = root.left;
			} else if (input > root.val) {
				count+= root.leftSum + root.dup + 1;
				if (root.right == null) {
					root.right = new TreeNode(input);
					break;
				}
				root = root.right;
			} else {
			    int res = count+root.leftSum;
				root.dup++;
				return res;
			}
		}

		return count;
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	int leftSum;
	int dup;

	TreeNode(int i) {
		val = i;
		left = null;
		right = null;
		leftSum = 0;
		dup = 0;
	}
}