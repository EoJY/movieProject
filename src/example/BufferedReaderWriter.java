package example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class BufferedReaderWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File movie = new File("../example.txt");
		FileReader fr = new FileReader(movie);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("../");
	}	

}
