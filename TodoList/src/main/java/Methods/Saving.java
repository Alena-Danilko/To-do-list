package Methods;

import App.Task;
import App.TodoList;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Saving extends Actions{
    @Override
    public void actionsInfo() {
        System.out.println("To read a file, please follow instructions and press Enter");
        System.out.println("Enter 0 to return to main menu");
    }

    @Override
    public String readUserInput() {
        System.out.println("path: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        return path;
    }

    @Override
    public void performAction(String command) {
        try {
            FileOutputStream fos = new FileOutputStream(command);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            List<Map.Entry<String, Task>> sorting = new ArrayList<>(TodoList.tasks.entrySet());
            for (Map.Entry<String, Task> stringTaskEntry : sorting) {
                oos.writeObject(stringTaskEntry);
            }
            oos.close();
            System.out.println("Tasks have been saved");
        } catch (IOException e) {
            System.out.println("Such file doesn't exist");
        }

    }
}
