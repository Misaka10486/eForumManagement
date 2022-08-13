package DataCRUD;

/* ClassName:
 *     CRUDException
 * Description:
 *     ${描述}
 * Date:
 *     2022/8/9
 */
public class CRUDException extends Exception {
    //无参构造
    public CRUDException() {

    }

    //有参构造
    public CRUDException(String message) {
        super(message);
    }
}
