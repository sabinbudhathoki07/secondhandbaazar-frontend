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
import com.sabin.sastofurniture.entity.Product;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ProductDAO_Impl implements ProductDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Product> __insertionAdapterOfProduct;

  private final EntityDeletionOrUpdateAdapter<Product> __deletionAdapterOfProduct;

  private final SharedSQLiteStatement __preparedStmtOfDeleteProduct;

  public ProductDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProduct = new EntityInsertionAdapter<Product>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Product` (`_id`,`ProductName`,`Product_Price`,`CompanyRating`,`pimage`,`des`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Product value) {
        if (value.get_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.get_id());
        }
        if (value.getProductName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductName());
        }
        if (value.getProduct_Price() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getProduct_Price());
        }
        if (value.getCompanyRating() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCompanyRating());
        }
        if (value.getPimage() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPimage());
        }
        if (value.getDes() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDes());
        }
      }
    };
    this.__deletionAdapterOfProduct = new EntityDeletionOrUpdateAdapter<Product>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Product` WHERE `_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Product value) {
        if (value.get_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.get_id());
        }
      }
    };
    this.__preparedStmtOfDeleteProduct = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from `product`";
        return _query;
      }
    };
  }

  @Override
  public Object insertProducts(final List<Product> product, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProduct.insert(product);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object registerProduct(final Product product, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfProduct.insert(product);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteProduct(final Product product, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfProduct.handle(product);
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
  public Object getProduct(final Continuation<? super Product> p0) {
    final String _sql = "Select * from Product";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<Product>() {
      @Override
      public Product call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductName");
          final int _cursorIndexOfProductPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "Product_Price");
          final int _cursorIndexOfCompanyRating = CursorUtil.getColumnIndexOrThrow(_cursor, "CompanyRating");
          final int _cursorIndexOfPimage = CursorUtil.getColumnIndexOrThrow(_cursor, "pimage");
          final int _cursorIndexOfDes = CursorUtil.getColumnIndexOrThrow(_cursor, "des");
          final Product _result;
          if(_cursor.moveToFirst()) {
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
            _result = new Product(_tmp_id,_tmpProductName,_tmpProduct_Price,_tmpCompanyRating,_tmpPimage,_tmpDes);
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
