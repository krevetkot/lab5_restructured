package exceptions;

import commands.Command;

public class IncorrectCommand extends Exception{
    private String command;

    public IncorrectCommand(String message, String command) {
        super("Проблема с командой " + command + ": " + message );
        this.command = command;
    }
}
