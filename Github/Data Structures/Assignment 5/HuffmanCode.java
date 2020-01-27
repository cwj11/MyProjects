

public class HuffmanCode implements Comparable<HuffmanCode> {

	private String letter;
	private String code;
	
	public HuffmanCode(String letter, String code) {
		this.letter = letter;
		this.code = code;
	}
	
	public String toString() {
		return letter + ": " + code;
	}
	
	public String getLetter() {
		return letter;
	}
	
	public String getCode() {
		return code;
	}

	@Override
	public int compareTo(HuffmanCode o) {
		return this.letter.compareTo(o.letter);
	}
	


	
}
