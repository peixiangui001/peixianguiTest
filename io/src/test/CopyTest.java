package test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyTest {

        public static void copy(String source,String target){
            try {
            FileInputStream is = new FileInputStream(new File(source));
            FileOutputStream out = new FileOutputStream(new File(target));
            byte buffer[] = new byte[4096];
            int index;
            while ((index=is.read(buffer))!=-1){
                out.write(buffer,0,index);
            }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    public static void fileCopyNIO(String source, String target) throws
            IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while(inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }

    public static void main(String[] args) {
            String source = "C:\\1.pdf";
            String target = "C:";
            copy(source,target);
    }

}
