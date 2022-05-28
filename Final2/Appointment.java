package src;


public class Appointment {


	    Patient patient = new Patient();
	    PatientFile File;
	    Doctor Doctor;

	    /**
	     * Constructor
	     * @param p: patient object
	     * @param pf: PatientFile object
	     * @param d: Doctor object
	     */
	    Appointment(Patient p, PatientFile pf, Doctor d){
	        patient = p;
	        Doctor = d;
	        File = pf;
	    }
	}


