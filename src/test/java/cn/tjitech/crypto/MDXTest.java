package cn.tjitech.crypto;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class MDXTest {
    @Test
    public void testMD2() throws UnsupportedEncodingException {
        assertEquals("1744595340C287247D8F34A966EFC4C5", MDX.md2("中华人民共和国-People Republics of China"));
        assertEquals("1744595340C287247D8F34A966EFC4C5", MDX.md2("中华人民共和国-People Republics of China".getBytes()));

        assertEquals("608DB68511AAC549D4347A34F2FDF437", MDX.md2().enc("gbk").digest("中华人民共和国-People Republics of China"));
        assertEquals("608DB68511AAC549D4347A34F2FDF437", MDX.md2("中华人民共和国-People Republics of China".getBytes("gbk")));

        assertEquals("40C287247D8F34A9", MDX.digester().bit16(true).md2("中华人民共和国-People Republics of China"));
        assertEquals("11AAC549D4347A34", MDX.md2().bit16(true).enc("gbk").digest("中华人民共和国-People Republics of China"));
    }

    @Test
    public void testMD4() throws UnsupportedEncodingException {
        assertEquals("1D461A5641A196CE7DE2FD617CCC1F73", MDX.md4("中华人民共和国-People Republics of China"));
        assertEquals("1D461A5641A196CE7DE2FD617CCC1F73", MDX.md4("中华人民共和国-People Republics of China".getBytes()));

        assertEquals("E5433DAAF8CFBE381458D59A15D5987B", MDX.md4().enc("gbk").digest("中华人民共和国-People Republics of China"));
        assertEquals("E5433DAAF8CFBE381458D59A15D5987B", MDX.md4("中华人民共和国-People Republics of China".getBytes("gbk")));

        assertEquals("41A196CE7DE2FD61", MDX.md4().bit16(true).digest("中华人民共和国-People Republics of China"));
        assertEquals("F8CFBE381458D59A", MDX.md4().bit16(true).enc("gbk").digest("中华人民共和国-People Republics of China"));
    }

    @Test
    public void testMD5() throws UnsupportedEncodingException {
        assertEquals("13545909292D1A93A70513E64A88B81E", MDX.md5("中华人民共和国-People Republics of China"));
        assertEquals("13545909292D1A93A70513E64A88B81E", MDX.md5("中华人民共和国-People Republics of China".getBytes()));

        assertEquals("E464668C447D3F1F7C48FABF2F7A8A62", MDX.md5().enc("gbk").digest("中华人民共和国-People Republics of China"));
        assertEquals("E464668C447D3F1F7C48FABF2F7A8A62", MDX.md5("中华人民共和国-People Republics of China".getBytes("gbk")));

        assertEquals("292D1A93A70513E6", MDX.md5().bit16(true).digest("中华人民共和国-People Republics of China"));
        assertEquals("447D3F1F7C48FABF", MDX.md5().bit16(true).enc("gbk").digest("中华人民共和国-People Republics of China"));
    }
}