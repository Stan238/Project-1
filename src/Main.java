//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Log logNote = new Log();
    logNote.writeLog("Project1 run");
    boolean chooseMenu = true;
    while ( chooseMenu) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Menu:\s
                 1. Write to file
                 2. Read file
                 3. Exit""");
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
                /* get name file
                 * check file is exist
                 * create file / open file
                 * get some note throw user's input
                 * close file*/

                Note fileNote = new Note();

                boolean isName = true;
                do {
                    System.out.print("Enter file name: ");
                    String nameOfFile;
                    nameOfFile = sc.next();
                    if (nameOfFile.indexOf('/') == -1) {
                        File name = new File(nameOfFile);
                        fileNote.setFileNote(name);
                        isName = false;
                    } else {
                        System.out.println("Contain unacceptable characteristics");
                        logNote.writeLog("Contain unacceptable characteristics - " + nameOfFile);
//                        sc.hasNext();
                    }
                } while (isName);
                fileNote.writeToNote();
                logNote.writeLog("Write to file");
                break;
            case 2:
                logNote.writeLog("Read file");
                break;
            case 3:
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
