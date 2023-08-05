import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Initial_window implements ActionListener {
    public static ArrayList<Student> studentList = new ArrayList<>();

    public Initial_window() {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        JLayeredPane pane = new JLayeredPane();
        pane.setBounds(0, 0, 600, 400);
        frame.setResizable(false);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pane);
        // Load the background image
        ImageIcon imageIcon = new ImageIcon("./gui_java.jpg");
        ImageIcon college_icon = new ImageIcon("./islington.png");

        JLabel background = new JLabel("", imageIcon, JLabel.CENTER);
        Image originalImage = college_icon.getImage();

        // Resize the image to 80x80 while maintaining the aspect ratio
        Image resizedImage = resizeImage(originalImage, 80, 80);

        // Create a new ImageIcon with the resized image
        ImageIcon resizedColgImageIcon = new ImageIcon(resizedImage);
        JLabel college_icon_label = new JLabel(resizedColgImageIcon, JLabel.CENTER);
        college_icon_label.setBounds(505, 0, 80, 80);

        background.setBounds(0, 0, 600, 400);
        JLabel title_label = new JLabel("Student Registration GUI");
        title_label.setForeground(Color.white);
        title_label.setFont(new Font("Century Gothic", Font.BOLD, 33));
        JLabel title_info = new JLabel("Welcome to our GUI. Click the buttons below to continue!");
        title_info.setForeground(Color.white);
        title_info.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        JButton regular_student_button = new JButton("Add a Regular Student");
        JButton dropout_student_button = new JButton("Add a Dropout Student");
        title_label.setBounds(85, 100, 440, 40);
        title_info.setBounds(80, 150, 400, 30);
        regular_student_button.setBounds(50, 220, 200, 30);
        dropout_student_button.setBounds(300, 220, 200, 30);
        // regular_student_button.setIcon(imageIcon);
        regular_student_button.addActionListener((e) -> regular_student_gui_window());
        dropout_student_button.addActionListener((e) -> dropout_student_gui_window());
        frame.setLayout(null);
        pane.setLayout(null);

        pane.add(background);
        pane.add(college_icon_label);
        pane.add(title_label);
        pane.add(title_info);
        pane.add(regular_student_button);
        pane.add(dropout_student_button);
        pane.setLayer(background, 0);
        pane.setLayer(college_icon_label, 1);
        pane.setLayer(title_label, 1);
        pane.setLayer(title_info, 1);
        pane.setLayer(regular_student_button, 1);
        pane.setLayer(dropout_student_button, 1);

        // frame.add(panel);
        frame.setVisible(true);
    }

    private static Image resizeImage(Image originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizedImage;
    }

    public void regular_student_gui_window() {
        RegularStudentGUI window1 = new RegularStudentGUI();
    }

    public void dropout_student_gui_window() {
        Dropout_gui window2 = new Dropout_gui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] a) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Initial_window window = new Initial_window();
            }
        });
    }
}

class RegularStudentGUI implements ActionListener {
    private JTextField studentNametxt;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    private JTextField EnrollmentIdtxt;
    private JTextField CourseNametxt;
    private JTextField CourseDurationtxt;
    private JTextField tutionFeetxt;
    private JTextField number_of_credithours_txt;
    private JTextField number_of_modules_txt;
    private JTextField number_of_daysPresent_txt;
    // private JTextField enrollment_ID_txt;
    private JComboBox<String> enroll_dayComboBox;
    private JComboBox<String> enroll_monthComboBox;
    private JComboBox<String> enroll_yearComboBox;
    private JFrame frame;
    private ArrayList<Regular> RegularList = new ArrayList<>();

    private static Image resizeImage(Image originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizedImage;
    }

    public RegularStudentGUI() {

        frame = new JFrame("Regular Student");
        frame.setSize(900, 500);

        JLayeredPane regular_jpane = new JLayeredPane();
        regular_jpane.setBounds(0, 0, 900, 500);
        frame.add(regular_jpane);
        frame.setResizable(false);
        frame.setLayout(null);

        ImageIcon regular_background = new ImageIcon("./regular_bck.jpg");

        // JLabel background_regular = new JLabel("", imageIcon, JLabel.CENTER);
        Image original_background_image = regular_background.getImage();

        // Resize the image to 80x80 while maintaining the aspect ratio
        Image resized_background_image = resizeImage(original_background_image, 900, 500);

        // Create a new ImageIcon with the resized image
        ImageIcon resized_regular_background_image_icon = new ImageIcon(resized_background_image);
        JLabel regular_bck_label = new JLabel(resized_regular_background_image_icon);
        regular_bck_label.setBounds(0, 0, 900, 500);
        regular_jpane.add(regular_bck_label);
        regular_jpane.setLayer(regular_bck_label, 0);

        JLabel head_label = new JLabel("Regular Student GUI");
        head_label.setFont(new Font("Century Gothic", Font.BOLD, 33));
        head_label.setBounds(300, 60, 350, 40);
        head_label.setForeground(Color.white);
        regular_jpane.add(head_label);
        regular_jpane.setLayer(head_label, 1);

        JLabel studentName = new JLabel("Student Name: ");
        studentName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        studentName.setBounds(70, 120, 150, 20);
        regular_jpane.add(studentName);
        regular_jpane.setLayer(studentName, 1);
        studentName.setForeground(Color.white);

        studentNametxt = new JTextField();
        studentNametxt.setBounds(240, 120, 150, 20);
        regular_jpane.add(studentNametxt);
        regular_jpane.setLayer(studentNametxt, 1);

        JLabel dateofBirth = new JLabel("Date of Birth: ");
        dateofBirth.setFont(new Font("Arial", Font.BOLD, 14));
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = Integer.toString(i + 1);
        }
        dayComboBox = new JComboBox<>(days);

        String[] months = { "1", "2", "2", "4", "5", "6",
                "7", "8", "9", "10", "11", "12" };
        monthComboBox = new JComboBox<>(months);

