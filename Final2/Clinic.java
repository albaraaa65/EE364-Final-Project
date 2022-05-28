package src;
import java.util.Stack;
public class Clinic {

	    Stack<Doctor> ArrayOfDoctor = new Stack<Doctor>();
	    Stack<Appointment> ArrayOfAppointment = new Stack<Appointment>();
	    int ClinicNumber = 0;

	    /**
	     * Constructor
	     * @param clinicNumber: Clinic number for further usage
	     */
	    Clinic(int clinicNumber){
	        ClinicNumber = clinicNumber;
	    }

	    /**
	     * Add appointment to the clinic
	     * @param appointment: appointment object
	     * @return number of appointments after last addition
	     */
	    public int AddAppointment(Appointment appointment){
	        ArrayOfAppointment.push(appointment);
	        return  ArrayOfAppointment.size();
	    }

	    /**
	     * Add doctor to the clinic
	     * @param doctor: doctor object
	     */
	    public void AddDoctor(Doctor doctor){
	        ArrayOfDoctor.push(doctor);
	    }

	    /**
	     * Remove earliest appointment
	     */
	    public void EndCurrentAppointment(){
	        ArrayOfAppointment.pop();
	    }
	}

	
	
	
	
	
	

