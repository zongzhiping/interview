package com.zzp.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zzy on 2017/8/21.
 */
public class NIOClient {
    public static void main(String args[]) throws IOException {
        NIOClient nioClient = new NIOClient();
        nioClient.initClient("127.0.0.1",8000);
        nioClient.listen();
    }

    private Selector selector;
    public void initClient(String name,int port) throws IOException {
        SocketChannel sc = SocketChannel.open();

        sc.configureBlocking(false);
        this.selector = Selector.open();
        sc.connect(new InetSocketAddress(name,port));
        sc.register(selector, SelectionKey.OP_CONNECT);
    }

    public void listen() throws IOException {
        System.out.println("客服端启动成功");
        while(true){
            selector.select();
            Set selectionSet = selector.selectedKeys();
            Iterator it = selectionSet.iterator();
            while(it.hasNext()){
                SelectionKey sk = (SelectionKey) it.next();
                if(sk.isConnectable()){
                    SocketChannel sc = (SocketChannel) sk.channel();
                    if(sc.isConnectionPending()) {
                        sc.finishConnect();
                    }

                    sc.configureBlocking(false);
                    sc.write(ByteBuffer.wrap("向服务器端发送消息".getBytes()));
                    sc.register(selector,SelectionKey.OP_READ);
                    it.remove();
                }else if((sk.interestOps()&SelectionKey.OP_READ)==SelectionKey.OP_READ){
                    SocketChannel channel = (SocketChannel) sk.channel();
                    ByteBuffer bb = ByteBuffer.allocate(1024);
                    channel.read(bb);
                    String str = new String(bb.array());
                    System.out.println("接受到服务器端的信息: "+str);
                    ByteBuffer outBuffer = ByteBuffer.wrap(str.getBytes());
                    channel.write(outBuffer);
                    it.remove();
                }
            }
        }
    }

}
