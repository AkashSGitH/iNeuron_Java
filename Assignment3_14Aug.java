package ineuronJava;

import java.util.Scanner;

public class Assignment3_14Aug {

	public static void main(String[] args) {
		// 1. WAP reverse a string
		// input: iNeuron
		// output: norueNi

		String s1 = "iNeuron";
		String s2 = "";

		for (int i = s1.length() - 1; i >= 0; i--) {
			s2 = s2 + s1.charAt(i);
		}
		System.out.println(s1);
		System.out.println(s2);

		System.out.println("**************************************");

		// 2. WAP to reverse a sentence while preserving the position.
		// Input : “Think Twice”
		// Output : “kniht eciwt”

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two words to reverse words' letters while preserving their position:");
		String s3=sc.nextLine().toUpperCase();
		System.out.println(s3);
		
		String s4 = "";

		String a[] = s3.split(" ");
		
		int len = a.length;
		System.out.println(a[0]);
		System.out.println(a[1]);
		for(int k=0;k<len;k++) {
			for(int i=a[k].length()-1;i>=0;i--) {
				s4=s4+a[k].charAt(i);
			}
			s4=s4+" ";
		}
			
			System.out.println(s4);

		System.out.println("**************************************");

//		3. WAP to check if the String is Anagram or not.  
		// An anagram is a word that creates another word from the letters of the
//		initial word given provided that the  letters are used exactly once   HEART --> EARTH  --> HATER

		// use two strings s1 and s2, if they are anagram of each other then return true
		// primary case: check length of both the strings
		System.out.println("Enter first word to check for Anagram :");
		String sa1 = sc.nextLine().toUpperCase();
		System.out.println(sa1);
		System.out.println("Enter second word to check for Anagram :");
		String sa2 = sc.nextLine().toUpperCase();
		System.out.println(sa2);

		char[] ca1 = sa1.toCharArray();
		char[] ca2 = sa2.toCharArray();

		// check their lengths
		if (ca1.length == ca2.length) {

			// sorting first string
			for (int i = 0; i < ca1.length; i++) {
				for (int j = i + 1; j < ca1.length; j++) {
					char temp;
					if ((int) ca1[i] > (int) ca1[j]) {
						temp = ca1[i];
						ca1[i] = ca1[j];
						ca1[j] = temp;
					}
				}
			}
			// sorting second string
			for (int i = 0; i < ca2.length; i++) {
				for (int j = i + 1; j < ca2.length; j++) {
					char temp;
					if ((int) ca2[i] > (int) ca2[j]) {
						temp = ca2[i];
						ca2[i] = ca2[j];
						ca2[j] = temp;
					}
				}
			}
			
			for(int i=0;i<ca1.length;i++) {
				if(ca1[i]!=ca2[i]) {
					System.out.println("Strings are NOT ANAGRAM");
					break;
				}
				else if(ca1[i]==ca2[i]&&i<(ca1.length)-1) {
					continue;
				}
				else {
					System.out.println("Strings are ANAGRAM");
				}
			}
				
		}
		
		else
		{
			System.out.println("Strings of different lengths CANNOT be ANAGRAM");
		}

		System.out.println("**************************************");


//		4. WAP to check if the String is a Pangram or not.  
//		pangram => all aplhabets atleast once

		System.out.println("Enter a sentence to check for pangram :");
		String pan = sc.nextLine().toUpperCase();
		System.out.println(pan);
		
		boolean p=false;
		// declaring an boolean array corresponding to each letter alphabetically 
		boolean [] check= new boolean[26];
		// setting every item as false, initially
		for(int i=0;i<check.length;i++) {
			check[i]=false;
		}
		
		char [] c= pan.toCharArray();
		int index = 0;
		for(int i=0;i<pan.length();i++) {
			if(c[i]>='A'&&c[i]<='Z') {
				index=c[i]-'A';
			}
			check[index]=true;
		}
		
		// checking for any false item in the check array
		for(int i=0;i<check.length;i++) {
			if(check[i]==false) {
				p=false;
				break;
			}
			else
				p=true;
		}
		
		if(p==true)
			System.out.println("The given string is pangram");
		else
			System.out.println("The given string is not pangram");
		
		System.out.println("**************************************");

//		5. WAP to print repeatedly occurring characters in the given String.

	System.out.println("Enter a word to check for repeated characters :");

	String s = sc.nextLine().toUpperCase();System.out.println(s);

	char [] ch = new char [s.length()];for(
	int i = 0;i<s.length();i++)
	{
		ch[i] = s.charAt(i);
	}
	// this can also be replaced with char [] c = s.toCharArray() method

	for(
	int i = 0;i<ch.length;i++)
	{
		int count = 1;
		for (int j = i + 1; j < ch.length; j++) {
			if (ch[i] == ch[j])
				count++;
		}
		if (count > 1)
			System.out.println(ch[i] + " " + count + " time(s)");
	}

	System.out.println("**************************************");

//		6. WAP to sort a String Alphabetically.

		System.out.println("Enter a word to check for Alphabetical order :");
		String s5 = sc.nextLine().toUpperCase();
		System.out.println(s5);
		
		char [] c1 = new char [s5.length()];
		String s6 = "";
		
		for(int i=0;i<c1.length;i++) {
			c1[i]=s5.charAt(i);
		}
				
		for(int i=0;i<c1.length;i++) {
			for(int j=i+1;j<c1.length;j++) {
				if((int)c1[i] > (int)c1[j]) {
					char temp;
					temp = c1[i];
//					System.out.println(temp);
					c1[i]=c1[j];
					c1[j]=temp;
				}
			}
		}
		
		for(int i=0; i<c1.length;i++) {
			s6=s6+c1[i];
		}
		
		System.out.println(s6);

	System.out.println("**************************************");

//		7. WAP to count the number of Vowels and Consonants of a String value.

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a word to count number of Vowels and Consonants :");
		
		String st1 = scan.nextLine().toUpperCase();
		System.out.println(st1);
		int cons_count=0, vow_count=0;
		
		for(int i=0;i<st1.length();i++) {
			if(  st1.charAt(i)=='A' || st1.charAt(i)=='E' || st1.charAt(i)=='I' || st1.charAt(i)=='O'
					|| st1.charAt(i)=='U' ) {
				vow_count++;
			}
			else {
				cons_count++;
			}
		}
		System.out.println("total number of vowels is "+vow_count);
		System.out.println("total number of consonants is "+cons_count);

	System.out.println("**************************************");

//		8. WAP to count number of special characters.

		System.out.println("Enter a word to count number of Special Characters :");
		
		String sq8 = sc.nextLine().toUpperCase();
		System.out.println(sq8);
		
		int sp_char=0;
		for(int i=0;i<sq8.length();i++) {
			if(  sq8.charAt(i)=='\t' || sq8.charAt(i)=='\b' || sq8.charAt(i)=='\r' || sq8.charAt(i)=='\n'
					|| sq8.charAt(i)=='\f'	|| sq8.charAt(i)=='\'' || sq8.charAt(i)=='\"' || sq8.charAt(i)=='\\' ) {
				sp_char++;
			}
			
		}
		
		System.out.println(sp_char);
	System.out.println("**************************************");

}

}
