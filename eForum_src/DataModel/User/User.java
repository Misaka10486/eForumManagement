package DataModel.User;

import java.io.Serial;
import java.io.Serializable;

/* ClassName:
 *     User
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/9
 */
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1958123660687909786L;
    private String name;
    private int ID;
    private String password;

    public User(String name) {
        this(name, null);
    }

    public User(String name, String password) {
        this(name, -1, password);
    }

    public User(String name, int ID, String password) {
        this.name = name;
        this.ID = ID;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }
}