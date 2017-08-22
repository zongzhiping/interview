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
 * Created by zzy on 2017/8/20.
 *
 * 基于网络的NIO传输
 */
public class MutilPortEcho {

    private int ports[];
    public static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    public MutilPortEcho(int ports[]) throws IOException {
        this.ports = ports;
        go(ports);
    }

    public static void go(int[] ports) throws IOException {
        Selector selector = Selector.open();
        for(int i = 0 ; i < ports.length ;i++){
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ServerSocket ss = ssc.socket();
            InetSocketAddress address = new InetSocketAddress("127.0.0.1",ports[i]);
            ss.bind(address);
            SelectionKey sk = ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Going to listen on " + ports[i]);
        }

        while(true){
            int num = selector.select();
            Set selectKeys = selector.selectedKeys();
            Iterator it = selectKeys.iterator();
            while(it.hasNext()){
                SelectionKey key = (SelectionKey) it.next();
                if((key.readyOps()&SelectionKey.OP_ACCEPT)==SelectionKey.OP_ACCEPT){
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    SelectionKey newKey = sc.register(selector,SelectionKey.OP_READ);
                    it.remove();
                    System.out.println("Got connection from " + sc);
                }else if((key.readyOps()& SelectionKey.OP_READ)==SelectionKey.OP_READ){
                    SocketChannel sc = (SocketChannel) key.channel();
                    int bytesEchoed = 0;
                    while(true){
                        byteBuffer.clear();
                        int r = sc.read(byteBuffer);
                        if(r<0){
                            break;
                        }
                        byteBuffer.flip();
                        sc.write(byteBuffer);
                        bytesEchoed+=r;
                    }
                    System.out.println("Echoed " + bytesEchoed + " from " + sc);
                    it.remove();
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        String ps[]={"9001","9002","9003"};
        if(ps.length<0){
            throw new RuntimeException("发生异常，程序退出");
        }
        int ports[] = new int[ps.length];
        for(int i = 0 ; i < ports.length ;i++){
            ports[i]=Integer.parseInt(ps[i]);
        }
        new MutilPortEcho(ports);
    }
}
