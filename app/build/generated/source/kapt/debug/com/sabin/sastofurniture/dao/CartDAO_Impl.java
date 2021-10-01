package com.sabin.sastofurniture.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.sabin.sastofurniture.entity.CartModel;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CartDAO_Impl implements CartDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CartModel> __insertionAdapterOfCartModel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteProduct;

  public CartDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCartModel = new EntityInsertionAdapter<CartModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `CartModel` (`pid`,`_id`,`ProductName`,`Product_Price`,`CompanyRating`,`pimage`,`des`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CartModel value) {
        stmt.bindLong(1, value.getPid());
        if (value.get_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.get_id());
        }
        if (value.getProductName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProductName());
        }
        if (value.getProduct_Price() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getProduct_Price());
        }
        if (value.getCompanyRating() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCompanyRating());
        }
        if (value.getPimage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPimage());
        }
        if (value.getDes() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDes());
        }
      }
    };
    this.__preparedStmtOfDeleteProduct = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from CartModel";
        return _query;
      }
    };
  }

  @Override
  public Object insertProducts(final List<CartModel> list, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCartModel.insert(list);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteProduct(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteProduct.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteProduct.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Object GetAllFav(final Continuation<? super List<CartModel>> p0) {
    final String _sql = "Select * from CartModel";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<CartModel>>() {
      @Override
      public List<CartModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPid = CursorUtil.getColumnIndexOrThrow(_cursor, "pid");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductName");
          final int _cursorIndexOfProductPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "Product_Price");
          final int _cursorIndexOfCompanyRating = CursorUtil.getColumnIndexOrThrow(_cursor, "CompanyRating");
          final int _cursorIndexOfPimage = CursorUtil.getColumnIndexOrThrow(_cursor, "pimage");
          final int _cursorIndexOfDes = CursorUtil.getColumnIndexOrThrow(_cursor, "des");
          final List<CartModel> _result = new ArrayList<CartModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CartModel _item;
            final int _tmpPid;
            _tmpPid = _cursor.getInt(_cursorIndexOfPid);
            final String _tmp_id;
            _tmp_id = _cursor.getString(_cursorIndexOfId);
            final String _tmpProductName;
            _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
            final Integer _tmpProduct_Price;
            if (_cursor.isNull(_cursorIndexOfProductPrice)) {
              _tmpProduct_Price = null;
            } else {
              _tmpProduct_Price = _cursor.getInt(_cursorIndexOfProductPrice);
            }
            final String _tmpCompanyRating;
            _tmpCompanyRating = _cursor.getString(_cursorIndexOfCompanyRating);
            final String _tmpPimage;
            _tmpPimage = _cursor.getString(_cursorIndexOfPimage);
            final String _tmpDes;
            _tmpDes = _cursor.getString(_cursorIndexOfDes);
            _item = new CartModel(_tmpPid,_tmp_id,_tmpProductName,_tmpProduct_Price,_tmpCompanyRating,_tmpPimage,_tmpDes);
            _result.add(_item);
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
