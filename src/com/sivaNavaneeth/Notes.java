package com.sivaNavaneeth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Notes {

    private String notesName;
    private String notesContent;

    public Notes( String notesName, String notesContent) {

        this.notesName = notesName;
        this.notesContent = notesContent;
    }


    public String  getNotesName() {
        return notesName;
    }

    public String getNotesContent() {
        return notesContent;
    }

    public static Notes create(String name,String content){
        return new Notes(name,content);
    }


}

