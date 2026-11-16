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

public class PatientHealthController {
	
	ObservableList<Patient> obs_patients = FXCollections.observableArrayList();

    @FXML
    private ListView<Patient> patientListView;

    @FXML
    private TextArea patientTextArea;
    
    public void initialize()
    {
    	try (BufferedReader input = Files.newBufferedReader(Paths.get("patients.xml")))
    	{
    		Patients patients = JAXB.unmarshal(input, Patients.class);
    		
    		for(Patient p: patients.getPatients())
    		{
    			obs_patients.add(p);
    		}
    		
    		patientListView.setItems(obs_patients);
    		
    		patientListView.getSelectionModel().selectedItemProperty().addListener(
    				new ChangeListener<Patient>()
    				{
    					@Override
    					public void changed(ObservableValue<? extends Patient> ov, Patient oldValue, Patient newValue)
    					{
    						patientTextArea.setText(preparePatientInfo(newValue));
    						
    					}
    					
    				}
    				
    				
    				);
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public String preparePatientInfo(Patient patient)
    {
    	String info = "";
    	info += "Insurance ID: " + patient.getInsuranceId();
    	info += "\nName: " + patient.getFirstName() + " " + patient.getLastName();
    	info += "\nAge: " + patient.getProfile().getAge();
    	info += String.format("%nWeight: %.1f lb", patient.getProfile().getWeightInPounds());
    	info += String.format("%nHeight: %.1f in", patient.getProfile().getHeightInInches());
    	info += String.format("%n%nBMI: %.2f", patient.getProfile().BMIIndex());
    	info += "\nBMI Category: " + patient.getProfile().getBMICategory();
    	info += "\nTarget Heart Rate Range: " + patient.getProfile().calcTargetHeartRateRange();
    	info += "\n\n" + patient.getCareDetails();
    	
    	return info;
    }
  }
