package ch.bfh.srs.srv.service;

import org.joda.time.DateTime;
import org.apache.commons.lang.NotImplementedException;

public class TimeframeService extends BaseService {

    public boolean addTimeframe(Integer resourceId, String name, DateTime start, DateTime end){
        throw new NotImplementedException();
    }

    public boolean modTimeframe(Integer timeframeId, String name, DateTime start, DateTime end){
        throw new NotImplementedException();
    }

    public boolean deleteTimeframe(Integer timeframeId){
        throw new NotImplementedException();
    }
}
