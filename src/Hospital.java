package kaau1;
import java.util.ArrayList;
public class Hospital {

	private ArrayList<String> clinic = new ArrayList<String>();
	private ArrayList<String> patientsfile = new ArrayList<String>();
	public Hospital(ArrayList<String> clinic, ArrayList<String> patientsfile) {
		super();
		this.clinic = clinic;
		this.patientsfile = patientsfile;
		
		
		clinic.add("heart clinic");
		clinic.add("Dental clinic");
		clinic.add("Surgery clinic");
		clinic.add("Orthopedic Clinic");
		clinic.add("Kids Clinic");
		clinic.add("Internal Medicine Clinic");
		clinic.add("Dermatology clinic");
		System.out.println(clinic.toString());
	}

	public Hospital() {

	}
}
