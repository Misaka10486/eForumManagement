package DataModel.Topic;

import DataModel.Circle.Circle;
import DataModel.User.User;

/* ClassName:
 *     Topic
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/9
 */
public class Topic {
    private int ID;
    private Circle circle;
    private User publisher;
    private String title;
    private String introduction;

    //从前端向后端（不知道ID时）
    public Topic(Circle circle, User publisher, String title, String introduction) {
        this(circle, publisher, title, introduction, -1);
    }

    //从后端调向前端（知道ID时）
    public Topic(Circle circle, User publisher, String title, String introduction, int ID) {
        this.circle = circle;
        this.publisher = publisher;
        this.title = title;
        this.introduction = introduction;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public Circle getCircle() {
        return circle;
    }

    public User getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getintroduction() {
        return introduction;
    }
}
