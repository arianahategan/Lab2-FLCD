package symbolTable;

public class BinarySearchTree {
    private Node root;

    private int length;

    public BinarySearchTree() {
        length = 0;
    }

    public Node getRoot() {
        return root;
    }

    public int search(String value){
        Node currentNode = root;
        int position = -1;
        while(currentNode != null && position == -1)
            if(currentNode.getValue().equals(value))
                position = currentNode.getIndex();
            else
                if(currentNode.getValue().compareTo(value) < 0)
                    currentNode = currentNode.getRight();
                else
                    currentNode = currentNode.getLeft();
        return position;
    }

    public void insert(String value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, String value) {

        if (current == null) {
            length++;
            return new Node(value, length - 1);
        }

        if (current.getValue().compareTo(value) > 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (current.getValue().compareTo(value) < 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }
}
