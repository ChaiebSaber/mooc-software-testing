package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {
    private CaesarShiftCipher cSC;

    @BeforeEach
    void setUp() {
        cSC = new CaesarShiftCipher();
    }

    @Test
    void CaesarShiftCipherInvalid() {
        String result = cSC.CaesarShiftCipher("DDD",-2);
        Assertions.assertEquals("invalid",result);
    }

    @Test
    void CaesarShiftCipherShiftMin() {
        String result = cSC.CaesarShiftCipher("a",-1);
        Assertions.assertEquals("z",result);
    }

    @Test
    void CaesarShiftCipherOffA() {
        String result = cSC.CaesarShiftCipher("b", -1);
        Assertions.assertEquals("a",result);
    }

    @Test
    void CaesarShiftCipherShiftMax() {
        String result = cSC.CaesarShiftCipher("z", 1);
        Assertions.assertEquals("a",result);
    }

    @Test
    void CaesarShiftCipherOffZ() {
        String result = cSC.CaesarShiftCipher("y", 1);
        Assertions.assertEquals("z",result);
    }

    @Test
    void CaesarShiftCipherabc() {
        String result = cSC.CaesarShiftCipher("abc", 3);
        Assertions.assertEquals("def", result);
    }

    @ParameterizedTest(name = "CaesarShiftCipher({0},{1})->{2}")
    @CsvSource({
            "'DDD',1,'invalid'",
            "'a',-1,'z'",
            "'b',-1,'a'",
            "'z',1,'a'",
            "'y',1,'z'",
            "'abc',3,'def'",
            "'xyz',3,'abc'"
    })
    void testAll(String str,int shift,String expected) {
        String result = cSC.CaesarShiftCipher(str, shift);
        Assertions.assertEquals(expected, result);
    }
}
