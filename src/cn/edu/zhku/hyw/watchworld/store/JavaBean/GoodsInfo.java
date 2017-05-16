package cn.edu.zhku.hyw.watchworld.store.JavaBean;
/**
 * 商品实体类
 * @author Administrator
 *
 */
public class GoodsInfo {
	
	private int       GoodsID         ;       //商品编号
	private String	  GoodsName       ;       // 商品名	
	private String	  GoodsPicturePath;       // 商品图片路径	
	private int	      Price           ;       // 价格	    
	private String	  Brand           ;       // 品牌	    
	private String	  MovementStyle   ;       // 机芯类型	
	private String	  Color           ;       // 颜色	    
	private String	  Material        ;       // 材质	    
	private String	  Shape           ;       // 形状	    
	private String	  Waterproof      ;       // 防水深度    
	private String	  Style           ;       // 风格	    
	private String	  Model           ;       // 型号  	
	private int	      Number          ;       // 库存  
	private int       StoreID         ;       // 店铺编号
	private int 	  SalesVolumes    ;       // 销量	    
	public int getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(int goodsID) {
		GoodsID = goodsID;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getMovementStyle() {
		return MovementStyle;
	}
	public void setMovementStyle(String movementStyle) {
		MovementStyle = movementStyle;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getMaterial() {
		return Material;
	}
	public void setMaterial(String material) {
		Material = material;
	}
	public String getShape() {
		return Shape;
	}
	public void setShape(String shape) {
		Shape = shape;
	}
	public String getWaterproof() {
		return Waterproof;
	}
	public void setWaterproof(String waterproof) {
		Waterproof = waterproof;
	}
	public String getStyle() {
		return Style;
	}
	public void setStyle(String style) {
		Style = style;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getGoodsPicturePath() {
		return GoodsPicturePath;
	}
	public void setGoodsPicturePath(String goodsPicturePath) {
		GoodsPicturePath = goodsPicturePath;
	}
	public int getSalesVolumes() {
		return SalesVolumes;
	}
	public void setSalesVolumes(int salesVolumes) {
		SalesVolumes = salesVolumes;
	}
	
	public int getStoreID() {
		return StoreID;
	}
	public void setStoreID(int storeID) {
		StoreID = storeID;
	}
	public GoodsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}