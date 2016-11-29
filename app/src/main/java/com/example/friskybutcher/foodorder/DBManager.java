package com.example.friskybutcher.foodorder;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class DBManager extends AppCompatActivity
{
    //Declare Database name, Table names, and version
    private static final String DATABASE_NAME = "Restaurant";
    private static final String TABLE_NAME = "food_items";  //This holds the menu items
    private static final String ORDER_TABLE = "orders"; //This holds the users current order
    private static final int DATABASE_VERSION = 1;
    //Declare Columns in each table
    public static final String COL_1 = "_id";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "CATAGORY";
    public static final String COL_4 = "PRICE";
    public static final String COL_5 = "DESCRIPTION";
    public static final String COL_6 = "STOCK";

    public static final String COL_1_O = "_id";
    public static final String COL_2_O = "NAME";
    public static final String COL_3_O = "PRICE";
    //Declare context, dbhelper and the db connection
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    private static final String TAG = "DbAdapter";

    //Strings to create tables
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME +
                    " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_2 + " TEXT, " +
                    COL_3 + " TEXT, " +
                    COL_4 + " REAL, " +
                    COL_5 + " TEXT, " +
                    COL_6 + " REAL);";

    private static final String CREATE_ORDER_TABLE =
            "CREATE TABLE " + ORDER_TABLE +
                    " (" + COL_1_O + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_2_O + " TEXT, " +
                    COL_3_O + " REAL);";

    public DBManager(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL("DROP TABLE IF EXISTS " + ORDER_TABLE);
            //Create food_items table and Order table
            db.execSQL(CREATE_TABLE);
            db.execSQL(CREATE_ORDER_TABLE);

            //Inserts for the menu (29 in total)
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Spicy Chicken Wangs', 'Starters', 7.99, 'Locally sourced Irish Chicken Wings with super spicy sauce!', 150)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Mexican Quesadillas', 'Starters', 6.99, 'Delicious crunchy quesadillas', 120)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Pizza Balls', 'Starters', 8, 'One of our new recipies, Time to deliver a pizza ball!', 25)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Caesar Salad', 'Starters', 7.99, 'Freshly made classic, Vegetarian', 70)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Red Pepper & Tomato Soup', 'Soup', 5.50, 'Homeade creamy tomato soup with Bread', 20)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Potato & Leek', 'Soup', 6.25, 'Creamy soup with chunky chicken & veg', 0)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Seafood Chowder', 'Soup', 9, 'Our most popular soup!', 200)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Sweet Potato & Butternut Squash', 'Soup', 8, 'For the vegans', 10)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Beef Ramen', 'Soup', 10, 'Japanese beef with noodles and soup', 30)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Ham & Cheese toastie', 'Sandwiches', 4.50, 'Hard to beat a classic toastie', 350)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Turkey Club Bagel', 'Sandwiches', 6, 'Turkey, tomato, lettuce, crispy bacon, melted cheese', 25)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Breakfast Roll', 'Sandwiches', 5.50, 'As many full irish ingrediants as we can fit!', 35)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Spaghetti Bolagnese', 'Pasta', 11, 'An italian classic, with parmesan cheese', 150)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Spaghetti Carbonara', 'Pasta', 11.50, 'Our take on another classic', 150)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Risotto Taleggio e Pera', 'Pasta', 13, 'Carnaroli rice with caramalised pear & taleggio cheese', 20)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Seafood Linguine', 'Pasta', 13, 'Linguine with seafood and a cream sauce', 150)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Homeade Ravioli', 'Pasta', 14, 'Homeade pasta ravioli with chicken and veg', 10)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Chitarra ai Frutti di mare', 'Pasta', 15, 'Homemade fresh spaghetti with mix of seafood in cherry tomato sauce and garlic', 24)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Fish & Chips', 'Fish', 11, 'Battered Cod with Chip-shop chips', 50)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Grilles salmon with mashed potato', 'Fish', 13, 'Fresh irish salmon with a creamy mash and veg', 30)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Roast Supreme of Corn-fed Chicken', 'Main Course', 15, 'Tomato, Red Onion, Courgette, Chorizo and Chickpea Cassoulet', 12)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Beef Burger', 'Main Course', 12, 'Irish homeade beef burgers with chip-shop chips', 150)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Wild Mushroom Panzarotti', 'Main Course', 15, 'Tiger Prawns, Cherry Tomatoes, Rocket, Cream Sauce, Parmesan', 1)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Rack of Free-range Kilmolin Lamb', 'Main Course', 16, 'Rosemary Roast Potatoes, Cherry Tomatoes & Kalamata Olives, Salsa Verde', 20)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('9oz Black Angus Sirloin Steak', 'Main Course', 21, 'Sauteed Onions and Shitake Mushrooms, Truffle and Parmesan Chips, Green Peppercorn Sauce', 30)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Vanilla Crème Brulée', 'Desert', 6, 'Lemon Sorbet', 75)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Chocolate Brownie', 'Desert', 6, 'Vanilla ice-cream', 150)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Fig and Frangipan Tart', 'Desert', 6, 'Lemon Marscapone Cream', 20)");
            db.execSQL("insert into " + TABLE_NAME + "(NAME, CATAGORY, PRICE, DESCRIPTION, STOCK) VALUES ('Mixed ice-cream', 'Desert', 4.50, 'Homeade chocolate, vanilla and mango ice-cream', 50)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            //Upgrade version
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + ORDER_TABLE);
            onCreate(db);
        }

    }

    public DBManager open() throws SQLException
    {
        //DbHelper now has the ability (through SQLiteOpenHelper) to manage our database (through context)
        DBHelper = new DatabaseHelper(context);
        db = DBHelper.getWritableDatabase();//opens database to be read or written
        return this;
    }

    //Method to display Catagories in a list
    public Cursor getCategories()
    {
        //Declare Cursor
        Cursor mCursor = null;
        String w = "SELECT DISTINCT " + COL_3 + " AS " + COL_1 + "," + COL_3 + " FROM " + TABLE_NAME;   //Get rid of duplicate catagory values

        try
        {
            mCursor = db.rawQuery(w, null);

            if(mCursor != null)
            {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        catch(SQLException e)
        {
            Log.e("Error", "Failed to get item" + e);
        }
        //return cursor query to display items
        return mCursor;
    }

    //Method to get starters from db and display in a list
    public Cursor getStarters()
    {
        //Declare cursor, matching string, and string query to return in a cursor
        Cursor mCursor = null;
        String starter_cata = "Starters";
        String q = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " = '" + starter_cata + "'";

        try
        {
            mCursor = db.rawQuery(q, null);

            if(mCursor != null)
            {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        catch(SQLException e)
        {
            Log.e("Error", "Failed to get item" + e);
        }
        //return query in cursor
        return mCursor;
    }
    /**********************************************************************************************************************/
    /*  FROM HERE TO DESERT WILL BE THE SAME METHODS BUT JUST VARIABLES CHANGED TO CORRESPOND TO THE DIFFERENT CATAGORIES */
    /**********************************************************************************************************************/
    public Cursor getSoup()
    {
        Cursor mCursor = null;
        String soup_cata = "Soup";
        String q = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " = '" + soup_cata + "'";

        try
        {
            mCursor = db.rawQuery(q, null);

            if(mCursor != null)
            {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        catch(SQLException e)
        {
            Log.e("Error", "Failed to get item" + e);
        }
        return mCursor;
    }

    public Cursor getSandwiches()
    {
        Cursor mCursor = null;
        String sandwich_cata = "Sandwiches";
        String q = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " = '" + sandwich_cata + "'";

        try
        {
            mCursor = db.rawQuery(q, null);

            if(mCursor != null)
            {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        catch(SQLException e)
        {
            Log.e("Error", "Failed to get item" + e);
        }
        return mCursor;
    }

    public Cursor getPasta()
    {
        Cursor mCursor = null;
        String pasta_cata = "Pasta";
        String q = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " = '" + pasta_cata + "'";

        try
        {
            mCursor = db.rawQuery(q, null);

            if(mCursor != null)
            {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        catch(SQLException e)
        {
            Log.e("Error", "Failed to get item" + e);
        }
        return mCursor;
    }

    public Cursor getFish()
    {
        Cursor mCursor = null;
        String fish_cata = "Fish";
        String q = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " = '" + fish_cata + "'";

        try
        {
            mCursor = db.rawQuery(q, null);

            if(mCursor != null)
            {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        catch(SQLException e)
        {
            Log.e("Error", "Failed to get item" + e);
        }
        return mCursor;
    }

    public Cursor getMainCourse()
    {
        Cursor mCursor = null;
        String main_cata = "Main Course";
        String q = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " = '" + main_cata + "'";

        try
        {
            mCursor = db.rawQuery(q, null);

            if(mCursor != null)
            {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        catch(SQLException e)
        {
            Log.e("Error", "Failed to get item" + e);
        }
        return mCursor;
    }
    public Cursor getDesert()
    {
        Cursor mCursor = null;
        String desert_cata = "Desert";
        String q = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " = '" + desert_cata + "'";

        try
        {
            mCursor = db.rawQuery(q, null);

            if(mCursor != null)
            {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        catch(SQLException e)
        {
            Log.e("Error", "Failed to get item" + e);
        }
        return mCursor;
    }

    //Method to add an item to order database
    public Cursor addToOrder(String id)
    {
        //String 'id' is passed through, which is the ID of the item on a list, which will be added to the Order db.
        //Declare cursor
        Cursor mCursor = null;
        String q = "INSERT INTO " + ORDER_TABLE +
                " SELECT _id, " + COL_2 +
                ", " + COL_4 +
                " FROM " + TABLE_NAME +
                " WHERE " + " _id " +
                "= " + id + ";";    //String to query db to add item to order
        try
        {
            mCursor = db.rawQuery(q, null);

            if (mCursor != null)
            {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        catch(SQLException e)
        {
            Log.e("Error", "Failed to get item" + e);
        }
        return mCursor;
    }

    //Method to display the users current order
    public Cursor viewOrder()
    {
        Cursor mCursor = null;
        String q = "SELECT * FROM " + ORDER_TABLE + ";";    //SELECT ALL FROM ORDERS

        try
        {
            mCursor = db.rawQuery(q, null);

            if(mCursor != null)
            {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
        catch(SQLException e)
        {
            Log.e("Error", "Failed to get item" + e);
        }
        return mCursor;
    }

    //Method to calculate all values in the price column of the Order db
    public double totalPrice()
    {
        Cursor c = db.rawQuery("SELECT Sum(" + COL_3_O +
                ") FROM " + ORDER_TABLE, null); //Gets the sum of all values in 'PRICE' Catagory
        if ( c.moveToFirst() )
        {
            return c.getDouble(0);  //returns double value from cursor
        }
        return c.getDouble(0);
    }

    //Method to remove a row from the Oder db
    public void remove(long id)
    {
        String string = String.valueOf(id); //id is passed which is the id of the item clicked and to be deleted
        db.execSQL("DELETE FROM " + ORDER_TABLE + " WHERE _id = '" + string + "'");
    }
}
