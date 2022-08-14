package Service.Request;

import java.io.Serial;

import DataModel.User.User;

public class LogInRequest extends Request {

    @Serial
    private static final long serialVersionUID = 722249782392549953L;
    private final User user;

    public LogInRequest(User user) {
        super("LogInRequest");
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}