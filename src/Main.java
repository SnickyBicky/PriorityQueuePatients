import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {

		Patient test1 = new Patient("Dupa", "Dupowski", "Ligma", 5);
		Patient test2 = new Patient("Andrew", "Ooga", "Cough", 3);
		Patient test3 = new Patient("Michael", "Booga", "Some illness", 1);

		PriorityQueue<Patient> testQueue = new PriorityQueue<>();

		testQueue.add(test1);
		testQueue.add(test2);
		testQueue.add(test3);

		System.out.println("The doctor will see patients in the following order:");
		for (Patient p : testQueue) {
			System.out.println(p.toString());
		}

		/*
		while (!patientsQueue.isEmpty()) {
			System.out.println(patientsQueue.remove());
		}
		*/
		
		System.out.println("");
		
		// Task - test with patients.txt
		ReadPatientFile.askFilePath();

	}
	
	
}
