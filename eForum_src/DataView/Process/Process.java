package DataView.Process;

import DataModel.User.User;
import DataTransfer.ObjectTransfer;
import DataView.Console.Console;
import DataView.Handler.Handler;
import DataView.Handler.MessageHandler;
import DataView.Message.KeyboardMessage;
import DataView.Message.Message;
import DataView.Screen.Screen;

public class Process {
    private Screen screen;
    private Message message;
    private Handler handler;
    private Console console;

    public Process() {
        screen = new Screen(100, 44);
        message = new KeyboardMessage();
        handler = new MessageHandler();
        console = new Console();
    }
    
    public void start() {
        begin();
        while (true) {
            screen.paint();
            message.accept();
            int result = handler.handle(message);
            switch (result) {
                case 1:

                    break;
                case 2:

                    break;
                default:
                    return;
            }
        }
    }

    public void begin() {
        console.system("cls");
        
        System.out.println("欢迎使用圈子！");
        System.out.print("请输入用户名：");
        String userName = console.getString();
        System.out.print("请输入密码：");
        String password = getPassword();
        User user = new User(userName, password);
        ObjectTransfer.transfer(user);
    }

    public String getPassword() {
        char[] password = new char[64];

        //输入密码过程
        int i = 0;
        char c = (char)console.getByte(false);
        while (c != '\r') {
            if (8 == c) {
                if (i - 1 > -1) {
                    --i;
                    System.out.print("\b \b");
                } 
            } else {
                password[i++] = c;
                System.out.print('*');
            }
            c = (char)console.getByte(false);
        }

        //将密码精确转换为String
        System.out.println();
        char[] passwordString = new char[i];
        System.arraycopy(password, 0, passwordString, 0, i);
        return new String(passwordString);
    }
}
