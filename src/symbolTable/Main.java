package symbolTable;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
	    SymbolTable symbolTable = new SymbolTable(binarySearchTree);
	    symbolTable.insert(12);
		symbolTable.insert(15);
	    symbolTable.insert(1);
		symbolTable.insert(3);
		symbolTable.insert(2);
		symbolTable.insert(4);
		symbolTable.insert(6);
		symbolTable.insert(22);

		if(symbolTable.search(22))
	        System.out.println("found");

		new BinaryTreePrinter(binarySearchTree.getRoot()).print(System.out);
    }
}
