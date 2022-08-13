package Service.Service;

import Service.Request.Request;
import Service.Response.Response;

/* ClassName:
 *     Service
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/13
 */

//所有服务必须实现Service接口
public interface Service {
    Response handle(Request request);
}
