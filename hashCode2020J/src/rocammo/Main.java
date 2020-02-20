package rocammo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
	public static final String IN_1 = "in/a_example.txt";
	public static final String IN_2 = "in/b_read_on.txt";
	public static final String IN_3 = "in/c_incunabula.txt";
	public static final String IN_4 = "in/d_tough_choices.txt";
	public static final String IN_5 = "in/e_so_many_books.txt";
	public static final String IN_6 = "in/f_libraries_of_the_world.txt";
	
	public static final String OUT_1 = "out/a_example.txt";
	public static final String OUT_2 = "out/b_read_on.txt";
	public static final String OUT_3 = "out/c_incunabula.txt";
	public static final String OUT_4 = "out/d_tough_choices.txt";
	public static final String OUT_5 = "out/e_so_many_books.txt";
	public static final String OUT_6 = "out/f_libraries_of_the_world.txt";
	
	public static void main(String[] args) throws IOException {
//		Problem l1 = readFile(IN_1);
		Problem l2 = readFile(IN_2);
//		Problem l3 = readFile(IN_3);
//		Problem l4 = readFile(IN_4);
//		Problem l5 = readFile(IN_5);
//		Problem l6 = readFile(IN_6);
		
		
	}
	
	private static Problem readFile(String path) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));

		String line = br.readLine();
		String[] header = line.split(" ");
		
		Problem problem = new Problem();
		problem.daysInTotal = Integer.parseInt(header[2]);

		line = br.readLine();
		String[] sizes = line.split(" ");
		for (int i = 0; i < sizes.length; i++) {
			problem.addBook(new Book(Integer.parseInt(sizes[i])));
		}
		
		Library library = new Library();
		
		while ((line = br.readLine()) != null) {
			String[] digits = line.split(" ");
			library.timeToSignUp = Integer.parseInt(digits[1]);
			library.booksPerDay = Integer.parseInt(digits[2]);
			
			line = br.readLine();
			String[] digits2 = line.split(" ");
			for (int i = 0; i < digits2.length; i++) {
				library.books.add(Integer.parseInt(digits[i]));
			}
			
			problem.addLibrary(library);
		}

		br.close();

		return problem;
	}
	
	public static void writeFile(String path, Library library) throws FileNotFoundException {
		PrintStream fw = new PrintStream(new File(path));
		fw.println(library);
		fw.close();
	}
}
