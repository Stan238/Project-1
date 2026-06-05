import java.io.File;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Note {
    private File fileNote;
    private Log logNote= new Log();


    public File getFileNote() {
        return fileNote;
    }

    public void setFileNote(String filename) {
        this.fileNote = new File("Notes/"+filename+".txt");
    }
    public void writeToNote() {
        if (!fileNote.exists()) {
            System.out.printf("Create file %s " , fileNote.getName());
            logNote.writeLog("Create file");
        }

        try (FileWriter writer =new FileWriter(fileNote, true)){

            PrintWriter writerPrint = new PrintWriter(writer);
            MessageFile message = new MessageFile();

            writerPrint.println(message.getMassage());
            writerPrint.close();
        } catch( RuntimeException | IOException e) {
            logNote.writeLog(e.toString());
        }



    }




}
