package DataModel.Posts;

import java.io.Serial;
import java.io.Serializable;

import DataModel.Circle.Circle;
import DataModel.Topic.Topic;
import DataModel.User.User;

/* ClassName:
 *     Posts
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/9
 */
public class Posts implements Serializable {
    @Serial
    private static final long serialVersionUID = 2936024254186575048L;
    private User user;
    private Circle circle;
    private Topic topic;
    private String title;
    private String content;
    private int rank = -1;

    //发帖但不加入任何话题
    public Posts(User user, Circle circle, String title, String content) {
        this(user, null, circle, title, content);
    }

    //发帖但是加入话题
    public Posts(User user, Topic topic, Circle circle, String title, String content) {
        this(user, circle, topic, title, content, -1);
    }

    //后端(业务逻辑层)返回一个完整的贴
    public Posts(User user, Circle circle, Topic topic, String title, String content, int rank) {
        this.user = user;
        this.circle = circle;
        this.topic = topic;
        this.title = title;
        this.content = content;
        this.rank = rank;
    }

    public User getUser() {
        return user;
    }

    public Circle getCircle() {
        return circle;
    }

    public Topic getTopic() {
        return topic;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getRank() {
        return rank;
    }
}