package org.transsonic.trustgame.register;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
import javax.xml.bind.DatatypeConverter;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.transsonic.trustgame.data.trustgame.Tables;
import org.transsonic.trustgame.data.trustgame.tables.records.GameRecord;
import org.transsonic.trustgame.data.trustgame.tables.records.GameplayRecord;
import org.transsonic.trustgame.data.trustgame.tables.records.GameuserRecord;
import org.transsonic.trustgame.data.trustgame.tables.records.MissionRecord;
import org.transsonic.trustgame.data.trustgame.tables.records.UserRecord;

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
        }

        String click = "start";
        if (request.getParameter("clickType") != null)
            click = request.getParameter("clickType").toString();
        int recordNr = 0;
        if (request.getParameter("recordNr") != null)
            recordNr = Integer.parseInt(request.getParameter("recordNr"));

        data.setShowModalWindow(0);
        data.setModalWindowHtml("");

        switch (click) {

        case "start": {
            data.setSelectedGamePlayId(0);
            data.setContentHtml(makeGamePlayPicklist(session, data, 0));
            break;
        }

        case "selectedGamePlay": {
            data.setSelectedGamePlayId(recordNr);
            data.setContentHtml(makeGamePlayPicklist(session, data, 1));
            break;
        }

        case "password": {
            makeNewUser(request, session, data);
            break;
        }

        default:
            System.err.println("UNKNOWN CLICKTYPE: " + click);
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

    public static String makeGamePlayPicklist(HttpSession session, RegisterData data, int state) {
        int selectedGamePlayId = data.getSelectedGamePlayId();
        StringBuilder s = new StringBuilder();
        DSLContext dslContext = DSL.using(data.getDataSource(), SQLDialect.MYSQL);
        List<GameplayRecord> gamePlays = dslContext.selectFrom(Tables.GAMEPLAY)
                .where(Tables.GAMEPLAY.AUTOREGISTER.eq(Byte.valueOf((byte) 1))).fetch();

        if (gamePlays.size() == 0) {
            s.append("<div class=\"tg-select-table\">\n");
            s.append("  <p><br>No games have self regstration turned on.</p><br><br>\n");
            s.append("</div>\n");
        }

        else {
            s.append(startForm());
            s.append(startPickTable());
            s.append("    <tr>\n");
            s.append("      <td width=\"25%\">Select gameplay</td>\n");
            s.append("      <td width=\"75%\">\n");
            s.append("        <select name=\"gamePlay\" id=\"gamePlay\" onchange=\"submitSelectedGamePlay(); \">");
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

            if (state == 1) {
                // check whether gamePlay correctly configured
                GameplayRecord gamePlay = SqlUtils.readGamePlayFromGamePlayId(data, data.getSelectedGamePlayId());
                if (gamePlay.getAutoregisterusergroupId() == null || gamePlay.getGrouppassword() == null) {
                    ModalWindowUtils.popup(data, "Self-registration not possible",
                            "Self-registration for this game is not possible at the moment.<br>Configuration error. Pleasy try later.",
                            "start();");
                    s.append(endPickTable());
                }

                else {
                    s.append("    <tr>\n");
                    s.append("      <td width=\"25%\">Password</td>\n");
                    s.append("      <td width=\"75%\">\n");
                    s.append("      <input type=\"password\" name=\"password\" />");
                    s.append("      </td>\n");
                    s.append("    </tr>\n");
                    s.append(endPickTable());

                    s.append("<br/>\n<span>\n");
                    s.append("  <button type=\"submit\" class=\"tg-register-button\" "
                            + " onclick=\"return submitPassword(" + data.getSelectedGamePlayId() + ");\" >"
                            + "REGISTER AS NEW USER</button>\n");
                    s.append("</span>\n");
                }
            } else {
                s.append(endPickTable());
            }

            s.append(endForm());
        }

        return s.toString();
    }

    private static void makeNewUser(HttpServletRequest request, HttpSession session, RegisterData data)
            throws ServletException {

        if (data.getSelectedGamePlayId() == 0) {
            data.setContentHtml(makeGamePlayPicklist(session, data, 0));
            return;
        }

        GameplayRecord gamePlay = SqlUtils.readGamePlayFromGamePlayId(data, data.getSelectedGamePlayId());

        String groupPassword = request.getParameter("password");
        MessageDigest mdGroup;
        String hashedGroupPassword;
        try {
            // https://www.baeldung.com/java-md5
            mdGroup = MessageDigest.getInstance("MD5");
            mdGroup.update(groupPassword.getBytes());
            byte[] digest = mdGroup.digest();
            hashedGroupPassword = DatatypeConverter.printHexBinary(digest).toLowerCase();
        } catch (NoSuchAlgorithmException e1) {
            throw new ServletException(e1);
        }

        if (!hashedGroupPassword.equals(gamePlay.getGrouppassword())) {
            ModalWindowUtils.popup(data, "Wrong password", "Wrong password for selected game", "start();");
        } else {
            DSLContext dslContext = DSL.using(data.getDataSource(), SQLDialect.MYSQL);
            UserRecord user = dslContext.newRecord(Tables.USER);
            String userCode = makeUniqueUserCode(data);
            user.setUsercode(userCode);
            user.set(Tables.USER.USERGROUP_ID, gamePlay.getAutoregisterusergroupId());
            user.set(Tables.USER.CREATETIME, LocalDateTime.now());
            String hashedPassword = "";
            String userPassword = UUID.randomUUID().toString();
            MessageDigest mdUser;
            try {
                // https://www.baeldung.com/java-md5
                mdUser = MessageDigest.getInstance("MD5");
                mdUser.update(userPassword.getBytes());
                byte[] digest = mdUser.digest();
                hashedPassword = DatatypeConverter.printHexBinary(digest).toLowerCase();
            } catch (NoSuchAlgorithmException e1) {
                throw new RuntimeException(e1);
            }
            user.set(Tables.USER.PASSWORD, hashedPassword); // restore old password if not changed
            user.setAdministrator((byte) 0);
            user.setEmail("");
            String name = gamePlay.getUsernameprefix() + "_" + userCode;
            user.setName(name);
            user.setUsername(name);
            user.store();

            GameuserRecord gameUser = initializeGameUser(data, gamePlay);
            gameUser.setUserId(user.getId());
            gameUser.store();

            String content = "<p>Your registration code is <span class=\"tg-register-code\">" + userCode
                    + "</span></p><br>\n";
            if (gamePlay.getAutoregistertext() != null)
                content += gamePlay.getAutoregistertext() + "\n";
            else
                content += "<p>Write it down as you will need it to log on</p>\n";
            ModalWindowUtils.popup(data, "Registration successful", content, "start();");
        }
    }

    /** make unique user code */
    private static String makeUniqueUserCode(RegisterData data) {
        DSLContext dslContext = DSL.using(data.getDataSource(), SQLDialect.MYSQL);
        String chars = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789";
        String code = "";
        boolean same = true;
        while (same) {
            Random r = new Random();
            code = "";
            for (int i = 0; i < 5; i++) {
                int p = r.nextInt(chars.length()); // bounds is exclusive
                code += chars.charAt(p);
            }
            UserRecord codeUser = dslContext.selectFrom(Tables.USER).where(Tables.USER.USERCODE.eq(code)).fetchAny();
            same = codeUser != null;
        }
        return code;
    }

    private static GameuserRecord initializeGameUser(RegisterData data, GameplayRecord gamePlay) {
        DSLContext dslContext = DSL.using(data.getDataSource(), SQLDialect.MYSQL);
        GameuserRecord gameUser = dslContext.newRecord(Tables.GAMEUSER);
        int gameId = gamePlay.getGameId();
        GameRecord game = SqlUtils.readGameFromGameId(data, gameId);
        gameUser.setGameplayId(gamePlay.getId());
        MissionRecord mission = SqlUtils.readMissionFromGameId(data, game.getId());
        gameUser.setScoreprofit(mission.getStartprofit());
        gameUser.setScoresatisfaction(mission.getStartsatisfaction());
        gameUser.setScoresustainability(mission.getStartsustainability());
        gameUser.setRoundnumber(UInteger.valueOf(1));
        gameUser.setRoundstatus(0);
        return gameUser;
    }

}
