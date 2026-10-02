package com.lira.core.data.di

import android.content.Context
import androidx.room.Room
import com.lira.core.data.db.LiraDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.zetetic.database.sqlcipher.SupportOpenHelperFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideLiraDatabase(
        @ApplicationContext context: Context
    ): LiraDatabase {
        // Инициализация SQLCipher с дефолтным ключом (в продакшене заменяется на защищенный ключ из KeyStore)
        val passphrase = SupportOpenHelperFactory.getBytes("LiraSecureKey2026".toCharArray())
        val factory = SupportOpenHelperFactory(passphrase)

        return Room.databaseBuilder(
            context,
            LiraDatabase::class.java,
            "lira_encrypted.db"
        )
            .openHelperFactory(factory)
            .fallbackToDestructiveMigration()
            .build()
    }
}
