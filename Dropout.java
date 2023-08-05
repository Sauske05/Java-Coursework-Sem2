public class Dropout extends Student
{
    // instance variables - replace the example below with your own
    private int numOfRemainingModules;
    private int numOfMonthsAttended;
    private String dateOfDropout;
    private int remainingAmount;
    private boolean hasPaid;
    
    /**
     * Constructor for objects of class Dropout
     */
    public Dropout(String dateOfBirth, String studentName, int courseDuration, int tutionFee, int numOfRemainingModules, int numOfMonthsAttended, String dateOfDropout, int enrollmentID, String courseName, String dateofEnrollment)
    {
        // initialise instance variables
        super(dateOfBirth, studentName, courseDuration, tutionFee);
        this.numOfRemainingModules = numOfRemainingModules;
        this.numOfMonthsAttended = numOfMonthsAttended;
        this.dateOfDropout = dateOfDropout;
        super.set_courseName(courseName); // can also pass parameter value using super.get_courseName(). 
        super.set_enrollmentID(enrollmentID); //same for these
        super.set_dateofEnrollment(dateofEnrollment);//same
        this.remainingAmount = 0;
        this.hasPaid = false;
        
    }
    // getter and setter method starts
    public int get_enrollmentID() {
        return super.get_enrollmentID();
    }

    public String get_courseName() {
        return super.get_courseName();
    }
    public String get_dateofEnrollment() {
        return super.get_dateofEnrollment();
    }
    public int get_numOfRemainingModules() {
    return numOfRemainingModules;
    }
    public int get_numOfMonthsAttended() {
    return this.numOfMonthsAttended;
    }
    public String get_dateOfDropout() {
    return dateOfDropout;
    }
    public int get_remainingAmount() {
    return remainingAmount;
    }
    public boolean get_hasPaid() {
    return hasPaid;
    }
    // getter setter method ends
    public void billsPayble () {
    String message = "";
    this.remainingAmount = (courseDuration - numOfMonthsAttended) * tutionFee;
    // Added logic of setting hasPaid to true only if there is no remaining Amount
    if (this.remainingAmount == 0) {
    hasPaid = true;
    message = "All bills cleared by the student";
} else {
    message = "The total amount of bills needed to be paid is" + "" + this.remainingAmount;}
    
    System.out.println(message);
    }
    
    // public void billsPayble(String abc) {
    // }
    // removeStudent() also can be written with a return type of void.
    public String removeStudent() {
    String message = "All Bills Cleared Sucessfully!";
    if (hasPaid = true) {
    // need to initialise student instance variables of Student as protected else we cant modify it here! We can get around by using setter but the question doesn't says introduce setters for all vals. 
    dateOfBirth = "";
    courseName = "";
    studentName = "";
    dateOfEnrollment = "";
    courseDuration = 0;
    tutionFee = 0;
    dateOfDropout = "";
    enrollmentID = 0;
    numOfRemainingModules = 0;
    numOfMonthsAttended = 0;
    remainingAmount = 0;
    } else {
    message = "All Bills not cleared.";
    }
    
    return message;
    }
    
    public void display() {
    super.display();
    System.out.println("The number of remaining modules is" + " "+get_numOfRemainingModules());
    System.out.println("The number of months attended is" +" "+ get_numOfMonthsAttended());
    System.out.println("The date of dropout was" +" "+ get_dateOfDropout());
    }
}
