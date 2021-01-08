package de.diskostu.android.roomwordsamplejava;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordViewModel extends AndroidViewModel {

    private WordRepository repository;

    private final LiveData<List<Word>> allWords;

    public WordViewModel(Application application) {
        super(application);
        repository = new WordRepository(application);
        allWords = repository.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return allWords;
    }

    public void insert(Word word) {
        repository.insert(word);
    }
}
