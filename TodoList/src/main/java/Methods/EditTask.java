package Methods;

import App.Task;
import App.TodoList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EditTask extends Actions{
    @Override
    public void actionsInfo() {
        System.out.println("To update a new task, please follow instructions and press Enter");
        System.out.println("Employee name, Task title, Deadline (format dd-mm-yyyy), Task status, Project name");
        System.out.println("Be sure to write the title name. If a field doesn't need to be changed, use - ");
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
                    } else {
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
        if(!info[0].equals("-")){
            TodoList.tasks.get(info[0]).setEmployee(info[0]);
        }
        if(!info[2].equals("-")){
            TodoList.tasks.get(info[2]).setDeadline(parsedDate);
        }
        if(!info[3].equals("-")){
            TodoList.tasks.get(info[3]).setStatus(info[3]);
        }
        if(!info[4].equals("-")){
            TodoList.tasks.get(info[4]).setProjectName(info[4]);
        }

        System.out.println("Task successfully applied");
    }
}
