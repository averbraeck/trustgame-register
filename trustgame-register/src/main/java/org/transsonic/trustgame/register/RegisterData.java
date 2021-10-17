package org.transsonic.trustgame.register;

import javax.sql.DataSource;

public class RegisterData {

    /**
     * the SQL datasource representing the database's connection pool.<br>
     * the datasource is shared among the servlets and stored as a ServletContext attribute.
     */
    private DataSource dataSource;

    /* ================================= */
    /* FULLY DYNAMIC INFO IN THE SESSION */
    /* ================================= */

    /**
     * The content of the screen.
     */
    private String contentHtml = "";

    /**
     * The state of the screen: 0 = no gameplay selected; 1 = gameplay selected, 2 = password given.
     */
    private int state = 0;

    /** the selected gamePlay. */
    private int selectedGamePlayId = 0;

    /**
     * when 0, do not show popup; when 1: show popup. <br>
     * filled and updated by RoundServlet.
     */
    private int showModalWindow = 0;

    /**
     * client info (dynamic) for popup.
     */
    private String modalWindowHtml = "";

    /* ******************* */
    /* GETTERS AND SETTERS */
    /* ******************* */

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getModalWindowHtml() {
        return modalWindowHtml;
    }

    public void setModalWindowHtml(String modalClientWindowHtml) {
        this.modalWindowHtml = modalClientWindowHtml;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    public int getShowModalWindow() {
        return showModalWindow;
    }

    public void setShowModalWindow(int showModalWindow) {
        this.showModalWindow = showModalWindow;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSelectedGamePlayId() {
        return selectedGamePlayId;
    }

    public void setSelectedGamePlayId(int selectedGamePlay) {
        this.selectedGamePlayId = selectedGamePlay;
    }
}
