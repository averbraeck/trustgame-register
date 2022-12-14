/*
 * This file is generated by jOOQ.
 */
package org.transsonic.trustgame.data.trustgame.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row14;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.transsonic.trustgame.data.trustgame.Indexes;
import org.transsonic.trustgame.data.trustgame.Keys;
import org.transsonic.trustgame.data.trustgame.Trustgame;
import org.transsonic.trustgame.data.trustgame.tables.records.GameplayRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Gameplay extends TableImpl<GameplayRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>trustgame.gameplay</code>
     */
    public static final Gameplay GAMEPLAY = new Gameplay();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GameplayRecord> getRecordType() {
        return GameplayRecord.class;
    }

    /**
     * The column <code>trustgame.gameplay.ID</code>.
     */
    public final TableField<GameplayRecord, Integer> ID = createField(DSL.name("ID"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>trustgame.gameplay.Game_ID</code>.
     */
    public final TableField<GameplayRecord, Integer> GAME_ID = createField(DSL.name("Game_ID"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>trustgame.gameplay.GroupDescription</code>.
     */
    public final TableField<GameplayRecord, String> GROUPDESCRIPTION = createField(DSL.name("GroupDescription"), SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>trustgame.gameplay.StartPlayDate</code>. NULL means no restrictions
     */
    public final TableField<GameplayRecord, LocalDateTime> STARTPLAYDATE = createField(DSL.name("StartPlayDate"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field("NULL", SQLDataType.LOCALDATETIME)), this, "NULL means no restrictions");

    /**
     * The column <code>trustgame.gameplay.EndPlayDate</code>. NULL means no restrictions
     */
    public final TableField<GameplayRecord, LocalDateTime> ENDPLAYDATE = createField(DSL.name("EndPlayDate"), SQLDataType.LOCALDATETIME(0).defaultValue(DSL.field("NULL", SQLDataType.LOCALDATETIME)), this, "NULL means no restrictions");

    /**
     * The column <code>trustgame.gameplay.Briefing_ID</code>.
     */
    public final TableField<GameplayRecord, Integer> BRIEFING_ID = createField(DSL.name("Briefing_ID"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>trustgame.gameplay.Debriefing_ID</code>.
     */
    public final TableField<GameplayRecord, Integer> DEBRIEFING_ID = createField(DSL.name("Debriefing_ID"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>trustgame.gameplay.Help_ID</code>.
     */
    public final TableField<GameplayRecord, Integer> HELP_ID = createField(DSL.name("Help_ID"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>trustgame.gameplay.Autoregister</code>.
     */
    public final TableField<GameplayRecord, Byte> AUTOREGISTER = createField(DSL.name("Autoregister"), SQLDataType.TINYINT.nullable(false).defaultValue(DSL.field("0", SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>trustgame.gameplay.GroupPassword</code>.
     */
    public final TableField<GameplayRecord, String> GROUPPASSWORD = createField(DSL.name("GroupPassword"), SQLDataType.VARCHAR(90).defaultValue(DSL.field("''", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>trustgame.gameplay.UsernamePrefix</code>.
     */
    public final TableField<GameplayRecord, String> USERNAMEPREFIX = createField(DSL.name("UsernamePrefix"), SQLDataType.VARCHAR(16).defaultValue(DSL.field("''", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>trustgame.gameplay.AutoregisterText</code>.
     */
    public final TableField<GameplayRecord, String> AUTOREGISTERTEXT = createField(DSL.name("AutoregisterText"), SQLDataType.CLOB.defaultValue(DSL.field("NULL", SQLDataType.CLOB)), this, "");

    /**
     * The column <code>trustgame.gameplay.AutoregisterUserGroup_ID</code>.
     */
    public final TableField<GameplayRecord, Integer> AUTOREGISTERUSERGROUP_ID = createField(DSL.name("AutoregisterUserGroup_ID"), SQLDataType.INTEGER.defaultValue(DSL.field("NULL", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>trustgame.gameplay.AutoregisterLink</code>.
     */
    public final TableField<GameplayRecord, String> AUTOREGISTERLINK = createField(DSL.name("AutoregisterLink"), SQLDataType.VARCHAR(90).defaultValue(DSL.field("NULL", SQLDataType.VARCHAR)), this, "");

    private Gameplay(Name alias, Table<GameplayRecord> aliased) {
        this(alias, aliased, null);
    }

    private Gameplay(Name alias, Table<GameplayRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>trustgame.gameplay</code> table reference
     */
    public Gameplay(String alias) {
        this(DSL.name(alias), GAMEPLAY);
    }

    /**
     * Create an aliased <code>trustgame.gameplay</code> table reference
     */
    public Gameplay(Name alias) {
        this(alias, GAMEPLAY);
    }

    /**
     * Create a <code>trustgame.gameplay</code> table reference
     */
    public Gameplay() {
        this(DSL.name("gameplay"), null);
    }

    public <O extends Record> Gameplay(Table<O> child, ForeignKey<O, GameplayRecord> key) {
        super(child, key, GAMEPLAY);
    }

    @Override
    public Schema getSchema() {
        return Trustgame.TRUSTGAME;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.GAMEPLAY_FK_GAMEPLAY_BRIEFING1_IDX, Indexes.GAMEPLAY_FK_GAMEPLAY_BRIEFING2_IDX, Indexes.GAMEPLAY_FK_GAMEPLAY_BRIEFING3_IDX, Indexes.GAMEPLAY_FK_GAMEPLAY_GAME1_IDX, Indexes.GAMEPLAY_FK_GAMEPLAY_USERGROUP1_IDX);
    }

    @Override
    public Identity<GameplayRecord, Integer> getIdentity() {
        return (Identity<GameplayRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<GameplayRecord> getPrimaryKey() {
        return Keys.KEY_GAMEPLAY_PRIMARY;
    }

    @Override
    public List<UniqueKey<GameplayRecord>> getKeys() {
        return Arrays.<UniqueKey<GameplayRecord>>asList(Keys.KEY_GAMEPLAY_PRIMARY, Keys.KEY_GAMEPLAY_ID_UNIQUE);
    }

    @Override
    public List<ForeignKey<GameplayRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<GameplayRecord, ?>>asList(Keys.FK_GAMEPLAY_GAME1, Keys.FK_GAMEPLAY_BRIEFING1, Keys.FK_GAMEPLAY_BRIEFING2, Keys.FK_GAMEPLAY_BRIEFING3, Keys.FK_GAMEPLAY_USERGROUP1);
    }

    private transient Game _game;
    private transient Briefing _fkGameplayBriefing1;
    private transient Briefing _fkGameplayBriefing2;
    private transient Briefing _fkGameplayBriefing3;
    private transient Usergroup _usergroup;

    public Game game() {
        if (_game == null)
            _game = new Game(this, Keys.FK_GAMEPLAY_GAME1);

        return _game;
    }

    public Briefing fkGameplayBriefing1() {
        if (_fkGameplayBriefing1 == null)
            _fkGameplayBriefing1 = new Briefing(this, Keys.FK_GAMEPLAY_BRIEFING1);

        return _fkGameplayBriefing1;
    }

    public Briefing fkGameplayBriefing2() {
        if (_fkGameplayBriefing2 == null)
            _fkGameplayBriefing2 = new Briefing(this, Keys.FK_GAMEPLAY_BRIEFING2);

        return _fkGameplayBriefing2;
    }

    public Briefing fkGameplayBriefing3() {
        if (_fkGameplayBriefing3 == null)
            _fkGameplayBriefing3 = new Briefing(this, Keys.FK_GAMEPLAY_BRIEFING3);

        return _fkGameplayBriefing3;
    }

    public Usergroup usergroup() {
        if (_usergroup == null)
            _usergroup = new Usergroup(this, Keys.FK_GAMEPLAY_USERGROUP1);

        return _usergroup;
    }

    @Override
    public Gameplay as(String alias) {
        return new Gameplay(DSL.name(alias), this);
    }

    @Override
    public Gameplay as(Name alias) {
        return new Gameplay(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Gameplay rename(String name) {
        return new Gameplay(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Gameplay rename(Name name) {
        return new Gameplay(name, null);
    }

    // -------------------------------------------------------------------------
    // Row14 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row14<Integer, Integer, String, LocalDateTime, LocalDateTime, Integer, Integer, Integer, Byte, String, String, String, Integer, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }
}
