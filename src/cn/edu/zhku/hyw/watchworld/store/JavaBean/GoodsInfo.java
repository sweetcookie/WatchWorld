package cn.edu.zhku.hyw.watchworld.store.JavaBean;
/**
 * 商品实体类
 * @author Administrator
 *
 */
public class GoodsInfo {
	
	private int       goodsID         ;       //1.商品编号
	private String	  goodsName       ;       // 2.商品名	
	private String	  goodsPicturePath;       // 3.商品图片路径	
	private int	      price           ;       // 4.价格	    
	private String	  brand           ;       // 5.品牌	    
	private String	  color           ;       // 7.颜色	    
	private String	  model           ;       // 12.型号  	
	private int	      number          ;       // 13.库存  
	private int       storeID         ;       // 14.店铺编号
	private int 	  salesVolumes    ;       // 15.销量	    
	
	public int getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsPicturePath() {
		return goodsPicturePath;
	}

	public void setGoodsPicturePath(String goodsPicturePath) {
		this.goodsPicturePath = goodsPicturePath;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}

	public int getSalesVolumes() {
		return salesVolumes;
	}

	public void setSalesVolumes(int salesVolumes) {
		this.salesVolumes = salesVolumes;
	}

	public GoodsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GoodsInfo [goodsID=" + goodsID + ", goodsName=" + goodsName
				+ ", goodsPicturePath=" + goodsPicturePath + ", price=" + price
				+ ", brand=" + brand + ", color=" + color + ", model=" + model
				+ ", number=" + number + ", storeID=" + storeID
				+ ", salesVolumes=" + salesVolumes + "]";
	}


	
	
	
}