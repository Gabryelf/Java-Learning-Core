package org.example.notes.notes_saves;

import org.example.notes.notes_interface.NotePad;

import java.io.*;


public class SaveNotes {

    public static void saveNote(String note){

        try {
            saveNoteInternal(System.currentTimeMillis(), note);
        } catch (FileNotFoundException e) {
            throw new RuntimeException( e );
        }
    }

    private static void saveNoteInternal(long timestamp, String note) throws FileNotFoundException {
        try(PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(new FileOutputStream( NotePad.NOTES_FILE ), "UTF-8" ) ) )) {
            out.println(timestamp + " -> " + note);
        } catch (IOException e){
            e.printStackTrace();

        }
    }


}
