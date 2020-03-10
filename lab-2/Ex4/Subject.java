package Lab2.Ex4;

import Lab2.Ex3.Room;
import Lab2.Ex2.Person;

public class Subject {
    private Room room;
    private int noStudents;
    private Person teacher;

    public Subject(Room room, int noStudents, Person teacher) {
        this.room = room;
        this.noStudents = noStudents;
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNoStudents() {
        return noStudents;
    }

    public void setNoStudents(int noStudents) {
        this.noStudents = noStudents;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }
    public void getSubjectData() {
        System.out.println(this.room.getRoomData() + " " + this.getNoStudents() + " " + this.teacher.getPersonData());
    }

}