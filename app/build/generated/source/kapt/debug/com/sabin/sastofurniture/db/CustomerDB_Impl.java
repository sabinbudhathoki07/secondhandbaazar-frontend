package com.sabin.sastofurniture.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.sabin.sastofurniture.dao.CartDAO;
import com.sabin.sastofurniture.dao.CartDAO_Impl;
import com.sabin.sastofurniture.dao.CustomerDAO;
import com.sabin.sastofurniture.dao.CustomerDAO_Impl;
import com.sabin.sastofurniture.dao.ProductDAO;
import com.sabin.sastofurniture.dao.ProductDAO_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CustomerDB_Impl extends CustomerDB {
  private volatile CustomerDAO _customerDAO;

  private volatile ProductDAO _productDAO;

  private volatile CartDAO _cartDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Product` (`_id` TEXT NOT NULL, `ProductName` TEXT, `Product_Price` INTEGER, `CompanyRating` TEXT, `pimage` TEXT, `des` TEXT, PRIMARY KEY(`_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Customer` (`_id` TEXT NOT NULL, `fullname` TEXT, `email` TEXT, `password` TEXT, `mobileno` TEXT, `pimage` TEXT, PRIMARY KEY(`_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CartModel` (`pid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `_id` TEXT, `ProductName` TEXT, `Product_Price` INTEGER, `CompanyRating` TEXT, `pimage` TEXT, `des` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fd1f99f86f50f8ee92d54ad632067639')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Product`");
        _db.execSQL("DROP TABLE IF EXISTS `Customer`");
        _db.execSQL("DROP TABLE IF EXISTS `CartModel`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsProduct = new HashMap<String, TableInfo.Column>(6);
        _columnsProduct.put("_id", new TableInfo.Column("_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProduct.put("ProductName", new TableInfo.Column("ProductName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProduct.put("Product_Price", new TableInfo.Column("Product_Price", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProduct.put("CompanyRating", new TableInfo.Column("CompanyRating", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProduct.put("pimage", new TableInfo.Column("pimage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProduct.put("des", new TableInfo.Column("des", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProduct = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProduct = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProduct = new TableInfo("Product", _columnsProduct, _foreignKeysProduct, _indicesProduct);
        final TableInfo _existingProduct = TableInfo.read(_db, "Product");
        if (! _infoProduct.equals(_existingProduct)) {
          return new RoomOpenHelper.ValidationResult(false, "Product(com.sabin.sastofurniture.entity.Product).\n"
                  + " Expected:\n" + _infoProduct + "\n"
                  + " Found:\n" + _existingProduct);
        }
        final HashMap<String, TableInfo.Column> _columnsCustomer = new HashMap<String, TableInfo.Column>(6);
        _columnsCustomer.put("_id", new TableInfo.Column("_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomer.put("fullname", new TableInfo.Column("fullname", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomer.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomer.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomer.put("mobileno", new TableInfo.Column("mobileno", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCustomer.put("pimage", new TableInfo.Column("pimage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCustomer = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCustomer = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCustomer = new TableInfo("Customer", _columnsCustomer, _foreignKeysCustomer, _indicesCustomer);
        final TableInfo _existingCustomer = TableInfo.read(_db, "Customer");
        if (! _infoCustomer.equals(_existingCustomer)) {
          return new RoomOpenHelper.ValidationResult(false, "Customer(com.sabin.sastofurniture.entity.Customer).\n"
                  + " Expected:\n" + _infoCustomer + "\n"
                  + " Found:\n" + _existingCustomer);
        }
        final HashMap<String, TableInfo.Column> _columnsCartModel = new HashMap<String, TableInfo.Column>(7);
        _columnsCartModel.put("pid", new TableInfo.Column("pid", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartModel.put("_id", new TableInfo.Column("_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartModel.put("ProductName", new TableInfo.Column("ProductName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartModel.put("Product_Price", new TableInfo.Column("Product_Price", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartModel.put("CompanyRating", new TableInfo.Column("CompanyRating", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartModel.put("pimage", new TableInfo.Column("pimage", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCartModel.put("des", new TableInfo.Column("des", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCartModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCartModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCartModel = new TableInfo("CartModel", _columnsCartModel, _foreignKeysCartModel, _indicesCartModel);
        final TableInfo _existingCartModel = TableInfo.read(_db, "CartModel");
        if (! _infoCartModel.equals(_existingCartModel)) {
          return new RoomOpenHelper.ValidationResult(false, "CartModel(com.sabin.sastofurniture.entity.CartModel).\n"
                  + " Expected:\n" + _infoCartModel + "\n"
                  + " Found:\n" + _existingCartModel);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "fd1f99f86f50f8ee92d54ad632067639", "82da4c0be27dafbbb82d6d3131d325d3");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Product","Customer","CartModel");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Product`");
      _db.execSQL("DELETE FROM `Customer`");
      _db.execSQL("DELETE FROM `CartModel`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public CustomerDAO getCustomerDAO() {
    if (_customerDAO != null) {
      return _customerDAO;
    } else {
      synchronized(this) {
        if(_customerDAO == null) {
          _customerDAO = new CustomerDAO_Impl(this);
        }
        return _customerDAO;
      }
    }
  }

  @Override
  public ProductDAO getProductDAO() {
    if (_productDAO != null) {
      return _productDAO;
    } else {
      synchronized(this) {
        if(_productDAO == null) {
          _productDAO = new ProductDAO_Impl(this);
        }
        return _productDAO;
      }
    }
  }

  @Override
  public CartDAO getCartProductDAO() {
    if (_cartDAO != null) {
      return _cartDAO;
    } else {
      synchronized(this) {
        if(_cartDAO == null) {
          _cartDAO = new CartDAO_Impl(this);
        }
        return _cartDAO;
      }
    }
  }
}
