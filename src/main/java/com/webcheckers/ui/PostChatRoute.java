package com.webcheckers.ui;

import com.google.gson.Gson;
import com.webcheckers.appl.GameCenter;
import com.webcheckers.appl.PlayerLobby;
import com.webcheckers.appl.PlayerServices;

import com.webcheckers.model.CheckersGame;
import com.webcheckers.model.Player;
import spark.*;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PostChatRoute implements Route {

    private final Gson gson=new Gson();
    private static final Logger LOG = Logger.getLogger(PostChatRoute.class.getName());
    public static ArrayList<String> msgLog= new ArrayList<>();
    /**
     * {@inheritDoc}
     */
    @Override
    public Object handle(Request request, Response response) {
      msgLog.add("<p>"+request.queryParams("message")+"</p>");
        String log="";
        for(int i=0; i<msgLog.size(); i++){
            if(i==msgLog.size()-1){
                log+=msgLog.get(i);
            }else{
                log+=msgLog.get(i)+",";
            }
        }
      return gson.toJson(log);
    }
}
