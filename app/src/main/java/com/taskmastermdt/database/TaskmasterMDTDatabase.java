package com.taskmastermdt.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.taskmastermdt.dao.TaskListDao;
import com.taskmastermdt.models.TaskList;

@TypeConverters({TaskmasterMDTDatabaseConverters.class})
@Database(entities = {TaskList.class}, version = 1)
public abstract class TaskmasterMDTDatabase extends RoomDatabase {
    public abstract TaskListDao taskListDao();
}
