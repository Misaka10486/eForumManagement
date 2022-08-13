package DataCRUD.User;

import DataCRUD.CRUDException;
import DataModel.Circle.Circle;
import DataModel.User.User;

/* InterfaceName:
 *     UserCRUD
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/9
 */
public interface UserCRUD {

    //通过用户名获取一个用户
    User getUser(String name) throws CRUDException;

    //删除一个用户（如果该用户是圈主，圈主必须转让或者删除圈子）
    void delete(User user) throws CRUDException;

    //创建一个用户
    void create(User user) throws CRUDException;

    //修改用户密码
    void modifyPassword(User user, String newPassword) throws CRUDException;

    //修改用户名
    void modifyName(User user, String newName) throws CRUDException;

    //修改用户权限
    void modifyAuthority(User user, Circle circle, int authority) throws CRUDException;
}
