package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GHappyTest {
    private GHappy gH;

    @BeforeEach
    void setUp() {
        gH = new GHappy();
    }

    @ParameterizedTest(name = "gHappy({0})->{1}")
    @CsvSource({
            "'allas',true",
            "'gss',false",
            "'ggkhu',true",
            "'asggkjgk',false",
            "'asggkjk',true",
            "'sdfgg',true"
    })
    void gHappyWithNoG(String str,boolean expected) {
        boolean result = gH.gHappy(str);
        Assertions.assertEquals(expected,result);
    }


}
