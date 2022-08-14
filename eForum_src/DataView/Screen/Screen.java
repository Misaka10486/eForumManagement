package DataView.Screen;

public class Screen {

    public final int length;
    public final int height;
    public int[][] net;

    public Screen(int length, int height) {
        this.length = length;
        this.height = height;
        this.net = new int[height][length];
        fill(' ');
    }

    //在控制台屏幕上绘制画面
    public void paint() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print((char)net[i][j]);
            }
            System.out.println();
        }
    }

    //重置帧
    public void reset() {
        fill(0);
    }

    public void fill(int style) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                net[i][j] = style;
            }
        }
    }
}
