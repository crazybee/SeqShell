package gui.src;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class FileUtils {

    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // ???????????
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // ?????
        while (line != null) { // ?? line ???????
            buffer.append(line); // ????????? buffer ?
            buffer.append("\n"); // ?????
            line = reader.readLine(); // ?????
        }
        reader.close();
        is.close();
    }

    /**
     * ????????
     * @param filePath ??????
     * @return ????
     * @throws IOException ??
     * @author cn.outofmemory
     * @date 2013-1-7
     */
    public static String readFile(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();
        FileUtils.readToBuffer(sb, filePath);
        return sb.toString();
    }
}