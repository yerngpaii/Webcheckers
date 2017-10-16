package com.webcheckers.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import com.webcheckers.appl.PlayerLobby;

import com.webcheckers.appl.PlayerServices;
import com.webcheckers.model.CheckersGame;
import spark.*;

/**
 * The UI Controller to GET the Home page.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 * @author Anorwen - - - edc8230@rit.edu
 */
public class GetHomeRoute implements Route {
  private static final Logger LOG = Logger.getLogger(GetHomeRoute.class.getName());

  private PlayerLobby playerlobby;
  static final String BOARD="board";

  private final TemplateEngine templateEngine;

  /**
   * Create the Spark Route (UI controller) for the
   * {@code GET /} HTTP request.
   *
   * @param templateEngine
   *   the HTML template rendering engine
   */
  public GetHomeRoute(final TemplateEngine templateEngine, PlayerLobby playerlobby) {
    // validation
    Objects.requireNonNull(templateEngine, "templateEngine must not be null");

    this.templateEngine = templateEngine;
    this.playerlobby = playerlobby;

    LOG.config("GetHomeRoute is initialized.");
  }

  public String addPlayersList(String viewingUser) {
    ArrayList<String> list = this.playerlobby.getUsers();
    if(list.contains(viewingUser)) {
      list.remove(viewingUser);
    }
    String result = "";
    for(String user: list) {
      result += "<li>" + user + "</li>";
    }
    return "<ul>" + result + "</ul>";
  }

  private String showNumber() {
    return Integer.toString(this.playerlobby.getUsers().size());
  }

  /**
   * Render the WebCheckers Home page.
   *
   * @param request
   *   the HTTP request
   * @param response
   *   the HTTP response
   *
   * @return
   *   the rendered HTML for the Home page
   */
  @Override
  public Object handle(Request request, Response response) {
    LOG.finer("GetHomeRoute is invoked.");

<<<<<<< HEAD
    Map<String, Object> vm = new HashMap<>();

    if(this.playerlobby.getUser(request.session()) == null) {
      vm.put("username", ""); // Place Holder for User
      vm.put("signURL", "/SignIn");
      vm.put("signLabel", "Sign In");
      vm.put("showPlayers", "<p>Please Sign In to see players.</p>");
    }
    else {
      vm.put("username", this.playerlobby.getUser(request.session()).toString());
      vm.put("numberUsers", showNumber());
      vm.put("signURL", "/SignedOut");
      vm.put("signLabel", "Sign Out");
      vm.put("showPlayers", addPlayersList(this.playerlobby.getUser(request.session()).toString()));
    }

    vm.put("numberUsers", this.showNumber()); // Not Being Used Yet
=======
    final Session httpSession = request.session();
    final PlayerServices playerServices =
            httpSession.attribute("playerServices");
    CheckersGame game = playerServices.currentGame();

    Map<String, Object> vm = new HashMap<>();
    vm.put(BOARD, game.getBoard());
>>>>>>> master
    vm.put("title", "Welcome!");
    return templateEngine.render(new ModelAndView(vm , "testHome.ftl"));
  }
<<<<<<< HEAD
}
=======

}
>>>>>>> master
