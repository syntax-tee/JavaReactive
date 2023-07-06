package content.chap8;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuple3;
import content.utility.Util;

public class Lec04Zip {

    public static void main(String[] args) {
     Flux<Tuple3<String, String, String>> car = Flux.zip(getBody(),getEngine(),getTires());
     car.subscribe(Util.subscriber());
    }

    public static Flux<String> getBody(){
        return Flux.range(1,2).map(integer -> "Body "+integer);
    }

    public static Flux<String> getEngine(){
        return Flux.range(1,5).map(integer -> "Engine "+integer);

    }

    public static Flux<String> getTires(){
        return Flux.range(1,5).map(integer -> "Tire "+integer);

    }
}
