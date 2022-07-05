import game.GameSession;
import game.Player;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/twentyOne")
public class ServletA extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        Player player = GameSession.getPlayer("player", session);
        Player server = GameSession.getPlayer("server", session);

        if (req.getParameter("take") != null) {
            player.getCard();
            server.getCard();
        }

        if (req.getParameter("pass") != null) {
            server.getCard();
        }
        if (req.getParameter("restart") != null) {
            server.restart();
            player.restart();
        }

        req.setAttribute("serverScore", server.getPoints());
        req.setAttribute("playerScore", player.getPoints());

        if (server.isLost() || player.isWin()) {
            req.setAttribute("res", "You wingit!");
            req.getRequestDispatcher("/result.jsp").forward(req, resp);
        } else if (player.isLost() || server.isWin()) {
            req.setAttribute("res", "You lose!");
            req.getRequestDispatcher("/result.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
