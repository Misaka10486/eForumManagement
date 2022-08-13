package Service.Request;

import DataModel.User.User;

/* ClassName:
 *     LogInRequest
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/13
 */
public class LogInRequest extends Request {

    private final User user;

    public LogInRequest(User user) {
        super("LogIn");
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
