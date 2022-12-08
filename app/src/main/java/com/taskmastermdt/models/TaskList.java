package com.taskmastermdt.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class TaskList {
    @PrimaryKey(autoGenerate = true)
    public Long id;

    private String name;
    private String body;

    private TaskListStatusTypeEnum status;
    private java.util.Date dateCreated;
    private Integer difficulty;

    public TaskList(String name, String body, TaskListStatusTypeEnum status, Date dateCreated, Integer difficulty) {
        this.name = name;
        this.body = body;
        this.status = status;
        this.dateCreated = dateCreated;
        this.difficulty = difficulty;
    }

    public TaskList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public TaskListStatusTypeEnum getStatus() {
        return status;
    }

    public void setStatus(TaskListStatusTypeEnum status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    //    public TaskList(String name, String body, String state) {
//        this.name = name;
//        this.body = body;
//        this.state = state;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }

    public enum TaskListStatusTypeEnum {
        NEW("New"),
        INPROGRESS("In Progress"),
        COMPLETE("Complete");

        private final String taskListStatusType;

        TaskListStatusTypeEnum(String taskListStatusType) {
            this.taskListStatusType = taskListStatusType;
        }

        public String getTaskListStatusType() {
            return taskListStatusType;
        }

        public static TaskListStatusTypeEnum fromString(String possibleTaskListStatusType) {
            for (TaskListStatusTypeEnum status : TaskListStatusTypeEnum.values()
            ) {
                if (status.taskListStatusType.equals(possibleTaskListStatusType)) {
                    return status;
                }
            }
            return null;
        }

        @NonNull
        @Override
        public String toString() {
            if (taskListStatusType == null) {
                return "";
            }
            return taskListStatusType;
        }
    }
}
