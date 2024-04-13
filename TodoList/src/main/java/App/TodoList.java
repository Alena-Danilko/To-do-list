package App;

import Methods.*;

import java.util.*;

public class TodoList {
    public static Map<String, Task> tasks = new LinkedHashMap<>();
    public static boolean appRunning = true;

    public void start(){
        System.out.println("To-do list app");
        while (TodoList.appRunning){
            showAvailableAction();
            int actionNumber = readAction();
            performAction(actionNumber);
        }
    }

    public void showAvailableAction(){
        System.out.println("1. Create task");
        System.out.println("2. Remove task");
        System.out.println("3. Edit task");
        System.out.println("4. Mark task as done");
        System.out.println("5. Display tasks");
        System.out.println("6. Sort tasks by date");
        System.out.println("7. Sort tasks by employee");
        System.out.println("8. Sort tasks by project");
        System.out.println("9. Save tasks to file");
        System.out.println("10. Read from file");
        System.out.println("11. Exit");
    }
    public int readAction(){
        List<Integer> availableAct = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        while(true){
            System.out.println("Choose action: ");
            Scanner sc = new Scanner(System.in);
            int actionNumber = sc.nextInt();
            if (availableAct.contains(actionNumber)){
                return actionNumber;
            } else {
                System.out.println("There is not such number. Please try again");
            }
        }
    }

    public void performAction(int actionNumber){
        Actions action;
        switch (actionNumber) {
            case Actions.CREATE_TASK -> {
                action = new CreateTask();
                action.actionsInfo();
                String command = action.readUserInput();
                if (!command.equals("0")) {
                    action.performAction(command);
                } else {
                    action.performAction(command);
                }
            }
            case Actions.REMOVE_TASK -> {
                if (!tasks.isEmpty()) {
                    action = new RemoveTask();
                    action.actionsInfo();
                    String command = action.readUserInput();
                    if (!command.equals("0")) {
                        action.performAction(command);
                    } else {
                        action.performAction(command);
                    }
                }
            }
            case Actions.EDIT_TASK -> {
                if (!tasks.isEmpty()) {
                    action = new EditTask();
                    action.actionsInfo();
                    String command = action.readUserInput();
                    if (!command.equals("0")) {
                        action.performAction(command);
                    } else {
                        action.performAction(command);
                    }
                }
            }
            case Actions.MARK_AS_DONE -> {
                if (!tasks.isEmpty()) {
                    action = new MarkAsDone();
                    action.actionsInfo();
                    String command = action.readUserInput();
                    if (!command.equals("0")) {
                        action.performAction(command);
                    } else {
                        action.performAction(command);
                    }
                }
            }
            case Actions.DISPLAY_TASKS -> {
                if(!tasks.isEmpty()){
                    action = new DisplayTasks();
                    action.actionsInfo();
                    action.performAction(null);
                }else {
                    System.out.println("To-do list is empty");
                }
            }
            case Actions.SORT_TASKS_BY_DATE -> {
                if(!tasks.isEmpty()){
                    action = new SortByDate();
                    action.performAction(null);
                }else {
                    System.out.println("To-do list is empty");
                }
            }
            case Actions.SORT_TASKS_BY_EMPLOYEE -> {
                if(!tasks.isEmpty()){
                    action = new SortByEmployee();
                    action.performAction(null);
                }else {
                    System.out.println("To-do list is empty");
                }
            }
            case Actions.SORT_TASKS_BY_PROJECT -> {
                if(!tasks.isEmpty()){
                    action = new SortByProject();
                    action.performAction(null);
                }else {
                    System.out.println("To-do list is empty");
                }
            }
            case Actions.SAVE_TASKS_TO_FILE -> {
                action = new Saving();
                action.actionsInfo();
                String command = action.readUserInput();
                if (!command.equals("0")) {
                    action.performAction(command);
                } else {
                    action.performAction(command);
                }

            }
            case Actions.READ_FROM_FILE -> {
                action = new Reading();
                action.actionsInfo();
                String command = action.readUserInput();
                if (!command.equals("0")) {
                    action.performAction(command);
                } else {
                    action.performAction(command);
                }
            }
            case Actions.EXIT -> {
                appRunning = false;
            }
        }
    }
}
