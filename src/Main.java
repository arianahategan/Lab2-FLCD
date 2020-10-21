import scanner.Scanner;
import symbolTable.BinarySearchTree;
import symbolTable.BinaryTreePrinter;
import symbolTable.SymbolTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
	    SymbolTable symbolTable = new SymbolTable(binarySearchTree);
		HashMap<String, Integer> PIF = new HashMap<String, Integer>();


		ArrayList<String> separators = new ArrayList<>(Arrays.asList(readSeparatorsFromFile("token.in")));

		ArrayList<String> operators = new ArrayList<>(Arrays.asList(readOperatorsFromFile("token.in")));

		ArrayList<String> reservedWords = new ArrayList<>(Arrays.asList(readReservedWordsFromFile("token.in")));

		Scanner scanner = new Scanner(separators, operators);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("p1.in"));
			String line = reader.readLine();
			int lineIndex = 1;
			while (line != null) {
				for(String token: scanner.getTokensFromLine(line)){
					if(isOperator(token, operators) || isSeparator(token, separators) || isReservedWord(token, reservedWords)){
						PIF.put(token, -1);

					}
					else{
						if(isConstant(token) || isIdentifier(token)) {
							symbolTable.insert(token);
							int indexInST = symbolTable.search(token);
							PIF.put(token, indexInST);
						}
						else{
							System.out.println("Lexical error on line " + lineIndex + ": " + token);
						}
					}
				}

				line = reader.readLine();
				lineIndex++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(PIF);
		new BinaryTreePrinter(binarySearchTree.getRoot()).print(System.out);

    }

	private static String[] readReservedWordsFromFile(String fileName) {
		String[] reservedWords = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			int lineIndex = 1;
			while (line != null) {
				if(lineIndex == 3){
					reservedWords = line.split(",");
				}
				line = reader.readLine();
				lineIndex++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reservedWords;
	}

	private static String[] readOperatorsFromFile(String fileName) {
		String[] operators = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			int lineIndex = 1;
			while (line != null) {
				if(lineIndex == 1){
					operators = line.split(",");
				}
				line = reader.readLine();
				lineIndex++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return operators;
	}

	private static String[] readSeparatorsFromFile(String fileName) {
		String[] separators = null;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			int lineIndex = 1;
			while (line != null) {
				if(lineIndex == 2){
					separators = line.split(",");
				}
				line = reader.readLine();
				lineIndex++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return separators;
	}

	private static boolean isConstant(String token) {

    	//integer
		if(token.matches("[+-]?[1-9][0-9]+") || token.matches("0"))
			return true;

		//string
		if(token.matches("[0-9A-Za-z_]+")){
			return true;
		}


		//char
		if(token.matches("[0-9A-Za-z_]"))
			return true;

		//boolean
		if(token.equals("TRUE") || token.equals("FALSE")){
			return true;
		}

    	return false;
	}


	private static boolean isIdentifier(String token) {
		return token.matches("[a-zA-Z]+[a-zA-Z0-9]*");
	}

	private static boolean isReservedWord(String token, ArrayList<String> reservedWords) {
    	for(String reservedWord: reservedWords)
			if(token.equals(reservedWord))
				return true;
		return false;
	}

	private static boolean isSeparator(String token, ArrayList<String> separators) {
		for(String separator: separators)
			if(token.equals(separator))
				return true;
		return false;
	}

	private static boolean isOperator(String token, ArrayList<String> operators) {
    	for(String operator: operators)
    		if(token.equals(operator))
    			return true;
    	return false;
	}


}
