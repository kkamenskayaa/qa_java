import com.example.Cat;
import com.example.Feline;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline = new Feline();

    Cat cat = new Cat(feline);

    @Test
    public void getSoundTest() {
        String sound = cat.getSound();
        assertEquals("Мяу",sound);
    }

    @Test
    public void getFoodTest() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}