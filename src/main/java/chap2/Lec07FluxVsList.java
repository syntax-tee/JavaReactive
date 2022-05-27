package chap2;

import chap2.helper.NameGenerator;
import utility.Util;


public class Lec07FluxVsList {
    public static void main(String[] args) {
//           List<String> names = NameGenerator.getNames(5);
//           System.out.println(names);

        NameGenerator.getNames(5).subscribe(Util.onNext());

    }
}
