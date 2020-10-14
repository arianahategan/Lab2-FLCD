package symbolTable;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
	    SymbolTable symbolTable = new SymbolTable(binarySearchTree);
	    symbolTable.insert("d");
		symbolTable.insert("b");
	    symbolTable.insert("a");
		symbolTable.insert("z");
		symbolTable.insert("e");
		symbolTable.insert("c");
		symbolTable.insert("g");
		symbolTable.insert("f");
		symbolTable.insert("z");


		System.out.println("Position of the element z in the ST is: " + symbolTable.search("z"));

		new BinaryTreePrinter(binarySearchTree.getRoot()).print(System.out);
    }
}
