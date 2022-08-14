package DataView.Console;

public class Console {

    //类加载时顺便加载dll
    static {
        System.load("E:\\KamijouMikoto\\programing\\VS\\C++\\JNI\\JNIDLL\\Console\\out\\Console.dll");
    }

    //无参构造方法
    public Console() {
    }

    public int getByte(boolean echo) {
        if (echo) {
            return getByte();
        }
        return getByteWithoutEcho();
    }

    //从控制台接收各种类型的输入
    public native int getByte();
    private native int getByteWithoutEcho();

    public native int getInt();

    public native long getLong();

    public native double getDouble();

    public native String getLine();//调用改方法会导致多一个回车符CR
    public String getString() {
        String string = getLine();
        return string.substring(0, string.length() - 1);
    }

    //调用系统命令
    public native void system(String order);
}
