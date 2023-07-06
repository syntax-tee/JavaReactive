package content.chap2;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import content.utility.Util;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("Received sub"+ subscription);
                atomicReference.set(subscription);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: "+integer);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError: "+t.getMessage());

            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        });

        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("going to cancel");
        Util.sleepSeconds(3);
        atomicReference.get().request(4);
        Util.sleepSeconds(3);




    }
}
