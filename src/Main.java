import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private JFrame frame;

    private JPanel panel;

    private DefaultTableModel model;

    private JTable table;

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
        frame.setMinimumSize(new Dimension(600, 600));
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane sPane = new JScrollPane();
        sPane.setPreferredSize(new Dimension(300, 400));

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.weighty = 0.2;
        JButton insertB = new JButton("Insert");
        JButton getAverageB = new JButton("Get Average");
        JLabel label = new JLabel("Course Parameters:");

        //think - do i need to shove these in an array at all? Maybe also add labels too?
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
        model.addColumn("Average");
        panel.add(table);

        //add insert button
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = c.weightx = 0;
        c.gridx = 1;
        c.gridy = 7;
        c.insets = (new Insets(0,20,0,20));
        panel.add(insertB, c);
        c.gridy = 8;
        panel.add(getAverageB, c);

        //add label
        c.gridx = 1;
        c.gridy = 0;
        panel.add(label, c);

        //add text fields
        for (int i = 0; i < insertTextFields.size(); i++) {
            c.gridwidth = 1;
            c.gridheight = 1;
            c.weighty = c.weightx = 0;
            c.gridx = 1;
            c.gridy = i+2;
            panel.add(insertTextFields.get(i), c);

        }

        //add table
        c.gridwidth = 2;
        c.gridheight = 10;
        c.weightx = c.weighty = 1.0;
        c.gridx = 2;
        c.gridy = 0;
        c.insets = (new Insets(0,0,0,0));

        sPane.getViewport().add(table);
        panel.add(sPane, c);


        frame.add(panel);

        insertB.addActionListener(new ActionListener() {
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
               model.addRow(new Object[] {name, grade, year, credits, avg});

               for (int i = 0; i < insertTextFields.size(); i ++) {
                   insertTextFields.get(i).setText("");
               }

            }
        });

        getAverageB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double avg = Organizer.getOrganizer().getAverage();
                DecimalFormat df = new DecimalFormat("###.##");
                JOptionPane.showMessageDialog(null,"Your average is " + avg);
                // fix weird ass rounding issue
            }
        });


    }

    public static void main(String[] args) {

        new Main().frame.setVisible(true);

    }


}
