package rocammo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

class Book {
	int id;
	int score;
}

class Library {
	ArrayList<Book> books;
	int loadingTime;
	
	public Library() {
		this.books = new ArrayList<Book>();
	}
}

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
	
	public static void main(String[] args) {
		Library l1 = readFile(IN_1);
		Library l2 = readFile(IN_2);
		Library l3 = readFile(IN_3);
		Library l4 = readFile(IN_4);
		Library l5 = readFile(IN_5);
		Library l6 = readFile(IN_6);
	}
	
	private static Library readFile(String path) throws IOException {
		int[] index;
		ArrayList<Integer> list = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader(path));

		String line = br.readLine();
		String[] header = line.split(" ");
		int scoreToReach = Integer.parseInt(header[0]);
		int arraySize = Integer.parseInt(header[1]);

//		Library library = new Library(...);

		index = new int[arraySize];
		line = br.readLine();
		String[] sizes = line.split(" ");
		for (int i = 0; i < sizes.length; i++) {
			index[i] = Integer.parseInt(sizes[i]);
			list.add(index[i]);
		}

//		library.fill(index);

		br.close();

//		return library;
	}
	
	public static void writeFile(String path, Library library) throws FileNotFoundException {
		PrintStream fw = new PrintStream(new File(path));
		fw.println(library);
		fw.close();
	}
}
