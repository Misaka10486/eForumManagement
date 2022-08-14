package DataView.Component;

import DataView.Screen.Screen;

public class Text implements Component {

    private Rectangle border;
    private char[] content;
    private boolean longText;

    public Text(Rectangle border, String content, boolean longText) {
        this.border = border;
        this.content = content.toCharArray();
        this.longText = longText;
    }

    @Override
    public void draw(Screen screen) {
        border.draw(screen);
        Point base1 = border.getBase1();
        Point base2 = border.getBase2();

        int i = 0, k;
        for (int j = base1.y + 1; j < base2.y; ++j) {
            k = base1.x + 1;
            while (k < base2.x) {
                if (i >= content.length) {
                    //如果文本内容已经全部绘制完成
                    return;//直接结束返回，因为本来就是空格（绘制的本质是覆盖原来的空格）
                }
                if (content[i] < 128) {
                    //如果是单格字符
                    screen.net[j][k++] = content[i++];
                } else {
                    //如果是双格字符
                    if (k < base2.x - 1) {
                        //并且本行剩余空格大于1
                        screen.net[j][k] = content[i++];
                        screen.net[j][k + 1] = 0;//一个两格字符不仅要占掉第一个空格，还要抹掉第二个空格
                        k += 2;
                    } else {
                        //否则直接换行
                        break;
                    }
                }
            }
        }

        //如果是长文本，则结尾以'.'代替
        if (longText && i < content.length) {
            screen.net[base2.y - 1][base2.x - 1] = 
            screen.net[base2.y - 1][base2.x - 2] =
            screen.net[base2.y - 1][base2.x - 3] = '.';
        }
    }
    

}
