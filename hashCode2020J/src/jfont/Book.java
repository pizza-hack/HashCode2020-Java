package jfont;

import java.util.ArrayList;

public class Book {

	public int points;
	public ArrayList<Integer> libraries;
	
	public Book(int points) {
		libraries = new ArrayList<Integer>();
		this.points = points;
	}
	
	public void addLibrary(int idLibrary) {
		libraries.add(idLibrary);
	}
	
}
