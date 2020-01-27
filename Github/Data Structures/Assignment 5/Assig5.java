import java.io.*;
import java.util.Scanner;

public class Assig5 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the file: ");
		String fileName = sc.next();
		File file = new File(fileName);
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(file));
		HuffmanTree tree = new HuffmanTree();
		if(tree.createBinaryTree(br))
			System.out.println("The Huffman Tree has been restored.");
		else {
			System.out.println("The Huffman Tree is invalid");
		}
		int userInput = 0;
		while(userInput != 3) {
			System.out.println("Please choose from the following:\n" +
					"1) Encode a text string \n2) Decode a Huffman String \n3) Quit");
			userInput = sc.nextInt();
			switch(userInput) {
			case 1:
				System.out.println("Enter a String from the following characters:");
				System.out.println(tree.getCharacters());
				sc.nextLine();
				String str = sc.nextLine();
				System.out.println("Huffman String:");
			
				System.out.println(tree.getHuffmanCode(str));
				break;
			case 2:
				System.out.println("Here is the encoding table:");
				tree.printTree();
				System.out.println("Please enter a Huffman string (one line, no spaces)");
				sc.nextLine();
				String message = sc.nextLine();
				System.out.println("Text String: ");
				System.out.println(tree.decode(message));
				break;
			case 3:
				System.out.println("Goodbye");
				break;
			default:
				break;
			}
		}
		sc.close();
	}

}
