package Methods;

import App.Task;
import App.TodoList;

import java.time.LocalDate;
import java.util.*;

public class SortByDate extends Actions{
    @Override
    public void actionsInfo()  {
        throw new UnsupportedOperationException("This operation is not available");
    }

    @Override
    public String readUserInput() {
            throw new UnsupportedOperationException("This operation is not available");
    }

    @Override
    public void performAction(String command) {
        List<Map.Entry<String, Task>> sorting = new ArrayList<>(TodoList.tasks.entrySet());
        Collections.sort(sorting, new Comparator<Map.Entry<String, Task>>() {
            @Override
            public int compare(Map.Entry<String, Task> o1, Map.Entry<String, Task> o2) {
                LocalDate ld1 = o1.getValue().getDeadline();
                LocalDate ld2 = o2.getValue().getDeadline();
                int result =  ld1.compareTo(ld2);
                return result;
            }
        });
        TodoList.tasks.clear();
        sorting.forEach((field) -> {
            TodoList.tasks.put(field.getKey(), field.getValue());
        });
        System.out.println("The list successfully sorted by data");
    }
}
