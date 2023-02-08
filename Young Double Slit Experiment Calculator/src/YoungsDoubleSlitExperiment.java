import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YoungsDoubleSlitExperiment extends JFrame implements ActionListener {
    private JTextField wavelengthInput, distanceInput, slitWidthInput;
    private JButton calculateButton;
    private JLabel resultLabel;

    public YoungsDoubleSlitExperiment() {
        setTitle("Young's Double Slit Experiment Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        wavelengthInput = new JTextField(10);
        distanceInput = new JTextField(10);
        slitWidthInput = new JTextField(10);
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("");

        add(new JLabel("Wavelength (m):"));
        add(wavelengthInput);
        add(new JLabel("Distance (m):"));
        add(distanceInput);
        add(new JLabel("Slit Width (m):"));
        add(slitWidthInput);
        add(calculateButton);
        add(resultLabel);

        calculateButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double wavelength = Double.parseDouble(wavelengthInput.getText());
        double distance = Double.parseDouble(distanceInput.getText());
        double slitWidth = Double.parseDouble(slitWidthInput.getText());

        double sinTheta = wavelength / (2 * slitWidth);
        double sin2Theta = 2 * sinTheta * sinTheta;
        double pathDifference = distance * sin2Theta;

        resultLabel.setText("Path Difference: " + pathDifference + " meters");
    }

    public static void main(String[] args) {
        YoungsDoubleSlitExperiment frame = new YoungsDoubleSlitExperiment();
        frame.setVisible(true);
    }
}
