import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParamTest {

    private String sex;
    private Boolean hasMane;

    public LionParamTest (String sex, Boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] LionParamTestParameters(){
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    Feline feline;

    @Test
    public void hasManeParamTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }
}