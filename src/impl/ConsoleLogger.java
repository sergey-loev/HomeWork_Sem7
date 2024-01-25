package impl;

import java.time.LocalDateTime;

public class ConsoleLogger implements Loggable {

    public void log(String message) {
        System.err.println(LocalDateTime.now() + " <--- : ---> " + message);
    }
}
