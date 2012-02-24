import java.io.*;


public class GrammarGen{
	public static void main(String args[]){
		if(args.length == 0){ //Need one input minimum
			System.out.println("Expected Filename");
			return;
		}
		String filename = args[0];
		Parser myParse = new Parser();
		String[] data = myParse.parse(filename);
		String grammar = new String("default");
		try{
			grammar = args[1]; //If there is a second argument, it will be made the name of the grammar
		}
		catch(IndexOutOfBoundsException e){}
		FileWriter myWriter;
		//BufferedWriter myWriter;
		try{
			myWriter = new FileWriter(grammar + ".gram");
			//myWriter = new BufferedWriter(mWriter);
			myWriter.write("#JSGF V1.0;\ngrammar " + grammar + ";\npublic <" + grammar + "Grammar> = (");
			for(int i = 0; i < (data.length - 1); i++){
				myWriter.write(data[i] + " | ");
				if(i%20 == 0){
					myWriter.write("\n");
				}
			}
			myWriter.write(data[data.length-1] + ") *;");
			myWriter.close();
		}catch(IOException e){
			System.out.println("File not available for writing");
			System.exit(0);
		}
		
	}
}