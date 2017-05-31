package com.ste9206.beerapplication.realm;

import java.util.Date;

import javax.inject.Inject;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by stefano on 29/05/17.
 */
public class LastUpdate extends RealmObject{

    @Inject
    public LastUpdate() {
    }

    private Date lastUpdate;

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
