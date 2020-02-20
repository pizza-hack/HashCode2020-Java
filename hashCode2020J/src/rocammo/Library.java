package rocammo;

import java.util.ArrayList;
import java.util.Collections;

public class Library {

	int timeToSignUp;
	ArrayList<Book> books;
	int booksPerDay;
	
	public Library() {
		this.books = new ArrayList<Book>();
	}
	
	public float daysToComplete() {
		long total = timeToSignUp;
		
		total += books.size()/booksPerDay;
		
		return total;
	}
	
	public long totalPoints() {
		long total = 0;
		for(Book b : books) {
			total += b.points;
		}
		return total;
	}
	
	public long getPoints(int daysLeft) {
		int days = daysLeft - timeToSignUp;
		int numB = booksPerDay * days;
		
		Collections.sort(books);
		
		long points = 0;
		for (int i = 0; i < numB; i++) {
			points += books.get(i).points;
		}
		
		return points;
	}
}
