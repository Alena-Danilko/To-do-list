package Methods;

import App.Task;
import App.TodoList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CreateTask extends Actions{
    @Override
    public void actionsInfo() {
        System.out.println("To add a new task, please follow instructions and press Enter");
        System.out.println("Employee name, Task title, Deadline (format dd-mm-yyyy), Task status, Project name");
        System.out.println("Enter 0 to return to main menu");
    }

    @Override
    public String readUserInput() {
        while (true){
            System.out.println("Write the required information on one line separated by commas");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if (!userInput.equals("0")) {
                String[] info = userInput.split(",");
                if (info.length == 5) {
                    if (info[2].length() == 10){
                        return userInput;
                    }
                    else {
                        System.out.println("The date is invalid, try again: ");
                    }
                } else {
                    System.out.println("Please follow instructions, try again: ");
                }
            } else {
                return userInput;
            }
        }

    }

    @Override
    public void performAction(String command) {
        String[] info =command.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(info[2], formatter);
        Task task = new Task(info[0], info[1], parsedDate, info[3], info[4]);
        TodoList.tasks.put(task.getTitle(), task);
        System.out.println("Task successfully added");
    }

}
