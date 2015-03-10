package org.kastan.flashcards;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class FlashCardsActivity extends ActionBarActivity {

    Random rand = new Random();

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
        updateWord();
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

    public void nextWord(View view) {
        updateWord();
    }

    private void updateWord() {
        int randomNum = rand.nextInt(words.length);
        wordView.setText(words[randomNum]);
    }

}
