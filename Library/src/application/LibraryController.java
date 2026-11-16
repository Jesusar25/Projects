package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class LibraryController {
	
    private final ObservableList<Book> books = FXCollections.observableArrayList();

    @FXML
    private ListView<Book> booksListView;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    void searchButtonPressed(ActionEvent event) {
    	
        setBooks();
      	booksListView.setItems(books);
      	String text = searchTextField.getText();
      	
      	ObservableList<Book> tempBooks = FXCollections.observableArrayList();
      	
      	for(int index = 0; index < books.size(); index++)
      	{
      		tempBooks.add(books.get(index));
      	}
      	   
      	books.clear();
      	
      	for(int index = 0; index < tempBooks.size(); index++)
      	{
      		Book book = tempBooks.get(index);
      		
      		if(text.isEmpty() || book.getTitle().contains(text) || book.getAuthor().contains(text))
      		{
      			books.add(book);
      		}

      	}
      	
      	booksListView.setItems(books);
      	
   }

    public void initialize()
    {
    	setBooks();
    }
    
    public void setBooks()
    {
    	books.clear();
    	
    	try(BufferedReader input = Files.newBufferedReader(Paths.get("library.xml"))) 
    		{
    			
    		      // unmarshal the file's contents
    		      Library mylibrary = JAXB.unmarshal(input, Library.class);

    		      for (Book book : mylibrary.getBooks()) {
    		        books.add(book);
    		      }
    		      booksListView.setItems(books);
    		   } 
    		   catch (IOException ioException) {
    		      System.err.println("Error opening file.");
    		   } 
    }

}
