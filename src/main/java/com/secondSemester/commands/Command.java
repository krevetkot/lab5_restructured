package com.secondSemester.commands;


import com.secondSemester.exceptions.IllegalValueException;
import lombok.Getter;

import java.util.Scanner;

/**
 * Абстрактный класс команды.
 *
 * @author Kseniya
 */
@Getter
public abstract class Command {
    /**
     * Название команды
     */
    protected String name = "";
    /**
     * Описание команды
     */
    protected String description = "";
    /**
     * Есть ли аргументы
     */
    protected boolean args;

    /**
     * Конструктор со всеми параметрами.
     *
     * @param name        - название
     * @param description - описание
     * @param args        - есть ли аргументы
     */
    public Command(String name, String description, boolean args) {
        this.name = name;
        this.description = description;
        this.args = args;
    }

    /**
     * Выполнение команды.
     *
     * @throws IllegalValueException - при недопустимом аргументе
     */
    public abstract void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException;
}
