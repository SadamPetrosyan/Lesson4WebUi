import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Triangle {
    private int a;
    private int b;
    private int c;

    public int TriangleSquare(){
        checkSidesPositive();
        checkValid();
        int p = (a + b + c) / 2; // TODO: p = полусумма сторон
        int s = (p - a) * (p - b); // TODO: a,b = катеты
        return s;
    }
    private void checkSidesPositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Стороны должны быть позитивными");
        }
    }

    private void checkValid() {
        long max = Math.max(Math.max(a, b), c);
        if (max >= (a + b + c - max)) {
            throw new IllegalArgumentException("Любые две стороны должны быть больше, чем другая сторона");
        }
    }
}