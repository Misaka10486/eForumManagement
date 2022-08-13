package DataCRUD.User;

import DataCRUD.CRUDException;
import DataModel.Circle.Circle;
import DataModel.User.User;

/* ClassName:
 *     UserConnection
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/9
 */
public class UserConnection implements UserCRUD {
    //补充该类，可以增加任何其他方法或属性以完成功能

    @Override
    public User getUser(String name) throws CRUDException {
        return null;
    }

    @Override
    public void delete(User user) throws CRUDException {

    }

    @Override
    public void create(User user) throws CRUDException {

    }

    @Override
    public void modifyPassword(User user, String newPassword) throws CRUDException {

    }

    @Override
    public void modifyName(User user, String newName) throws CRUDException {

    }

    @Override
    public void modifyAuthority(User user, Circle circle, int authority) throws CRUDException {

    }
}
