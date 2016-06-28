package thinkinjava;



/**
 * Created by Administrator on 2016/4/24.
 */
public class Person {
    private final String first;
    private final String last;
    private final String address;

    Person(String first,String last,String address) {
        this.first = first;
        this.last=last;
        this.address=address;
    }
    public String toString(){
        return "Person: "+first+" "+last+" "+address;
    }
    private static class NullPerson extends Person implements  Null{

        private NullPerson() {
            super("None", "None", "None");
        }
        public String toString(){
            return "NullPerson";
        }

    }
    public static final Person NULL=new NullPerson();
}
class Position{
    private  String title;
    private Person person;
    public Position(String title,Person person){
        this.person=person;
        this.title=title;
        if(person==null){
            person=Person.NULL;
        }
    }
    public Position(String title){
        this.title=title;
        person=Person.NULL;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String newTitle){
        title=newTitle;
    }
    public Person getPerson(){
        return  person;
    }
    public void setPerson(Person newPerson){
        person=newPerson;
        if (person==null){
            person=Person.NULL;
        }
    }
    public String toString(){
        return "Position: "+title+" "+person.toString();
    }
}


