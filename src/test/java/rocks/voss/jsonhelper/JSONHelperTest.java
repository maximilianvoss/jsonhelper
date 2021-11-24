package rocks.voss.jsonhelper;

import org.junit.Test;
import rocks.voss.jsonhelper.beans.GlossEntryBean;
import rocks.voss.jsonhelper.beans.WrapperBean;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class JSONHelperTest {
    @Test
    public void loadAsStream() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream jsonStream = loader.getResourceAsStream("sample.json");
        WrapperBean wrapper = JSONHelper.createBean(WrapperBean.class, jsonStream);

        assertEquals("example glossary", wrapper.getGlossary().getTitle());
        assertEquals("S", wrapper.getGlossary().getGlossDiv().getTitle());
        assertEquals("SGML", wrapper.getGlossary().getGlossDiv().getGlossList().get(0).getId());
        assertEquals("SGML", wrapper.getGlossary().getGlossDiv().getGlossList().get(0).getSortAs());
        assertEquals("Standard Generalized Markup Language", wrapper.getGlossary().getGlossDiv().getGlossList().get(0).getGlossTerm());
        assertEquals("SGML", wrapper.getGlossary().getGlossDiv().getGlossList().get(0).getAcronym());
        assertEquals("ISO 8879:1986", wrapper.getGlossary().getGlossDiv().getGlossList().get(0).getAbbrev());
        assertEquals("A meta-markup language, used to create markup languages such as DocBook.", wrapper.getGlossary().getGlossDiv().getGlossList().get(0).getGlossDef().getPara());
        assertEquals("GML", wrapper.getGlossary().getGlossDiv().getGlossList().get(0).getGlossDef().getGlossSeeAlso().get(0));
        assertEquals("XML", wrapper.getGlossary().getGlossDiv().getGlossList().get(0).getGlossDef().getGlossSeeAlso().get(1));
        assertEquals("markup", wrapper.getGlossary().getGlossDiv().getGlossList().get(0).getGlossSee());
    }

    @Test
    public void createSubBean() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream jsonStream = loader.getResourceAsStream("sample.json");
        WrapperBean wrapper = JSONHelper.createBean(WrapperBean.class, jsonStream);

        Object tmp = wrapper.getGlossary().getGlossDiv().getGlossList().get(0);
        GlossEntryBean entry = JSONHelper.createBean(GlossEntryBean.class, tmp);

        assertEquals("example glossary", wrapper.getGlossary().getTitle());
        assertEquals("S", wrapper.getGlossary().getGlossDiv().getTitle());
        assertEquals("SGML", entry.getId());
        assertEquals("SGML", entry.getSortAs());
        assertEquals("Standard Generalized Markup Language", entry.getGlossTerm());
        assertEquals("SGML", entry.getAcronym());
        assertEquals("ISO 8879:1986", entry.getAbbrev());
        assertEquals("A meta-markup language, used to create markup languages such as DocBook.", entry.getGlossDef().getPara());
        assertEquals("GML", entry.getGlossDef().getGlossSeeAlso().get(0));
        assertEquals("XML", entry.getGlossDef().getGlossSeeAlso().get(1));
        assertEquals("markup", entry.getGlossSee());
    }
}
