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

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane sPane = new JScrollPane();
        sPane.setPreferredSize(new Dimension(250, 250));

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.weighty = 0.2;
        button = new JButton("Insert");
        JLabel label = new JLabel("Course Parameters:");

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

        //insert columns on table
        model.addColumn("Name");
        model.addColumn("Grade");
        model.addColumn("Year");
        model.addColumn("Credits");
        model.addColumn("Class Average");
        panel.add(table);

        //add insert button
        c.gridx = 0;
        c.gridy = insertTextFields.size() + 1;
        panel.add(button, c);

        //add label
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);

        //add table
        c.gridx = 2;
        c.gridy = 3;
        sPane.getViewport().add(table);
        panel.add(sPane, c);

        //add text fields
        for (int i = 0; i < insertTextFields.size(); i++) {
            c.gridx = 0;
            c.gridy = i+1;
            panel.add(insertTextFields.get(i), c);

        }


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
