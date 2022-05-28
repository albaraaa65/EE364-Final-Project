package src;
import java.util.Stack;
public class Lab {


	    Stack<Patient> ArrayOfPatient = new Stack<>();

	    /**
	     * Add new patient to laboratory investigations
	     * @param p: patient object
	     */
	    public void requestLab(Patient p){
	        ArrayOfPatient.push(p);
	    }
	}


