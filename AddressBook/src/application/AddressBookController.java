package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXB;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class AddressBookController {
	
	ObservableList<Contact> obs = FXCollections.observableArrayList();
	
	public void initialize()
	{
		try(BufferedReader input = Files.newBufferedReader(Paths.get("contacts.xml")))
		{
			Contacts contacts = JAXB.unmarshal(input, Contacts.class);
			
			for(Contact c: contacts.getContacts())
			{
				obs.add(c);
			}
			
			contactListView.setItems(obs);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		contactListView.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Contact>() {
					
					@Override
					public void changed(ObservableValue<? extends Contact> ov, Contact oldContact, Contact newContact)
					{
						if(newContact != null)
							contactTextArea.setText(newContact.getContactString());
					}
				}
			);
	}

    @FXML
    private ListView<Contact> contactListView;

    @FXML
    private TextArea contactTextArea;

}
