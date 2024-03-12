package commands;


import exceptions.IllegalValueException;
import lombok.Getter;

import java.util.Scanner;

@Getter
public abstract class Command {
    protected String name = ""; //название команды
    protected String description = ""; //описание команды
    protected boolean args; //колво аргументов

    public Command(String name, String description, boolean args){
        this.name = name;
        this.description = description;
        this.args = args;
    }

    public Command(){}

    public abstract void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException;
}
