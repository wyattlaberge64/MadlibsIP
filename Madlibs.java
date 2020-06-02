import java.util.Arrays;
import java.util.Scanner;

/* Mad libs - Java - Only version
 * See flowchart: https://www.lucidchart.com/documents/view/1ac364ec-8af0-4668-b874-f3eba4b9e570
 * Traditional MadLibs game: Author creates a sentence, decides which words to get replaced, enters
 * parts of speech for those words. Gets player(s) who enter new words that match the parts of speech
 * without knowing the original sentence.  Then everyone gathers to read the new silly sentence. 
 */
public class Madlibs {
	
		static String sentenceString = null; 
		static String sentence[];
		static int toReplace = 0;
		static int replaceIndex = 0;
		static String replacement = null;
		static String newSentence;
		static String prompt = null;
		static int replacements[];
		static String oldSentence;
		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";
		
		public static String[] getSentence()
	    {
	        Scanner in = new Scanner(System.in);
	        System.out.print(ANSI_GREEN + "Input a sentence for a madlib: " + ANSI_RESET);
	        String sentenceString = in.nextLine();
	        //in.close();
	        // switch statement with int data type
	        try {
	        	sentence = sentenceString.split(" ");
	        }

	        catch (NumberFormatException e)
	        {
	            throw new NumberFormatException(ANSI_RED + "The characters you entered did not match the conversion format." + ANSI_RESET);
	        }

	         catch (IllegalArgumentException e)
	        {
	            throw new IllegalArgumentException(ANSI_RED + "Conversion format not one of i, b or h." + ANSI_RESET);
	        }
			return sentence;

	    }

		public static int getToReplace(String prompt)
	    {
	        Scanner input = new Scanner(System.in);
	        System.out.print(ANSI_BLUE + prompt + ANSI_RESET);
	        int toReplace = 999;
	        toReplace = input.nextInt();
	        //input.close();
	        // switch statement with int data type
	        if(toReplace != (int)toReplace) {
	        	System.out.print(ANSI_YELLOW + "Must be a numeral" + ANSI_RESET);
	        	toReplace = getToReplace(prompt);
	        }
			return toReplace;
	    }
		
		public static String getWord(int replaceIndex, String prompt)
	    {
	        Scanner inWord = new Scanner(System.in);
	        System.out.print(ANSI_PURPLE + prompt +sentence[replaceIndex]+"? " + ANSI_RESET);
	        String partOfSpeech = inWord.nextLine();
	        //inWord.close();
			return partOfSpeech;
	    }
		
		public static void confirm(String prompt)
	    {
	        Scanner confirmPrompt = new Scanner(System.in);
	        System.out.print(ANSI_BLUE + prompt + ANSI_RESET);
	        int toConfirm = confirmPrompt.nextInt();
	        //input.close();
	    }
		
		  
		/* Function authorSetup
	   * Author enters a sentence string. It is converted to an array. 
	   * Author enters number of words to replace, then which ones, and replaces 
	   * those words with their corresponding parts of speech in the array.
	   * @param none
	   * @return none
	   */  
		
		public static void authorSetup(){
			sentence = getSentence();
			oldSentence = String.join(" ", sentence);
			toReplace = getToReplace(ANSI_CYAN + "How many words to replace? " + ANSI_RESET);
			replacements = new int[toReplace];
			String partOfSpeech = null;
			for(int i = 0; i < toReplace; i++){
				replaceIndex = getToReplace("Replace which word in sentence? ");
				replaceIndex--;
				replacements[i] = replaceIndex;
				System.out.println("i = " + i + " replacements[i] = " + replacements[i] + " replaceIndex = " + replaceIndex);
				partOfSpeech = getWord(replaceIndex, "What part of speech is ");
				sentence[replaceIndex] = partOfSpeech;
			}
			System.out.print("Author, go get Player");
			System.out.println();
		}
		
		/* Function playerPopulate
	   * Ask player for replacement words.
	   * @param none
	   * @return none
	   */
		
		public static void playerPopulate(){
			for(int i = 0; i < toReplace; i++){
				replaceIndex = replacements[i];
				replacement = getWord(replaceIndex, "Enter a ");
				sentence[replaceIndex] = replacement;
			}
		}
		
		/* Function displayResult
	   * Creates a new sentence from the sentence array. 
	   * Instructs player to get author so they can see the new sentence
	   * Prompts to play again, returns confirm result.
	   * @param none
	   * @return again (boolean)
	   */
		
		public static void displayResult(){
			newSentence = String.join(" ", sentence);
			confirm("Get Author, then enter a number to see new sentence.");
			System.out.print("The old sentence was "+ oldSentence + ", and the new sentence is " + newSentence + ".");
		}
		
		/* Function Main
		 * Manages game play: initializes variables and calls authorSetup and playerPopulate.  
		 * Based on returned value of displayResult, recursively calls itself or alerts thanks and ends. 
		 * All functions are within Main so that variables can be accessed without globals. 
		 * @param none
		 * @return none
		 */
		public static void main(String args[]){
			// initialize variables (in one line!)
			
			// function calls
			authorSetup();
			playerPopulate();
			displayResult();
//			if(displayResult() = true){
//			main();
//			}
//			System.out.print("Thanks for playing");
		}
	// End Function Main
}
