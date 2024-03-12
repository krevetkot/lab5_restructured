package commands;

import exceptions.FailedBuildingException;
import exceptions.IllegalValueException;
import managers.CollectionManager;
import managers.Console;
import objects.Dragon;
import objects.forms.DragonForm;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Update extends Command{
    public Update(){
        super("update", "обновить значение элемента коллекции, id которого равен заданному", true);
    }

    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException, NumberFormatException, NoSuchElementException{
        if (CollectionManager.getCollection().isEmpty()){
            throw new NoSuchElementException("Коллекция пока что пуста");
        }

        long id = Long.parseLong(argument);
        Dragon oldDragon = CollectionManager.getById(id);

        if (oldDragon==null){
            throw new NoSuchElementException("Нет элемента с таким ID.");
        }

        int index = CollectionManager.getCollection().indexOf(oldDragon);
        int oldID = oldDragon.getId();

        try {
            Dragon changedDragon = new DragonForm().build(scanner, fileMode);
            changedDragon.setId(oldID);
            CollectionManager.getCollection().set(index, changedDragon);
            Console.print("Элемент с ID " + id + " обновлен", fileMode);
        } catch (FailedBuildingException e){
            Console.print(e.getMessage(), false);
        }


    }
}
