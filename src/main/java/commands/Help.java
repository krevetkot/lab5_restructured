package commands;

import exceptions.IllegalValueException;
import managers.CommandManager;

import java.util.Collection;
import java.util.Scanner;

public class Help extends Command {
    private CommandManager commandManager;

    public Help(CommandManager commandManager){
        super("help", "вывести справку по доступным командам", false);
        this.commandManager = commandManager;
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        Collection<Command> commands = commandManager.getCommandMap().values();
            System.out.println("Доступны команды:");
            for (Command command : commands) {
                System.out.println(command.getName() + ": " + command.getDescription());
            }
    }
}
