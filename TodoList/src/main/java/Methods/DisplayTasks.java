package Methods;

import App.TodoList;

public class DisplayTasks extends Actions{
    @Override
    public void actionsInfo() {
        System.out.println("The list of tasks: ");
    }

    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("This operation is not available");
    }

    @Override
    public void performAction(String command) {
        TodoList.tasks.forEach((key, task) -> {
            System.out.println("ID = " + task.getEmployee() + " , task title = " + key + " , deadline = " + task.getDeadline()
                    + ", task status = " + task.getStatus() + ", project name = "+ task.getProjectName());
        });
    }
}
