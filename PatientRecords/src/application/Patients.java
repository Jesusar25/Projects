package application;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patients")
@XmlAccessorType(XmlAccessType.FIELD)
public class Patients {

    // Provided mapping for the two patient types.
    @XmlElements({
        @XmlElement(name = "inpatient", type = InPatient.class),
        @XmlElement(name = "outpatient", type = OutPatient.class)
    })
    private ArrayList<Patient> patients = new ArrayList<>();

    public Patients() {
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
}

