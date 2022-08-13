package Service.Service;

import DataCRUD.CRUDException;
import DataCRUD.User.UserCRUD;
import DataCRUD.User.UserConnection;
import DataModel.User.User;
import Service.Request.LogInRequest;
import Service.Request.Request;
import Service.Response.LogInResponse;
import Service.Response.Response;

/* ClassName:
 *     LogInService
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/13
 */

//框架使得每实现一项功能只需要写三个类，这三个类还是固定模板的！
//具体就是，前端发出request类对象（一行调用的事儿很简单，我都封装好了的），后端接收到后
//会自动安排相应的service类对象处理（这个”自动安排“用反射做的，你们不需要了解，我封装好了），
//service类对象里面都需有一个handle函数接收request类对象作为参数，然后通过这个函数给出response类对象作为回应就行了

//比如，下面这个“登录功能”实现案例
// request里面包含用户信息和请求类型（到时候会统一规定为前后端一致的英文字符串），这里就是"logIn"
//在service里面根据request的信息，在这里就是用户名和密码，调用数据库接口函数（这些接口函数的存在可以使得负责业
//务逻辑的人员完全不用关心JDBC和sql语句，而写sql语句的人也不用关心业务逻辑，各司其职）查询该用户，根据用户是否存在以及
//密码正确与否new出response类对象return即可（同样的，这里也不用关心return了之后这个对象怎么跑到前端去的，我帮各位已经完成了
//这些琐碎的工作）

public class LogInService implements Service {

    @Override
    public Response handle(Request request) {
        LogInRequest logInRequest = (LogInRequest) request;
        User user1 = logInRequest.getUser();
        UserCRUD userData = new UserConnection();

        try {
            User user2 = userData.getUser(logInRequest.getUser().getName()); //此处调用了数据库查询接口函数（当然这个函数还没写w
            if (null != user2) {
                if (user2.getPassword().equals(user1.getPassword())) {
                    return new LogInResponse("登录成功！", true);
                } else {
                    return new LogInResponse("密码错误！", false);
                }
            } else {
                return new LogInResponse("用户不存在！", false);
            }
        } catch (CRUDException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
