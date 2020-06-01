package com.yevhensuturin;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeDataTransfer {
    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();

            Runnable writer1 = new Runnable() {
                @Override
                public void run() {
                    try{
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i = 0; i<10; i++){
                            String currentTime = "The 1 time is: "+ System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());

                            buffer.flip();
                            while (buffer.hasRemaining()){
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (IOException | InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };

            Runnable writer2 = new Runnable() {
                @Override
                public void run() {
                    try{
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i = 0; i<10; i++){
                            String currentTime = "The 2 time is: "+ System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());

                            buffer.flip();
                            while (buffer.hasRemaining()){
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (IOException | InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try{
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for (int i=0; i<10; i++){
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Read Thread: "+new String(timeString) + "\tcurrent time = "+System.currentTimeMillis());
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    } catch (IOException | InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer1).start();
            new Thread(writer2).start();
            new Thread(reader).start();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
