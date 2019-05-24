import product.model.ProductEntity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class random {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ProductEntity product = new ProductEntity();
        product.setId(123);
        product.setAvgRating(4);
        product.setDelete(false);
        product.setName("iphone 7");

        Method[] declaredFields = product.getClass().getDeclaredMethods();

        for(Method field : declaredFields){
            Object data = field.invoke(product);
            System.out.printf("data %s : %s \n", field.getName(), data);
        }
    }
}
