import com.example.Feline;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline = new Feline();

    @Test
    public void eatMeatTest() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensTestArgs() {
        assertEquals(7, feline.getKittens(7));
    }

}