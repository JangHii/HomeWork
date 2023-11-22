package word;


public class Word {

	
	public String word ;
	public String mean ;
	
	
	public Word() {}
	public Word(String word, String mean) {
		this.word = word;
		this.mean = mean;
	}
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	
	
	@Override
	public String toString() {
		return "Word [word=" + word + ", mean=" + mean + "]";
	}
	
	
	
	
	
}



