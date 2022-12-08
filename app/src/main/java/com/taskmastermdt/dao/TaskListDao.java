package com.taskmastermdt.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.taskmastermdt.models.TaskList;

import java.util.List;

@Dao
public interface TaskListDao {

    @Insert
    public void insertTask(TaskList taskList);

    //Find all
    @Query("SELECT * FROM TaskList")
    public List<TaskList> findAll();

    //Find by Id
    @Query("SELECT * FROM TaskList WHERE id = :id")
    public TaskList findById(long id);

    //Find all by status
    @Query("SELECT * FROM TaskList WHERE status = :status")
    public List<TaskList> findAllByStatus(TaskList.TaskListStatusTypeEnum status);

    @Delete
    public void delete(TaskList taskList);

    @Update
    public void update(TaskList taskList);
}
