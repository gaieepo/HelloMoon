package com.example.HelloMoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;

/**
 * Created by gaieepo on 10/6/2016.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;
    private boolean isPause;
    private SurfaceHolder mSurfaceHolder;

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        mSurfaceHolder = surfaceHolder;
    }

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
            isPause = false;
        }
    }

    public void play(Context c) {
        if (isPause) {
            mPlayer.start();
        } else {
            stop();

            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
            mPlayer.setDisplay(mSurfaceHolder);

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mPlayer.start();
                }
            });

            mPlayer.start();
        }
        isPause = false;
    }

    public void pause() {
        if (mPlayer != null) {
            mPlayer.pause();
            isPause = true;
        }
    }

    public boolean isPlaying() {
        if (mPlayer != null)
            return mPlayer.isPlaying();
        else
            return false;
    }
}
