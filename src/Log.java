import java.io.*;
import java.util.Date;

public class Log {
    private final File logFile = new File("log/log.l");
    public void writeLog (String message) {
        try (FileWriter writerlog = new FileWriter(logFile, true)) {
            PrintWriter printlog = new PrintWriter(writerlog);
            Date dateLog = new Date();
            printlog.println(dateLog + " " + message);
            printlog.close();
        } catch (RuntimeException | IOException e){
            System.out.println(e);
        }
    }

//not sure
    public String toString(File name) throws UnsupportedEncodingException {
        String message = new String("Create file %d".getBytes(), name.getName());
        return message;
    }
}
