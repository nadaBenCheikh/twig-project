package home.chat.Controllers;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Client {
    private static Client single_instance = null;
    private Socket socket;
    PrintWriter out;
    BufferedReader in;
    BufferedReader stdIn;
    private String hostName = "127.0.0.1";
    private int portNumber = 5559;
    MsgListener msgListener;
    boolean stop = false;
    public static Client getInstance() throws IOException {
        if (single_instance == null)
            single_instance = new Client();

        return single_instance;
    }

    public Client() throws IOException {
        try {
            socket = new Socket(hostName, portNumber);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            System.out.println("Connection refused");
        }

        stdIn = new BufferedReader(new InputStreamReader(System.in));
        handle();
    }
    public void handle() {
        new Thread(new Runnable() {
            public void run() {
                String fromServer;
                while(!stop){
                    try {
                        if((fromServer = in.readLine())!=null){
                            msgListener.publish(fromServer);
                        }
                    } catch (IOException ignored) {
                    }
                }
            }
        }).start();
    }
    public void sendMsg(String textTosend,int id) throws IOException {
        JSONObject jo = new JSONObject();
        jo.put("user_id",id);
        jo.put("text",textTosend);
        getOut().println(jo.toString());
        if(jo.toString().equals("Bye server"))
            stop=true;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public BufferedReader getStdIn() {
        return stdIn;
    }

    public void setStdIn(BufferedReader stdIn) {
        this.stdIn = stdIn;
    }

    public MsgListener getMsgListener() {
        return msgListener;
    }

    public void setMsgListener(MsgListener msgListener) {
        this.msgListener = msgListener;
    }
}
