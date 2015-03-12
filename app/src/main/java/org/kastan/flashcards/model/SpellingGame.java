package org.kastan.flashcards.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by karlkastan on 3/10/15.
 */
public class SpellingGame {

  private static Comparator<CharSequence> RANDOM_COMPARATOR = new Comparator<CharSequence>() {
    Random rand = new Random();

    @Override
    public int compare(CharSequence charSequence, CharSequence charSequence2) {
      int v = rand.nextInt(3);
      return v-1;
    }
  };

  private int index = -1;
  private int size = 0;
  private List<? extends CharSequence> words;

  public SpellingGame(List<? extends CharSequence> words, boolean isOrdered) {

    if(null == words) {
      throw new IllegalArgumentException("words can not be null");
    }

    this.words = new ArrayList<CharSequence>(words);

    if(!isOrdered) {
      Collections.sort(this.words, RANDOM_COMPARATOR);
    }

    size = this.words.size();
  }

  public List<? extends CharSequence> getOrderdWords() {
    return words;
  }

  public int getPosition() {
    return index + 1;
  }

  public CharSequence next() {

    if(index < (size-1)) {
      index++;
    } else {
      index = 0;
    }

    return words.get(index);
  }

  public CharSequence previous() {
    if(index > 0) {
      index--;
    } else {
      index = size-1;
    }

    return words.get(index);
  }

  public CharSequence current() {
    if(index > -1) {
      return words.get(index);
    }

    return next();
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    if(null == words || index >= words.size()) {
      throw new IllegalArgumentException("Index can not exceed word list size.");
    }
    this.index = index;
  }
}
