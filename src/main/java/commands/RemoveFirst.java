package commands;

import exceptions.IllegalValueException;
import managers.CollectionManager;

import java.util.Scanner;

/**
 * Команда remove_first: удаляет удалить первый элемент из коллекции.
 *
 * @author Kseniya
 */
public class RemoveFirst extends Command {
    public RemoveFirst() {
        super("remove_first", "удалить первый элемент из коллекции", false);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        if (CollectionManager.getCollection().isEmpty()) {
            System.out.println("Коллекция пуста.");
        } else {
            CollectionManager.getCollection().remove(0);
            System.out.println("Первый элемент в коллекции удален.");
        }
    }
}
