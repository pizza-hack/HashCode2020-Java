package jfont;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Problem {
	
	int daysInTotal;
	
	ArrayList<Library> libraries;
	ArrayList<Book> allBooks;
	ArrayList<Library> selectedLibraries;
	
	public Problem() {
		libraries = new ArrayList<Library>();
		allBooks = new ArrayList<Book>();
		selectedLibraries = new ArrayList<Library>();
	}
	
	public void addBook(Book b) {
		allBooks.add(b);
	}
	
	public void addLibrary(Library l) {
		libraries.add(l);
	}
	
	int restDays;
	
	public void solve() {
		
		restDays = daysInTotal;
		
		while(restDays>1 && libraries.size()>0) {
			System.out.println("Quedan "+restDays+" dias");
			
			for(Library l : libraries) {
				l.getPoints(restDays);
			}
			
			Library best = Collections.max(libraries, new Comparator<Library>() {
				public int compare(Library l1, Library l2) {
					return (int) (l1.getRatio() - l2.getRatio());
				};
			});
			
			if(best.lastPointsCalculated>0) {
			
				ArrayList<Book> toRemove = best.selectLibrary(restDays);
				libraries.remove(best);
				selectedLibraries.add(best);
				
				for(Library l : libraries) {
					l.books.removeAll(toRemove);
				}
				
			}
			restDays -= best.timeToSignUp;
			
		}
		
	}
	
	public void writeSolution(PrintStream out) {
		out.println(selectedLibraries.size());
		long points = 0;
		for(int i=0;i<selectedLibraries.size();i++) {
			Library l = selectedLibraries.get(i);
			out.println(l.id+" "+l.selected.size());
			for(int b=0;b<l.selected.size();b++) {
				out.print(l.selected.get(b).id+" ");
				points += l.selected.get(b).points;
			}
			out.println();
		}
		System.out.println(points);
	}
}
