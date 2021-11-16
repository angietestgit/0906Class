package kioskProjectTest;

public class SQLQuery {

	public static final String showHamburger = "select s_name, s_price, s_Cal from VW_ALL where s_type = 'Hamburger'";
	public static final String showBeverage = "select s_name, s_price, s_Cal from VW_ALL where s_type = Beverage";
	public static final String showSide = "select s_name, s_price, s_Cal from VW_ALL where s_type = Side";
	public static final String showHamburgerForTheOld = "select s_name, s_Price from Sales where (s_name = 'BulgogiBurger' or s_name = 'ChickenBurger'  or s_name = 'ShrimpBurger' or s_name ='CheeseBurger')"; 
    public static final String showBeverageForTheOld = "select s_name, s_Price from Sales where (s_name = 'Americano' or s_name = 'Coke' or s_name = 'OrangeJuice')";
    public static final String showSideForTheOld = "select s_name, s_Price from Sales where (s_name = 'snackWrap' or s_name = 'CheeseStick' or s_name = 'ChickenNugget')";

}