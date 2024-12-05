import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskPanel extends JPanel {
    private Task task;
    private JCheckBox checkBox;
    private JLabel titleLabel;

    public TaskPanel(Task task) {
        this.task = task;
        setLayout(new BorderLayout());

        checkBox = new JCheckBox();
        checkBox.setSelected(task.isCompleted());
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task.setCompleted(checkBox.isSelected());
                updateTitle();
            }
        });

        titleLabel = new JLabel(task.getTitle());
        updateTitle();

        add(checkBox, BorderLayout.WEST);
        add(titleLabel, BorderLayout.CENTER);
    }

    private void updateTitle() {
        titleLabel.setText(task.toString());
    }
}