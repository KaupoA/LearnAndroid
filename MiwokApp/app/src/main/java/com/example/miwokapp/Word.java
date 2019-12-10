package com.example.miwokapp;

class Word {

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mImageTwoResourceId;
    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    Word(String defaultTranslation, String miwokTranslation,int imageTwoResourceId,
         int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    Word(String defaultTranslation, String miwokTranslation, int imageResourceId,
         int imageTwoResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    int getImageResourceId() {
        return mImageResourceId;
    }

    int getImageTwoResourceId() {
        return mImageTwoResourceId;
    }

    boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    int getAudioResourceId() {
        return mAudioResourceId;
    }
}
