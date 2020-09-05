import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Action implements ActionListener {
    Checked check = new Checked();

    @Override
    public void actionPerformed(ActionEvent e) {

        if (((JButton) e.getSource()).getBackground() == Color.green) {
            int btnIndex = 0;
            ArrayList<Integer> grayBtn = new ArrayList<>();
            if (mapFrame.player == 1) {
                for (int i = 1; i <= 64; i++) {
                    if (mapFrame.btns.get(i).getBackground() == Color.gray) {
                        grayBtn.add(i);
                    }
                }
                Random rand = new Random();
                btnIndex = rand.nextInt(grayBtn.size());
                mapFrame.btns.get(grayBtn.get(btnIndex)).setBackground(Color.black);
                for (int i = 1; i <= 64; i++) {
                    if (mapFrame.btns.get(i).getBackground() == Color.gray) {
                        mapFrame.btns.get(i).setBackground(Color.pink);
                    }
                }
                mapFrame.information.setText("player 2");
                mapFrame.player = 2;
            } else {
                for (int i = 1; i <= 64; i++) {
                    if (mapFrame.btns.get(i).getBackground() == Color.gray) {
                        grayBtn.add(i);
                    }
                }
                Random rand = new Random();
                btnIndex = rand.nextInt(grayBtn.size());
                mapFrame.btns.get(grayBtn.get(btnIndex)).setBackground(Color.white);
                for (int i = 1; i <= 64; i++) {
                    if (mapFrame.btns.get(i).getBackground() == Color.gray) {
                        mapFrame.btns.get(i).setBackground(Color.pink);
                    }
                }

                mapFrame.information.setText("player 1");
                mapFrame.player = 1;
            }
            check.possibleMove(grayBtn.get(btnIndex));
        }


        if (((JButton) e.getSource()).getBackground() == Color.gray) {
            int btnIndex = mapFrame.btns.indexOf(e.getSource());
            ((JButton) e.getSource()).setSize(58, 58);
            ((JButton) e.getSource()).setOpaque(true);
            ((JButton) e.getSource()).setBorderPainted(false);
            if (mapFrame.player == 1) {
                ((JButton) e.getSource()).setBackground(Color.black);
                for (int i = 1; i <= 64; i++) {
                    if (mapFrame.btns.get(i).getBackground() == Color.gray) {
                        mapFrame.btns.get(i).setBackground(Color.pink);
                    }
                }
                mapFrame.information.setText("player 2");
                mapFrame.player = 2;
            } else {
                ((JButton) e.getSource()).setBackground(Color.white);
                for (int i = 1; i <= 64; i++) {
                    if (mapFrame.btns.get(i).getBackground() == Color.gray) {
                        mapFrame.btns.get(i).setBackground(Color.pink);
                    }
                }
                mapFrame.information.setText("player 1");
                mapFrame.player = 1;
            }
            check.possibleMove(btnIndex);
        }
    }
}
