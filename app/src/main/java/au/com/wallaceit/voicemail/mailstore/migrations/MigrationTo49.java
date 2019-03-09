package au.com.wallaceit.voicemail.mailstore.migrations;


import android.database.sqlite.SQLiteDatabase;


class MigrationTo49 {
    public static void createMsgCompositeIndex(SQLiteDatabase db) {
        db.execSQL("CREATE INDEX IF NOT EXISTS msg_composite ON messages (deleted, empty,folder_id,flagged,read)");
    }
}