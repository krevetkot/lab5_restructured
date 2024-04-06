package com.secondSemester;

import com.secondSemester.exceptions.FailedBuildingException;
import jakarta.xml.bind.JAXBException;
import com.secondSemester.managers.CollectionManager;
import com.secondSemester.managers.RuntimeManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Вы не указали имя файла. Запуск невозможен.");
            System.exit(1);
        }
        String filename = args[0];

        try {
            CollectionManager.loadCollection(filename);

            RuntimeManager.launch();
        } catch (IOException | FailedBuildingException e) {
            System.out.println(e.getMessage());
            System.out.println("Не удалось загрузить коллекцию.");
            System.exit(1);
        } catch (JAXBException e) {
            System.out.println("Файл поврежден. Не удалось загрузить коллекцию.");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Не удалось загрузить коллекцию.");
            System.exit(1);
        }


    }
}
