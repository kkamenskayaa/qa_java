import com.example.Lion;
import com.example.Feline;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> lionFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualLionFood = lion.getFood();
        assertEquals(lionFood, actualLionFood);
    }

    @Test
    public void doesHaveManeTrueTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean maneChecker = lion.doesHaveMane();
        assertTrue(maneChecker);
    }

    @Test
    public void doesHaveManeFalseTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean maneChecker = lion.doesHaveMane();
        assertFalse(maneChecker);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void invalidSexExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Другое", feline));
        assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
    }

}
