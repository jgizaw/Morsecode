/**
 * TreeNode class that represents a node in a binary tree.
 * 
 * @param <T> the type of data the node holds
 * 
 * @author Joshua Gizaw
 */
public class TreeNode<T> {
    protected T data;
    protected TreeNode<T> left;
    protected TreeNode<T> right;

    /**
     * Create a new TreeNode with left and right child set to null and data set to the dataNode.
     * 
     * @param dataNode the data to be stored in the TreeNode
     */
    public TreeNode(T dataNode) {
        data = dataNode;
        left = null;
        right = null;
    }

    /**
     * Create a new TreeNode by making a deep copy of another node.
     * 
     * @param node the node to copy
     */
    public TreeNode(TreeNode<T> node) {
        data = node.data;
        left = node.left;
        right = node.right;
    }

    /**
     * Return the data within this TreeNode.
     * 
     * @return the data within the TreeNode
     */
    public T getData() {
        return data;
    }
}
