package com.zzp.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zzy on 2017/8/21.
 */
public class NIOServer {
    public static void main(String args[]) throws IOException {
        NIOServer server = new NIOServer();
        server.initServer(8000);
        server.listen();
    }

    //通道管理器
    private Selector selector;

    public void initServer(int port) throws IOException {


        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ServerSocket ss = ssc.socket();
        ss.bind(new InetSocketAddress(port));
        this.selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {
        System.out.println("服务器端启动成功");
        while(true){

            selector.select();
            Set<SelectionKey> selectionkeysSet = selector.selectedKeys();
            Iterator it = selectionkeysSet.iterator();
            while(it.hasNext()){
                SelectionKey sk = (SelectionKey) it.next();
                if((sk.interestOps()&SelectionKey.OP_ACCEPT)==SelectionKey.OP_ACCEPT){
                   ServerSocketChannel ssc = (ServerSocketChannel) sk.channel();
                   SocketChannel sc = ssc.accept();
                   sc.configureBlocking(false);
                   sc.write(ByteBuffer.wrap("向客户端发送一条消息".getBytes()));

                   it.remove();
                   sc.register(selector,SelectionKey.OP_READ);
                }else if((sk.interestOps()&SelectionKey.OP_READ)==SelectionKey.OP_READ){
                    SocketChannel sc = (SocketChannel) sk.channel();
                    ByteBuffer bb = ByteBuffer.allocate(1024);
                    sc.read(bb);
                    System.out.println("服务器端收到消息:   "+new String(bb.array()).trim());
                    sc.write(ByteBuffer.wrap(bb.array()));
                    it.remove();
                }

            }
        }

    }

}
