package content.chap8;

import content.chap8.helper.NameGenerator;
import content.utility.Util;

public class Lec01StartWith {

    public static void main(String[] args) {
        NameGenerator generator = new NameGenerator();
        generator.generateNames().take(2).subscribe(Util.subscriber("sam"));


        generator.generateNames().take(2).subscribe(Util.subscriber("mike"));


        generator.generateNames().filter(n -> n.startsWith("A")).take(1).subscribe(Util.subscriber("marshal"));

    }
}
