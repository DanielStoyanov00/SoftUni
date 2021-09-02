package _03StudentSystem;

import static _03StudentSystem.Printer.printLine;

public class StudentSystem {
    private CommandHandler handler;
    private boolean isWorking;

    public StudentSystem() {
        this.handler = new CommandHandler();
    }

    public void start() {
        this.isWorking = true;
        while (isWorking) {
            String result = handler.handleCommand(Reader.readArray("\\s+"));

            if (result != null && !result.equals("Exit")){
                printLine(result);
            }
            isWorking = !"Exit".equals(result);
        }
    }
}
