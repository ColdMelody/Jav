package headfirst.builderpattern;

/**
 * Created by Bill on 2017/4/22.
 * Email androidBaoCP@163.com
 */
public class BuilderTest {
    public static void main(String[] args){
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(240,8)
                .calories(100)
                .sodiem(35)
                .carbohydrate(27)
                .build();
        System.out.println(nutritionFacts);
    }
}
