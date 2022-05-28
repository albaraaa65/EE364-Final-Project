package src;
//import statements
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * 	
 * @author "Team 8"
 *
 */
public class Hospital {
    Stack<PatientFile> ArrayOfPatientFile = new Stack<>();
    Stack<Clinic> ArrayOfClinic = new Stack<>();
    Stack<Doctor> ArrayOfDoctor = new Stack<>();
    Xray xray = new Xray();
    Lab lab = new Lab();

    /**
     * @param args: program arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to hospital management System");
        Hospital hospital = new Hospital();
        hospital.setup();
        hospital.mainLoop();
    }

    /**
     * Setup Method calling other creation function
     */
    private void setup(){
        CreateAllDoctors();
        CreateAllClinic();
    }

    /**
     * Creates all Hospital doctors
     */
    private void CreateAllDoctors(){
        for (int i=0; i < 6; i++) {
            Doctor doctor = new Doctor(i+1);
            ArrayOfDoctor.push(doctor);
        }
    }

    /**
     * Creates all hospital clinics
     */
    private void CreateAllClinic(){
        for (int i = 0; i<6; i++) {
            Clinic clinic = new Clinic(i+1);
            clinic.AddDoctor(ArrayOfDoctor.elementAt(i));
            ArrayOfClinic.push(clinic);
        }
    }

    /**
     * Main simulation loop
     * @apiNote : timeFactor in seconds representing how many seconds for each minute
     * @apiNote : time is the current minute
     * @apiNote : maxTime maximum minutes for simulation
     */
    private void mainLoop(){
        int timeFactor = 1; //time period for running the simulation
        int time = 0;
        int maxTime = 10;
        System.out.println("Simulation will begin for "+ maxTime + " times where 1 minute = " + timeFactor);
        while (time<maxTime) {
            try {
                TimeUnit.SECONDS.sleep(timeFactor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;
            Random random = new Random();
            Patient patient = new Patient();
            patient.FileNum = time + 100;
            int source = random.nextInt(6);
            switch (source) {
                case 0:
                    takeNewAppointment(patient);
                    break;
                case 1:
                    takeNewAppointment(patient);
                    break;
                case 2:
                    takeNewAppointment(patient);
                    break;
                case 3:
                    takeNewAppointment(patient);
                    break;
                case 4:
                    patient.walkIn.WalkIn = true;
                    checkIn(patient);
                    break;
                case 5:
                    patient.er.ER = true;
                    checkIn(patient);
                    break;
            }
            if (time % 5 == 0) {
                for (int i = 0; i < ArrayOfDoctor.size(); i++) {
                    if (ArrayOfDoctor.elementAt(i).ArrayOfAppointment.size() > 0) {
                        int dismiss = random.nextInt(2);
                        if (dismiss==1) {
                            Patient tp = ArrayOfDoctor.elementAt(i).EndCurrentAppointment();
                            ArrayOfClinic.elementAt(i).EndCurrentAppointment();
                            lab.ArrayOfPatient.push(tp);
                            xray.ArrayOfPatient.push(tp);
                            break;
                        }
                    }
                }
            }
            if (time%2 == 0) {
                for (int i = 0; i < ArrayOfDoctor.size(); i++){
                    if (ArrayOfDoctor.elementAt(i).ArrayOfWalkinin.size()>0) {
                        ArrayOfDoctor.elementAt(i).ArrayOfWalkinin.pop();
                        patient.FileNum = patient.FileNum+10000;
                        takeNewAppointment(patient);
                    }
                }
            }
            //****************************
            //Printing simulation report
            System.out.println("Hospital problem simulation");
            System.out.println("---------------------------");
            System.out.println("Time: " + time);
            int totalWaitingPatients = 0;
            int walkin = 0;
            for (int i = 0; i < ArrayOfClinic.size(); i++) {
                System.out.println("Number of waiting patients in clinic" +
                        ArrayOfClinic.elementAt(i).ClinicNumber + " : " +
                        ArrayOfClinic.elementAt(i).ArrayOfAppointment.size());
                totalWaitingPatients+=ArrayOfClinic.elementAt(i).ArrayOfAppointment.size();
            }
            for (int i = 0; i < ArrayOfDoctor.size(); i++) {
                walkin += ArrayOfDoctor.elementAt(i).ArrayOfWalkinin.size();
            }
            System.out.println("Number of walk-in patients: " + walkin);
            totalWaitingPatients+=walkin;
            System.out.println("Total waiting patients: " + totalWaitingPatients);
            System.out.println("Laboratory investigations: " + lab.ArrayOfPatient.size());
            System.out.println("Xray requested: " + xray.ArrayOfPatient.size());
        }
    }

    /**
     * Reserve new appointment
     * @param p: patient object to reserve appointment
     */
    private void takeNewAppointment(Patient p){
        Random random = new Random();
        int chooseDoctor = random.nextInt(ArrayOfDoctor.size());
        Doctor doctor = ArrayOfDoctor.elementAt(chooseDoctor);
        Clinic clinic = ArrayOfClinic.elementAt(chooseDoctor);
        PatientFile patientFile = new PatientFile(p);
        patientFile.FileNumber = p.FileNum;
        Appointment appointment = new Appointment(p, patientFile, doctor);
        ArrayOfPatientFile.push(patientFile);
        ArrayOfDoctor.elementAt(chooseDoctor).AddAppointment(appointment);
        ArrayOfClinic.elementAt(chooseDoctor).AddAppointment(appointment);
    }

    /**
     * For patients with no appointments waiting for reservation
     * @param p: Patient Object
     */
    private void checkIn(Patient p){
        Random random = new Random();
        int chooseDoctor = random.nextInt(ArrayOfDoctor.size());
        Doctor doctor = ArrayOfDoctor.elementAt(chooseDoctor);
        WalkIn walkIn = new WalkIn();
        ArrayOfDoctor.elementAt(chooseDoctor).ArrayOfWalkinin.push(walkIn);
    }
}
