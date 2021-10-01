package com.sabin.sastofurniture.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sabin.sastofurniture.entity.Customer;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CustomerDAO_Impl implements CustomerDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Customer> __insertionAdapterOfCustomer;

  private final EntityDeletionOrUpdateAdapter<Customer> __deletionAdapterOfCustomer;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCustomers;

  public CustomerDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomer = new EntityInsertionAdapter<Customer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Customer` (`_id`,`fullname`,`email`,`password`,`mobileno`,`pimage`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Customer value) {
        if (value.get_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.get_id());
        }
        if (value.getFullname() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFullname());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmail());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPassword());
        }
        if (value.getMobileno() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMobileno());
        }
        if (value.getPimage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPimage());
        }
      }
    };
    this.__deletionAdapterOfCustomer = new EntityDeletionOrUpdateAdapter<Customer>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Customer` WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Customer value) {
        if (value.get_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.get_id());
        }
      }
    };
    this.__preparedStmtOfDeleteCustomers = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from `Customer`";
        return _query;
      }
    };
  }

  @Override
  public Object registerCustomer(final Customer customer, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCustomer.insert(customer);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteCustomer(final Customer customer, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCustomer.handle(customer);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteCustomers(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCustomers.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteCustomers.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Object checkuser(final String email, final String password,
      final Continuation<? super Customer> p2) {
    final String _sql = "select * from Customer where email=(?) and password=(?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, email);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<Customer>() {
      @Override
      public Customer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfFullname = CursorUtil.getColumnIndexOrThrow(_cursor, "fullname");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfMobileno = CursorUtil.getColumnIndexOrThrow(_cursor, "mobileno");
          final int _cursorIndexOfPimage = CursorUtil.getColumnIndexOrThrow(_cursor, "pimage");
          final Customer _result;
          if(_cursor.moveToFirst()) {
            final String _tmp_id;
            _tmp_id = _cursor.getString(_cursorIndexOfId);
            final String _tmpFullname;
            _tmpFullname = _cursor.getString(_cursorIndexOfFullname);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPassword;
            _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            final String _tmpMobileno;
            _tmpMobileno = _cursor.getString(_cursorIndexOfMobileno);
            final String _tmpPimage;
            _tmpPimage = _cursor.getString(_cursorIndexOfPimage);
            _result = new Customer(_tmp_id,_tmpFullname,_tmpEmail,_tmpPassword,_tmpMobileno,_tmpPimage);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p2);
  }

  @Override
  public Object getUser(final Continuation<? super Customer> p0) {
    final String _sql = "Select * from Customer";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<Customer>() {
      @Override
      public Customer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfFullname = CursorUtil.getColumnIndexOrThrow(_cursor, "fullname");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfMobileno = CursorUtil.getColumnIndexOrThrow(_cursor, "mobileno");
          final int _cursorIndexOfPimage = CursorUtil.getColumnIndexOrThrow(_cursor, "pimage");
          final Customer _result;
          if(_cursor.moveToFirst()) {
            final String _tmp_id;
            _tmp_id = _cursor.getString(_cursorIndexOfId);
            final String _tmpFullname;
            _tmpFullname = _cursor.getString(_cursorIndexOfFullname);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final String _tmpPassword;
            _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            final String _tmpMobileno;
            _tmpMobileno = _cursor.getString(_cursorIndexOfMobileno);
            final String _tmpPimage;
            _tmpPimage = _cursor.getString(_cursorIndexOfPimage);
            _result = new Customer(_tmp_id,_tmpFullname,_tmpEmail,_tmpPassword,_tmpMobileno,_tmpPimage);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}
