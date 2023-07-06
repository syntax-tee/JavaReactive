package content.chap4;

import content.chap4.helper.OrderService;
import content.chap4.helper.UserService;
import content.utility.Util;

public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                 .flatMap(user-> OrderService.getPurchaseOrder(user.getUserId()))
                 .subscribe(Util.subscriber());
    }
}
