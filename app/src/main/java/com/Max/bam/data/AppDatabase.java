package com.Max.bam.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.Max.bam.data.dao.ThemeCardDao;
import com.Max.bam.data.entity.ThemeCard;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {ThemeCard.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ThemeCardDao themeCardDao();

    public static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ThemeCardDao dao = INSTANCE.INSTANCE.themeCardDao();
                dao.deleteAll();

                ThemeCard word = new ThemeCard("Hello", "sheesh");
                dao.insert(word);
                word = new ThemeCard("World", "bruh");
                dao.insert(word);
            });
        }
    };

    private static volatile AppDatabase INSTANCE;



    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
