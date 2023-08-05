
public class Regular extends Student
{
    // instance variables - replace the example below with your own
    private int numOfModules;
    private int numOfCreditHours;
    private double daysPresent;
    private boolean isGrantedScholarship;
    /**
     * Constructor for objects of class Regular
     */
    public Regular(String dateOfBirth, String studentName, int courseDuration, int tutionFee,int numOfModules, int numOfCreditHours, double daysPresent, String dateOfEnrollment, String courseName, int enrollmentID)
    {
        // initialise instance variables
        super(dateOfBirth, studentName, courseDuration, tutionFee);
        super.set_courseName(courseName);
        super.set_enrollmentID(enrollmentID);
        super.set_dateofEnrollment(dateOfEnrollment);
        this.numOfModules = numOfModules;
        this.numOfCreditHours = numOfCreditHours;
        this.daysPresent = daysPresent;
        this.isGrantedScholarship = false;
    }

    // getter and setter methods for Regular class
     public int getNumOfModules() {
        return numOfModules;
    }

    public int getNumOfCreditHours() {
        return numOfCreditHours;
    }

    public double getDaysPresent() {
        return daysPresent;
    }

    public boolean get_GrantedScholarship() {
        return isGrantedScholarship;
    }

    public void setIsGrantedScholarship(boolean isGrantedScholarship) {
        this.isGrantedScholarship = isGrantedScholarship;
    }

    public void set_days_present(int daysPresent) {
        this.daysPresent = daysPresent;
    }
    // getter and setter ends
    public void presentPercentage(double daysPresent) {
    // multiply courseDuration by 30, since it is in months and daysPresent in days.
    double present_percentage = (daysPresent / (super.get_courseDuration() * 30)) * 100;
    String message = "";
    this.daysPresent = daysPresent;
    if (daysPresent > (get_courseDuration() * 30)) {
    // logic check since daysPresent cant be greater than courseDuration
    System.out.println("Days Present cannot be greater than courseDuration!");
    } else {
    if (present_percentage >= 80 & present_percentage <= 100) {
        System.out.println("Check");
        setIsGrantedScholarship(true);
    message = "A";
    }
    
    else if (present_percentage < 80 & present_percentage >=60) {
    message = "B";
    }
    
    else if (present_percentage < 60 & present_percentage >=40) {
    message = "C";
    } 
    
    else if (present_percentage < 40 & present_percentage >=20) {
    message = "D";
    } 
    
    else { message = "E";}
    System.out.println("The student's attendence is" +" "+ present_percentage + "%. So, the student's grade is"+ " "+message);
}
    
    }
    
    public void grantCertificate(String courseName, int enrollmentId, String dateOfEnrollment) {
     System.out.print(super.get_studentName() + " has graduated from " + get_courseName() + " with enrollment ID " + get_enrollmentID() + " and enrollment date " + get_dateofEnrollment() + ".");
    if (isGrantedScholarship) {
        System.out.print(" The scholarship has been granted.");
    }
    System.out.println();
    } 
    
    public void display() {
    super.display();
    System.out.println("Number of modules: " + this.numOfModules);
    System.out.println("Number of credit hours: " + this.numOfCreditHours);
    System.out.println("Days present: " + this.daysPresent);
}

}
