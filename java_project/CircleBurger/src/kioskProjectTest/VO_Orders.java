package kioskProjectTest;


public class VO_Orders {

	private int productNumber; // 주문번호
	private int ticketnumber;      // 번호표
	private String PurchaseDate;   // 구매일자
	private int ageGroup;// 연령대
 	private int productId; // 상품번호
 	
 	public VO_Orders() {

	}
 	
 	public VO_Orders(int productNumber, int ticketnumber, String purchaseDate, int ageGroup, int productId) {

		this.productNumber = productNumber;
		this.ticketnumber = ticketnumber;
		this.PurchaseDate = purchaseDate;
		this.ageGroup = ageGroup;
		this.productId = productId;
	}
	

	public int getProductNumber() {
		return productNumber;
	}

	public int getTicketnumber() {
		return ticketnumber;
	}
	
	public String getPurchaseDate() {
		return PurchaseDate;
	}

	public int getAgegroup() {
		return ageGroup;
	}
	
	public int getProductId() {
		return productId;
	}


	@Override
	public String toString() {
		return "Orders [productNumber=" + productNumber + ", ticketnumber=" + ticketnumber + ", PurchaseDate="
				+ PurchaseDate + ", ageGroup=" + ageGroup + ", productId=" + productId + "]";
	}
	
	
    @Override
	public boolean equals(Object o) {
        if (o instanceof VO_Orders) {
        	VO_Orders b = (VO_Orders) o;
            if (this.productNumber == b.productNumber) {
                return true;
            }
        }
        return false;
    }

}