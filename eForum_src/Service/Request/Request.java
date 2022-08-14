package Service.Request;

import java.io.Serial;
import java.io.Serializable;

public abstract class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 4050832002033364013L;
    public final String requestType;

    public Request(String requestType) {
        this.requestType = requestType;
    }

    //继承该类，可以增加任何其他方法或属性以完成功能
}