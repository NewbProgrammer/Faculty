package com.itstep.ppjava13v1.prepod.academy.UI.Impl;

import com.itstep.ppjava13v1.prepod.academy.UI.UserInterface;
import com.itstep.ppjava13v1.prepod.academy.db.entities.Person;
import com.itstep.ppjava13v1.prepod.academy.services.PersonService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

    Scanner scanner = new Scanner(System.in);
    PersonService personService;

    public ConsoleUserInterface(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run() {


        label:
        while (true) {
            System.out.println("Добро пожаловатьв БД академии");
            System.out.println("Выберите пункт меню");
            System.out.println("1. Создать запись о человеке");
            System.out.println("2. Просмотреть / изменить записи о людях");
            System.out.println("0. Выход из программы");
            String usersChoice = scanner.nextLine();
            switch (usersChoice) {
                case "1":
                    createPerson();
                    break;
                case "2":
                    showPersons();
                    break;
                case "0":
                    break label;
                default:
                    System.out.println("Ошибка ввода");
                    break;
            }
        }
    }

    private void showPersons() {
        List<Person> persons = personService.findAll();
        for (int i = 0; i < persons.size(); i++) {
            System.out.println((i+1) + ". " + persons.get(i).getName() + " " + persons.get(i).getBirthday()
                    + " " + persons.get(i).getPassport());
        }
    }

    private void createPerson() {
        //запросить имя, возраст, паспорт
        String name = "Vasya";
        Date birthday = new Date();
        String passport = "AE225544";
        personService.save(name, birthday, passport);
    }
}
