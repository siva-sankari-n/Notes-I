package com.sivaNavaneeth;

import java.util.Scanner;

public class Main {
     private static Scanner scanner=new Scanner(System.in);
     private static NotesService notes=new NotesService("content");
        public static void main(String[] args) {

            boolean quit = false;
            printActions();
            while (!quit) {
                System.out.println("\nActions: ");
                int features = scanner.nextInt();
                scanner.nextLine();

                switch (features) {
                    case 0:
                        System.out.println("\n tap to exit");
                        quit = true;
                        break;
                    case 1:
                        notes.printList();
                        break;
                    case 2:
                        createNotes();
                        break;
                    case 3:
                        editNotes();
                        break;
                    case 4:
                        removeNotes();
                        break;
                    case 5:
                        viewNotes();
                        break;
                    case 6:
                        printActions();
                        break;
                }
            }
        }
    public static void createNotes(){
        System.out.println("Enter Notes name: ");
                String name=scanner.nextLine();
        System.out.println("Enter Notes content: ");
                String content=scanner.nextLine();
                Notes newNotes=Notes.create(name,content);
                if(notes.createNotes(newNotes)){
                System.out.println(name+"--->"+content);
               }else{
              System.out.println(name+"already exists");
               }
    }
   public static void editNotes() {
       System.out.println("Enter Existing Note name: ");
       String name = scanner.nextLine();
       Notes existingContent = notes.viewNotes(name);
       if (existingContent == null) {
           System.out.println("Notes not found");
           return;
       }
       System.out.println("Enter new note name: ");
       String newName = scanner.nextLine();
       System.out.println("Enter new note content");
       String newcontent=scanner.nextLine();
       Notes newContent = Notes.create(newName,newcontent);

       if (notes.editNotes(existingContent, newContent)) {
           System.out.println("Successfully updated");
       } else {
           System.out.println("Error updating");
       }
   }
   public static void removeNotes(){
       System.out.println("Enter Existing Note name: ");
       String name = scanner.nextLine();

       Notes existingContent = notes.viewNotes(name);
       if (existingContent == null) {
           System.out.println("Notes not found");
           return;
       }
       if(notes.removeNotes(existingContent)){
           System.out.println("Successfully deleted");
       }else{
           System.out.println("Error deleting");
       }
   }
   public static void viewNotes(){
       System.out.println("Enter Existing Note name: ");
       String name = scanner.nextLine();

       Notes existingContent = notes.viewNotes(name);
       if (existingContent == null) {
           System.out.println("Notes not found");
           return;
       }
       System.out.println("Note Name:"+existingContent.getNotesName()+"\nContent: "+existingContent.getNotesContent());
   }
    public static void printActions(){
        System.out.println("Press\n");
        System.out.println("0 -to shutdown\n"+
                "1 -to print Notes List\n"+
                "2 -to create a new Notes\n"+
                "3 -to edit existing an existing notes\n"+
                "4 -to remove an existing notes\n"+
                "5 -view if an existing contact exists\n"+
                "6 -to print a list of available features.");
        System.out.println("Choose anyone features: ");

    }

}
