/*
 * This file is generated by jOOQ.
 */
package org.transsonic.trustgame.data.trustgame.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.transsonic.trustgame.data.trustgame.Keys;
import org.transsonic.trustgame.data.trustgame.Trustgame;
import org.transsonic.trustgame.data.trustgame.tables.records.UsergroupRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Usergroup extends TableImpl<UsergroupRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>trustgame.usergroup</code>
     */
    public static final Usergroup USERGROUP = new Usergroup();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsergroupRecord> getRecordType() {
        return UsergroupRecord.class;
    }

    /**
     * The column <code>trustgame.usergroup.ID</code>.
     */
    public final TableField<UsergroupRecord, Integer> ID = createField(DSL.name("ID"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>trustgame.usergroup.GroupName</code>.
     */
    public final TableField<UsergroupRecord, String> GROUPNAME = createField(DSL.name("GroupName"), SQLDataType.VARCHAR(45).nullable(false), this, "");

    private Usergroup(Name alias, Table<UsergroupRecord> aliased) {
        this(alias, aliased, null);
    }

    private Usergroup(Name alias, Table<UsergroupRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>trustgame.usergroup</code> table reference
     */
    public Usergroup(String alias) {
        this(DSL.name(alias), USERGROUP);
    }

    /**
     * Create an aliased <code>trustgame.usergroup</code> table reference
     */
    public Usergroup(Name alias) {
        this(alias, USERGROUP);
    }

    /**
     * Create a <code>trustgame.usergroup</code> table reference
     */
    public Usergroup() {
        this(DSL.name("usergroup"), null);
    }

    public <O extends Record> Usergroup(Table<O> child, ForeignKey<O, UsergroupRecord> key) {
        super(child, key, USERGROUP);
    }

    @Override
    public Schema getSchema() {
        return Trustgame.TRUSTGAME;
    }

    @Override
    public Identity<UsergroupRecord, Integer> getIdentity() {
        return (Identity<UsergroupRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<UsergroupRecord> getPrimaryKey() {
        return Keys.KEY_USERGROUP_PRIMARY;
    }

    @Override
    public List<UniqueKey<UsergroupRecord>> getKeys() {
        return Arrays.<UniqueKey<UsergroupRecord>>asList(Keys.KEY_USERGROUP_PRIMARY, Keys.KEY_USERGROUP_ID_UNIQUE);
    }

    @Override
    public Usergroup as(String alias) {
        return new Usergroup(DSL.name(alias), this);
    }

    @Override
    public Usergroup as(Name alias) {
        return new Usergroup(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Usergroup rename(String name) {
        return new Usergroup(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Usergroup rename(Name name) {
        return new Usergroup(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
