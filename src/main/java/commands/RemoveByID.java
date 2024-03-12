package commands;

import exceptions.IllegalValueException;
import managers.CollectionManager;
import objects.Dragon;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class RemoveByID extends Command{
    public RemoveByID(){
        super("remove_by_id", "удалить элемент из коллекции по его id", true);}

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException, NoSuchElementException, NumberFormatException{
        if (CollectionManager.getCollection().isEmpty()){
            throw new NoSuchElementException("Коллекция пока что пуста");
        }

        long id = Long.parseLong(argument);
        Dragon oldDragon = CollectionManager.getById(id);

        if (oldDragon==null){
            throw new NoSuchElementException("Нет элемента с таким ID.");
        }

        if (CollectionManager.getCollection().remove(oldDragon)){
            System.out.println("Элемент с ID " + id + " удален");
        }
        else {
            System.out.println("Элемент с ID " + id + " не удален");
        }

    }

}
