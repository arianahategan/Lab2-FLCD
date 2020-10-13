package symbolTable;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public boolean search(int value){
        Node currentNode = root;
        boolean found = false;
        while(currentNode != null && !found)
            if(currentNode.getValue() == value)
                found = true;
            else
                if(currentNode.getValue() < value)
                    currentNode = currentNode.getRight();
                else
                    currentNode = currentNode.getLeft();
        return found;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }


//    public Node insert(Node node, int value){
//        if(root == null){
//            node = new Node(value);
//            root = node;
//        }
//        else{
//            if(node == null){
//                node = new Node(value);
//            }
//            else
//                if(node.getValue() <= value)
//                    node.setLeft(insert(node.getLeft(), value));
//                else
//                    node.setRight(insert(node.getRight(), value));
//        }
//        return node;
//    }

    public String traversePreOrder(Node root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());

        String pointerRight = "└──";
        String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

    public void traverseNodes(StringBuilder sb, String padding, String pointer, Node node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }
}
