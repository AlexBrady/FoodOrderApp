package com.example.friskybutcher.foodorder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "Restaurant";
    public static final String TABLE_NAME = "food_items";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "CATAGORY";
    public static final String COL_4 = "PRICE";
    public static final String COL_5 = "DESCRIPTION";
    public static final String COL_6 = "STOCK";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CATAGORY TEXT,PRICE REAL,DESCRIPTION TEXT,STOCK INTEGER)");

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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
