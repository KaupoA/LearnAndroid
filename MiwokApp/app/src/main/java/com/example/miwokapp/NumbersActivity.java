package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener =
            new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Make a new ArrayList named words
        final ArrayList<Word> words = new ArrayList<>();

        // Add items to the ArrayList
        words.add(new Word("one", "lutti",
                R.drawable.number_one, R.drawable.play_arrow, R.raw.number_one));
        words.add(new Word("two", "otiiko",
                R.drawable.number_two, R.drawable.play_arrow, R.raw.number_two));
        words.add(new Word("three", "tolookosu",
                R.drawable.number_three, R.drawable.play_arrow, R.raw.number_three));
        words.add(new Word("four","oyyisa",
                R.drawable.number_four, R.drawable.play_arrow, R.raw.number_four));
        words.add(new Word("five","massokka",
                R.drawable.number_five, R.drawable.play_arrow, R.raw.number_five));
        words.add(new Word("six","temmokka",
                R.drawable.number_six, R.drawable.play_arrow, R.raw.number_six));
        words.add(new Word("seven","kenekaku",
                R.drawable.number_seven, R.drawable.play_arrow, R.raw.number_seven));
        words.add(new Word("eight","kawinta",
                R.drawable.number_eight, R.drawable.play_arrow, R.raw.number_eight));
        words.add(new Word("nine","wo'e",
                R.drawable.number_nine, R.drawable.play_arrow, R.raw.number_nine));
        words.add(new Word("ten","na'aacha",
                R.drawable.number_ten, R.drawable.play_arrow, R.raw.number_ten));

        WordAdapter wordsAdapter = new WordAdapter(this, words,
                R.color.category_numbers);
        ListView numbersListView = findViewById(R.id.wordListView);
        numbersListView.setAdapter(wordsAdapter);

        numbersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(NumbersActivity.this,
                            word.getAudioResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT) {
                        mediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}
