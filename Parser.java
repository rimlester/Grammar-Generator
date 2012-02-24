import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Parser {
	public String[] parse(String filename){
		Scanner p = null;
		try{
			p = new Scanner(new File(filename));
		}catch(IOException e){
			System.out.println("File Not Found");
			System.exit(0);
		}

		Pattern delim = Pattern.compile("[^a-z^A-Z]");
		p.useDelimiter(delim);
		ArrayList<String> dump = new ArrayList<String>(20);
		String temp = null;
		while(p.hasNext()){
			temp = p.next();
			if(!Pattern.matches("(^a-zA-Z)*", (CharSequence)temp)){
				dump.add(temp); 
			}
		}
		Reducer myReducer = new Reducer();
		String[] fin = myReducer.Reduce(dump);
		return(fin);
	}
	
}
