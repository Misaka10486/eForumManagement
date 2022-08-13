package DataCRUD.Circle;

import DataCRUD.CRUDException;
import DataModel.Circle.Circle;
import DataModel.User.User;

/* ClassName:
 *     CircleConnection
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/9
 */
public class CircleConnection implements CircleCRUD {
    //补充该类，可以增加任何其他方法或属性以完成功能

    @Override
    public Circle getCircle(String name) throws CRUDException {
        return null;
    }

    @Override
    public void delete(Circle circle) throws CRUDException {

    }

    @Override
    public void create(User master, Circle circle) throws CRUDException {

    }

    @Override
    public void modifyName(Circle circle, String newName) throws CRUDException {

    }

    @Override
    public void modifyIntroduction(Circle circle, String newIntroduction) throws CRUDException {

    }
}
