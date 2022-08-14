package DataView.Component;

public class Point implements Cloneable{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //控制点的上下左右移动
    public Point up() {
        --y;
        return this;
    }
    public Point down() {
        ++y;
        return this;
    }
    public Point left() {
        --x;
        return this;
    }
    public Point right() {
        ++x;
        return this;
    }

    //克隆函数
    public Point clone() {
        try {
            return (Point)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
