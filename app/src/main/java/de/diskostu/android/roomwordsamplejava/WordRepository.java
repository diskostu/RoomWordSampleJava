package de.diskostu.android.roomwordsamplejava;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

class WordRepository {

    private final WordDao wordDao;
    private final LiveData<List<Word>> allWords;

    WordRepository(Application application) {
        final WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
        allWords = wordDao.getAlphabetizedWords();
    }

    LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> wordDao.insert(word));
    }
}
