package com.yevhensuturin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class JavaNIOMain {
    public static void main(String[] args) {
        try (FileOutputStream  binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(100);
//            byte[] outputBytes = "Hello world!".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
//            buffer.flip();

//            read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
//                               updates the position accordingly.
//                               Note that now we're talking about the channel's position, not the byte buffer's position.
//                               Of course, the bytes will be placed into the buffer starting at its current position.
//            write(ByteBuffer) - the same as read, except it writes. There's one exception.
//                              If a datasource is opened in APPEND mode, then the first write will take place starting
//                              at the end of the datasource, rather than at position 0. After the write, the position
//                              will be updated accordingly.
//            position() - returns the channel's position.
//            position(long) - sets the channel's position to the passed value.
//            truncate(long) - truncates the size of the attached datasource to the passed value.
//            size() - returns the size of the attached datasource


            byte[] outputBytes = "Hello world!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length ;
            buffer.putInt(1000);
            buffer.flip();

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);

            channel.read(intBuffer, int3Pos);
            intBuffer.flip();
            System.out.println("int3= " + intBuffer.getInt());
            intBuffer.flip();
            channel.read(intBuffer, int2Pos);
            System.out.println("int2= " + intBuffer.getInt(0));
            intBuffer.flip();
            channel.read(intBuffer, int1Pos);
            System.out.println("int1= " + intBuffer.getInt(0));
            intBuffer.flip();


// Calculate all the staff positions
            byte[] outputString = "Hello world!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;
            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES;
            long newInt3Pos = str2Pos + outputString2.length;

// Set data for in position
            ByteBuffer newIntBuffer =  ByteBuffer.allocate(Integer.BYTES);
            newIntBuffer.putInt(245);
            newIntBuffer.flip();
            binChannel.write(newIntBuffer, newInt1Pos);

            newIntBuffer.flip();
            newIntBuffer.putInt(-987654);
            newIntBuffer.flip();
            binChannel.write(newIntBuffer, newInt2Pos);

            newIntBuffer.flip();
            newIntBuffer.putInt(1000);
            newIntBuffer.flip();
            binChannel.write(newIntBuffer, newInt3Pos);

            buffer.flip();
            buffer.put(outputString);
            buffer.flip();
            binChannel.write(buffer, str1Pos);

            binChannel.write(ByteBuffer.wrap(outputString), str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString2), str2Pos);



//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.read(readBuffer);
//            readBuffer.flip();
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//            System.out.println("InputString= " + new String(inputString));
//            System.out.println("int1= " + readBuffer.getInt());
//            System.out.println("int2= " + readBuffer.getInt());
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer.get(inputString2);
//            System.out.println("InputString2= "+ new String(inputString2));
//            System.out.println("int3= " + readBuffer.getInt());

            channel.close();
            ra.close();




//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//            buffer.flip();

//            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
//            int numBytes = binChannel.write(buffer);
//            System.out.println("Num bytes written was: " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("Num bytes written was: " + numBytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98245);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("Num bytes written was: " + numBytes);
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//            System.out.println("outputBytes before reading = " + new String(outputBytes));
//            long numBytesRead = channel.read(buffer);
//            if(buffer.hasArray()){
//                System.out.println("byte buffer = " + new String(buffer.array()));
//                System.out.println("outputBytes after reading = " + new String(outputBytes));
//            }
//     ABSOLUTE READ
//   Here we set the start position where to read data from the buffer. But steel we need to flip buffer before reading data from channel
//            intBuffer.flip();
//            numBytes = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytes = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));




//     RELATIVE READ
//   Use current position at the buffer to read the data. We always need to flip buffer inorder to set position to the buffers begin
//   The buffers position is changed when we read/write data from/to the buffer. So if we need to read or write from/to the first buffers position
//   we need to flip buffer. Another approach is to set a position to the getInt(position) method
//            intBuffer.flip();
//            numBytes = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytes = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());

//            channel.close();
//            ra.close();




//  java.io RandomAccessFile using
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            byte[] b = new byte[outputBytes.length];
//            ra.read(b);
//            System.out.println(new String(b));
//
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();
//            System.out.println(int1);
//            System.out.println(int2);



//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();

//            Path dataPath = FileSystems.getDefault().getPath("data.txt");
//            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
//
//            List<String> lines = Files.readAllLines(dataPath);
//            for(String line: lines){
//                System.out.println(line);
//            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
