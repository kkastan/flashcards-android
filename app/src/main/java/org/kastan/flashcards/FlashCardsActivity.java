package org.kastan.flashcards;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.kastan.flashcards.model.SpellingGame;

import java.util.ArrayList;
import java.util.Arrays;


public class FlashCardsActivity extends ActionBarActivity {

  private static String WORDS_ARR_KEY = "WORDS_ARR";
  private static String WORDS_INDEX_KEY = "WORDS_INDEX";

  SpellingGame game;

  static String[] words = {
          "the", "a", "an", "here", "is",
          "I", "see", "and", "we", "he",
          "she", "big", "have", "it", "no",
          "go", "you", "this", "down", "small"
  };

  private TextView wordView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flash_cards);

    wordView = (TextView) findViewById(R.id.flash_card_word);

    if(null != savedInstanceState
            && null != savedInstanceState.getCharSequenceArrayList(WORDS_ARR_KEY)
            && savedInstanceState.containsKey(WORDS_INDEX_KEY)) {

      game = new SpellingGame(savedInstanceState.getCharSequenceArrayList(WORDS_ARR_KEY), true);
      game.setIndex(savedInstanceState.getInt(WORDS_INDEX_KEY));
      currentWord();

    } else {
      game = new SpellingGame(Arrays.asList(words), false);
      nextWord();
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    outState.remove(WORDS_ARR_KEY);
    outState.remove(WORDS_INDEX_KEY);
    outState.putCharSequenceArrayList(WORDS_ARR_KEY, new ArrayList<CharSequence>(game.getOrderdWords()));
    outState.putInt(WORDS_INDEX_KEY, game.getIndex());
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_flash_cards, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  public void onClick(View view) {
    nextWord();
  }

  private void nextWord() {
    wordView.setText(game.next());
  }

  private void currentWord() {
    wordView.setText(game.current());
  }
}
