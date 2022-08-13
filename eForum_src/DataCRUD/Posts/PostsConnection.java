package DataCRUD.Posts;

import DataCRUD.CRUDException;
import DataModel.Posts.Posts;

/* ClassName:
 *     PostsConnection
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/9
 */
public class PostsConnection implements PostsCRUD {
    //补充该类，可以增加任何其他方法或属性以完成功能


    @Override
    public Posts[] getPosts1(String title) throws CRUDException {
        return new Posts[0];
    }

    @Override
    public Posts[] getPosts2(String content) throws CRUDException {
        return new Posts[0];
    }

    @Override
    public Posts[] getPosts3(String userName) throws CRUDException {
        return new Posts[0];
    }

    @Override
    public Posts[] getPosts4(String userName, String title) throws CRUDException {
        return new Posts[0];
    }

    @Override
    public Posts[] getPosts5(String userName, String content) throws CRUDException {
        return new Posts[0];
    }

    @Override
    public void create(Posts posts) throws CRUDException {

    }

    @Override
    public void delete(Posts posts) throws CRUDException {

    }

    @Override
    public void modifyTitle(Posts posts, String newTitle) throws CRUDException {

    }

    @Override
    public void modifyContent(Posts posts, String newContent) throws CRUDException {

    }
}
