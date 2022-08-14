package DataView.Component;

import DataView.Screen.Screen;

public class Rectangle implements Component {

    private Point base1;
    private Point base2;
    private int style1;
    private int style2;
    private int height;
    private int length;

    public Rectangle(int x, int y, int height, int length, int style1, int style2) {
        this.base1 = new Point(x, y);
        this.height = height;
        this.length = length;
        this.base2 = new Point(x + length - 1, y + height - 1);
        this.style1 = style1;
        this.style2 = style2;
    }

    public Rectangle(Point base1, Point base2, int style1, int style2) {
        this.base1 = base1;
        this.base2 = base2;
        this.style1 = style1;
        this.style2 = style2;
        this.height = base2.y - base1.y + 1;
        this.length = base2.x - base1.x + 1;
    }

    @Override
    public void draw(Screen screen) {
        for (int i = base1.x; i <= base2.x; ++i) {
            screen.net[base1.y][i] = style1;
            screen.net[base2.y][i] = style1;
        }

        for (int i = base1.y + 1; i < base2.y; ++i) {
            screen.net[i][base1.x] = style2;
            screen.net[i][base2.x] = style2;
        }
    }

    public void setStyle1(int style1) {
        this.style1 = style1;
    }

    public void setStyle2(int style2) {
        this.style2 = style2;
    }

    public Point getBase1() {
        return base1.clone();
    }

    public Point getBase2() {
        return base2.clone();
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}