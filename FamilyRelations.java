import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FamilyRelations {
    public Person person;
    public ArrayList<Person> human;

    public FamilyRelations() {
        person = null;
        human = new ArrayList<Person>();
    }


    public void readFamTree(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println(" File not found.");
        }
        Scanner input = new Scanner(file);

        input.useDelimiter("[^a-zA-Z']+");
        String name;
        String mother,father,personName;
        name=input.nextLine();
        while (name.length()>0 && !name.equals("Relationships(mother,father)")){
            if (!nameFound(name)){
                human.add(new Person(name));

            }
            name=input.nextLine();
        }
        name=input.nextLine();

        while (name.length()>0 && !name.equals("End")) {
            if (name.equals("-")){

                // continue;
                name= input.nextLine();
                continue;
            }

            if (!nameFound(name)){
                System.out.println("Name Not Found.");
                System.exit(1);
            }else {
                personName = name;
                mother = input.nextLine();
                father = input.nextLine();
                findParents(personName, mother, father);
            }
            name=input.nextLine();
        }
        System.out.println(human);

    }


    public Person getPerson(String name){
        for (Person person:human){
            if (person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public boolean nameFound(String name){
        if (human.isEmpty()) {
            return false;
        }
        for (Person person:human) {
            if (name.equals(person.getName())) {
                return true;
            }
        }
        return false;
    }


    private void findParents(String name,String mother, String father){
        Person newPerson=getPerson(name);
        if (!mother.equals("unknown")){
            Person mom=getPerson(mother);
            if (mom==null){
                System.out.println("Error mother not found");
                System.exit(1);
            }
            newPerson.setMother(mom);
            mom.addChildren(newPerson);

        }
        if (!father.equals("unknown")){
            Person dad=getPerson(father);
            if (dad==null){
                System.out.println("Error father not found");
                System.exit(1);
            }
            newPerson.setFather(dad);
            dad.addChildren(newPerson);

        }
    }


}