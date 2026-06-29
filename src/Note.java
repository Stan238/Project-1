import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Scanner;

public class Note {
    private File fileNote;
    private final Log logNote = new Log();



    public void setFileNote(String filename) {
        this.fileNote = new File("Notes/" + filename + ".txt");
    }

    public boolean writeToNote() {
//        Check file exist, if not then it will create automatically and note in the log file
        if (!fileNote.exists()) {
            System.out.println("File not exist. Do you want to create file? (Enter 'yes')");
//           Create file safely
            Scanner sc = new Scanner(System.in);
            String answerCreate = sc.next();
            if (answerCreate.equals("yes")) {
                try {
                    if (fileNote.createNewFile()) {
                        System.out.printf("Create file %s ", fileNote.getName());
                        logNote.writeLog("Create file");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else {
                return false;
            }

        }

        try (FileWriter writer = new FileWriter(fileNote, true)) {

            PrintWriter writerPrint = new PrintWriter(writer);
            MessageFile message = new MessageFile();

            writerPrint.println(message.getMassage());
            writerPrint.close();

        } catch (RuntimeException | IOException e) {
            logNote.writeLog(e.toString());
        }
        return true;

    }

    // Reading from file
    public void readNote() {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(fileNote))) {
            String line;
            System.out.println("==== Start Note ====");
            while ((line = inputStream.readLine()) != null) {
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

    public void listFiles() {
        File directoryFile = new File("Notes");

        if(directoryFile.exists()) {
            String[] listFiles =  directoryFile.list();
            if (listFiles.length > 0) {
                for (String nameFile : listFiles) {
                    System.out.println(nameFile.substring(0, nameFile.lastIndexOf('.')));
                }
            } else {
                System.out.println("Files list is empty. Create your own file :)");
            }
        } else {

              if (directoryFile.mkdir()){
                  logNote.writeLog("Create directory");
              }

        }
    }


    public boolean deleteNote(){

        if(fileNote.delete()) {
            logNote.writeLog("File "+ fileNote.getName() + "deleted");
            return true;
        } else {
            logNote.writeLog("File "+ fileNote.getName() + "can not be delete!!");
            return false;
        }

    }



}
