package commands;

import exceptions.IllegalValueException;
import managers.CollectionManager;
import managers.Console;

import java.util.Scanner;

public class Clear extends Command{
    public Clear(){
        super("clear", "очистить коллекцию", false);}
    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        if (CollectionManager.getCollection().isEmpty()){
            Console.print("Коллекция и так пуста.", fileMode);
        }
        else {
            CollectionManager.getCollection().clear();
            Console.print("Коллекция очищена.", fileMode);
        }
    }
}
