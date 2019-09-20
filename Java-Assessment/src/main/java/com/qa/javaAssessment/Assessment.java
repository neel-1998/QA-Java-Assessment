package com.qa.javaAssessment;

import java.util.Arrays;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
        String[] aryWord = input.split("");
        String newWord;
        String output = input.replaceAll("(?i)bert", " ");
        String[] aryTemp = output.split("");
        if ((aryWord.length - aryTemp.length) <= 4) {
            newWord = "";
        } else {
            newWord = output;
            newWord = newWord.substring(newWord.indexOf(" ") + 1);
            String[] revTemp = newWord.split("");
            String[] revTemp2 = newWord.split("");
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < revTemp.length; i++) {
                revTemp[i] = revTemp2[revTemp.length - i - 1];
                answer.append(revTemp[i]);
            }
            newWord = answer.toString();
            newWord = newWord.substring(newWord.indexOf(" ") + 1);
            newWord = newWord.trim();
        }
        String answer = newWord;
        return answer;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
        int[] num = {a, b, c};
        Arrays.sort(num);
        if((num[2]-num[1]) == (num[1]-num[0])) {
            return true;
        } else {
            return false;
        }
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
        String[] aryWord = input.split("");
        String[] output = new String[aryWord.length];
        int mid = (aryWord.length / 2);
        for(int i=0; i<a; i++) {
            if (a % 2 == 1) {
                aryWord[mid + (i / 2)] = "remove";
                aryWord[mid - (i / 2)] = "remove";
                aryWord[mid] = "remove";
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int j = 0; j < aryWord.length; j++) {
            if(aryWord[j].equals("remove") == false) {
                output[j] = aryWord[j];
                answer.append(output[j]);
            }
        }
        String newWord = answer.toString();
        return newWord;
    }


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
        String[] aryWord = input.split("");
        int counter = 1;
        int values[] = new int[aryWord.length];
        for(int i=0; i<aryWord.length-1; i++) {
            if(aryWord[i+1].equals(aryWord[i]) == true) {
                counter += 1;
                values[i] = counter;
            } else {
                counter = 1;
                values[i] = counter;
            }
        }
        Arrays.sort(values);
        return values[aryWord.length - 1];
    }

	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
        String[] aryArg1 = arg1.split(" ");
        int counter = 0;
        for(int i=0; i<aryArg1.length; i++){
            if(aryArg1[i].compareToIgnoreCase("am") == 0) {
                counter += 1;
            }
        }
	    return counter;
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
        if (arg1 % 3 == 0 && arg1 % 5 == 0) {
            return "fizzbuzz";
        } else if (arg1 % 5 == 0) {
            return "buzz";
        } else if (arg1 % 3 == 0) {
            return "fizz";
        }
     return null;
    }


	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
        String[] aryArg1 = arg1.split(" ");
        int[] resultArray = new int[aryArg1.length];

        for(int i=0; i<aryArg1.length; i++) {
            int tot = 0;
            int n = aryArg1[i].split("").length;
            for(int j=0; j<n; j++) {
                tot += Integer.parseInt(aryArg1[i].split("")[j]);
            }
            resultArray[i] = tot;
        }
        Arrays.sort(resultArray);
        return resultArray[aryArg1.length - 1];
    }
}
