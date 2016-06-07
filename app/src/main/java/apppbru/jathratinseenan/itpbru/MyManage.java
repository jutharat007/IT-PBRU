package apppbru.jathratinseenan.itpbru;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lab324-19 on 6/7/2016 AD.
 */
public class MyManage {

    // Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    private static final String user_table = "userTABLE";
    private static final String column_id = "_id";
    private static final String column_name = "Name";
    private static final String column_surname = "Surname";
    private static final String column_user = "User";
    private static final String column_password = "Password";

    public MyManage(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    } //Constructor

    public long addNewUser(String strID,
                           String strName,
                           String strSurname,
                           String strUser,
                           String strPassword) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_id, strID);
        contentValues.put(column_name, strName);
        contentValues.put(column_surname, strSurname);
        contentValues.put(column_user, strUser);
        contentValues.put(column_password, strPassword);

        return sqLiteDatabase.insert(user_table, null, contentValues);
    }


} //Main Class
