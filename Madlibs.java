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
		static String replacements[];
		static String newSentence = null;
		
		public static String[] getSentence()
	    {
	        Scanner in = new Scanner(System.in);
	        System.out.print("Input a sentence for a madlib: ");
	        String sentenceString = in.nextLine();
	        in.close();
	        // switch statement with int data type
	        try {
	        	sentence = sentenceString.split(" ");
	        }

	        catch (NumberFormatException e)
	        {
	            throw new NumberFormatException("The characters you entered did not match the conversion format.");
	        }

	         catch (IllegalArgumentException e)
	        {
	            throw new IllegalArgumentException("Conversion format not one of i, b or h.");
	        }
			return sentence;

	    }

		
		/* Function authorSetup
	   * Author enters a sentence string. It is converted to an array. 
	   * Author enters number of words to replace, then which ones, and replaces 
	   * those words with their corresponding parts of speech in the array.
	   * @param none
	   * @return none
	   */  
		
//		public static void authorSetup(){
//			sentenceString = prompt("Input a sentence for a madlib: ");
//			sentence = sentenceString.split(" ");
//			toReplace = prompt("How many words to replace? ");
//			for(let i = 0; i < toReplace; i++){
//				replaceIndex = prompt("Replace which word in sentence? ");
//				replaceIndex--;
//				replacements[i] = replaceIndex;
//				let partOfSpeech = prompt("What part of speech is "+sentence[replaceIndex]+"? ");
//				sentence[replaceIndex] = partOfSpeech;
//			}
//			System.out.print("Author, go get Player");
//		}
		
		/* Function playerPopulate
	   * Ask player for replacement words.
	   * @param none
	   * @return none
	   */
		
//		public static void playerPopulate(){
//			for(let i = 0; i < toReplace; i++){
//				replacement = prompt("Enter a "+sentence[replacements[i]]);
//				sentence[replacements[i]] = replacement;
//			}
//		}
		
		/* Function displayResult
	   * Creates a new sentence from the sentence array. 
	   * Instructs player to get author so they can see the new sentence
	   * Prompts to play again, returns confirm result.
	   * @param none
	   * @return again (boolean)
	   */
		
//		public static void displayResult(){
//			newSentence = sentence.join(" ");
//			let ready = confirm("Get Author, then press OK to see new sentence.");
//			System.out.print(newSentence);
//			let again = confirm("Play again?");
//			return again;
//		}
		
		/* Function Main
		 * Manages game play: initializes variables and calls authorSetup and playerPopulate.  
		 * Based on returned value of displayResult, recursively calls itself or alerts thanks and ends. 
		 * All functions are within Main so that variables can be accessed without globals. 
		 * @param none
		 * @return none
		 */
		public static void main(){
			// initialize variables (in one line!)
			
			// function calls
//			authorSetup();
//			playerPopulate();
//			if(displayResult() = true){
//			main();
//			}
//			System.out.print("Thanks for playing");
			System.out.print(getSentence());
		}
	// End Function Main
}
