package com.fullstack;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullstack.data.ParentTask;
import com.fullstack.data.Project;
import com.fullstack.data.Task;
import com.fullstack.data.User;
import org.hibernate.cache.spi.access.CachedDomainDataAccess;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MockData {

    public static void main (String[] args) {

        User user1 = new User("Adish", "Gangwal", "1");
        User user2 = new User("Priyanka", "Luhadiya", "2");
        User user3 = new User("Priyanshu", "Gangwal", "3");

        List userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        Project project1 = new Project("Project Name 1", new Date(), new Date(), 1);
        Project project2 = new Project("Project Name 2", new Date(), new Date(), 1);
        Project project3 = new Project("Project Name 3", new Date(), new Date(), 1);

        Task task1 = new Task("Task Name 1", new Date(), new Date(), 1, "New");
        Task task2 = new Task("Task Name 2", new Date(), new Date(), 1, "New");
        Task task3 = new Task("Task Name 3", new Date(), new Date(), 1, "New");


        ParentTask parentTask1 = new ParentTask("Parent Task 1");
        ParentTask parentTask2 = new ParentTask("Parent Task 2");

        user1.setProjectList(new ArrayList<Project>( Arrays.asList(project1,project2)));
        user2.setProjectList(new ArrayList<Project>( Arrays.asList(project3)));

        project1.setTaskList(new ArrayList<Task>( Arrays.asList(task1)));
        project2.setTaskList(new ArrayList<Task>( Arrays.asList(task2)));
        project3.setTaskList(new ArrayList<Task>( Arrays.asList(task3)));

        task1.setParentTask(parentTask1);
        task2.setParentTask(parentTask2);
        //task1.setUser(user1);
       // task1.setProject(project1);


        ObjectMapper mapper = new ObjectMapper();

        try {
            //mapper.writeValue(new File("c:\\Users\\ag_ga\\user1.json"), user1);
            String jsonString = mapper.writeValueAsString(userList);

            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
