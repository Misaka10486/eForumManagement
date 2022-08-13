package Service.Response;

/* ClassName:
 *     LogInResponse
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/13
 */
public class LogInResponse extends Response {

    public final boolean success;

    public LogInResponse(String information, boolean success) {
        super(information);
        this.success = success;
    }
}
