package commands;

import exceptions.IllegalValueException;
import managers.*;

import java.util.Scanner;

public class Info extends Command {

    public Info(){
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", false);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пока что пуста. Тип коллекции: " + CollectionManager.getCollection().getClass());
        }
        else {
            System.out.println("Тип коллекции: " + CollectionManager.getCollection().getClass());
            System.out.println("Количество элементов: " + CollectionManager.getCollection().size());
            System.out.println("Дата инициализации: " + CollectionManager.getCollection().getFirst().getCreationDate());
        }
    }
}
