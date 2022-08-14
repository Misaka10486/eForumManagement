package DataModel.Circle;

import java.io.Serial;
import java.io.Serializable;

/* ClassName:
 *     Circle
 * Description:
 *     在业务逻辑层圈子的数据模型
 * Date:
 *     2022/8/9
 */
public class Circle implements Serializable {
    @Serial
    private static final long serialVersionUID = 2615885473391020337L;
    private final int ID;
    private String name;
    private String introduction;

    //来自前端的
    public Circle(String name, String introduction) {
        this(-1, name, introduction);
    }

    //来自后端的
    public Circle(int ID, String name, String introduction) {
        this.ID = ID;
        this.name = name;
        this.introduction = introduction;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getIntroduction() {
        return introduction;
    }
}