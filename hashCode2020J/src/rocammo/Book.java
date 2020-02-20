package rocammo;

import java.util.ArrayList;

public class Book implements Comparable {

	public int points;
	public ArrayList<Integer> libraries;
	
	public Book(int points) {
		libraries = new ArrayList<Integer>();
		this.points = points;
	}
	
	public void addLibrary(int idLibrary) {
		libraries.add(idLibrary);
	}

	@Override
	public int compareTo(Object o) {
		return this.points - ((Book) o).points;
	}
	
}
