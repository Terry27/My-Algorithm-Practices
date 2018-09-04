public class Codec {   //preorder traversal using queue
    private static final String  delimiter = ",";
    private static final String emptyNode = "#";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append(emptyNode+delimiter);
        }else{
            sb.append(node.val+delimiter);
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<String>();
        q.addAll(Arrays.asList(data.split(delimiter)));
        return deserializeHelper(q);
    }
    
    private TreeNode deserializeHelper(Queue<String> q){
        String val = q.remove();
        if(val.equals(emptyNode)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);
        return node;
    }
}