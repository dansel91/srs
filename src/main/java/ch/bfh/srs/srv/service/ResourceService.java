/*
 * Copyright (c) 2015 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.srs.srv.service;

import ch.bfh.srs.srv.entity.Resource;
import org.apache.commons.lang.NotImplementedException;

import java.util.List;

public class ResourceService extends BaseService<Resource> {

    public boolean addResource(int organisationId, String name) {
        throw new NotImplementedException();
    }

    public List<Resource> getResources() {
        throw new NotImplementedException();
    }

    public Resource getResource(int id) {
        throw new NotImplementedException();
    }

    public boolean deleteResource(int resourceId) {
        throw new NotImplementedException();
    }

    public boolean modResource(int resourceId, String name) {
        throw new NotImplementedException();
    }
}
