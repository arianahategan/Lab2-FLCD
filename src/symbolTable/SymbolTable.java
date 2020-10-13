package symbolTable;

public class SymbolTable {
    private final BinarySearchTree binarySearchTree;

    public SymbolTable(BinarySearchTree binarySearchTree) {
        this.binarySearchTree = binarySearchTree;
    }

    public void insert(int value){
        binarySearchTree.insert(value);
    }

    public boolean search(int value){
        return binarySearchTree.search(value);
    }

    private int getAsciiSum(String str){
        int asciiSum = 0;
        for(int i = 0; i < str.length(); i++)
            asciiSum += str.charAt(i);
        return asciiSum;
    }


}
