package nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.locks.ReentrantLock;

public class MappedByteBufferTest {
    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        File file = new File("D://db.txt");
        long length = file.length();
        FileInputStream inputStream = new FileInputStream(file);
        MappedByteBuffer mappedByteBuffer = inputStream.getChannel().map(FileChannel.MapMode.READ_ONLY,
                0,length);

    }
}
