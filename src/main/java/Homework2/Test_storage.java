package Homework2;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Test_storage {
    public static void main(String[] args) throws IOException {
        //Для корректной работы, после команд используйте скобки (). Также не ставьте сразу 2 скобки(), сначала ставьте одну, какой-то товар, затем другую.
        //add (что-то) - добавление объекта на склад
        //remove (что-то) - удаление объектов со склада
        //contains (что-то) - проверка наличия объекта на складе
        //count () - количество объектов на складе
        //show () - сколько и каких объектов на складе
        //export () - выгрузка добавленных объектов в Учётка.xls файл в папке проекта
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
            };
            int i = 0;

            if (params[0].equals("export")) {
                Workbook book = new HSSFWorkbook();
                Sheet sheet = book.createSheet("Warehouse contents");
                while (i < storage.size()) {
                    Row row1 = sheet.createRow((short) i);
                    row1.createCell((short) 0).setCellValue(storage.get(i));
                    i++;
            }
                book.write(new FileOutputStream("Учётка.xls"));
                book.close();

                continue;
            }
            if (params[0].equals("exit")){
            return;
            }

        }
    }
}
