package headfirst.builderpattern;

/**
 * Created by Bill on 2017/4/22.
 * Email androidBaoCP@163.com
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    public static class Builder{
        private final int servingSize;
        private final int servings;
        private int calories     = 0;
        private int fat          = 0;
        private int sodium       = 0;
        private int carbohydrate = 0;
        public Builder(int servingSize,int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val){
            calories = val;
            return this;
        }
        public Builder fat(int val){
            fat = val;
            return this;
        }
        public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }
        public Builder sodiem(int val){
            sodium = val;
            return this;
        }

        public NutritionFacts build(){
            return new NutritionFacts(this);
        }

    }
    private NutritionFacts(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "ServingSize:" + String.valueOf(servingSize) + "\n" +
                "Serving:" + String.valueOf(servings) + "\n" +
                "calories:" + String.valueOf(calories) + "\n" +
                "fat:" + String.valueOf(fat) + "\n" +
                "sodium:" + String.valueOf(sodium) + "\n" +
                "carbohydrate:" + String.valueOf(carbohydrate) + "\n";
    }

}
