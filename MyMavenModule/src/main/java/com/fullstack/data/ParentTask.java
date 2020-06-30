package com.fullstack.data;

import javax.persistence.*;
import java.util.List;

@Entity
public class ParentTask {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long parentTaskId;
    private String parentTask;

    @OneToMany
    private List<Task> taskList;

    public ParentTask() {
    }

    public ParentTask(String parentTask){
        this.parentTask=parentTask;
    }
    public Long getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(Long parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
