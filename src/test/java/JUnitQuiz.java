import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.linesOf;

public class JUnitQuiz {
    @Test
    public void junitTest(){
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길동";

        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();

        assertThat(name1).isEqualTo(name2);
        assertThat(name1).isEqualTo(name3);


    }
    @Test
    public void junitTest2(){
        int num1 = 15;
        int num2 = 0;
        int num3 = -5;
        assertThat(num1).isNotNegative();
        assertThat(num2).isZero();
        assertThat(num3).isNegative();

        assertThat(num1).isGreaterThan(num2);
        assertThat(num3).isLessThan(num2);
    }

}
