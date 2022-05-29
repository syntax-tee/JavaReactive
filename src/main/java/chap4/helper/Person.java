package chap4.helper;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import utility.Util;

@Data
@ToString
public class Person {

    private String name;
    private int age;

    public Person() {
        this.name = Util.faker().name().fullName();
        this.age = Util.faker().random().nextInt(1,20);

    }
}
