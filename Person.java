import java.util.ArrayList;

public class Person {

    private String name;
    private Person father;
    private Person mother;
    private ArrayList<Person> children;

    public Person(String name) {
        this.name = name;
        this.mother = null;
        this.father = null;
        this.children = null;
    }

    public void setFather(Person Father) {
        this.father = Father;
    }

    public void setMother(Person Mother) {
        this.mother = Mother;
    }

    public void addChildren(Person child) {
        if (children == null) {
            children = new ArrayList<Person>();
        }
        this.children.add(child);

    }

    public String getName() {
        return this.name;
    }

    public Person getFather() {
        return this.father;
    }

    public Person getMother() {
        return this.mother;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name;
    }
}