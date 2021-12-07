import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.LogTestTime;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LogTestTime.class)
public class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    @Test
    @DisplayName("Рассчитать площадь: прямоугольного треугольника (3, 4, 5) и (6, 4, 8)")
    void rectangularTriangleTest() {
        Triangle triangle = new Triangle(3, 4, 5); //todo Arrange
        int actualResult = triangle.TriangleSquare(); //todo Act
        assertEquals(6, actualResult); //todo Assert
    }

    public static Stream<Arguments> triangleForSquare() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 6),
                Arguments.of(new Triangle(6, 4, 8), 15));
    }

    @ParameterizedTest(name = "Рассчитать площадь: для {0} площадь = {1}")
    @MethodSource("triangleForSquare")
    void triangleSquareTest(Triangle triangle, int expectedResult) {
        int actualResult = triangle.TriangleSquare(); //todo Act
        assertEquals(expectedResult, actualResult); //todo Assert
    }

}