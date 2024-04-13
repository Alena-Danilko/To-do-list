package Methods;

import App.Task;
import App.TodoList;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Reading extends Actions{
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
            Scanner sc = new Scanner(new File(command));
            while(sc.hasNextLine()){
                String file = sc.nextLine();
                String[] splitFile = file.split(",");
                LocalDate date = LocalDate.from(LocalDateTime.parse(splitFile[2]));
                Task task = new Task(splitFile[0], splitFile[1], date, splitFile[3], splitFile[4]);
                TodoList.tasks.put(task.getTitle(), task);
            }
            sc.close();
            System.out.println("Tasks have been read");
        } catch (FileNotFoundException e) {
            System.out.println("Such file doesn't exist");
        }
    }
}
