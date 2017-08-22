package com.zzp.io;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by zzy on 2017/8/20.
 */
public class ClientDemo {
    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1",9002);

        socket.close();
    }
}
