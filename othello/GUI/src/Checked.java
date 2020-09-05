import java.awt.Color;

public class Checked {
    ChangeColor changing = new ChangeColor();
    CheckMethods checking = new CheckMethods();

    public void possibleMove(int btnIndex) {
        changing.change(btnIndex);

        checking.checkMove(-1, 2, -8, 1);
        checking.checkMove(-1, 2, 0, 2);
        checking.checkMove(-1, 2, 8, 1);

        int whiteCnt = 0;
        int blackCnt = 0;
        for (int i = 1; i <= 64; i++) {
            if (mapFrame.btns.get(i).getBackground() == Color.black) {
                blackCnt++;
            }
            if (mapFrame.btns.get(i).getBackground() == Color.white) {
                whiteCnt++;
            }
        }
        mapFrame.whiteLbl.setText(String.valueOf(whiteCnt));
        mapFrame.blackLbl.setText(String.valueOf(blackCnt));

        int tmp = 0;
        for (int i = 1; i <= 64; i++) {
            if (mapFrame.btns.get(i).getBackground() == Color.gray) {
                tmp++;
            }

        }
        if (tmp == 0) {
            mapFrame.information.setText("Pass");
            if (mapFrame.player == 1) {
                mapFrame.player = 2;
            } else {
                mapFrame.player = 1;
            }
            checking.checkMove(-1, 2, -8, 1);
            checking.checkMove(-1, 2, 0, 2);
            checking.checkMove(-1, 2, 8, 1);
            for (int i = 1; i <= 64; i++) {
                if (mapFrame.btns.get(i).getBackground() == Color.gray) {
                    tmp++;
                }
            }
            if (tmp == 0) {
                if (whiteCnt < blackCnt) {
                    mapFrame.information.setText("player 1 won!!!");
                } else if (whiteCnt > blackCnt) {
                    mapFrame.information.setText("player 2 won!!!");
                } else {
                    mapFrame.information.setText("draw!!!");
                }
            }
        }
    }
}
