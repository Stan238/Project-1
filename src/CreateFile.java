import java.io.File;

public class CreateFile {
    private Log logNote= new Log();
    public void createFile(File name) {

        System.out.printf("Create file %s " ,name.getName());
        logNote.writeLog("Create file");
    }


}
