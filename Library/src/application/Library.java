package application;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Library {
	
	@XmlElement(name= "book") 
	private List<Book> books = new ArrayList<Book>();

	public List<Book> getBooks()
	{
		return books;
	}
}
