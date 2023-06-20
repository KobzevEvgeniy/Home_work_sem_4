package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> patronymic = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        System.out.println("Введите фио, возраст и пол, затем выберите действие:");
        System.out.println("Выберите действие: exit- выход ");
        Scanner scanner = new Scanner(System.in);
        Boolean run = true;
        int i = 0;
        while (run) {
            String str = scanner.nextLine();

            if (str.equals("exit")) {
                System.out.println("Отсортированный по возрасту список : ");
                break;
            }

            String[] fio = str.split(" ");
            index.add(i);
            surname.add(fio[0]);
            name.add(fio[1]);
            patronymic.add(fio[2]);
            age.add(Integer.parseInt(fio[3]));
            gender.add(fio[4]);

            i++;
        }
        ArrayList<Integer> temporary = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            temporary.add(age.get(j));

        }
        // Сортировка  по возрасту
        for (int j = 0; j < index.size() - 1; j++) {
            for (int k = 0; k < index.size() - 1 - j; k++) {
                if (temporary.get(k) > temporary.get(k + 1)) {

                    int temp = index.get(k);
                    index.set(k, index.get(k + 1));
                    index.set(k + 1, temp);
                    temp = temporary.get(k);
                    temporary.set(k, temporary.get(k + 1));
                    temporary.set(k + 1, temp);

                }
            }
        }
        for (int j = 0; j < index.size(); j++) {
            System.out.printf("%s %s. %s. %s %s \n", surname.get(index.get(j)), name.get(index.get(j)).charAt(0),
                    patronymic.get(index.get(j)).charAt(0), age.get(index.get(j)), gender.get(index.get(j)));
        }
        ArrayList<String> temporary2 = new ArrayList<>();
        for (int j = 0; j < index.size(); j++) {
            temporary2.add(gender.get(index.get(j)));
        }
        // Сортировка по полу
        for (int j = 0; j < index.size()-1 ; j++) {

            if (temporary2.get(j).contains("муж")&&temporary2.get(j+1).contains("жен")){
                int temp = index.get(j);
                index.set(j, index.get(j + 1));
                index.set(j + 1, temp);
                String temp2 = temporary2.get(j);
                temporary2.set(j, temporary2.get(j + 1));
                temporary2.set(j + 1, temp2);
            }
            else continue;
        }
        System.out.println("\n");
        for (int j = 0; j < index.size() ; j++) {
            System.out.printf("%s %s. %s. %s %s \n", surname.get(index.get(j)), name.get(index.get(j)).charAt(0),
                    patronymic.get(index.get(j)).charAt(0), age.get(index.get(j)), gender.get(index.get(j)));
        }


    }
}



