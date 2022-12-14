/*
 * This file is generated by jOOQ.
 */
package org.transsonic.trustgame.data.trustgame;


import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.transsonic.trustgame.data.trustgame.tables.Carrier;
import org.transsonic.trustgame.data.trustgame.tables.Carrierreview;
import org.transsonic.trustgame.data.trustgame.tables.Client;
import org.transsonic.trustgame.data.trustgame.tables.Fbreport;
import org.transsonic.trustgame.data.trustgame.tables.Gameplay;
import org.transsonic.trustgame.data.trustgame.tables.Gameuser;
import org.transsonic.trustgame.data.trustgame.tables.Mission;
import org.transsonic.trustgame.data.trustgame.tables.Order;
import org.transsonic.trustgame.data.trustgame.tables.Ordercarrier;
import org.transsonic.trustgame.data.trustgame.tables.Review;
import org.transsonic.trustgame.data.trustgame.tables.Round;
import org.transsonic.trustgame.data.trustgame.tables.Selectedcarrier;
import org.transsonic.trustgame.data.trustgame.tables.User;
import org.transsonic.trustgame.data.trustgame.tables.Usercarrier;
import org.transsonic.trustgame.data.trustgame.tables.Userclick;
import org.transsonic.trustgame.data.trustgame.tables.Userorder;
import org.transsonic.trustgame.data.trustgame.tables.Userround;


