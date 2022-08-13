package DataCRUD.Circle;

import DataCRUD.CRUDException;
import DataModel.Circle.Circle;
import DataModel.User.User;

public interface CircleCRUD {

    //通过唯一圈名获取圈子
    Circle getCircle(String name) throws CRUDException;

    //删除指定的圈子
    void delete(Circle circle) throws CRUDException;

    //创建一个圈子，并指定圈主
    void create(User master, Circle circle) throws CRUDException;

    //修改圈名
    void modifyName(Circle circle, String newName) throws CRUDException;

    //修改简介
    void modifyIntroduction(Circle circle, String newIntroduction) throws CRUDException;
}