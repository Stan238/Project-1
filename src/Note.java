import java.io.File;

public class Note {
    private File fileNote;

    public File getFileNote() {
        return fileNote;
    }

    public void setFileNote(File fileNote) {
        this.fileNote = fileNote;
    }
    public void writeToNote() {
        if (!fileNote.exists()) {
            CreateFile createNote = new CreateFile();
            createNote.createFile(fileNote);
        }
    }




}
