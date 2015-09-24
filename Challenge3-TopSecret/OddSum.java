//UIUC CS125 FALL 2014 MP. File: OddSum.java, CS125 Project: Challenge3-TopSecret, Version: 2015-09-20T22:31:37-0500.575882357
/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author qilezhi2
 */
public class OddSum { 
/**
Example output if user enters 10:
Max?
1 + 3 + 5 + 7 + 9 = 25
25 = 9 + 7 + 5 + 3 + 1

Example output if user enters 11:
Max?
1 + 3 + 5 + 7 + 9 + 11 = 36
36 = 11 + 9 + 7 + 5 + 3 + 1

 */
 public static void main(String[] args) { 
	 
	 // Enter a positive number.
	 int num = TextIO.getlnInt(); 
	 while (num<=0) num = TextIO.getlnInt();
	 
	 int sum = 1;
	 int i;
	 
	 TextIO.putln("Max?");
	 
	 // Print the first line.
	 String s1="1";
	 
	 for (i=3; i<=num; i+=2) {
		 s1 += " + " + i;
		 sum += i;
	 }
	 s1 += " = " + sum;
	 TextIO.putln(s1);
	 
	 // Print the second line.
	 String s2 = "";
	 s2 += sum + " = ";
	 
	 if (num%2==0) num -= 1; // Find the biggest odd that is not bigger than num.
	 
	 for (int j=i-2; j>=3; j-=2) {
		 s2 += j + " + ";
	 }
	 s2 += "1";
	 TextIO.putln(s2);

  } // end of main method
 
} // end of class 
