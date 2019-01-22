package com.test.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PoolSubpageMetric;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author: liuxl
 * @date: 2019-01-21 10:35
 * @description:
 */
public class EchoServer {

    private final String host;

    private final int port;

    public EchoServer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(host, port))
                .childHandler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new EchoServerHandler());
                    }
                });

        ChannelFuture future = b.bind().sync();
        System.out.println(EchoServer.class.getName() + "started and listen on " + future.channel().localAddress());
        future.channel().closeFuture().sync();

        group.shutdownGracefully().sync();
    }

    public static void main(String[] args) throws InterruptedException {

        new EchoServer("localhost",12345).start();
    }
}