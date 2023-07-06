package content.chap5;

import content.chap5.assingment.InventoryService;
import content.chap5.assingment.OrderService;
import content.chap5.assingment.RevenueService;
import content.utility.Util;

public class Lec06Assignment {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        InventoryService inventoryService = new InventoryService();
        RevenueService revenueService = new RevenueService();

        //revenue and inventory observe the order stream
        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        revenueService.revenueStream().subscribe(Util.subscriber("revenue"));
        inventoryService.inventoryStream().subscribe(Util.subscriber("inventory"));

        Util.sleepSeconds(60);

    }
}
