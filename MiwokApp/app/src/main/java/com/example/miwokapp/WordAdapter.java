package com.example.miwokapp;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    WordAdapter(NumbersActivity numbersActivity, ArrayList<Word> words, int colorResourceId) {
        super(numbersActivity, 0, words);
        mColorResourceId = colorResourceId;
    }

    WordAdapter(FamilyActivity familyActivity, ArrayList<Word> words, int colorResourceId) {
        super(familyActivity, 0, words);
        mColorResourceId = colorResourceId;
    }

    WordAdapter(ColorsActivity colorsActivity, ArrayList<Word> words, int colorResourceId) {
        super(colorsActivity, 0, words);
        mColorResourceId = colorResourceId;
    }

    WordAdapter(PhrasesActivity phrasesActivity, ArrayList<Word> words, int colorResourceId) {
        super(phrasesActivity, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate
                    (R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);
        TextView miwokTextView = listItemView.findViewById(R.id.miwokTextView);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = listItemView.findViewById(R.id.defaultTextView);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView numbersImageView = listItemView.findViewById(R.id.numbersImageView);

        if(currentWord.hasImage()) {
            numbersImageView.setImageResource(currentWord.getImageResourceId());
            numbersImageView.setVisibility(View.VISIBLE);
        }else {
            numbersImageView.setVisibility(View.GONE);
        }

        View listItem = listItemView.findViewById(R.id.listItem);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        listItem.setBackgroundColor(color);

        return listItemView;
    }
}
