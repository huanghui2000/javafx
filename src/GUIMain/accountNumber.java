package GUIMain;

import java.io.*;
import java.net.InetAddress;

public class accountNumber {

    public static int register(String account, String password, String ID) throws IOException {
        int i;
        File file = new File(account);
        if (file.exists()) {
            i = 0;
        } else {
            DataOutputStream output = new DataOutputStream(new FileOutputStream(file, true));
            output.writeUTF(account);
            output.writeUTF(password);
            output.writeUTF(ID);
            InetAddress ip = InetAddress.getLocalHost();
            output.writeUTF(ip.getHostAddress());
            output.writeUTF("8080");
            i = 1;
            output.close();
        }
        return i;
    }

    public static int testing(String account) {
        int i;
        File file = new File(account);
        if (!file.exists()) {
            i = 1;
        } else i = 0;
        return i;
    }

    public static int testing(String account, String password) throws IOException {
        int i;
        File file = new File(account);
        if (!file.exists()) {
            i = 0;
        } else {
            DataInputStream input = new DataInputStream(new FileInputStream(file));
            if (account.equals(input.readUTF()) && password.equals(input.readUTF())) {
                i = 1;
            } else i = 0;
            input.close();
        }
        return i;
    }
}
