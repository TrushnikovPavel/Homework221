package Homework2;

import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test_storage {
    public static void main(String[] args) {
        //Для корректной работы, после команд используйте скобки (). Также не ставьте сразу 2 скобки(), сначала ставьте одну, какой-то товар, затем другую.
        //add (что-то) - добавление объекта на склад
        //remove (что-то) - удаление объектов со склада
        //contains (что-то) - проверка наличия объекта на складе
        //count () - количество объектов на складе
        //show () - сколько и каких объектов на складе
        //exit () - выход с консоли

        FixedArrayList<String> storage = new FixedArrayList<>(18);
        Scanner scanner = new Scanner(System.in);
        while (true){
            var inputString = scanner.nextLine();
            var params = inputString.split(" ");
            int startIndexObject = inputString.indexOf('(');
            int endIndexObject = inputString.indexOf(')');
            var object  = inputString.substring(startIndexObject + 1, endIndexObject);
            if (params[0].equals("add")){
                boolean wasAdded = storage.add(object);
                if (wasAdded){
                    System.out.println("" + object + " был добавлен");
                }
                else {
                    System.out.println("Склад заполнен");
                }
                continue;
            }
            if (params[0].equals("remove")){
                storage.removeAll(Collections.singleton(object));
                System.out.println("" + object + " был удалён");
                continue;
            }
            if (params[0].equals("contains")){
                if (storage.contains(object)){
                    System.out.println("" + object + " в наличии");
                }
                else {
                    System.out.println("" + object + " нет в наличии");
                }
                continue;
            }
            if (params[0].equals("count")){
                System.out.println(storage.size());
                continue;
            }
            if (params[0].equals("show")){
                System.out.println(storage.stream()
                        .collect(Collectors.groupingBy(Objects::toString, Collectors.counting() )));
                continue;
            }
            if (params[0].equals("exit")){
            return;
            }

        }
    }
}
