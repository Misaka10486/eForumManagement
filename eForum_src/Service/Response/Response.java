package Service.Response;

/* ClassName:
 *     Response
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/13
 */
public abstract class Response {
    private final String information;

    protected Response(String information) {
        this.information = information;
    }

    //继承该类，可以增加任何其他方法或属性以完成功能
}
