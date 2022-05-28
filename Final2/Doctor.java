package src;
import java.util.Stack;
public class Doctor {

	    Stack<WalkIn> ArrayOfWalkinin = new Stack<>();
	    Stack<Appointment> ArrayOfAppointment = new Stack<>();
	    int DoctorNumber = 0;

	    /**
	     * Constructor
	     * @param doctorNumber: for further usage
	     */
	    Doctor(int doctorNumber){
	        DoctorNumber = doctorNumber;
	    }

	    /**
	     *  Add appointment to the current doctor
	     * @param appointment : recently reserved appointment
	     * @return : Number of appointments
	     */
	    public int AddAppointment(Appointment appointment){
	        ArrayOfAppointment.push(appointment);
	        return  ArrayOfAppointment.size();
	    }

	    /**
	     * Remove the earliest appointment from the list
	     * @return : the removed patient object
	     */
	    public Patient EndCurrentAppointment(){
	        Patient p = ArrayOfAppointment.firstElement().patient;
	        ArrayOfAppointment.pop();
	        return  p;
	    }
	}

	
	
	

