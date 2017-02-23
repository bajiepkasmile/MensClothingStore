package com.nodomain.mensclothingstore.model;


import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.*;


public class CommentTests {

    @Test
    public void creatingCommentIsCorrect() {
        String senderName = "sender";
        Calendar sentTime = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"));
        String text = "text";
        Comment comment = new Comment(senderName, sentTime, text);

        assertEquals(senderName, comment.getSenderName());
        assertEquals(sentTime, comment.getSentTime());
        assertEquals(text, comment.getText());
    }
}
