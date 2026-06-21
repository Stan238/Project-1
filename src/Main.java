//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Log logNote = new Log();
    logNote.writeLog("Project1 run");
    boolean chooseMenu = true;
    boolean isName;
    Note fileNote = new Note();

    while ( chooseMenu) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Menu:\s
                 1. List files
                 2. Write
                 3. Read
                 4. Delete
                 5. Exit""");
        System.out.print("Your selection:");
        int menuNumber;
        try {
            menuNumber = sc.nextInt();
       }catch (InputMismatchException e){
            menuNumber = 0;
            logNote.writeLog(e.toString());
        }

        switch (menuNumber) {
            case 1:
                System.out.println("=== List files===");
                fileNote.listFiles();
                System.out.println("=== === === === ===");
               break;
            case 2:
                /* get name file
                 * check file is exist
                 * create file / open file
                 * get some note throw user's input
                 * close file*/
                isName = true;
                do {
                    System.out.print("Enter file name: ");
                    String nameOfFile;
                    nameOfFile = sc.next();
                    if (nameOfFile.indexOf('/') == -1) {
                        fileNote.setFileNote(nameOfFile);
                        isName = false;
                    } else {
                        System.out.println("Contain unacceptable characteristics");
                        logNote.writeLog("Contain unacceptable characteristics - " + nameOfFile);
                    }
                } while (isName);
                 if (fileNote.writeToNote()) {
                logNote.writeLog("Write to file");
                 } else {
                     logNote.writeLog("Unsuccessfully attempt wrote file ");
                 }
                break;
            case 3:
                /* get name file
                 * check file is exist
                 *  open file
                 * read file
                 * close file*/
//                TODO create methods to check name file and set name File Note
                isName = true;
                do {
                    System.out.print("Enter file name: ");
                    String nameOfFile;
                    nameOfFile = sc.next();
                    if (nameOfFile.indexOf('/') == -1) {
                        fileNote.setFileNote(nameOfFile);
                        isName = false;
                    } else {
                        System.out.println("Contain unacceptable characteristics");
                        logNote.writeLog("Contain unacceptable characteristics - " + nameOfFile);
                    }
                } while (isName);
                fileNote.readNote();
                logNote.writeLog("Read file");
                break;
            case 4:
                System.out.println("Do you want to delay file?");
                isName = true;
                do {
                    System.out.print("Enter file name: ");
                    String nameOfFile;
                    nameOfFile = sc.next();
                    if (nameOfFile.indexOf('/') == -1) {
                        fileNote.setFileNote(nameOfFile);
                        isName = false;
                    } else {
                        System.out.println("Contain unacceptable characteristics");
                        logNote.writeLog("Contain unacceptable characteristics - " + nameOfFile);
                    }
                } while (isName);
                fileNote.deleteNote();
                break;
            case 5:
                System.out.println("Good buy,\n See you soon!");
                chooseMenu = false;
                sc.close();
                break;
            default:
                System.out.println( "Incorrect enter! \n Enter again!!");
        }
    }
    logNote.writeLog("Project1 stopped");



}
