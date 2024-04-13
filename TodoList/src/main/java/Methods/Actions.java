package Methods;

public abstract class Actions {

    public static final int CREATE_TASK = 1;
    public static final int REMOVE_TASK = 2;
    public static final int EDIT_TASK = 3;
    public static final int MARK_AS_DONE = 4;
    public static final int DISPLAY_TASKS = 5;
    public static final int SORT_TASKS_BY_DATE = 6;
    public static final int SORT_TASKS_BY_EMPLOYEE = 7;
    public static final int SORT_TASKS_BY_PROJECT = 8;
    public static final int SAVE_TASKS_TO_FILE = 9;
    public static final int READ_FROM_FILE = 10;
    public static final int EXIT = 11;

    public abstract void actionsInfo();
    public abstract String readUserInput();
    public abstract void performAction(String command);
}
