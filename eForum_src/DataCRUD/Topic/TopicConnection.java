package DataCRUD.Topic;

import DataCRUD.CRUDException;
import DataModel.Topic.Topic;

/* ClassName:
 *     TopicConnection
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/13
 */
public class TopicConnection implements TopicCRUD {
    //补充该类，可以增加任何其他方法或属性以完成功能

    @Override
    public Topic[] getTopics1(String title) throws CRUDException {
        return new Topic[0];
    }

    @Override
    public Topic[] getTopics2(String Introduction) throws CRUDException {
        return new Topic[0];
    }

    @Override
    public void modifyTitle(Topic topic, String newTitle) throws CRUDException {

    }

    @Override
    public void modifyIntroduction(Topic topic, String newIntroduction) throws CRUDException {

    }

    @Override
    public void delete(Topic topic) throws CRUDException {

    }

    @Override
    public void create(Topic topic) throws CRUDException {

    }
}
