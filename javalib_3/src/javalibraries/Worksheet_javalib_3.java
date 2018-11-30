package javalibraries;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Worksheet_javalib_3 {
	/**
	 * Every Java application must contain at least one main function. The Java
	 * Virtual Machine searches for this function and calls it first to launch
	 * the application.
	 *
	 * @param args An array of Strings given on the command-line.
	 */
		
	static public void main(String[] args) {
		
		//Read contents of file specified in the parameter
		readFile("res/inputfile.txt");
		
		//New string containing the text to be written into a new file.
		String[] content = {
				"The",
				" quick",
				" brown",
				" fox",
				" jumps",
				" over",
				" the",
				" lazy",
				" dogs",
				" tail",
				"."
			};

		//Create a new file named as stated in the first parameter 
		//& paste contents of second parameter into the file body
		writeFile("res/outputfile.txt",content);
	} // END FUNCTION main
	
	static public void readFile(String filename) { //Read contents of file specified in the parameter
		
		//Create a new 'file' object to store file location
		File inputFile = new File(filename);
		// Java must fetch the data from the storage medium (like a disk) so
		// some classes are provided to do this. FileReader allows us to read
		// the raw characters from the file
		FileReader reader = null;
		// Reading characters is time consuming so Java provides another class that
		// does this for us and offers a more useful interface
		BufferedReader inputBuffer = null;

		try {
			// a FileReader is created by passing a File object as a parameter to the constructor
			// this throws an exception if the file does not exist so we have to catch it.
			reader = new FileReader(inputFile);
			// a BufferedReader is created by passing a Reader as a parameter to the constructor
			inputBuffer = new BufferedReader(reader);
			String inputLine = inputBuffer.readLine();
			
			//WHILE the next line is not null, print line to console
			while(inputBuffer.readLine() != null) {
				inputLine = inputBuffer.readLine();
				System.out.println(inputLine);
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();

		} catch (IOException ioe) {
			ioe.printStackTrace();

		} finally {
			if(inputBuffer != null) {
				try {
					inputBuffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static public void writeFile(String filename, String[] content) {
		
		File outputFile = new File(filename);
		try {

			if(outputFile.createNewFile()){
				System.out.println("New file created : " + filename);
			}else{

				System.out.println("File already exists : " + filename);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	
	FileWriter writer = null;
	BufferedWriter outputBuffer = null;
	try {
		
		writer = new FileWriter(filename);
		
		outputBuffer = new BufferedWriter(writer);
		
		for(int i=0; i<content.length;i++) {
			
			outputBuffer.write(content[i]+"\n");
		}
		
	}catch(IOException ioe){
		ioe.printStackTrace();
		
	}finally{
		if(outputBuffer != null){
			try {
				outputBuffer.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
			}
		}
	}
}

