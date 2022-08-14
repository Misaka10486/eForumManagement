package DataView.Console;

public class Console {

    //�����ʱ˳�����dll
    static {
        System.load("E:\\KamijouMikoto\\programing\\VS\\C++\\JNI\\JNIDLL\\Console\\out\\Console.dll");
    }

    //�޲ι��췽��
    public Console() {
    }

    public int getByte(boolean echo) {
        if (echo) {
            return getByte();
        }
        return getByteWithoutEcho();
    }

    //�ӿ���̨���ո������͵�����
    public native int getByte();
    private native int getByteWithoutEcho();

    public native int getInt();

    public native long getLong();

    public native double getDouble();

    public native String getLine();//���øķ����ᵼ�¶�һ���س���CR
    public String getString() {
        String string = getLine();
        return string.substring(0, string.length() - 1);
    }

    //����ϵͳ����
    public native void system(String order);
}
