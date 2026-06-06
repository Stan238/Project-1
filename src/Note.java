import java.io.File;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Note {
    private File fileNote;
    private Log logNote= new Log();

//   public File getFileNote() {
//        return fileNote;
//    }

    public void setFileNote(String filename) {
        this.fileNote = new File("Notes/"+filename+".txt");
    }

    public void writeToNote() {
//        Check file exist, if not then it will create automatically and note in the log file
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

    public void readNote() {
      try (BufferedReader inputStream = new BufferedReader(new FileReader(fileNote))){
          String line;
          System.out.println("==== Start Note ====");
          while((line = inputStream.readLine()) != null) {
              System.out.println(line);
          }
          System.out.println("==== End Note ====");
      } catch (FileNotFoundException e) {
          System.out.println("File not found");
          logNote.writeLog(e.toString());
      } catch (IOException ioException) {
          logNote.writeLog(ioException.getMessage());
      } finally {
          System.out.println("Choose exist file");
      }

    }




}
