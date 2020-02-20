package rocammo;

import java.util.ArrayList;


public class Problem {
	
	int daysInTotal;
	
	ArrayList<Library> libraries;
	ArrayList<Book> books;
	
	public Problem() {
		libraries = new ArrayList<Library>();
		books = new ArrayList<Book>();
	}
	
	public void addBook(Book b) {
		books.add(b);
	}
	
	public void addLibrary(Library l) {
		libraries.add(l);
	}
}
