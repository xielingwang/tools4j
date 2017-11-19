package cn.tjitech.transform;

import static org.junit.Assert.*;
import org.junit.Test;

public class HexTest {

    @Test
    public void testFormatByte() {
        byte[] bytes = new byte[] {
                0x00,0x05,0x0A,0x0F,0x50,0x55,0x5A,0x5F,0x70,0x75,0x7A,0x7F,0x60,0x65,0x6A,0x6F, (byte) 0xFF
        };
        String[] hexStrs = new String[] {
                "00","05","0A","0F","50","55","5A","5F","70","75","7A","7F","60","65","6A","6F","FF"
        };
        for (int i = 0; i < bytes.length; i ++) {
            byte b = bytes[i];
            assertEquals(hexStrs[i], Hex.format(b));
            assertEquals(hexStrs[i].toLowerCase(), Hex.format(b, true));
        }
    }

    @Test
    public void testFormatBytes() {
        byte[] bytes = new byte[] {
                0x00,0x05,0x0A,0x0F,0x50,0x55,0x5A,0x5F,0x70,0x75,0x7A,0x7F,0x60,0x65,0x6A,0x6F, (byte) 0xFF
        };
        String target = "00050A0F50555A5F70757A7F60656A6FFF";
        assertEquals(target, Hex.format(bytes));
    }
}
