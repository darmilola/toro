/*
 * Copyright (c) 2017 Nam Nguyen, nam@ene.im
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.ene.toro;

import android.support.annotation.NonNull;
import android.view.View;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import im.ene.toro.media.PlayerState;

/**
 * @author eneim | 5/31/17.
 */

public interface Player {

  @NonNull View getPlayerView();

  @NonNull PlayerState getCurrentState();

  /**
   * {@link ExoPlayer} should call {@link ExoPlayer#prepare(MediaSource)} here, and not start
   * playback when ready
   */
  boolean prepare(@NonNull PlayerState playerState);

  void release();

  /**
   * Start playback or resume from a pausing state.
   */
  void play();

  /**
   * Pause current playback.
   */
  void pause();

  boolean isPlaying();

  boolean wantsToPlay();

  /**
   * @return prefer playback order in list. Can be customized.
   */
  int getPlayerOrder();
}