package src;
import java.util.Stack;
public class Xray {

	    Stack<Patient> ArrayOfPatient = new Stack<>();

	    /**
	     * Add a patient to the patients array
	     * @param p: patient object
	     */
	    public void requestXray(Patient p){
	        ArrayOfPatient.push(p);
	    }
	}


