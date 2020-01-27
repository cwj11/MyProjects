import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {

	private BinaryNode<String> firstNode;
	private ArrayList<HuffmanCode> characters;


	public HuffmanTree() {
		firstNode = new BinaryNode<String>(null);
		characters = new ArrayList<HuffmanCode>();
	}

	/**Create the hoffman tree from the input
	 * @param file - the Scanner of the file
	 * @return true if hoffman tree is successfully created
	 * @throws IOException 
	 */
	public boolean createBinaryTree(BufferedReader file) throws IOException{
		file.readLine();
		boolean ans = createBinaryTree(file, firstNode, "");
		Collections.sort(characters);
		return ans;

	}

	/**
	 * Recursive method for creating bianry tree
	 * @param fileName - file name of the tree
	 * @param n - counter for the array
	 * @return
	 * @throws IOException 
	 */
	private boolean createBinaryTree(BufferedReader file, BinaryNode<String> currentNode, String currentCode) throws IOException {
		String str = file.readLine();
		if(str == null || str.equals(""))
			return true;
		if(str.charAt(0) == 'I') {
			currentNode.setLeftChild(new BinaryNode<String>(null));
			if(!createBinaryTree(file, currentNode.getLeftChild(), currentCode + "0"))
				return false;
		}else if(str.charAt(0) == 'L'){
			currentNode.setLeftChild(new BinaryNode<String>(str.substring(2,3)));
			characters.add(new HuffmanCode(str.substring(2,3), currentCode + "0"));
		}else {
			return false;
		}
		str = file.readLine();
		if(str == null || str.equals(""))
			return true;
		if(str.charAt(0) == 'I') {
			currentNode.setRightChild(new BinaryNode<String>(null));
			if(!createBinaryTree(file, currentNode.getRightChild(), currentCode + "1"))
				return false;
		}else if(str.charAt(0) == 'L'){
			currentNode.setRightChild(new BinaryNode<String>(str.substring(2,3)));
			characters.add(new HuffmanCode(str.substring(2,3), currentCode + "1"));
		}
		return true;


	}

	public void printTree() {
		printTree(firstNode, "");
	}

	private void printTree(BinaryNode<String> currentNode, String currentCode) {
		for(HuffmanCode code: characters) {
			System.out.println(code);
		}
	}

	public String getCharacters() {
		String ans = "";
		for(HuffmanCode code: characters) {
			ans += code.getLetter();
		}
		return ans;
	}

	public String getHuffmanCode(String word) {
		String ans = "";
		for(int i = 0; i < word.length(); i++) {
			int n = 0;
			while(n < characters.size() && !characters.get(n).getLetter().equals(word.substring(i, i+1))){
				n++;
			}
			if(n < characters.size())
				ans += characters.get(n).getCode() + "\n";
			else {
				return "Invalid Input";
			}
		}
		return ans;
	}
	
	public String decode(String message) {
		return decode(message, firstNode, "");
	}
	
	public String decode(String message, BinaryNode<String> currentNode, String ans){
		if(currentNode.getData() == null) {
			if(message.equals(""))
				return "Invalid Input.";
			if(message.charAt(0) == '0') {
				return decode(message.substring(1), currentNode.getLeftChild(), ans);
			}else
				return decode(message.substring(1), currentNode.getRightChild(), ans);
		}else {
			if(message.equals(""))
				return ans += currentNode.getData();
			ans += currentNode.getData();
			return decode(message, firstNode, ans);
		}
	}


}