/**
 * A class modelling indexes of tables in trustgame.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index CARRIER_FK_CARRIER_GAME1_IDX = Internal.createIndex(DSL.name("fk_Carrier_Game1_idx"), Carrier.CARRIER, new OrderField[] { Carrier.CARRIER.GAME_ID }, false);
    public static final Index CARRIERREVIEW_FK_CARRIERREVIEW_CARRIER1_IDX = Internal.createIndex(DSL.name("fk_CarrierReview_Carrier1_idx"), Carrierreview.CARRIERREVIEW, new OrderField[] { Carrierreview.CARRIERREVIEW.CARRIER_ID }, false);
    public static final Index CARRIERREVIEW_FK_CARRIERREVIEW_ROUND1_IDX = Internal.createIndex(DSL.name("fk_CarrierReview_Round1_idx"), Carrierreview.CARRIERREVIEW, new OrderField[] { Carrierreview.CARRIERREVIEW.ROUND_ID }, false);
    public static final Index CLIENT_FK_CLIENT_GAME1_IDX = Internal.createIndex(DSL.name("fk_Client_Game1_idx"), Client.CLIENT, new OrderField[] { Client.CLIENT.GAME_ID }, false);
    public static final Index FBREPORT_FK_FBREPORT_CARRIER1_IDX = Internal.createIndex(DSL.name("fk_FBReport_Carrier1_idx"), Fbreport.FBREPORT, new OrderField[] { Fbreport.FBREPORT.CARRIER_ID }, false);
    public static final Index GAMEPLAY_FK_GAMEPLAY_BRIEFING1_IDX = Internal.createIndex(DSL.name("fk_GamePlay_Briefing1_idx"), Gameplay.GAMEPLAY, new OrderField[] { Gameplay.GAMEPLAY.BRIEFING_ID }, false);
    public static final Index GAMEPLAY_FK_GAMEPLAY_BRIEFING2_IDX = Internal.createIndex(DSL.name("fk_GamePlay_Briefing2_idx"), Gameplay.GAMEPLAY, new OrderField[] { Gameplay.GAMEPLAY.DEBRIEFING_ID }, false);
    public static final Index GAMEPLAY_FK_GAMEPLAY_BRIEFING3_IDX = Internal.createIndex(DSL.name("fk_GamePlay_Briefing3_idx"), Gameplay.GAMEPLAY, new OrderField[] { Gameplay.GAMEPLAY.HELP_ID }, false);
    public static final Index GAMEPLAY_FK_GAMEPLAY_GAME1_IDX = Internal.createIndex(DSL.name("fk_GamePlay_Game1_idx"), Gameplay.GAMEPLAY, new OrderField[] { Gameplay.GAMEPLAY.GAME_ID }, false);
    public static final Index GAMEPLAY_FK_GAMEPLAY_USERGROUP1_IDX = Internal.createIndex(DSL.name("fk_GamePlay_UserGroup1_idx"), Gameplay.GAMEPLAY, new OrderField[] { Gameplay.GAMEPLAY.AUTOREGISTERUSERGROUP_ID }, false);
    public static final Index USERROUND_FK_GAMEPLAYROUND_GAMEPLAY1_IDX = Internal.createIndex(DSL.name("fk_GamePlayRound_GamePlay1_idx"), Userround.USERROUND, new OrderField[] { Userround.USERROUND.GAMEPLAY_ID }, false);
    public static final Index USERROUND_FK_GAMEPLAYROUND_ROUND1_IDX = Internal.createIndex(DSL.name("fk_GamePlayRound_Round1_idx"), Userround.USERROUND, new OrderField[] { Userround.USERROUND.ROUND_ID }, false);
    public static final Index USERROUND_FK_GAMEPLAYROUND_USER1_IDX = Internal.createIndex(DSL.name("fk_GamePlayRound_User1_idx"), Userround.USERROUND, new OrderField[] { Userround.USERROUND.GAMEUSER_ID }, false);
    public static final Index MISSION_FK_MISSION_GAME1_IDX = Internal.createIndex(DSL.name("fk_Mission_Game1_idx"), Mission.MISSION, new OrderField[] { Mission.MISSION.GAME_ID }, false);
    public static final Index ORDER_FK_ORDER_CUSTOMER1_IDX = Internal.createIndex(DSL.name("fk_Order_Customer1_idx"), Order.ORDER, new OrderField[] { Order.ORDER.CLIENT_ID }, false);
    public static final Index ORDER_FK_ORDER_ROUND1_IDX = Internal.createIndex(DSL.name("fk_Order_Round1_idx"), Order.ORDER, new OrderField[] { Order.ORDER.ROUND_ID }, false);
    public static final Index ORDERCARRIER_FK_ORDERCARRIER_CARRIER1_IDX = Internal.createIndex(DSL.name("fk_OrderCarrier_Carrier1_idx"), Ordercarrier.ORDERCARRIER, new OrderField[] { Ordercarrier.ORDERCARRIER.CARRIER_ID }, false);
    public static final Index ORDERCARRIER_FK_ORDERCARRIER_ORDER1_IDX = Internal.createIndex(DSL.name("fk_OrderCarrier_Order1_idx"), Ordercarrier.ORDERCARRIER, new OrderField[] { Ordercarrier.ORDERCARRIER.ORDER_ID }, false);
    public static final Index REVIEW_FK_REVIEW_CARRIER1_IDX = Internal.createIndex(DSL.name("fk_Review_Carrier1_idx"), Review.REVIEW, new OrderField[] { Review.REVIEW.CARRIER_ID }, false);
    public static final Index REVIEW_FK_REVIEW_ROUND1_IDX = Internal.createIndex(DSL.name("fk_Review_Round1_idx"), Review.REVIEW, new OrderField[] { Review.REVIEW.ROUND_ID }, false);
    public static final Index ROUND_FK_ROUND_GAME_IDX = Internal.createIndex(DSL.name("fk_Round_Game_idx"), Round.ROUND, new OrderField[] { Round.ROUND.GAME_ID }, false);
    public static final Index SELECTEDCARRIER_FK_SELECTEDCARRIER_ORDERCARRIER1_IDX = Internal.createIndex(DSL.name("fk_SelectedCarrier_OrderCarrier1_idx"), Selectedcarrier.SELECTEDCARRIER, new OrderField[] { Selectedcarrier.SELECTEDCARRIER.ORDERCARRIER_ID }, false);
    public static final Index SELECTEDCARRIER_FK_SELECTEDCARRIER_USERORDER1_IDX = Internal.createIndex(DSL.name("fk_SelectedCarrier_UserOrder1_idx"), Selectedcarrier.SELECTEDCARRIER, new OrderField[] { Selectedcarrier.SELECTEDCARRIER.USERORDER_ID }, false);
    public static final Index GAMEUSER_FK_USER_GAMEPLAY1_IDX = Internal.createIndex(DSL.name("fk_User_GamePlay1_idx"), Gameuser.GAMEUSER, new OrderField[] { Gameuser.GAMEUSER.GAMEPLAY_ID }, false);
    public static final Index USER_FK_USER_USERGROUP1_IDX = Internal.createIndex(DSL.name("fk_User_UserGroup1_idx"), User.USER, new OrderField[] { User.USER.USERGROUP_ID }, false);
    public static final Index GAMEUSER_FK_USER_USERS1_IDX = Internal.createIndex(DSL.name("fk_User_users1_idx"), Gameuser.GAMEUSER, new OrderField[] { Gameuser.GAMEUSER.USER_ID }, false);
    public static final Index USERCARRIER_FK_USERCARRIER_CARRIER_IDX = Internal.createIndex(DSL.name("fk_UserCarrier_Carrier_idx"), Usercarrier.USERCARRIER, new OrderField[] { Usercarrier.USERCARRIER.CARRIER_ID }, false);
    public static final Index USERCARRIER_FK_USERCARRIER_GAMEUSER_IDX = Internal.createIndex(DSL.name("fk_UserCarrier_GameUser_idx"), Usercarrier.USERCARRIER, new OrderField[] { Usercarrier.USERCARRIER.GAMEUSER_ID }, false);
    public static final Index USERCLICK_FK_USERCLICK_GAMEUSER_IDX = Internal.createIndex(DSL.name("fk_UserClick_GameUser_idx"), Userclick.USERCLICK, new OrderField[] { Userclick.USERCLICK.GAMEUSER_ID }, false);
    public static final Index USERORDER_FK_USERORDER_GAMEPLAYROUND1_IDX = Internal.createIndex(DSL.name("fk_UserOrder_GamePlayRound1_idx"), Userorder.USERORDER, new OrderField[] { Userorder.USERORDER.USERROUND_ID }, false);
    public static final Index USERORDER_FK_USERORDER_ORDER1_IDX = Internal.createIndex(DSL.name("fk_UserOrder_Order1_idx"), Userorder.USERORDER, new OrderField[] { Userorder.USERORDER.ORDER_ID }, false);
}
