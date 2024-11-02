package bean;

import java.io.Serializable;

public class Product implements Serializable {
	/** 商品番号 */
	private int id;
	/** 商品名 */
	private String name;
	/** 価格 */
	private int price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
