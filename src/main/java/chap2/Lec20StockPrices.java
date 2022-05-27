package chap2;

import chap2.assignment.StockPricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class Lec20StockPrices {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new  CountDownLatch(1);

        StockPricePublisher.getPrice().subscribeWith(new Subscriber<Integer>() {
            private Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer price) {
                System.out.println(LocalDateTime.now()+ ": Price :"+ price);
                if(price > 110 ||  price < 90){
                    this.subscription.cancel();
                }
            }

            @Override
            public void onError(Throwable t) {
                latch.countDown();

            }

            @Override
            public void onComplete() {
              latch.countDown();
            }
        });
        latch.await();

    }
}
