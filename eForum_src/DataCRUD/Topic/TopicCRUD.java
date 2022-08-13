package DataCRUD.Topic;

import DataCRUD.CRUDException;
import DataModel.Topic.Topic;

/* InterfaceName:
 *     TopicCRUD
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/10
 */
public interface TopicCRUD {
    Topic[] getTopics1(String title) throws CRUDException;

    Topic[] getTopics2(String Introduction) throws CRUDException;

    void modifyTitle(Topic topic, String newTitle) throws CRUDException;

    void modifyIntroduction(Topic topic, String newIntroduction) throws CRUDException;

    void delete(Topic topic) throws CRUDException;

    void create(Topic topic) throws CRUDException;

}
