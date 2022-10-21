package chap8;

import reactor.core.publisher.Flux;
import utility.Util;

import java.time.Duration;

public class Lec05CombineLatest {

    public static void main(String[] args) {
      Flux.combineLatest(getNumber(),getString(),(i,s)-> s + i).subscribe(Util.subscriber());

      Util.sleepSeconds(5);

    }

    private static  Flux<String> getString(){
        return Flux.just("A","B","C").delayElements(Duration.ofSeconds(1));
    }


    private static Flux<Integer> getNumber(){
      return Flux.just(1,2,3).delayElements(Duration.ofSeconds(3));
    }

}
