package rocammo;

import java.util.ArrayList;

public class Library {

	int timeToSignUp;
	ArrayList<Integer> books;
	int booksPerDay;
	
	public Library() {
		this.books = new ArrayList<Integer>();
	}
	
	public float daysToComplete() {
		long total = timeToSignUp;
		
		total += books.size()/booksPerDay;
		
		return total;
	}
	
	public long totalPoints(ArrayList<Book> allBooks) {
		long total = 0;
		for(Integer i : books) {
			total += allBooks.get(i).points;
		}
		return total;
	}
	
}
