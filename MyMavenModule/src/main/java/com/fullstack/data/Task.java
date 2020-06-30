package com.fullstack.data;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long taskId;
    private String task;
    private Date startDate;
    private Date endDate;
    private int priority;
    private String status;
    private boolean isParent;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    public Task() {
    }

    public Task(String taskName, Date startDate, Date endDate, int priority, String status) {
        this.task = taskName;
        this.startDate = startDate;
        this.endDate=endDate;
        this.priority=priority;
        this.status=status;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public ParentTask getParentTask() {
        return parentTask;
    }

    public void setParentTask(ParentTask parentTask) {
        this.parentTask = parentTask;
    }

    @ManyToOne
    @JoinColumn(name = "parentTaskId")
    private ParentTask parentTask;


    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }
}
