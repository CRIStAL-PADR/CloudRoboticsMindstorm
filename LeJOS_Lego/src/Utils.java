import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static List<String> split(String s, char c) {
		
		List<String> splittedString = new ArrayList<String>();
		String temp = "";
		
		for(char sc: s.toCharArray()) {			
		    if(sc == c) {
		    	splittedString.add(temp);
		    	temp = "";
		    } else {
		    	temp += c;
		    }
		}
		
		return splittedString;
	}
}
