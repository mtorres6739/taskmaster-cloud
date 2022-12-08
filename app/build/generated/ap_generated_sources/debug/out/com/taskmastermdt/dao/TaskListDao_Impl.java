package com.taskmastermdt.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.taskmastermdt.database.TaskmasterMDTDatabaseConverters;
import com.taskmastermdt.models.TaskList;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TaskListDao_Impl implements TaskListDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TaskList> __insertionAdapterOfTaskList;

  private final EntityDeletionOrUpdateAdapter<TaskList> __deletionAdapterOfTaskList;

  private final EntityDeletionOrUpdateAdapter<TaskList> __updateAdapterOfTaskList;

  public TaskListDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTaskList = new EntityInsertionAdapter<TaskList>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TaskList` (`id`,`name`,`body`,`status`,`dateCreated`,`difficulty`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaskList value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getBody() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBody());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, __TaskListStatusTypeEnum_enumToString(value.getStatus()));
        }
        final Long _tmp = TaskmasterMDTDatabaseConverters.dateToTimeStamp(value.getDateCreated());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        if (value.getDifficulty() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getDifficulty());
        }
      }
    };
    this.__deletionAdapterOfTaskList = new EntityDeletionOrUpdateAdapter<TaskList>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `TaskList` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaskList value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
      }
    };
    this.__updateAdapterOfTaskList = new EntityDeletionOrUpdateAdapter<TaskList>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TaskList` SET `id` = ?,`name` = ?,`body` = ?,`status` = ?,`dateCreated` = ?,`difficulty` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TaskList value) {
        if (value.id == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.id);
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getBody() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBody());
        }
        if (value.getStatus() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, __TaskListStatusTypeEnum_enumToString(value.getStatus()));
        }
        final Long _tmp = TaskmasterMDTDatabaseConverters.dateToTimeStamp(value.getDateCreated());
        if (_tmp == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, _tmp);
        }
        if (value.getDifficulty() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getDifficulty());
        }
        if (value.id == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.id);
        }
      }
    };
  }

  @Override
  public void insertTask(final TaskList taskList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTaskList.insert(taskList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final TaskList taskList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTaskList.handle(taskList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final TaskList taskList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTaskList.handle(taskList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<TaskList> findAll() {
    final String _sql = "SELECT * FROM TaskList";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
      final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
      final List<TaskList> _result = new ArrayList<TaskList>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TaskList _item;
        _item = new TaskList();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getLong(_cursorIndexOfId);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpBody;
        if (_cursor.isNull(_cursorIndexOfBody)) {
          _tmpBody = null;
        } else {
          _tmpBody = _cursor.getString(_cursorIndexOfBody);
        }
        _item.setBody(_tmpBody);
        final TaskList.TaskListStatusTypeEnum _tmpStatus;
        _tmpStatus = __TaskListStatusTypeEnum_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
        _item.setStatus(_tmpStatus);
        final Date _tmpDateCreated;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDateCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDateCreated);
        }
        _tmpDateCreated = TaskmasterMDTDatabaseConverters.fromTimeStamp(_tmp);
        _item.setDateCreated(_tmpDateCreated);
        final Integer _tmpDifficulty;
        if (_cursor.isNull(_cursorIndexOfDifficulty)) {
          _tmpDifficulty = null;
        } else {
          _tmpDifficulty = _cursor.getInt(_cursorIndexOfDifficulty);
        }
        _item.setDifficulty(_tmpDifficulty);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public TaskList findById(final long id) {
    final String _sql = "SELECT * FROM TaskList WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
      final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
      final TaskList _result;
      if(_cursor.moveToFirst()) {
        _result = new TaskList();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _result.id = null;
        } else {
          _result.id = _cursor.getLong(_cursorIndexOfId);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpBody;
        if (_cursor.isNull(_cursorIndexOfBody)) {
          _tmpBody = null;
        } else {
          _tmpBody = _cursor.getString(_cursorIndexOfBody);
        }
        _result.setBody(_tmpBody);
        final TaskList.TaskListStatusTypeEnum _tmpStatus;
        _tmpStatus = __TaskListStatusTypeEnum_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
        _result.setStatus(_tmpStatus);
        final Date _tmpDateCreated;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDateCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDateCreated);
        }
        _tmpDateCreated = TaskmasterMDTDatabaseConverters.fromTimeStamp(_tmp);
        _result.setDateCreated(_tmpDateCreated);
        final Integer _tmpDifficulty;
        if (_cursor.isNull(_cursorIndexOfDifficulty)) {
          _tmpDifficulty = null;
        } else {
          _tmpDifficulty = _cursor.getInt(_cursorIndexOfDifficulty);
        }
        _result.setDifficulty(_tmpDifficulty);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TaskList> findAllByStatus(final TaskList.TaskListStatusTypeEnum status) {
    final String _sql = "SELECT * FROM TaskList WHERE status = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, __TaskListStatusTypeEnum_enumToString(status));
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfBody = CursorUtil.getColumnIndexOrThrow(_cursor, "body");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreated");
      final int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
      final List<TaskList> _result = new ArrayList<TaskList>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TaskList _item;
        _item = new TaskList();
        if (_cursor.isNull(_cursorIndexOfId)) {
          _item.id = null;
        } else {
          _item.id = _cursor.getLong(_cursorIndexOfId);
        }
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpBody;
        if (_cursor.isNull(_cursorIndexOfBody)) {
          _tmpBody = null;
        } else {
          _tmpBody = _cursor.getString(_cursorIndexOfBody);
        }
        _item.setBody(_tmpBody);
        final TaskList.TaskListStatusTypeEnum _tmpStatus;
        _tmpStatus = __TaskListStatusTypeEnum_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
        _item.setStatus(_tmpStatus);
        final Date _tmpDateCreated;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfDateCreated)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfDateCreated);
        }
        _tmpDateCreated = TaskmasterMDTDatabaseConverters.fromTimeStamp(_tmp);
        _item.setDateCreated(_tmpDateCreated);
        final Integer _tmpDifficulty;
        if (_cursor.isNull(_cursorIndexOfDifficulty)) {
          _tmpDifficulty = null;
        } else {
          _tmpDifficulty = _cursor.getInt(_cursorIndexOfDifficulty);
        }
        _item.setDifficulty(_tmpDifficulty);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __TaskListStatusTypeEnum_enumToString(
      final TaskList.TaskListStatusTypeEnum _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case NEW: return "NEW";
      case INPROGRESS: return "INPROGRESS";
      case COMPLETE: return "COMPLETE";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private TaskList.TaskListStatusTypeEnum __TaskListStatusTypeEnum_stringToEnum(
      final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "NEW": return TaskList.TaskListStatusTypeEnum.NEW;
      case "INPROGRESS": return TaskList.TaskListStatusTypeEnum.INPROGRESS;
      case "COMPLETE": return TaskList.TaskListStatusTypeEnum.COMPLETE;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
