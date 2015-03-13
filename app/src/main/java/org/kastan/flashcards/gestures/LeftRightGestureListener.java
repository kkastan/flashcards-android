package org.kastan.flashcards.gestures;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by karlkastan on 3/12/15.
 */
public class LeftRightGestureListener extends GestureDetector.SimpleOnGestureListener {

  private OnLeftRight onLeftRight;

  public LeftRightGestureListener(OnLeftRight onLeftRight) {
    this.onLeftRight = onLeftRight;
  }

  @Override
  public boolean onFling(MotionEvent m1, MotionEvent m2, float velocityX, float velocityY) {

    float dy = m1.getY() - m2.getY();
    if (dy < 0.0) {
      dy *= -1.0f;
    }

    // ignore gestures with too much vertical motion
    if (dy > 100f) {
      return true;
    }

    float direction = m1.getX() - m2.getX();
    float dx = direction < -1.0 ? direction * -1.0f : direction;

    // ignore gestures with too little horizontal motion
    if (dx < 100f) {
      return true;
    }

    if(direction > 0.0) {
      onLeftRight.onLeft();
    } else {
      onLeftRight.onRight();
    }

    return true;
  }

}
