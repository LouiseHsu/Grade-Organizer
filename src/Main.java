import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private JFrame frame;

    private JPanel panel;

    private JButton button;

    private JLabel label;

    private JTextField nameField;
    private JTextField gradeField;
    private JTextField yearField;
    private JTextField creditsField;
    private JTextField avgField;


    private Main() {


        gui();

    }

    public void gui() {
        frame = new JFrame("Testing, testing");
        frame.setSize(500, 500);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        button = new JButton("Insert");
        label = new JLabel("Course Parameters:");

        //think - do i need to shove these in an array at all?
        List <JTextField> insertTextFields = new ArrayList<>();
        nameField = new JTextField(8);
        gradeField = new JTextField(3);
        yearField = new JTextField(4);
        creditsField = new JTextField(1);
        avgField = new JTextField(3);

        //insert the text fields to list
        insertTextFields.add(nameField);
        insertTextFields.add(gradeField);
        insertTextFields.add(yearField);
        insertTextFields.add(creditsField);
        insertTextFields.add(avgField);

        //add insert button
        c.gridx = 0;
        c.gridy = insertTextFields.size() + 1;
        panel.add(button, c);

        //add label
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

        //add text fields
        for (int i = 0; i < insertTextFields.size(); i++) {
            c.gridx = 0;
            c.gridy = i+1;
            panel.add(insertTextFields.get(i), c);
        }

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();


        frame.add(panel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               for (int i = 0; i < insertTextFields.size(); i ++) {
                   if (insertTextFields.get(i).getText() == "") {
                       return;
                   }
               }
               String name = nameField.getText();
               int grade = Integer.parseInt(gradeField.getText());
               String year = yearField.getText();
               int credits = Integer.parseInt(creditsField.getText());
               int avg = Integer.parseInt(avgField.getText());

               Organizer.getOrganizer().addCourse(true, name, grade, year, credits, avg);

               for (int i = 0; i < insertTextFields.size(); i ++) {
                   insertTextFields.get(i).setText("");
               }

            }
        });


    }

    public static void main(String[] args) {

        new Main().frame.setVisible(true);

    }


}
