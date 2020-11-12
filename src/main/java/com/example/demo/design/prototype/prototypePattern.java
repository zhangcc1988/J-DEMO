package com.example.demo.design.prototype;


/**
 *  原型模式
 *  用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象
 *  这里使用clone来实现原型模式
 */
public class prototypePattern {

    public static void main(String[] args) throws CloneNotSupportedException {
        ProductInfo productInfo = new ProductInfo("??");

        Product product = new Product("i", "am", "sb", productInfo);
        Product clone = (Product) product.clone();

        clone.getProductInfo().setName("haha");
        System.out.println("product --"+product.toString());
        System.out.println("clone --"+clone.toString());

    }

}

class Product implements Cloneable{

    private String column1;
    private String column2;
    private String column3;
    private ProductInfo productInfo;

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public Product(String column1, String column2, String column3, ProductInfo productInfo) {
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.productInfo = productInfo;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 深度clone
        Product product = ((Product) super.clone());
        ProductInfo clone = ((ProductInfo) this.productInfo.clone());
        product.setProductInfo(clone);
        return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "column1='" + column1 + '\'' +
                ", column2='" + column2 + '\'' +
                ", column3='" + column3 + '\'' +
                ", productInfo=" + productInfo +
                '}';
    }
}

class ProductInfo implements Cloneable{
    private String name;

    public ProductInfo(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return ((ProductInfo) super.clone());
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
