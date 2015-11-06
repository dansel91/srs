/*
 * Copyright (c) 2015 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.srs.srv.service;

import org.joda.time.DateTime;
import org.apache.commons.lang.NotImplementedException;

public class TimeframeService extends BaseService {

    public boolean addTimeframe(int resourceId, String name, DateTime start, DateTime end){
        throw new NotImplementedException();
    }

    public boolean modTimeframe(int timeframeId, String name, DateTime start, DateTime end){
        throw new NotImplementedException();
    }

    public boolean deleteTimeframe(int timeframeId){
        throw new NotImplementedException();
    }
}
