import java.awt.*;
import java.awt.event.*;

public class CollegeAdmissionForm extends Frame implements ActionListener {
    TextField nameField, emailField;
    Checkbox male, female;
    Checkbox cbJava, cbPython, cbWeb;
    Choice cityChoice, stateChoice;
    Button submitBtn;
    Label resultLabel;

    public CollegeAdmissionForm() {
        setTitle("College Admission Form");
        setSize(400, 500);
        setLayout(new GridLayout(10, 2, 5, 5)); // clean alignment
        setLocationRelativeTo(null); // center window

        Label nameLabel = new Label("Name:");
        nameField = new TextField(20);

        Label emailLabel = new Label("Email:");
        emailField = new TextField(20);

        Label genderLabel = new Label("Gender:");
        Panel genderPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        male = new Checkbox("Male");
        female = new Checkbox("Female");
        genderPanel.add(male);
        genderPanel.add(female);

        Label courseLabel = new Label("Select Courses:");
        Panel coursePanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        cbJava = new Checkbox("Java");
        cbPython = new Checkbox("Python");
        cbWeb = new Checkbox("Web Development");
        coursePanel.add(cbJava);
        coursePanel.add(cbPython);
        coursePanel.add(cbWeb);

        Label cityLabel = new Label("City:");
        cityChoice = new Choice();
        cityChoice.add("Pune");
        cityChoice.add("Mumbai");
        cityChoice.add("Nagpur");

        Label stateLabel = new Label("State:");
        stateChoice = new Choice();
        stateChoice.add("Maharashtra");
        stateChoice.add("Gujarat");
        stateChoice.add("Karnataka");

        submitBtn = new Button("Submit");
        submitBtn.addActionListener(this);

        resultLabel = new Label("");

        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(genderLabel);
        add(genderPanel);
        add(courseLabel);
        add(coursePanel);
        add(cityLabel);
        add(cityChoice);
        add(stateLabel);
        add(stateChoice);
        add(new Label("")); // empty cell for spacing
        add(submitBtn);
        add(new Label("Result:"));
        add(resultLabel);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        String name = nameField.getText();
        String email = emailField.getText();

        String gender = "";
        if (male.getState()) gender = "Male";
        else if (female.getState()) gender = "Female";
        else gender = "Not specified";

        String courses = "";
        if (cbJava.getState()) courses += "Java ";
        if (cbPython.getState()) courses += "Python ";
        if (cbWeb.getState()) courses += "Web ";

        String city = cityChoice.getSelectedItem();
        String state = stateChoice.getSelectedItem();

        resultLabel.setText(name + ", " + email + ", " + gender + ", " + courses + city + ", " + state);
    }

    public static void main(String[] args) {
        new CollegeAdmissionForm();
    }
}