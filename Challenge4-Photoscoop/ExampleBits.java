//UIUC CS125 FALL 2014 MP. File: ExampleBits.java, CS125 Project: Challenge4-Photoscoop, Version: 2015-09-28T09:39:24-0500.547710265

public class ExampleBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<16;i++) {
			TextIO.putln(i+ " "+Integer.toHexString(i)+ " : "+Integer.toBinaryString(i));
		}
	}
}
