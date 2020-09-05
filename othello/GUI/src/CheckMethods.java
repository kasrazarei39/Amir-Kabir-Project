import java.awt.Color;

public class CheckMethods {
    public void changeColor(int start, int finish, int type, int counter, int btnIndex) {
        int cnt = 0;
        for (int k = start; k < finish; k += counter) {
            cnt = type + k;
            int location = btnIndex;
            int center = btnIndex;
            boolean flag = false;

            if (mapFrame.btns.get(btnIndex).getBackground() == Color.black) {
                while (true) {

                    if ((cnt == -9 || cnt == 7 || cnt == -1) && location % 8 == 0) {
                        break;
                    }
                    if ((cnt == 9 || cnt == -7 || cnt == 1) && location % 8 == 1) {
                        break;
                    }
                    if (location - cnt <= 0 || location - cnt > 64) {
                        break;
                    }

                    if (mapFrame.btns.get(location - cnt).getBackground() == Color.black) {
                        if (flag) {
                            while (center != (location - cnt)) {
                                mapFrame.btns.get(center).setBackground(Color.black);
                                center -= cnt;
                            }
                            break;
                        } else {
                            break;
                        }
                    } else if (mapFrame.btns.get(location - cnt).getBackground() == Color.white) {
                        flag = true;
                    } else {
                        break;
                    }
                    location -= cnt;
                }
            }

            if (mapFrame.btns.get(btnIndex).getBackground() == Color.white) {

                while (true) {
                    if ((cnt == -9 || cnt == 7 || cnt == -1) && location % 8 == 0) {
                        break;
                    }
                    if ((cnt == 9 || cnt == -7 || cnt == 1) && location % 8 == 1) {
                        break;
                    }
                    if (location - cnt <= 0 || location - cnt > 64) {
                        break;
                    }
                    if (mapFrame.btns.get(location - cnt).getBackground() == Color.white) {
                        if (flag) {
                            while (center != (location - cnt)) {
                                mapFrame.btns.get(center).setBackground(Color.white);
                                center -= cnt;
                            }
                            break;
                        } else {
                            break;
                        }
                    } else if (mapFrame.btns.get(location - cnt).getBackground() == Color.black) {
                        flag = true;
                    } else {
                        break;
                    }
                    location -= cnt;
                }
            }

        }


    }


    public void checkMove(int start, int finish, int type, int counter) {
        int cnt = 0;
        for (int k = start; k < finish; k += counter) {
            cnt = type + k;
            for (int i = 1; i <= 64; i++) {
                if (mapFrame.player == 1) {
                    if (mapFrame.btns.get(i).getBackground() == Color.black) {
                        int location = i;
                        boolean flag = false;
                        while (true) {
                            if ((cnt == -9 || cnt == 7 || cnt == -1) && location % 8 == 0) {
                                break;
                            }
                            if ((cnt == 9 || cnt == -7 || cnt == 1) && location % 8 == 1) {
                                break;
                            }
                            if (location - cnt <= 0 || location - cnt > 64) {
                                break;
                            }
                            if ((location - cnt) % 8 == 0) {
                                if (flag && mapFrame.btns.get(location - cnt).getBackground() == Color.pink) {
                                    mapFrame.btns.get(location - cnt).setBackground(Color.gray);

                                    break;
                                }

                            }
                            if (mapFrame.btns.get(location - cnt).getBackground() == Color.pink) {
                                if (flag) {
                                    mapFrame.btns.get(location - cnt).setBackground(Color.gray);


                                    break;
                                } else {
                                    break;
                                }
                            } else if (mapFrame.btns.get(location - cnt).getBackground() == Color.white) {
                                flag = true;
                            } else {
                                break;
                            }
                            location -= cnt;
                        }
                    }
                }

                if (mapFrame.player == 2) {
                    if (mapFrame.btns.get(i).getBackground() == Color.white) {
                        int location = i;
                        boolean flag = false;
                        while (true) {
                            if ((cnt == -9 || cnt == 7 || cnt == -1) && location % 8 == 0) {
                                break;
                            }
                            if ((cnt == 9 || cnt == -7 || cnt == 1) && location % 8 == 1) {
                                break;
                            }
                            if (location - cnt <= 0 || location - cnt > 64) {
                                break;
                            }
                            if ((location - cnt) % 8 == 0) {
                                if (flag && mapFrame.btns.get(location - cnt).getBackground() == Color.pink) {
                                    mapFrame.btns.get(location - cnt).setBackground(Color.gray);
                                    break;
                                }

                            }
                            if (mapFrame.btns.get(location - cnt).getBackground() == Color.pink) {
                                if (flag) {
                                    mapFrame.btns.get(location - cnt).setBackground(Color.gray);
                                    break;
                                } else {
                                    break;
                                }
                            } else if (mapFrame.btns.get(location - cnt).getBackground() == Color.black) {
                                flag = true;
                            } else {
                                break;
                            }
                            location -= cnt;
                        }
                    }
                }
            }
        }
    }
}
