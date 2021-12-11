import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * ReadPatientFile - a class entirely about reading a txt file for Patients
 * @author Dawid
 *
 */
//test with patients.txt file
public class ReadPatientFile {
	
	/**
	 * Reads a txt file line by line, adds Patient to queue, prints out the contents of patientQueue by 
	 * printing out the entries that are being dequeued. 
	 * 
	 * @param in Scanner
	 * @return patientQueue
	 * @throws InputMismatchException
	 */
	public static PriorityQueue<Patient> ReadDataLineByLine(Scanner in) throws InputMismatchException {

		PriorityQueue<Patient> patientQueue = new PriorityQueue<Patient>();

		try {
			while (in.hasNextLine()) {
				Patient patient = ReadPatientFile.readPatient(in);
				patientQueue.add(patient);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Illegal value entered");
			System.exit(0);
		} catch(InputMismatchException e){
			System.out.println("Input mismatch!");
			System.exit(0);
		} finally {
			in.close();
		}	
		
		//proper order printing
		while(!patientQueue.isEmpty()) {
			System.out.println(patientQueue.remove());
		}
		
		return patientQueue;

	}
	
	/**
	 * Reads the filepath, initializes ReadDataLineByLine method. 
	 * @param filename the path of the file 
	 * @return ReadDataLineByLine method
	 */
	public static PriorityQueue<Patient> readFile(String filename) {
		
		try {
			File inputFile = new File(filename);
			Scanner in = new Scanner(inputFile);
			return ReadPatientFile.ReadDataLineByLine(in);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open " + filename);
			System.exit(0);
		}
		return null;

	}
	
	/**
	 * Asks the user about the filepath, prints out the message and initializes readFile method
	 */
	public static void askFilePath() {
		Scanner input = new Scanner (System.in);
		System.out.println ("Please enter a filepath to read the data:");
		String filename = input.next ();
		input.close ();
		
		System.out.println("The doctor will see patients in the following order:");
		ReadPatientFile.readFile(filename);
		
		
	}
	
	/**
	 * reads in Patient properties and creates Patient object
	 * @param in Scanner
	 * @return newPatient 
	 */
	public static Patient readPatient(Scanner in) {
		
		String firstName = in.nextLine();
		String lastName = in.nextLine();
		String illness = in.nextLine();
		int severity = in.nextInt();
		in.nextLine(); // to avoid nextInt() issue
		
		Patient newPatient = new Patient(firstName, lastName, illness, severity);
		return newPatient;
	}
	
}
