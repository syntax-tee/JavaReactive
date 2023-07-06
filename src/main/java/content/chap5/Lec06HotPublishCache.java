package content.chap5;

import reactor.core.publisher.Flux;
import content.utility.Util;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec06HotPublishCache {

    public static void main(String[] args) {
        //share = publish().refCount()
        //cache = publish().replay() int.max
        Flux<String> movieStream = Flux.fromStream(Lec06HotPublishCache::getMovie).delayElements(Duration.ofSeconds(2)).cache();

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);

        System.out.println("Mike is about to join");

        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(60);

    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of("Scene 1", "Scene 2", "Scene 3", "Scene 4", "Scene 5", "Scene 6","Scene 7","Scene 8");
    }
}
