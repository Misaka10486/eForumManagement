package Service.Request;

/* ClassName:
 *     Request
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/13
 */
public abstract class Request {
    public final String requestType;

    public Request(String requestType) {
        this.requestType = requestType;
    }

    //继承该类，可以增加任何其他方法或属性以完成功能
}