        String[] years = new String[100]; // Assuming the year range from 1923 to 2022
        for (int i = 0; i < 100; i++) {
            years[i] = Integer.toString(1923 + i);
        }
        yearComboBox = new JComboBox<>(years);

        dateofBirth.setBounds(70, 160, 150, 20);
        dayComboBox.setBounds(240, 160, 50, 20);
        monthComboBox.setBounds(290, 160, 50, 20);
        yearComboBox.setBounds(340, 160, 80, 20);

        dateofBirth.setFont(new Font("Century Gothic", Font.PLAIN, 14));

        regular_jpane.add(dateofBirth);
        regular_jpane.add(dayComboBox);
        regular_jpane.add(monthComboBox);
        regular_jpane.add(yearComboBox);
        regular_jpane.setLayer(dateofBirth, 1);
        regular_jpane.setLayer(dayComboBox, 1);
        regular_jpane.setLayer(monthComboBox, 1);
        regular_jpane.setLayer(yearComboBox, 1);
        dateofBirth.setForeground(Color.white);

        JLabel EnrollmentId = new JLabel("Enrollement ID: ");
        EnrollmentId.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        EnrollmentId.setForeground(Color.white);

        EnrollmentId.setBounds(490, 120, 150, 20);
        regular_jpane.add(EnrollmentId);
        regular_jpane.setLayer(EnrollmentId, 1);
        EnrollmentIdtxt = new JTextField();
        EnrollmentIdtxt.setBounds(670, 120, 150, 20);
        regular_jpane.add(EnrollmentIdtxt);
        regular_jpane.setLayer(EnrollmentIdtxt, 1);

        JLabel CourseName = new JLabel("CourseName: ");
        CourseName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        CourseName.setForeground(Color.white);
        CourseName.setBounds(70, 200, 150, 20);
        regular_jpane.add(CourseName);
        regular_jpane.setLayer(CourseName, 1);

        CourseNametxt = new JTextField();
        CourseNametxt.setBounds(240, 200, 150, 20);
        regular_jpane.add(CourseNametxt);
        regular_jpane.setLayer(CourseNametxt, 1);

        JLabel CourseDuration = new JLabel("CourseDuration: ");
        CourseDuration.setForeground(Color.white);
        CourseDuration.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        CourseDuration.setBounds(70, 240, 150, 20);
        regular_jpane.add(CourseDuration);
        regular_jpane.setLayer(CourseDuration, 1);

        CourseDurationtxt = new JTextField();
        CourseDurationtxt.setBounds(240, 240, 150, 20);
        regular_jpane.add(CourseDurationtxt);
        regular_jpane.setLayer(CourseDurationtxt, 1);

        JLabel number_of_modules = new JLabel("Number of Modules: ");
        number_of_modules.setFont(new Font("Century Gothicl", Font.PLAIN, 14));
        number_of_modules.setForeground(Color.white);
        number_of_modules.setBounds(70, 280, 150, 20);
        regular_jpane.add(number_of_modules);
        regular_jpane.setLayer(number_of_modules, 1);

        number_of_modules_txt = new JTextField();
        number_of_modules_txt.setBounds(240, 280, 150, 20);
        regular_jpane.add(number_of_modules_txt);
        regular_jpane.setLayer(number_of_modules_txt, 1);

        JButton Back = new JButton("Back");
        Back.setBounds(100, 400, 150, 30);
        Back.addActionListener((e) -> initial_window_open());
        JButton AddRegular = new JButton("Add Regular Student");
        AddRegular.setBounds(270, 400, 150, 30);
        AddRegular.addActionListener((e) -> addRegularFunction());

        regular_jpane.add(Back);
        regular_jpane.add(AddRegular);
        regular_jpane.setLayer(Back, 1);
        regular_jpane.setLayer(AddRegular, 1);

        JLabel dateofEnrollment = new JLabel("Date of Enrollment: ");
        dateofEnrollment.setForeground(Color.white);
        dateofEnrollment.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        dateofEnrollment.setBounds(490, 160, 150, 20);
        regular_jpane.add(dateofEnrollment);
        regular_jpane.setLayer(dateofEnrollment, 1);

        enroll_dayComboBox = new JComboBox<>(days);

        enroll_monthComboBox = new JComboBox<>(months);

        enroll_yearComboBox = new JComboBox<>(years);

        enroll_dayComboBox.setBounds(670, 160, 50, 20);
        enroll_monthComboBox.setBounds(720, 160, 50, 20);
        enroll_yearComboBox.setBounds(770, 160, 70, 20);
        regular_jpane.add(enroll_dayComboBox);
        regular_jpane.add(enroll_monthComboBox);
        regular_jpane.add(enroll_yearComboBox);
        regular_jpane.setLayer(enroll_dayComboBox, 1);
        regular_jpane.setLayer(enroll_monthComboBox, 1);
        regular_jpane.setLayer(enroll_yearComboBox, 1);

        JLabel number_of_daysPresent = new JLabel("Days Present: ");
        number_of_daysPresent.setForeground(Color.white);
        number_of_daysPresent.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        regular_jpane.add(number_of_daysPresent);
        regular_jpane.setLayer(number_of_daysPresent, 1);
        number_of_daysPresent.setBounds(490, 200, 150, 20);

        number_of_daysPresent_txt = new JTextField();
        number_of_daysPresent_txt.setBounds(670, 200, 150, 20);
        regular_jpane.add(number_of_daysPresent_txt);
        regular_jpane.setLayer(number_of_daysPresent_txt, 1);

        JLabel number_of_credithours = new JLabel("Credit Hours: ");
        number_of_credithours.setForeground(Color.white);
        number_of_credithours.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        number_of_credithours.setBounds(490, 240, 150, 20);
        regular_jpane.add(number_of_credithours);
        regular_jpane.setLayer(number_of_credithours, 1);

