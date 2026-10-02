package com.lira.core.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1, exportSchema = false)
abstract class LiraDatabase : RoomDatabase() {
    // Здесь в будущем появятся DAO (ассистент, финансы, заметки)
}
