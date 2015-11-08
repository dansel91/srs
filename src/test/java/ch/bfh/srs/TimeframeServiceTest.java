package ch.bfh.srs;

import ch.bfh.srs.srv.entity.Timeframe;
import ch.bfh.srs.srv.service.TimeframeService;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.ObjectUtils;
import org.apache.openjpa.jdbc.kernel.exps.Null;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static junit.framework.Assert.assertEquals;
public class TimeframeServiceTest {

    TimeframeService service;

    @Before
    public void setUp() {
        service = new TimeframeService();
    }

    @Test(expected = NotImplementedException.class)
    public void testAddTimeframe() {
        DateTime from = DateTime.now();
        DateTime to = DateTime.now().plus(1);
        boolean added = service.addTimeframe(1, "Testframe",from, to);
        Timeframe frameEntity = service.getById(Timeframe.ID_NQUERY, 1);
        assertEquals(from, frameEntity.getStart());
        assertEquals(to, frameEntity.getEnd());
        assertTrue(added);
    }

    @Test(expected = NotImplementedException.class)
    public void testModTimeframe() {
        DateTime from = DateTime.now().plus(Period.hours(2));
        DateTime to = DateTime.now().plus(Period.hours(4));
        boolean modified = service.modTimeframe(1, "Testframe modified", from, to);
        assertTrue(modified);
        Timeframe frameEntity = service.getById(Timeframe.ID_NQUERY, 1);
        assertEquals(from, frameEntity.getStart());
        assertEquals(to, frameEntity.getEnd());
    }

    @Test(expected = NotImplementedException.class)
    public void testDeleteTimeframe() {
        boolean deleted = service.deleteTimeframe(1);
        assertTrue(deleted);
        Timeframe frameEntity = service.getById(Timeframe.ID_NQUERY, 1);
        assertNull(frameEntity);
    }

}
