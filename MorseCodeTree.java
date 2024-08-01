import java.util.ArrayList;

/**
 * MorseCodeTree class that implements LinkedConverterTreeInterface.
 * This class builds a Morse Code Tree and provides methods to insert,
 * fetch, and traverse the tree.
 * 
 * @author Joshua Gizaw
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    private TreeNode<String> root;

    /**
     * Constructor that initializes the tree by calling buildTree().
     */
    public MorseCodeTree() {
        buildTree();
    }

    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    @Override
    public void insert(String code, String letter) {
        if (root == null) {
            root = new TreeNode<>("");
        }
        addNode(root, code, letter);
    }
    
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 1) {
            if (code.equals(".")) {
                root.left = new TreeNode<>(letter);
            } else if (code.equals("-")) {
                root.right = new TreeNode<>(letter);
            }
        } else {
            if (code.charAt(0) == '.') {
                if (root.left == null) {
                    root.left = new TreeNode<>("");
                }
                addNode(root.left, code.substring(1), letter);
            } else if (code.charAt(0) == '-') {
                if (root.right == null) {
                    root.right = new TreeNode<>("");
                }
                addNode(root.right, code.substring(1), letter);
            }
        }
    }

    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        if (root == null) return null;
        if (code.length() == 1) {
            if (code.equals(".")) {
                return root.left != null ? root.left.data : null;
            } else if (code.equals("-")) {
                return root.right != null ? root.right.data : null;
            }
        } else {
            if (code.charAt(0) == '.') {
                return fetchNode(root.left, code.substring(1));
            } else if (code.charAt(0) == '-') {
                return fetchNode(root.right, code.substring(1));
            }
        }
        return null;
    }

    @Override
    public MorseCodeTree delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public MorseCodeTree update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Builds the Morse Code Tree by inserting nodes.
     */
    @Override
    public void buildTree() {
        root = new TreeNode<>("");
        insert(".", "e");
        insert("-", "t");
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.--", "y");
        insert("-.-.", "c");
        insert("--..", "z");
        insert("--.-", "q");
    }

    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root != null) {
            LNRoutputTraversal(root.left, list);
            list.add(root.data);
            LNRoutputTraversal(root.right, list);
        }
    }
}
