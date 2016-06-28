package thinkinjava;

import java.util.ArrayList;

/**
 * Created by Bill on 2016/4/24.
 * Email androidBaoCP@163.com
 */
public class Staff extends ArrayList<Position> {
    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    private void add(String... titles) {
        for (String title : titles) {
            add(new Position(title));
        }
    }

    private Staff(String... titles) {
        add(titles);
    }

    private boolean positionAvailable(String title) {
        for (Position position : this) {
            if (position.getTitle().equals(title) && position.getPerson().equals(Person.NULL))
                return true;
        }
        return false;
    }

    private void fillPosition(String title, Person person) {
        for (Position position : this)
            if (position.getTitle().equals(title) && position.getPerson() == Person.NULL) {
                position.setPerson(person);
                return;
            }
        throw new RuntimeException("Position: " + title + " not available");
    }

    public static void main(String[] args) {
        Staff staff = new Staff("President", "CTO", "Marketing Manager", "Product Manager", "Project Lead", "Software Engineer", "Software Engineer", "Test Engineer", "Technical Writer");
        staff.fillPosition("President", new Person("Me", "Last", "The Top,Lonely At"));
        if (staff.positionAvailable("Software Engineer")) {
            staff.fillPosition("Software Engineer", new Person("Bod", "Coder", "Bright Light City"));
        }
        System.out.println(staff);
    }

}