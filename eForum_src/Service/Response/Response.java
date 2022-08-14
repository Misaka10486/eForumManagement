package Service.Response;

import java.io.Serial;
import java.io.Serializable;

public abstract class Response implements Serializable {
    @Serial
    private static final long serialVersionUID = 8277472087127032200L;
    protected final String information;

    protected Response(String information) {
        this.information = information;
    }

    //继承该类，可以增加任何其他方法或属性以完成功能
}