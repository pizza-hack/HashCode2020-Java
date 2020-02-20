package jfont;

import java.util.ArrayList;

public class Library {

	int timeToSignUp;
	ArrayList<Integer> books;
	int booksPerDay;
	ArrayList<Book> allBooks;
	
	public float daysToComplete() {
		long total = timeToSignUp;
		
		total += books.size()/booksPerDay;
		
		return total;
	}
	
	public long totalPoints() {
		long total = 0;
		for(Integer i : books) {
			total += allBooks.get(i).points;
		}
		return total;
	}
	
}
