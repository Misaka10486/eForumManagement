package Service.Response;

import java.io.Serial;

public class LogInResponse extends Response {

    @Serial
    private static final long serialVersionUID = -3158707278211480236L;
    public final boolean success;

    public LogInResponse(String information, boolean success) {
        super(information);
        this.success = success;
    }
}
