package org.transsonic.trustgame.register;

import java.io.IOException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.transsonic.trustgame.data.trustgame.Tables;
import org.transsonic.trustgame.data.trustgame.tables.records.GameplayRecord;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    /** */
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        System.getProperties().setProperty("org.jooq.no-logo", "true");

        // determine the connection pool, and create one if it does not yet exist (first use after server restart)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }

        try {
            Context ctx = new InitialContext();
            try {
                ctx.lookup("/trustgame-register_datasource");
            } catch (NamingException ne) {
                final HikariConfig config = new HikariConfig();
                config.setJdbcUrl("jdbc:mysql://localhost:3306/trustgame");
                config.setUsername("trustgame");
                config.setPassword("TG%s1naval%2105");
                config.setMaximumPoolSize(2);
                config.setDriverClassName("com.mysql.cj.jdbc.Driver");
                DataSource dataSource = new HikariDataSource(config);
                ctx.bind("/trustgame-register_datasource", dataSource);
            }
        } catch (NamingException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        RegisterData data = SessionUtils.getData(session);
        if (data == null) {
            data = new RegisterData();
            session.setAttribute("registerData", data);
            try {
                data.setDataSource((DataSource) new InitialContext().lookup("/trustgame-register_datasource"));
            } catch (NamingException e) {
                throw new ServletException(e);
            }
            return;
        }

        String click = "gamePlay";
        if (request.getParameter("clickType") != null)
            click = request.getParameter("clickType").toString();
        int recordNr = 0;
        if (request.getParameter("recordNr") != null)
            recordNr = Integer.parseInt(request.getParameter("recordNr"));

        switch (click) {

        case "gamePlay": {
            data.setSelectedGamePlayId(recordNr);
            StringBuilder s = new StringBuilder();
            s.append(startForm());
            s.append(startPickTable());
            s.append(makeGamePlayPicklist(session, data));
            s.append(endPickTable());
            s.append(endForm());
            data.setContentHtml(s.toString());
            break;
        }

        default:
            break;
        }

        response.sendRedirect("jsp/register/register.jsp");
    }

    public static String startForm() {
        StringBuilder s = new StringBuilder();
        s.append("<div class=\"tg-form\">\n");
        s.append("  <form id=\"registerForm\" action=\"/trustgame-register/register\" method=\"POST\" >\n");
        s.append("    <input id=\"clickType\" type=\"hidden\" name=\"clickType\" value=\"tobefilled\" />\n");
        s.append("    <input id=\"recordNr\" type=\"hidden\" name=\"recordNr\" value=\"0\" />\n");
        s.append("    <fieldset>\n");
        return s.toString();
    }

    public static String endForm() {
        StringBuilder s = new StringBuilder();
        s.append("    </fieldset>\n");
        s.append("  </form>\n");
        s.append("</div>\n");
        return s.toString();
    }

    public static String startPickTable() {
        StringBuilder s = new StringBuilder();
        s.append("<div class=\"tg-select-table\">\n");
        s.append("  <table>\n");
        return s.toString();
    }

    public static String endPickTable() {
        StringBuilder s = new StringBuilder();
        s.append("  </table>\n");
        s.append("</div>\n");
        return s.toString();
    }

    public static String makeGamePlayPicklist(HttpSession session, RegisterData data) {
        int selectedGamePlayId = data.getSelectedGamePlayId();
        StringBuilder s = new StringBuilder();
        DSLContext dslContext = DSL.using(data.getDataSource(), SQLDialect.MYSQL);
        List<GameplayRecord> gamePlays = dslContext.selectFrom(Tables.GAMEPLAY)
                .where(Tables.GAMEPLAY.AUTOREGISTER.eq(Byte.valueOf((byte) 1))).fetch();

        if (gamePlays.size() == 0) {
            s.append("    <p>No games that have autoregstration turned on.</p>\n");
        }

        else {
            s.append("    <tr>\n");
            s.append("      <td width=\"25%\">Select gameplay</td>\n");
            s.append("      <td width=\"75%\">\n");
            s.append("        <select name=\"gamePlay\" id=\"gamePlay\" onchange=\"submitSelectGamePlay(); \">");
            s.append("          <option value=\"0\">&nbsp;</option>\n");
            for (GameplayRecord gamePlay : gamePlays) {
                int id = gamePlay.getId();
                s.append("        <option value=\"");
                s.append(id);
                s.append("\"");
                if (id == selectedGamePlayId) {
                    s.append(" selected");
                }
                s.append(">");
                s.append(gamePlay.getGroupdescription());
                s.append("</option>\n");
            }
            s.append("        </select>\n");
            s.append("      </td>\n");
            s.append("    </tr>\n");
        }

        return s.toString();
    }

}
