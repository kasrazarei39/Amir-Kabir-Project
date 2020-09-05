public class ChangeColor {
    CheckMethods checking = new CheckMethods();

    public void change(int btnIndex) {
        checking.changeColor(-1, 2, -8, 1, btnIndex);

        checking.changeColor(-1, 2, 0, 2, btnIndex);

        checking.changeColor(-1, 2, 8, 1, btnIndex);
    }
}
