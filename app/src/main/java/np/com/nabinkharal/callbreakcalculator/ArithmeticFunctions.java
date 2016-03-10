package np.com.nabinkharal.callbreakcalculator;


public class ArithmeticFunctions {
    int l;
    Float largest;

    public Float getLargest(Float[] array) {
        largest = array[0];
        l = array.length;
        for (int i = 0; i < l; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return largest;
    }
}
