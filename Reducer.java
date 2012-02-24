import java.util.ArrayList;


public class Reducer {
	public String[] Reduce(ArrayList<String> inp){
		ArrayList<String> red = new ArrayList<String>();
		for(int i = 0; i < inp.size(); i++){
			if(check(inp.get(i), red)){
				red.add(inp.get(i));
			}
		}
		String[] retString = new String[red.size()];
		for(int i = 0; i < red.size(); i++){
			retString[i] = (String)red.get(i);
		}
		return (retString);	
	}

	private boolean check(String inp, ArrayList<String> red){
		for(int i = 0; i < red.size(); i++){
				if(inp.equalsIgnoreCase(red.get(i))||inp.equals("^")){
					return false;
				}
		}
		return true;
	}
}
