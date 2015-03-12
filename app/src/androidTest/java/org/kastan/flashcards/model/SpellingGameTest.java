package org.kastan.flashcards.model;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;

/**
 * Created by karlkastan on 3/10/15.
 */
public class SpellingGameTest extends TestCase {

  String[] words = { "one", "two", "three"};

  public void testNextWord() {
    SpellingGame game = new SpellingGame(Arrays.asList(words), true);
    assertEquals("one", game.current());
    assertEquals("two", game.next());
    assertEquals("three", game.next());
    assertEquals("one", game.next());
    assertEquals("two", game.next());
  }

  public void testPreviousWord() {
    SpellingGame game = new SpellingGame(Arrays.asList(words), true);
    assertEquals("one", game.current());
    assertEquals("three", game.previous());
    assertEquals("two", game.previous());
    assertEquals("one", game.previous());
    assertEquals("three", game.previous());
  }
}
