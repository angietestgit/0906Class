package Class;

public class Sales {

	 private int productId;// 상품번호
	 private String  productName; //  판매 상품명
	 private int quantity; // 판매 상품  갯수
	 private int price;  // 판매 상품 가격
	 private int calorie;    // 칼로리
	 private String type;   // 상품타입
	 
	public Sales() {
		
	}
	
	public Sales(String productName, int quantity, int price, int calorie, String type) {
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.calorie = calorie;
		this.type = type;
	}
	
	
	
	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	
	public int getQuantity() {
		return quantity;
	}



	public int getPrice() {
		return price;
	}

	public int getCalorie() {
		return calorie;
	}

	
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "sales [productName=" + productName + ", quantity=" + quantity + ", price=" + price + ", calorie="
				+ calorie + ", type=" + type + "]";
	}

	public boolean equals(Object o) {
	        if (o instanceof Sales) {
	        	Sales b = (Sales) o;
	            if (this.productName == b.productName) {
	                return true;
	            }
	        }
	        return false;
	    }

	}
	 