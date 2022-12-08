package com.taskmastermdt.database;

import androidx.room.TypeConverter;

import java.util.Date;

public class TaskmasterMDTDatabaseConverters {
    @TypeConverter
    public static Date fromTimeStamp(Long dateValue){
        return dateValue == null ? null : new Date(dateValue);
    }

    @TypeConverter
    public static Long dateToTimeStamp(Date date){
        return date == null ? null : date.getTime();
    }
}
