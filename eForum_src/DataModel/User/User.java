package DataModel.User;

/* ClassName:
 *     User
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/9
 */
public class User {
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
