/**
 * Patient class, for Patient objects
 * @author Dawid
 *
 */
public class Patient implements Comparable<Patient> {

	private String firstName;
	private String lastName;
	private String illness;
	private int severity;

	/**
	 * Constructor for Patient
	 * @param firstNameParam
	 * @param lastNameParam
	 * @param illnessParam
	 * @param severityParam
	 */
	public Patient(String firstNameParam, String lastNameParam, String illnessParam, int severityParam) {
		this.setFirstName(firstNameParam);
		this.setLastName(lastNameParam);
		this.setIllness(illnessParam);
		this.setSeverity(severityParam);
	}

	/**
	 * compareTo method: returns -1 if this patient comes before otherPatient; 0 if they are the
	 * same; and +1 if this patient should come after otherPatient.
	 * 
	 */
	@Override
	public int compareTo(Patient otherPatient) {
		if (this.severity > otherPatient.getSeverity()) {

			return -1;
			
		} else if (this.severity == otherPatient.getSeverity()) {

			return 0;
			
		} else {
			
			return 1;
		}
	}

	
	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets firstName
	 * @param firstNameParam
	 */
	public void setFirstName(String firstNameParam) {
		this.firstName = firstNameParam;
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets lastName
	 * @param lastNameParam
	 */
	public void setLastName(String lastNameParam) {
		this.lastName = lastNameParam;
	}

	/**
	 * @return illness
	 */
	public String getIllness() {
		return illness;
	}

	/**
	 * sets illness
	 * @param illnessParam
	 */
	public void setIllness(String illnessParam) {
		this.illness = illnessParam;
	}

	/**
	 * @return severity
	 */
	public int getSeverity() {
		return severity;
	}

	/**
	 * sets severity, throws error when user tries to enter severity different than 1-5 inclusive
	 * @param severityParam
	 */
	public void setSeverity(int severityParam) {

		if (severityParam > 1 || severityParam <= 5) {
			this.severity = severityParam;
		} else {
			throw new IllegalArgumentException("Wrong input, severity value must be between 1 and 5 inclusive");
		}
	}	
	
	public String toString() {
		String output = "    " + this.firstName + " " + this.lastName + ", " + this.illness + " | severity: " + this.severity;
		return output;
	}
}
