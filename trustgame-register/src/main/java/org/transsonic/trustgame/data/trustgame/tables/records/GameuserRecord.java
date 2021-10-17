/*
 * This file is generated by jOOQ.
 */
package org.transsonic.trustgame.data.trustgame.tables.records;


import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;
import org.transsonic.trustgame.data.trustgame.tables.Gameuser;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class GameuserRecord extends UpdatableRecordImpl<GameuserRecord> implements Record9<Integer, Integer, Integer, LocalDateTime, Integer, Integer, Integer, UInteger, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>trustgame.gameuser.ID</code>. Users could self-regster or be created upfront. Users are unique per GamePlay.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>trustgame.gameuser.ID</code>. Users could self-regster or be created upfront. Users are unique per GamePlay.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>trustgame.gameuser.GamePlay_ID</code>.
     */
    public void setGameplayId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>trustgame.gameuser.GamePlay_ID</code>.
     */
    public Integer getGameplayId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>trustgame.gameuser.User_ID</code>.
     */
    public void setUserId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>trustgame.gameuser.User_ID</code>.
     */
    public Integer getUserId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>trustgame.gameuser.FirstLogin</code>.
     */
    public void setFirstlogin(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>trustgame.gameuser.FirstLogin</code>.
     */
    public LocalDateTime getFirstlogin() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>trustgame.gameuser.ScoreProfit</code>. Default filled with Organization.StartProfit. Updated every round.
     */
    public void setScoreprofit(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>trustgame.gameuser.ScoreProfit</code>. Default filled with Organization.StartProfit. Updated every round.
     */
    public Integer getScoreprofit() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>trustgame.gameuser.ScoreSatisfaction</code>. Default filled with Organization.StartSatisfaction. Updated every round.
     */
    public void setScoresatisfaction(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>trustgame.gameuser.ScoreSatisfaction</code>. Default filled with Organization.StartSatisfaction. Updated every round.
     */
    public Integer getScoresatisfaction() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>trustgame.gameuser.ScoreSustainability</code>. Default filled with Organization.StartSustainability. Updated every round.
     */
    public void setScoresustainability(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>trustgame.gameuser.ScoreSustainability</code>. Default filled with Organization.StartSustainability. Updated every round.
     */
    public Integer getScoresustainability() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>trustgame.gameuser.RoundNumber</code>.
     */
    public void setRoundnumber(UInteger value) {
        set(7, value);
    }

    /**
     * Getter for <code>trustgame.gameuser.RoundNumber</code>.
     */
    public UInteger getRoundnumber() {
        return (UInteger) get(7);
    }

    /**
     * Setter for <code>trustgame.gameuser.RoundStatus</code>. When RoundStatus is 0, order confirmation takes place. The top-right button is grey and contains 'Start of day'.
When RoundStatus is 1, the user has finished the day and can start scoring the transport. The top-right button is active and contains 'Finish day'.
When RoundSttaus is 2, the user has finished scoring, and can go to the next day. The top-right button is active and contains Go to next day'.
     */
    public void setRoundstatus(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>trustgame.gameuser.RoundStatus</code>. When RoundStatus is 0, order confirmation takes place. The top-right button is grey and contains 'Start of day'.
When RoundStatus is 1, the user has finished the day and can start scoring the transport. The top-right button is active and contains 'Finish day'.
When RoundSttaus is 2, the user has finished scoring, and can go to the next day. The top-right button is active and contains Go to next day'.
     */
    public Integer getRoundstatus() {
        return (Integer) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, Integer, Integer, LocalDateTime, Integer, Integer, Integer, UInteger, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Integer, Integer, Integer, LocalDateTime, Integer, Integer, Integer, UInteger, Integer> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Gameuser.GAMEUSER.ID;
    }

    @Override
    public Field<Integer> field2() {
        return Gameuser.GAMEUSER.GAMEPLAY_ID;
    }

    @Override
    public Field<Integer> field3() {
        return Gameuser.GAMEUSER.USER_ID;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Gameuser.GAMEUSER.FIRSTLOGIN;
    }

    @Override
    public Field<Integer> field5() {
        return Gameuser.GAMEUSER.SCOREPROFIT;
    }

    @Override
    public Field<Integer> field6() {
        return Gameuser.GAMEUSER.SCORESATISFACTION;
    }

    @Override
    public Field<Integer> field7() {
        return Gameuser.GAMEUSER.SCORESUSTAINABILITY;
    }

    @Override
    public Field<UInteger> field8() {
        return Gameuser.GAMEUSER.ROUNDNUMBER;
    }

    @Override
    public Field<Integer> field9() {
        return Gameuser.GAMEUSER.ROUNDSTATUS;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getGameplayId();
    }

    @Override
    public Integer component3() {
        return getUserId();
    }

    @Override
    public LocalDateTime component4() {
        return getFirstlogin();
    }

    @Override
    public Integer component5() {
        return getScoreprofit();
    }

    @Override
    public Integer component6() {
        return getScoresatisfaction();
    }

    @Override
    public Integer component7() {
        return getScoresustainability();
    }

    @Override
    public UInteger component8() {
        return getRoundnumber();
    }

    @Override
    public Integer component9() {
        return getRoundstatus();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getGameplayId();
    }

    @Override
    public Integer value3() {
        return getUserId();
    }

    @Override
    public LocalDateTime value4() {
        return getFirstlogin();
    }

    @Override
    public Integer value5() {
        return getScoreprofit();
    }

    @Override
    public Integer value6() {
        return getScoresatisfaction();
    }

    @Override
    public Integer value7() {
        return getScoresustainability();
    }

    @Override
    public UInteger value8() {
        return getRoundnumber();
    }

    @Override
    public Integer value9() {
        return getRoundstatus();
    }

    @Override
    public GameuserRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public GameuserRecord value2(Integer value) {
        setGameplayId(value);
        return this;
    }

    @Override
    public GameuserRecord value3(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public GameuserRecord value4(LocalDateTime value) {
        setFirstlogin(value);
        return this;
    }

    @Override
    public GameuserRecord value5(Integer value) {
        setScoreprofit(value);
        return this;
    }

    @Override
    public GameuserRecord value6(Integer value) {
        setScoresatisfaction(value);
        return this;
    }

    @Override
    public GameuserRecord value7(Integer value) {
        setScoresustainability(value);
        return this;
    }

    @Override
    public GameuserRecord value8(UInteger value) {
        setRoundnumber(value);
        return this;
    }

    @Override
    public GameuserRecord value9(Integer value) {
        setRoundstatus(value);
        return this;
    }

    @Override
    public GameuserRecord values(Integer value1, Integer value2, Integer value3, LocalDateTime value4, Integer value5, Integer value6, Integer value7, UInteger value8, Integer value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GameuserRecord
     */
    public GameuserRecord() {
        super(Gameuser.GAMEUSER);
    }

    /**
     * Create a detached, initialised GameuserRecord
     */
    public GameuserRecord(Integer id, Integer gameplayId, Integer userId, LocalDateTime firstlogin, Integer scoreprofit, Integer scoresatisfaction, Integer scoresustainability, UInteger roundnumber, Integer roundstatus) {
        super(Gameuser.GAMEUSER);

        setId(id);
        setGameplayId(gameplayId);
        setUserId(userId);
        setFirstlogin(firstlogin);
        setScoreprofit(scoreprofit);
        setScoresatisfaction(scoresatisfaction);
        setScoresustainability(scoresustainability);
        setRoundnumber(roundnumber);
        setRoundstatus(roundstatus);
    }
}
