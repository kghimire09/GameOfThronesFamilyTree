
import java.io.FileReader;
import java.util.*;
import java.io.*;

public class Family {
    public static Scanner console = new Scanner(System.in);
    public static void main(String[] args)  {
        try {
            familyInformation();
        } catch (FileNotFoundException e) {
            System.out.println("error");
            System.exit(1);
        }
    }


    public static void familyInformation() throws FileNotFoundException {
        FamilyRelations fr=new FamilyRelations();
        fr.readFamTree("family.txt");
        String name = "";
        while (!name.equalsIgnoreCase("exit")) {
            System.out.println("Write family tree member's name to get information: ");
            name = console.nextLine();
            System.out.println();
            if (name.equalsIgnoreCase("exit")){
                System.exit(1);
            }
            Person person = fr.getPerson(name);
            if (person == null){
                System.out.println("No Match");
            }
            else{
                System.out.println("Name: " + person.getName());
                if (person.getMother()==null){
                    System.out.print("Maternal Line: Unknown");
                    System.out.println();
                }
                else {
                    System.out.println("Maternal Line: ");
                    System.out.println("\t"+person.getName());
                    System.out.println("\t\t"+person.getMother().getName());
                }

                if (person.getFather()==null){
                    System.out.print("Paternal Line: Unknown");
                    System.out.println();
                }
                else {
                    System.out.println("Paternal Line:");
                    System.out.println("\t" + person.getName());
                    System.out.println("\t\t" + person.getFather().getName());
                }


                if (person.getChildren()==null){
                    System.out.println("No Children");
                }else {
                    System.out.println("Children: ");
                    for (Person per: person.getChildren()){
                        System.out.println("\t"+ per.getName());
                    }
                }

            }

        }

    }



}
