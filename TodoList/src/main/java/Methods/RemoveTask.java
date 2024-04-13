package Methods;

import App.Task;
import App.TodoList;

import java.util.Scanner;

public class RemoveTask extends Actions{
    @Override
    public void actionsInfo() {
        System.out.println("To remove a task, enter title and press Enter");
        System.out.println("Enter 0 to return to main menu");
    }

    @Override
    public String readUserInput() {
        while(true){
            System.out.println("Enter title: ");
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            if(userInput != null){
                Task task = TodoList.tasks.get(userInput);
                if (task != null){
                    return userInput;
                } else {
                    System.out.println("There isn't such title, try another one");
                }
            } else {
                return userInput;
            }
        }
    }

    @Override
    public void performAction(String command) {
        TodoList.tasks.remove(command);
        System.out.println("Task successfully removed");
    }
}
