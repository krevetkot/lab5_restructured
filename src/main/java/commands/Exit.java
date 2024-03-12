package commands;

import exceptions.IllegalValueException;

import java.util.Scanner;

public class Exit extends Command{
    public Exit(){
        super("exit", "завершить программу (без сохранения в файл)", false);}

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        System.exit(0);
    }
}