        number_of_credithours_txt = new JTextField();
        number_of_credithours_txt.setBounds(670, 240, 150, 20);
        regular_jpane.add(number_of_credithours_txt);
        regular_jpane.setLayer(number_of_credithours_txt, 1);

        JLabel tutionFee = new JLabel("Tution Fee: ");
        tutionFee.setForeground(Color.white);
        tutionFee.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        tutionFee.setBounds(490, 280, 150, 20);
        regular_jpane.add(tutionFee);
        regular_jpane.setLayer(tutionFee, 1);

        tutionFeetxt = new JTextField();
        tutionFeetxt.setBounds(670, 280, 150, 20);
        regular_jpane.add(tutionFeetxt);
        regular_jpane.setLayer(tutionFeetxt, 1);

        JButton PresentPercentage = new JButton("Present Percentage");
        PresentPercentage.setBounds(450, 400, 150, 30);
        PresentPercentage.addActionListener((e) -> present_percentage_function());
        regular_jpane.add(PresentPercentage);
        regular_jpane.setLayer(PresentPercentage, 1);

        JButton GrantCertificate = new JButton("Grant Certificate");
        GrantCertificate.setBounds(620, 400, 150, 30);
        regular_jpane.add(GrantCertificate);
        regular_jpane.setLayer(GrantCertificate, 1);
        GrantCertificate.addActionListener((e) -> grantCertificateFunction());

        // JButton PayBills = new JButton("Pay Bills");
        // PayBills.setPreferredSize(new Dimension(100, 30));
        // JButton removeStudent = new JButton("Remove Student");
        // removeStudent.setPreferredSize(new Dimension(150, 30));
        JButton displayButton = new JButton("Display");
        displayButton.setBounds(520, 350, 150, 30);
        regular_jpane.add(displayButton);
        regular_jpane.setLayer(displayButton, 1);
        displayButton.addActionListener((e) -> displayFunction());

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(190, 350, 150, 30);
        regular_jpane.add(clearButton);
        regular_jpane.setLayer(clearButton, 1);
        clearButton.addActionListener((e) -> clearFunction());

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void initial_window_open() {
        Initial_window iw = new Initial_window();
    }

    // ArrayList<Student> studentList = new ArrayList<>();

