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

public class InsertAt extends Command{
    public InsertAt(){
        super("insert_at", "добавить новый элемент в заданную позицию", true);
    }
    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner)
            throws NoSuchElementException, NumberFormatException, IllegalValueException{

        if (CollectionManager.getCollection().isEmpty()){
            throw new NoSuchElementException("Коллекция пока что пуста");
        }

        int index = Integer.parseInt(argument);

        if (index>CollectionManager.getCollection().size()){
            throw new NoSuchElementException("Индекс должен быть меньше или равен размеру коллекции. Размер = "
                    + CollectionManager.getCollection().size());
        }

        if (index<0){
            throw new NoSuchElementException("Агрумент index должен быть больше или равен нулю.");
        }

        DragonForm newDragon = new DragonForm();
        try {
            Dragon buildedDragon = newDragon.build(scanner, fileMode);
            if (!CollectionManager.getCollection().contains(buildedDragon)){
                CollectionManager.getCollection().add(buildedDragon);
                Console.print("Спасибо, ваши данные приняты!", fileMode);
            }
            else {
                Console.print("Такой дракон уже есть в коллекции.", false);
            }
        } catch (FailedBuildingException e){
            Console.print(e.getMessage(), false);
        }

    }

}
