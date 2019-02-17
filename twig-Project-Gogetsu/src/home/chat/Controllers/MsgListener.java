package home.chat.Controllers;

import java.io.IOException;

public interface MsgListener {
    void publish(String test) throws IOException;
}
