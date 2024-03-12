package commands;

import exceptions.IllegalValueException;
import managers.CollectionManager;

import java.util.Collections;
import java.util.Scanner;

public class Reorder extends Command{
    public Reorder(){
        super("reorder", "отсортировать коллекцию в порядке, обратном нынешнему", false);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        Collections.reverse(CollectionManager.getCollection());
        System.out.println("Коллекция отсортирована в обратном порядке.");
    }


}
