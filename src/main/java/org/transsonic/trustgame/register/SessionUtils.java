package org.transsonic.trustgame.register;

import jakarta.servlet.http.HttpSession;

public final class SessionUtils {

    private SessionUtils() {
        // utility class
    }

    public static RegisterData getData(final HttpSession session) {
        return (RegisterData) session.getAttribute("registerData");
    }

}
