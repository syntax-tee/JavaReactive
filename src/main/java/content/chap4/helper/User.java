package content.chap4.helper;


import lombok.Data;
import lombok.ToString;
import content.utility.Util;

@Data
@ToString
public class User {

    private int userId;
    private String name;

    public User(int userId) {
        this.userId = userId;
        this.name = Util.faker().name().fullName();
    }

}
