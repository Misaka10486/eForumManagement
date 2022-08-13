package DataCRUD.Posts;

import DataCRUD.CRUDException;
import DataModel.Posts.Posts;

/* InterfaceName:
 *     PostsCRUD
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/9
 */
public interface PostsCRUD {

    //通过标题搜索帖子
    Posts[] getPosts1(String title) throws CRUDException;

    //通过内容搜索帖子
    Posts[] getPosts2(String content) throws CRUDException;

    //通过作者搜索帖子
    Posts[] getPosts3(String userName) throws CRUDException;

    //通过作者和标题搜索贴子
    Posts[] getPosts4(String userName, String title) throws CRUDException;

    //通过作者和内容搜索帖子
    Posts[] getPosts5(String userName, String content) throws CRUDException;

    //发布一个新帖
    void create(Posts posts) throws CRUDException;

    //删除一个帖子
    void delete(Posts posts) throws CRUDException;

    //更改帖子标题
    void modifyTitle(Posts posts, String newTitle) throws CRUDException;

    //更改帖子内容
    void modifyContent(Posts posts, String newContent) throws CRUDException;
}