    public int parseIntWithErrorMessage(String input, String fieldName) {

        try {
            return Integer.parseInt(input);

        } catch (NumberFormatException ex) {
            // Handle the exception with a custom error message for the specific field
            JOptionPane.showMessageDialog(frame,
                    "Invalid input for " + fieldName + "! Please enter a valid integer.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw ex;
        } // Rethrow the exception to indicate that the input is invalid

    }

    public void negative_val_message(String field_name) {
        JOptionPane.showMessageDialog(frame,
                field_name + "cannot be negative!", "Error", JOptionPane.ERROR_MESSAGE);

    }

    public static boolean isNumeric(String str) {
        return str.matches("^[a-zA-Z\\s]+$");
    }

    public Regular regular_values() {
        try {
            // Get input from the text fields and perform some operations
            String studentName = studentNametxt.getText();
            String courseDurationstr = CourseDurationtxt.getText();
            // int courseDuration = Integer.parseInt(CourseDurationtxt.getText());
            int courseDuration = parseIntWithErrorMessage(courseDurationstr, "course duration");
            if (!isNumeric(studentName)) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;

            }

            // Get input for other fields
            String tutionFeeStr = tutionFeetxt.getText();
            String numofModulesStr = number_of_modules_txt.getText();
            String numofCreditHoursStr = number_of_credithours_txt.getText();
            String daysPresentStr = number_of_daysPresent_txt.getText();
            String enrollmentIDStr = EnrollmentIdtxt.getText();
            int tutionFee = parseIntWithErrorMessage(tutionFeeStr, "Tution Fee");
            int numofModules = parseIntWithErrorMessage(numofModulesStr, "Num of Modules");
            int numofCreditHours = parseIntWithErrorMessage(numofCreditHoursStr, "Num of Credit Hours");
            int daysPresent = parseIntWithErrorMessage(daysPresentStr, "Days Present");
            String courseName = CourseNametxt.getText();
            int enrollmentID = parseIntWithErrorMessage(enrollmentIDStr, "Enrollment ID");

            if (!isNumeric(courseName)) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid Course Name.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
            // Get input for date of birth
            String daydob = (String) dayComboBox.getSelectedItem();
            // String daydob1 = dayComboBox.getSelectedItem().toString();
            String monthdob = (String) monthComboBox.getSelectedItem();
            String yeardob = (String) yearComboBox.getSelectedItem();
            String dateOfBirth = daydob + "/" + monthdob + "/" + yeardob;

            // Get input for enrollment date
            String enrollyear = (String) enroll_yearComboBox.getSelectedItem();
            String enrollmonth = (String) enroll_monthComboBox.getSelectedItem();
            String enrollday = (String) enroll_dayComboBox.getSelectedItem();
            String enrolldate = enrollday + "/" + enrollmonth + "/" + enrollyear;

            // empty check
            if (studentName.isEmpty() || courseDurationstr.isEmpty() || courseName.isEmpty() ||
                    tutionFeeStr.isEmpty() || numofCreditHoursStr.isEmpty() || numofModulesStr.isEmpty() ||
                    daysPresentStr.isEmpty() || enrollmentIDStr.isEmpty()) {

                JOptionPane.showMessageDialog(frame,
                        "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            // negative values check
            if (tutionFee < 0) {
                negative_val_message("Tution Fee");
                return null;
            }

            if (numofModules < 0) {
                negative_val_message("Number of Modules");
                return null;
            }

            if (numofCreditHours < 0) {
                negative_val_message("Number of Credit Hours");
                return null;
            }

            if (daysPresent < 0) {
                negative_val_message("Days Present");
                return null;
            }

            if (enrollmentID < 0) {
                negative_val_message("Enrollment ID");
                return null;
            }
            if (courseDuration < 0) {
                negative_val_message("Course Duration");
                return null;
            }
            if (daysPresent > (courseDuration * 30)) {
                JOptionPane.showMessageDialog(frame, "Days Present must be smaller than course duration", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }

            Regular a = new Regular(dateOfBirth, studentName, courseDuration, tutionFee, numofModules, numofCreditHours,
                    daysPresent, enrolldate, courseName, enrollmentID);
            return a;
        } catch (Exception ex) {
            // Handle any other unexpected exceptions
            JOptionPane.showMessageDialog(frame,
                    "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            // Return null or a default value if you need to handle the failure case
            return null;
        }

    }

    public void addRegularFunction() {
        // if (regular_values() != null) {

        // Initial_window.studentList.add(regular_values());
        // // Initial_window.studentList.add(regular_values());
        // for (Student student : Initial_window.studentList) {
        // if (student instanceof Regular) {
        // System.out.println(student.get_studentName() + " is a Regular student.");
        // }
        // }

        // JOptionPane.showMessageDialog(frame, "Object Added Successfully", "Added",
        // JOptionPane.INFORMATION_MESSAGE);
        // }

        if (regular_values() != null) {
            Regular newStudent = regular_values();

            // Check if enrollmentID is unique
            boolean isEnrollmentIDUnique = true;
            for (Student existingStudent : Initial_window.studentList) {
                if (existingStudent instanceof Regular
                        && existingStudent.get_enrollmentID() == newStudent.get_enrollmentID()) {
                    isEnrollmentIDUnique = false;
                    break; // No need to continue checking
                }
            }

            if (!isEnrollmentIDUnique) {
                JOptionPane.showMessageDialog(frame, "Enrollment ID must be unique!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Initial_window.studentList.add(newStudent);

                for (Student student : Initial_window.studentList) {
                    if (student instanceof Regular) {
                        System.out.println(student.get_studentName() + " is a Regular student.");
                    }
                }

                JOptionPane.showMessageDialog(frame, "Object Added Successfully", "Added",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public void present_percentage_function() {
        String enrollmentIDStr = "";
        boolean enrollment_val = false;

        boolean loop = true;

        try {
            if (Initial_window.studentList.size() > 0) {
                while (loop) {
                    try {
                        enrollmentIDStr = JOptionPane.showInputDialog("Enter your Enrollment ID: ");
                        if (enrollmentIDStr == null) {
                            loop = false;
                        }
                        if (!enrollmentIDStr.isEmpty()) {
                            loop = false;

                        } else {
                            JOptionPane.showMessageDialog(frame, "Enrollment ID cannot be empty!", "Warning",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception e) {
                    }

                }
                try {
                    int enrollment_ID_val = Integer.parseInt(enrollmentIDStr);

                    for (Student student : Initial_window.studentList) {
                        if (student instanceof Regular) {
                            // System.out.println(student.get_studentName() + " is a Regular student.")
                            RegularList.add((Regular) student);
                            // System.out.println(RegularList);
                            // System.out.println("This is of present_percentage!!");
                        }
                    }

                    for (Regular i : RegularList) {
                        if (enrollment_ID_val == i.get_enrollmentID()) {
                            String number_of_days_str = JOptionPane.showInputDialog("Enter number of days: ");
                            int number_of_days = Integer.parseInt(number_of_days_str);
                            enrollment_val = true;
                            i.set_days_present(number_of_days);
                            i.presentPercentage(number_of_days);
                            if (i.getDaysPresent() > (i.get_courseDuration() * 30)) {
                                JOptionPane.showMessageDialog(frame, "Days Present greater than CourseDuration",
                                        "Certification",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        }

                    }
                    if (!enrollment_val) {
                        JOptionPane.showMessageDialog(frame, "Enrollment ID not found",
                                "Certification",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(frame, "Enter a valid Integer", "Warning", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                }

            }

            else {
                JOptionPane.showMessageDialog(frame, "No students added yet!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            throw e;
        }

    }

    public void grantCertificateFunction() {
        try {
            if (Initial_window.studentList.size() > 0) {
                boolean enrollment_val = false;
                try {
                    int enrollment_ID = Integer.parseInt(JOptionPane.showInputDialog("Enter Enrollment ID: "));

                    for (Regular i : RegularList) {

                        if (enrollment_ID == i.get_enrollmentID()) {
                            String courseName = JOptionPane.showInputDialog("Enter courseName: ");
                            String dateofEnrollment = JOptionPane.showInputDialog("Enter Date Of Enrollment: ")
                                    .toString();
                            enrollment_val = true;
                            if (courseName.equals(i.get_courseName())) {
                                if (dateofEnrollment.equals(i.get_dateofEnrollment())) {

                                    i.grantCertificate(courseName, i.get_enrollmentID(), dateofEnrollment);
                                    if (i.get_GrantedScholarship()) {
                                        JOptionPane.showMessageDialog(frame, "Scholarship Granted", "Certification",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "Scholarship Cannot be Granted",
                                                "Certification",
                                                JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(frame,
                                            "Invalid Date of Enrollment for the course.. for given Enrollment ID",
                                            "Certification",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                            } else {
                                JOptionPane.showMessageDialog(frame, "Course Name not found for given Enrollment ID",
                                        "Certification",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                            break; // No need to continue looping once a match is found
                        }
                    }

                    if (!enrollment_val) {
                        JOptionPane.showMessageDialog(frame, "Enrollment ID not found", "Certification",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(frame, "Enter valid input for Enrollment ID", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Unexpected Error Occurred", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "No students added yet!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    // Regular regular_obj = present_percentage_function();
    // System.out.println(regular_obj.getDaysPresent());
    // System.out.println("Check new");
    // System.out.println(regular_obj.get_studentName());
    // // String courseName = CourseNametxt.getText();
    // System.out.println(regular_obj.get_GrantedScholarship());
    // System.out.println("Granted Scholarship data");
    // int enrollmentID = Integer.parseInt(EnrollmentIdtxt.getText());
    // String enrollyear = (String) enroll_yearComboBox.getSelectedItem();
    // String enrollmonth = (String) enroll_monthComboBox.getSelectedItem();
    // String enrollday = (String) enroll_dayComboBox.getSelectedItem();
    // String enrolldate = enrollday + "/" + enrollmonth + "/" + enrollyear;
    // regular_obj.grantCertificate(courseName, regular_obj.get_enrollmentID(),
    // enrolldate);
    // if (regular_obj.get_GrantedScholarship() == true) {
    // JOptionPane.showMessageDialog(frame, "Scholarship Granted", "Certification",
    // JOptionPane.INFORMATION_MESSAGE);
    // // System.out.println(regular_values().get_GrantedScholarship());
    // } else if (regular_obj.get_GrantedScholarship() == false) {
    // JOptionPane.showMessageDialog(frame, "Scholarship Cannot be Granted",
    // "Certification",
    // JOptionPane.INFORMATION_MESSAGE);
    // // System.out.println(regular_values().get_GrantedScholarship());
    // } else {
    // System.out.print("Null val");
    // }

    public void displayFunction() {

        try {
            regular_values().display();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "No students added yet", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearFunction() {
        studentNametxt.setText("");
        dayComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        EnrollmentIdtxt.setText("");
        CourseNametxt.setText("");
        CourseDurationtxt.setText("");
        tutionFeetxt.setText("");
        number_of_credithours_txt.setText("");
        number_of_daysPresent_txt.setText("");
        number_of_modules_txt.setText("");
        EnrollmentIdtxt.setText("");
        enroll_dayComboBox.setSelectedIndex(0);
        enroll_monthComboBox.setSelectedIndex(0);
        enroll_yearComboBox.setSelectedIndex(0);

        JOptionPane.showMessageDialog(frame, "Cleared Successfully!", "Cleared", JOptionPane.INFORMATION_MESSAGE);
    }

}

class Dropout_gui implements ActionListener {
    // private String student_name_txt_val;
    private JTextField student_name_txt;
    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    private JTextField courseDurationtxt;
    private JTextField tutionFeetxt;
    private JTextField numofRemainingModulestxt;
    private JTextField numofMonthsAttendedtxt;
    private JComboBox<String> dropoutdayComboBox;
    private JComboBox<String> dropoutmonthComboBox;
    private JComboBox<String> dropoutyearComboBox;
    private JFrame dropout_frame;
    private JTextField enrollmentIDtxt;
    private JTextField courseNametxt;
    private JComboBox<String> enrollmentyearComboBox;
    private JComboBox<String> enrollmentmonthComboBox;
    private JComboBox<String> enrollmentdayComboBox;
    // Combo box raw type resuts in raw val. Genric type param should be given!

    public Dropout_gui() {
        dropout_frame = new JFrame("Dropout Window");

        JLayeredPane dropout_pane = new JLayeredPane();
        dropout_pane.setBounds(0, 0, 900, 540);

        ImageIcon background_dropout = new ImageIcon("./dropoutbck.jpg");
        Image resizedbackground_image = resizeImage(background_dropout.getImage(), 900, 540);

        ImageIcon resized_backgrround_dropout = new ImageIcon(resizedbackground_image);
        dropout_frame.add(dropout_pane);
        JLabel background_dropout_labeel = new JLabel(resized_backgrround_dropout, JLabel.CENTER);
        background_dropout_labeel.setBounds(0, 0, 900, 540);
        dropout_pane.add(background_dropout_labeel);
        dropout_pane.setLayer(background_dropout_labeel, 0);

        JLabel dropout_main_title = new JLabel("Dropout Class GUI");
        dropout_main_title.setBounds(300, 50, 300, 40);
        dropout_main_title.setFont(new Font("Century Gothic", Font.BOLD, 33));
        dropout_main_title.setForeground(Color.white);
        JLabel student_name = new JLabel("Student Name");
        student_name.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        student_name.setForeground(Color.white);
        student_name.setBounds(80, 130, 100, 20);
        student_name_txt = new JTextField();
        student_name_txt.setBounds(200, 130, 150, 20);

        JLabel dateofBirth = new JLabel("Date of Birth");
        dateofBirth.setBounds(80, 170, 100, 20);
        dateofBirth.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        dateofBirth.setForeground(Color.white);

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = Integer.toString(i + 1);
        }
        dayComboBox = new JComboBox<>(days);

        String[] months = { "1", "2", "2", "4", "5", "6",
                "7", "8", "9", "10", "11", "12" };
        monthComboBox = new JComboBox<>(months);

        String[] years = new String[100]; // Assuming the year range from 1923 to 2022
        for (int i = 0; i < 100; i++) {
            years[i] = Integer.toString(1923 + i);
        }
        yearComboBox = new JComboBox<>(years);

        dayComboBox.setBounds(200, 170, 50, 20);
        monthComboBox.setBounds(250, 170, 50, 20);
        yearComboBox.setBounds(300, 170, 80, 20);

        JLabel courseDuration = new JLabel("Course Duration: ");
        courseDuration.setBounds(80, 210, 120, 20);
        courseDuration.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        courseDuration.setForeground(Color.white);

        JLabel tutionFee = new JLabel("Tution Fee: ");
        tutionFee.setBounds(80, 250, 100, 20);
        tutionFee.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        tutionFee.setForeground(Color.white);

        courseDurationtxt = new JTextField();
        courseDurationtxt.setBounds(200, 210, 150, 20);

        tutionFeetxt = new JTextField();
        tutionFeetxt.setBounds(200, 250, 150, 20);

        dropoutdayComboBox = new JComboBox<>(days);

        dropoutmonthComboBox = new JComboBox<>(months);

        dropoutyearComboBox = new JComboBox<>(years);

        dropoutdayComboBox.setBounds(200, 290, 50, 20);
        dropoutmonthComboBox.setBounds(250, 290, 50, 20);
        dropoutyearComboBox.setBounds(300, 290, 80, 20);

        JLabel dropoutdate = new JLabel("Dropout Date: ");
        dropoutdate.setBounds(80, 290, 100, 20);
        dropoutdate.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        dropoutdate.setForeground(Color.white);

        // right wing main code

        JLabel enrollmentID = new JLabel("Enrollment ID: ");
        enrollmentID.setBounds(470, 130, 150, 20);
        enrollmentID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        enrollmentID.setForeground(Color.WHITE);

        enrollmentIDtxt = new JTextField();
        enrollmentIDtxt.setBounds(640, 130, 150, 20);

        JLabel courseName = new JLabel("Course Name: ");
        courseName.setBounds(470, 170, 150, 20);
        courseName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        courseName.setForeground(Color.WHITE);

        courseNametxt = new JTextField();
        courseNametxt.setBounds(640, 170, 150, 20);

        JLabel enrollmentdate = new JLabel("Enrollment Date: ");
        enrollmentdate.setBounds(470, 210, 150, 20);
        enrollmentdate.setForeground(Color.WHITE);
        enrollmentdate.setFont(new Font("Century Gothic", Font.PLAIN, 14));

        enrollmentdayComboBox = new JComboBox<>(days);

        enrollmentmonthComboBox = new JComboBox<>(months);

        enrollmentyearComboBox = new JComboBox<>(years);

        enrollmentdayComboBox.setBounds(640, 210, 50, 20);
        enrollmentmonthComboBox.setBounds(690, 210, 50, 20);
        enrollmentyearComboBox.setBounds(740, 210, 80, 20);

        JLabel numofRemainingModules = new JLabel("Remaining Modules: ");
        numofRemainingModules.setBounds(470, 250, 150, 20);
        numofRemainingModules.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        numofRemainingModules.setForeground(Color.white);

        numofRemainingModulestxt = new JTextField();
        numofRemainingModulestxt.setBounds(640, 250, 150, 20);

        JLabel numofMonthsAttended = new JLabel("Months Attended: ");
        numofMonthsAttended.setBounds(470, 290, 150, 20);
        numofMonthsAttended.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        numofMonthsAttended.setForeground(Color.white);

        numofMonthsAttendedtxt = new JTextField();
        numofMonthsAttendedtxt.setBounds(640, 290, 150, 20);

        // buttons
        JButton billPayablebutton = new JButton("Bills Payable");
        billPayablebutton.setBounds(150, 350, 150, 30);
        billPayablebutton.addActionListener((e) -> billsPayableFunction());
        JButton removeStudentbutton = new JButton("Remove Student");
        removeStudentbutton.setBounds(350, 350, 150, 30);
        removeStudentbutton.addActionListener((e) -> removeStudentFunction());

        JButton displaybutton = new JButton("Display");
        displaybutton.setBounds(550, 350, 150, 30);

        displaybutton.addActionListener((e) -> displayFunction());
        JButton clearbutton = new JButton("Clear");
        clearbutton.setBounds(120, 410, 150, 30);
        clearbutton.addActionListener((e) -> clearFunction());

        JButton addDropoutStudentButton = new JButton("Add Dropout Student");
        addDropoutStudentButton.setBounds(320, 410, 200, 30);
        addDropoutStudentButton.addActionListener((e) -> addDropoutFunction());

        JButton backbutton = new JButton("Back");
        backbutton.setBounds(580, 410, 150, 30);
        backbutton.addActionListener((e) -> initial_window_open());

        // left wing add
        dropout_frame.setSize(900, 500);
        dropout_frame.setLayout(null);
        dropout_pane.setLayout(null);
        dropout_pane.add(dropout_main_title);
        dropout_pane.add(student_name);
        dropout_pane.add(student_name_txt);
        dropout_pane.add(dateofBirth);
        dropout_pane.add(dayComboBox);
        dropout_pane.add(monthComboBox);
        dropout_pane.add(yearComboBox);
        dropout_pane.add(courseDuration);
        dropout_pane.add(courseDurationtxt);
        dropout_pane.add(tutionFee);
        dropout_pane.add(tutionFeetxt);

        dropout_pane.setLayer(dropout_main_title, 1);
        dropout_pane.setLayer(student_name, 1);
        dropout_pane.setLayer(student_name_txt, 1);
        dropout_pane.setLayer(dateofBirth, 1);
        dropout_pane.setLayer(dayComboBox, 1);
        dropout_pane.setLayer(monthComboBox, 1);
        dropout_pane.setLayer(yearComboBox, 1);
        dropout_pane.setLayer(courseDuration, 1);
        dropout_pane.setLayer(courseDurationtxt, 1);
        dropout_pane.setLayer(tutionFee, 1);
        dropout_pane.setLayer(tutionFeetxt, 1);

        // right wing add

        dropout_pane.add(numofRemainingModules);
        dropout_pane.add(numofMonthsAttended);
        dropout_pane.add(numofMonthsAttendedtxt);
        dropout_pane.add(numofRemainingModulestxt);
        dropout_pane.add(dropoutdate);
        dropout_pane.add(dropoutdayComboBox);
        dropout_pane.add(dropoutmonthComboBox);
        dropout_pane.add(dropoutyearComboBox);
        dropout_pane.add(enrollmentIDtxt);
        dropout_pane.add(enrollmentID);
        dropout_pane.add(courseName);
        dropout_pane.add(courseNametxt);
        dropout_pane.add(enrollmentdate);
        dropout_pane.add(enrollmentdayComboBox);
        dropout_pane.add(enrollmentmonthComboBox);
        dropout_pane.add(enrollmentyearComboBox);

        dropout_pane.setLayer(numofMonthsAttended, 1);
        dropout_pane.setLayer(numofMonthsAttendedtxt, 1);
        dropout_pane.setLayer(numofRemainingModules, 1);
        dropout_pane.setLayer(numofRemainingModulestxt, 1);
        dropout_pane.setLayer(dropoutdate, 1);
        dropout_pane.setLayer(dropoutdayComboBox, 1);
        dropout_pane.setLayer(dropoutmonthComboBox, 1);
        dropout_pane.setLayer(dropoutyearComboBox, 1);
        dropout_pane.setLayer(enrollmentID, 1);
        dropout_pane.setLayer(enrollmentIDtxt, 1);
        dropout_pane.setLayer(courseName, 1);
        dropout_pane.setLayer(courseNametxt, 1);
        dropout_pane.setLayer(enrollmentdate, 1);
        dropout_pane.setLayer(enrollmentdayComboBox, 1);
        dropout_pane.setLayer(enrollmentmonthComboBox, 1);
        dropout_pane.setLayer(enrollmentyearComboBox, 1);

        // button add
        dropout_pane.add(billPayablebutton);
        dropout_pane.add(removeStudentbutton);
        dropout_pane.add(displaybutton);
        dropout_pane.add(clearbutton);
        dropout_pane.add(backbutton);
        dropout_pane.add(addDropoutStudentButton);

        dropout_pane.setLayer(billPayablebutton, 1);
        dropout_pane.setLayer(removeStudentbutton, 1);
        dropout_pane.setLayer(displaybutton, 1);
        dropout_pane.setLayer(clearbutton, 1);
        dropout_pane.setLayer(backbutton, 1);
        dropout_pane.setLayer(addDropoutStudentButton, 1);

        dropout_frame.setVisible(true);
        // dropout_pane.setVisible(true);

    }

    private static Image resizeImage(Image originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizedImage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public void initial_window_open() {
        Initial_window iw = new Initial_window();
    }

    public int parseIntWithErrorMessage(String input, String fieldName) {

        try {
            return Integer.parseInt(input);

        } catch (NumberFormatException ex) {
            // Handle the exception with a custom error message for the specific field
            JOptionPane.showMessageDialog(dropout_frame,
                    "Invalid input for " + fieldName + "! Please enter a valid integer.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw ex;
        } // Rethrow the exception to indicate that the input is invalid

    }

    public void negative_val_message(String field_name) {
        JOptionPane.showMessageDialog(dropout_frame,
                field_name + "cannot be negative!", "Error", JOptionPane.ERROR_MESSAGE);

    }

    public Dropout dropout_values() {
        try {
            String studnetName = student_name_txt.getText();
            if (!RegularStudentGUI.isNumeric(studnetName)) {
                JOptionPane.showMessageDialog(dropout_frame, "Please enter a valid name.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
            String courseDurationstr = courseDurationtxt.getText();
            String numofRemainingModulesStr = numofRemainingModulestxt.getText();
            String number_of_months_attendedStr = numofMonthsAttendedtxt.getText();
            String tutionFeeStr = tutionFeetxt.getText();
            int courseDuration = parseIntWithErrorMessage(courseDurationstr, "Course Duration");
            int numberofRemainingModules = parseIntWithErrorMessage(numofRemainingModulesStr,
                    "Num of Remaining Modules");
            int number_of_months_attended = parseIntWithErrorMessage(number_of_months_attendedStr,
                    "Num of Months Attended");
            int tutionFee = parseIntWithErrorMessage(tutionFeeStr, "Tution Fee");
            String dayval = (String) dayComboBox.getSelectedItem();
            String monthval = (String) monthComboBox.getSelectedItem();
            String yearval = (String) yearComboBox.getSelectedItem();
            String dateofBirth = dayval + "/" + monthval + "/" + yearval;
            String dropdayval = (String) dropoutdayComboBox.getSelectedItem();
            String dropmonthval = (String) dropoutmonthComboBox.getSelectedItem();
            String dropyearval = (String) dropoutyearComboBox.getSelectedItem();
            String dateofDropout = dropdayval + "/" + dropmonthval + "/" + dropyearval;
            String enrollmentIDStr = enrollmentIDtxt.getText();
            int EnrollmentID = parseIntWithErrorMessage(enrollmentIDStr, "Enrollment ID");
            String enroll_day_val = (String) enrollmentdayComboBox.getSelectedItem();
            String enroll_month_val = (String) enrollmentmonthComboBox.getSelectedItem();
            String enroll_year_val = (String) enrollmentyearComboBox.getSelectedItem();
            String enroll_date = enroll_day_val + "/" + enroll_month_val + "/" + enroll_year_val;
            String course_name = courseNametxt.getText();

            if (!RegularStudentGUI.isNumeric(course_name)) {
                JOptionPane.showMessageDialog(dropout_frame, "Please enter a valid name.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }

            // empty check and null check
            if (courseDuration < 0) {
                negative_val_message("Course Duration");
                return null;
            }

            if (numberofRemainingModules < 0) {
                negative_val_message("Number of Remaining Modules");
                return null;
            }

            if (number_of_months_attended < 0) {
                negative_val_message("Number of Months Attended");
                return null;
            }

            if (tutionFee < 0) {
                negative_val_message("Tution Fee");
                return null;
            }

            if (studnetName.isEmpty()) {
                JOptionPane.showMessageDialog(dropout_frame,
                        "Student name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (courseDurationstr.isEmpty()) {
                JOptionPane.showMessageDialog(dropout_frame,
                        "Course Duration cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (numofRemainingModulesStr.isEmpty()) {
                JOptionPane.showMessageDialog(dropout_frame,
                        "Course Name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (tutionFeeStr.isEmpty()) {
                JOptionPane.showMessageDialog(dropout_frame,
                        "Tution Fee cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (number_of_months_attendedStr.isEmpty()) {
                JOptionPane.showMessageDialog(dropout_frame,
                        "Credit Hours cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            Dropout dropoutobj = new Dropout(dateofBirth, studnetName, courseDuration, tutionFee,
                    numberofRemainingModules,
                    number_of_months_attended, dateofDropout, EnrollmentID, course_name, enroll_date);
            return dropoutobj;
        } catch (Exception ex) {
            // Handle any other unexpected exceptions
            JOptionPane.showMessageDialog(dropout_frame,
                    "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            // Return null or a default value if you need to handle the failure case
            return null;

        }
    }

    public void clearFunction() {
        student_name_txt.setText("");
        courseDurationtxt.setText("");
        numofRemainingModulestxt.setText("");
        tutionFeetxt.setText("");
        dayComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        yearComboBox.setSelectedIndex(0);
        courseDurationtxt.setText("");
        numofMonthsAttendedtxt.setText("");
        dropoutdayComboBox.setSelectedIndex(0);
        dropoutmonthComboBox.setSelectedIndex(0);
        dropoutyearComboBox.setSelectedIndex(0);
        courseNametxt.setText("");
        enrollmentIDtxt.setText("");
        enrollmentdayComboBox.setSelectedIndex(0);
        enrollmentmonthComboBox.setSelectedIndex(0);
        enrollmentyearComboBox.setSelectedIndex(0);

        JOptionPane.showMessageDialog(dropout_frame, "Values cleared successfully!", "Clear",
                JOptionPane.INFORMATION_MESSAGE);
    }

   
    public void billsPayableFunction() {
        ArrayList<Dropout> dropout_list_temp = new ArrayList<>();
        boolean loop = true;
        boolean enrollment_val = false;
        int enrollment_ID_val = 0;
        String enrollment_ID_val_str = "";

        try {
            if (Initial_window.studentList.size() > 0) {
                while (loop) {
                    try {
                        enrollment_ID_val_str = JOptionPane.showInputDialog("Enter enrollment ID: ");
                        if (enrollment_ID_val_str.isEmpty()) {
                            JOptionPane.showMessageDialog(dropout_frame, "Cannot be empty", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        enrollment_ID_val = Integer.parseInt(enrollment_ID_val_str);

                        if (enrollment_ID_val > 0) {
                            loop = false;
                        } else {
                            JOptionPane.showMessageDialog(dropout_frame, "Enrollment ID cannot be negative", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(dropout_frame, "Enter a valid Enrollment ID", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    }
                }

                for (Student student : Initial_window.studentList) {
                    if (student instanceof Dropout) {
                        dropout_list_temp.add((Dropout) student);
                    }
                }

                for (Dropout i : dropout_list_temp) {
                    if (enrollment_ID_val == i.get_enrollmentID()) {
                        enrollment_val = true;
                        i.billsPayble();
                        break;
                    }
                }

                if (!enrollment_val) {
                    JOptionPane.showMessageDialog(dropout_frame, "Enrollment ID not found", "Bills Payable",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(dropout_frame, "No dropout students added yet!", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(dropout_frame, "Closed!", "Closed", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dropout_frame, "Enter a valid enrollment ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            throw e;
        }
    }

    public void displayFunction() {
        dropout_values().display();
    }

    public void removeStudentFunction() {
        ArrayList<Dropout> dropout_list_temp = new ArrayList<>();
        boolean loop = true;
        boolean enrollment_val = false;
        int enrollment_ID_val = 0;
        String enrollment_ID_val_str = "";

        try {
            if (Initial_window.studentList.size() > 0) {
                while (loop) {
                    try {
                        enrollment_ID_val_str = JOptionPane.showInputDialog("Enter enrollment ID: ");
                        if (enrollment_ID_val_str.isEmpty()) {
                            JOptionPane.showMessageDialog(dropout_frame, "Cannot be empty", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        enrollment_ID_val = Integer.parseInt(enrollment_ID_val_str);

                        if (enrollment_ID_val > 0) {
                            loop = false;
                        } else {
                            JOptionPane.showMessageDialog(dropout_frame, "Enrollment ID cannot be negative", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(dropout_frame, "Enter a valid Enrollment ID", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    }
                }

                for (Student student : Initial_window.studentList) {
                    if (student instanceof Dropout) {
                        dropout_list_temp.add((Dropout) student);
                    }
                }

                for (Dropout i : dropout_list_temp) {
                    if (enrollment_ID_val == i.get_enrollmentID()) {
                        enrollment_val = true;
                        i.removeStudent();
                        break;
                    }
                }

                if (!enrollment_val) {
                    JOptionPane.showMessageDialog(dropout_frame, "Enrollment ID not found", "Bills Payable",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(dropout_frame, "No dropout students added yet!", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(dropout_frame, "Closed!", "Closed", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dropout_frame, "Enter a valid enrollment ID!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            throw e;
        }
    }

    public void addDropoutFunction() {

        if (dropout_values() != null) {
            Dropout dropStudent = dropout_values();

            // Check if enrollmentID is unique
            boolean isEnrollmentIDUnique = true;
            for (Student existingStudent : Initial_window.studentList) {
                if (existingStudent instanceof Dropout
                        && existingStudent.get_enrollmentID() == dropStudent.get_enrollmentID()) {
                    isEnrollmentIDUnique = false;
                    break; // No need to continue checking
                }
            }

            if (!isEnrollmentIDUnique) {
                JOptionPane.showMessageDialog(dropout_frame, "Enrollment ID must be unique!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Initial_window.studentList.add(dropStudent);

                for (Student student : Initial_window.studentList) {
                    if (student instanceof Dropout) {
                        System.out.println(student.get_studentName() + " is a Dropout student.");
                    }
                }

                JOptionPane.showMessageDialog(dropout_frame, "Object Added Successfully", "Added",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}