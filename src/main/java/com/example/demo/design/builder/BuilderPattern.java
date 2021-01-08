package com.example.demo.design.builder;


/**
 * 建造者模式
 * 使用多个简单的对象一步一步构建成一个复杂的对象。这种类型的设计模式属于创建型模式
 */
public class BuilderPattern {

    public static void main(String[] args) {
        Product builder = new Product.Builder().setColumn1("I")
                .setColumn2("LOVE")
                .setColumn3("YOU")
                .setColumn4("!")
                .builder();

        System.out.println(builder.toString());

    }

}

class Product {

    private final String column1;
    private final String column2;
    private final String column3;
    private final String column4;

    public Product(String column1, String column2, String column3, String column4) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
    }

    @Override
    public String toString() {
        return column1 + ' ' + column2 + ' ' + column3 + ' ' + column4;
    }

    static class Builder {

        private String column1;
        private String column2;
        private String column3;
        private String column4;

        public Builder setColumn1(String column1) {
            this.column1 = column1;
            return this;
        }

        public Builder setColumn2(String column2) {
            this.column2 = column2;
            return this;
        }

        public Builder setColumn3(String column3) {
            this.column3 = column3;
            return this;
        }

        public Builder setColumn4(String column4) {
            this.column4 = column4;
            return this;
        }

        Product builder() {
            Product product = new Product(this.column1, this.column2, this.column3, this.column4);
            return product;
        }

    }
}