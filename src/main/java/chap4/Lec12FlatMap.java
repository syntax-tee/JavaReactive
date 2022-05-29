package chap4;

import chap4.helper.OrderService;
import chap4.helper.UserService;
import utility.Util;

public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                 .flatMap(user-> OrderService.getPurchaseOrder(user.getUserId()))
                 .subscribe(Util.subscriber());
    }
}
