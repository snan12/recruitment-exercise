package words;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Words {
	int sum=0;
	
	 public static List<String> getUniqueWordsFromSentence(String sentence) {
		 List<String> list = null;
		 String refinedSentence = "";
		
			try {
				sentence = sentence.toLowerCase();
				refinedSentence = sentence.replaceAll("[^a-zA-Z ]", " ");
				String[] wordsList = refinedSentence.split("\\s+");
				Set<String> uniqueWordList = new HashSet<>();
				for (String eachWordFromWordList : wordsList) {
					uniqueWordList.add(eachWordFromWordList);
				}

				list = new ArrayList<>(uniqueWordList);
			} catch (UnsupportedOperationException exception) {
				exception.printStackTrace();

			} catch (Exception | Error exception) {
				exception.printStackTrace();

			}

			return list;
		}


	 public int add(int a, int b) {
			int inputone;
			int inputtwo;
			//int sum=0;

			try {
				inputone = a;
				inputtwo = b;
				sum = inputone + inputtwo;

			} catch (Exception e) {
				e.printStackTrace();

			}
			 
		  return sum;
		}



	
}