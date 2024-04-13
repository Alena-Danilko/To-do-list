package App;

import java.time.LocalDate;


public class Task {
    private String employee;
    private String title;
    private LocalDate deadline;

    private String status;
    private String projectName;

    public String getEmployee() {
        return employee;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Task (String employee, String title, LocalDate deadline, String status, String projectName){
        setEmployee(employee);
        setTitle(title);
        setDeadline(deadline);
        setStatus(status);
        setProjectName(projectName);
    }

    @Override
    public String toString() {
        return "Employee = " + employee + " , task title = " + title + " , deadline = " + deadline + ", task status = " + status +
                ", project name = "+ projectName;
    }
}