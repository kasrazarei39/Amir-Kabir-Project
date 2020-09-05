import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class mapFrame {
    Checked check = new Checked();
    public static ArrayList<JButton> btns = new ArrayList<>();
    JButton tmp;
    JFrame frame;
    public static JLabel whiteLbl = new JLabel();
    public static JLabel blackLbl = new JLabel();
    public static JLabel information = new JLabel();
    public static int player = 1;

    public mapFrame() {
        this.frame = new JFrame();
        frame.setSize(510, 700);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        whiteLbl.setBounds(150, 530, 120, 40);
        whiteLbl.setText("0");
        frame.add(whiteLbl);

        blackLbl.setBounds(340, 530, 30, 40);
        blackLbl.setText("0");
        frame.add(blackLbl);

        information.setBounds(220, 530, 120, 40);
        information.setText("player 1");
        frame.add(information);

        createButtons();

        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void createButtons() {
        btns.add(tmp);
        int xDistance = 0;
        int yDistance = 0;
        for (int i = 0; i < 64; i++) {
            JButton button = new JButton();
            button.setOpaque(true);
            button.setBorderPainted(false);

            button.setBounds(10 + xDistance, 10 + yDistance, 60, 60);
            if (i == 27 || i == 36) {
                button.setBackground(Color.white);
                button.setSize(58, 58);
            } else if (i == 28 || i == 35) {
                button.setBackground(Color.black);
                button.setSize(58, 58);
            } else {

                button.setBackground(Color.pink);
            }
            btns.add(button);
            frame.add(button);
            if ((i + 1) % 8 == 0) {
                xDistance = 0;
                yDistance += 62;
            } else {
                xDistance += 62;
            }
            button.addActionListener(new Action());
        }
        JButton whiteBtn = new JButton();
        whiteBtn.setBounds(70, 520, 60, 60);
        whiteBtn.setOpaque(true);
        whiteBtn.setBorderPainted(false);
        whiteBtn.setBackground(Color.white);
        frame.add(whiteBtn);

        JButton blackBtn = new JButton();
        blackBtn.setBounds(380, 520, 60, 60);
        blackBtn.setOpaque(true);
        blackBtn.setBorderPainted(false);
        blackBtn.setBackground(Color.black);
        frame.add(blackBtn);

        JButton random = new JButton();
        random.setBounds(220, 600, 60, 60);
        random.setOpaque(true);
        random.setBorderPainted(false);
        random.setBackground(Color.green);
        frame.add(random);
        random.addActionListener(new Action());

        JLabel randomLbl = new JLabel("Random");
        randomLbl.setBounds(223, 570, 90, 30);
        frame.add(randomLbl);


        check.possibleMove(1);
    }
}
