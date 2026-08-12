package org.example.notes.notes_main;

import org.example.notes.notes_interface.NotePad;

import static org.example.notes.notes_saves.SaveNotes.saveNote;

public class Main {
    public static void main(String[] args) {
        NotePad notePad = new NotePad();
        saveNote("Hello, world!");
    }


}
