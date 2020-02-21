package jfont;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

	int timeToSignUp;
	ArrayList<Book> books;
	ArrayList<Book> selected;
	int booksPerDay;
	int id;
	long lastPointsCalculated;

	public Library(int id) {
		this.id = id;
		this.books = new ArrayList<Book>();
		this.selected = new ArrayList<Book>();
	}

	public void sort() {
		Collections.sort(books);
	}

	public float daysToComplete() {
		long total = timeToSignUp;

		total += books.size() / booksPerDay;

		return total;
	}

	public ArrayList<Book> selectLibrary(int daysLeft) {

		int maxBooks = (daysLeft - this.timeToSignUp) * booksPerDay;

		int currentBook = 0;

		while (currentBook < books.size() && selected.size() < maxBooks) {
			selected.add(books.get(currentBook));
			currentBook++;
		}

		// System.out.println("MaxBooks: "+maxBooks+" - Selected:"+selected.size()+" -
		// booksInLibrary"+books.size()+" - points last:"+lastPointsCalculated);

		return selected;
	}

	public long getPoints(int daysLeft) {
		int days = daysLeft - timeToSignUp;
		int maximumBooks = booksPerDay * days;

		long points = 0;
		int currentBook = 0;
		while (currentBook < maximumBooks && currentBook < books.size()) {

			points += books.get(currentBook).points;
			currentBook++;

		}

		lastPointsCalculated = points;

//		if (currentBook >= books.size()) {
//
//			int gapDays = (maximumBooks - currentBook) / booksPerDay;
//			int workDays = currentBook / booksPerDay;
//
//			float pointsPerDay = points / (float) workDays;
//
//			lastPointsCalculated = (int) (points - pointsPerDay * gapDays);
//		}

//		if(currentBook < maximumBooks) {
//			lastPointsCalculated = 0;
//		}
		return lastPointsCalculated;
	}

	public float getRatio() {
		if (lastPointsCalculated <= 0)
			return lastPointsCalculated;
		return lastPointsCalculated/this.timeToSignUp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "LP: " + lastPointsCalculated;
	}

}
