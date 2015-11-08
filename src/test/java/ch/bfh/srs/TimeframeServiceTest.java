package ch.bfh.srs;

import ch.bfh.srs.srv.service.TimeframeService;
import org.apache.commons.lang.NotImplementedException;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TimeframeServiceTest {

    TimeframeService service;

    @Before
    public void setUp() {
        service = new TimeframeService();
    }

    @Test(expected = NotImplementedException.class)
    public void testAddTimeframe() {
        boolean added = service.addTimeframe(1, "Testframe", DateTime.now(), DateTime.now());
        assertTrue(added);
    }

    @Test(expected = NotImplementedException.class)
    public void testModTimeframe() {
        boolean modified = service.modTimeframe(1, "Testframe modified", DateTime.now(), DateTime.now());
        assertTrue(modified);
    }

    @Test(expected = NotImplementedException.class)
    public void testDeleteTimeframe() {
        boolean deleted = service.deleteTimeframe(1);
        assertTrue(deleted);
    }

}
