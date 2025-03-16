public class OutputPrinter {
    public void welcome(){
        printWithNewLine("Welcome to parking lot!");
    }
    public void end(){
        printWithNewLine("Thanks for using parking lot!");
    }
    public void notFound(){
        printWithNewLine("Not Found");
    }
    public void statusHeader(){
        printWithNewLine("Slot No.  License No. Colour");
    }
    public void parkingLotFull(){
        printWithNewLine("Sorry parking lot is Full");
    }
    public void parkingLotEmpty(){
        printWithNewLine("Sorry parking lot is empty");
    }
    public void invalidFile(){
        printWithNewLine("Sorry invalid file given");
    }
    public void printWithNewLine(final String msg) {
        System.out.println(msg);
    }
}
