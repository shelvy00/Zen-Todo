package org.zenmanager.ZenTasks.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Task extends AbstractEntity {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 25, message = "Name must be between 3 and 25 characters")
    private String name;

    @Size(max = 500, message = "Description cannot be longer than 500 characters")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private TaskProgress taskProgressEnum = TaskProgress.TODO;

    @ManyToOne
    private User user;

    public Task(String name, String description, LocalDate startDate, LocalDate dueDate) {
        super();
        this.name = name;
        this.description = description;
        this.taskProgressEnum = TaskProgress.TODO;
    }

    public Task() {
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user){
        this.user = user;
    }

    public String getName () {
        return name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description){
        this.description = description;
    }

    public TaskProgress getTaskProgress () {
        return taskProgressEnum;
    }

    public void setTaskProgressEnum (TaskProgress taskProgressEnum){
        this.taskProgressEnum = taskProgressEnum;
    }


    @Override
    public String toString () {
        return name;
    }

    public LocalDate getStartDate () {
        return startDate;
    }

    public void setStartDate (LocalDate startDate){
        this.startDate = startDate;
    }

    public LocalDate getDueDate () {
        return dueDate;
    }

    public void setDueDate (LocalDate dueDate){
        this.dueDate = dueDate;
    }

}
