package jfont;

import java.util.ArrayList;

public class Book implements Comparable {

	public int points;
	public int id;
	public boolean sent = false;
//	public ArrayList<Integer> libraries;
	
	public Book(int index, int points) {
//		libraries = new ArrayList<Integer>();
		this.id = index;
		this.points = points;
	}
	
	@Override
	public String toString() {
		return id+" - "+points+" points";
	}
	
	
//	public void addLibrary(int idLibrary) {
//		libraries.add(idLibrary);
//	}

	@Override
	public int compareTo(Object o) {
		return ((Book) o).points - this.points;
	}
	
}
