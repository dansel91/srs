package ch.bfh.srs;

import ch.bfh.srs.srv.entity.Resource;
import ch.bfh.srs.srv.service.ResourceService;
import org.apache.commons.lang.NotImplementedException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ResourceServiceTest {

    ResourceService service;

    @Before
    public void setUp() {
        service = new ResourceService();
    }

    @Test(expected = NotImplementedException.class)
    public void testAddResource() {
        boolean added = service.addResource(1, "Tennisplatz 1");
        assertTrue(added);
    }

    @Test(expected = NotImplementedException.class)
    public void testGetResources() {
        List<Resource> resources = service.getResources();
        assertTrue(!resources.isEmpty());
    }

    @Test(expected = NotImplementedException.class)
    public void testGetResource() {
        Resource resource = service.getResource(1);
        assertTrue(resource.getName().equals("Test"));
    }

    @Test(expected = NotImplementedException.class)
    public void testDeleteResource() {
        boolean deleted = service.deleteResource(1);
        assertTrue(deleted);
    }

    @Test(expected = NotImplementedException.class)
    public void testModResource() {
        boolean modified = service.modResource(1, "Tennisplatz 4");
        assertTrue(modified);
    }

}
