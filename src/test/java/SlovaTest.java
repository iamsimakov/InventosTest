import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Alex on 18.12.2015.
 */
public class SlovaTest {
    @Test
    public void testAddSymbol() throws Exception {
        Assert.assertEquals(Slova.addSymbol("011", 4), "0110");
        Assert.assertEquals(Slova.addSymbol("111", 4), "1111");
        Assert.assertEquals(Slova.addSymbol("100", 4), "1001");
    }

    @Test
    public void testSum() throws Exception {
        Assert.assertEquals(Slova.sum("011"), 5);
    }

    @Test
    public void testRemoveSymbol() throws Exception {
        Assert.assertEquals(Slova.removeSymbol("11011", 4), "1111");
    }

    @Test
    public void testReplaceSymbols() throws Exception {
        Assert.assertEquals(Slova.replaceSymbols("0000", 4), "0000");
        Assert.assertEquals(Slova.replaceSymbols("1111", 4), "1111");
        Assert.assertEquals(Slova.replaceSymbols("1011", 4), "1001");
    }
}