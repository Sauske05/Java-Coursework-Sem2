//import java.util.ArrayList;

public class Student
{
    // instance variables - replace the example below with your own
    
    protected String studentName,dateOfBirth;
    protected int tutionFee,courseDuration;
    protected String dateOfEnrollment="";
    protected String courseName ="";
    protected int enrollmentID = 0;
    /**
     * Constructor for objects of class Student
     */
    public Student(String dateOfBirth, String studentName, int courseDuration, int tutionFee)
    {
        // initialise instance variables
        this.dateOfBirth = dateOfBirth;
        this.studentName = studentName;
        this.courseDuration = courseDuration;
        this.tutionFee = tutionFee;
        
    }

    // getter and setter methods starts
    public String get_dateOfBirth() {
    return this.dateOfBirth;
    }
     
    public String get_studentName() {
    return this.studentName;
    }
    
    public int get_courseDuration() {
    return this.courseDuration;
    }
    
    public int get_tutionFee() {
    return this.tutionFee;
    }
    
    public void set_courseName(String coursename) {
    this.courseName = coursename;
    }
    
    public String get_courseName() {
    return this.courseName;
    }
    
    public void set_enrollmentID(int ID) {
    this.enrollmentID = ID;
    }
    
    public int get_enrollmentID() {
    return this.enrollmentID;
    }
    
    public void set_dateofEnrollment(String date) {
    this.dateOfEnrollment = date;
}

    public String get_dateofEnrollment() {
    return this.dateOfEnrollment;
    }
    // getter setter method ends
    
    //display method
    public void display() {
        // check if dateOfEnrollment, courseName and EnrollmentID are empty or 0.
        if (dateOfEnrollment.equals("") || dateOfEnrollment == null) {
        System.out.println("Date of Enrollment Value is missing!");
        } 
        else if (courseName == "" || courseName == null) {
        System.out.println("Course Name is not mentioned!");
        }
        else if (enrollmentID == 0) {
        System.out.println("Enrollment ID is not declared!");
        }
        else {
        System.out.println("Enrollment ID: " + get_enrollmentID());
        System.out.println("Date of Birth: " + get_dateOfBirth());
        System.out.println("Course Name: " + get_courseName());
        System.out.println("Student Name: " + get_studentName());
        System.out.println("Date Enrolled: " + get_dateofEnrollment());
        System.out.println("Course Duration: " + get_courseDuration() + " months");
        System.out.println("Tuition Fee: " + get_tutionFee());
        System.out.println();
        System.out.println();}
    }
    
}
