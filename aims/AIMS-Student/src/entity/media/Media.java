package entity.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entity.db.AIMSDB;
import utils.Utils;

/**
 * The general media class, for another media it can be done by inheriting this class
 * @author nguyenlm
 */
public class Media {

    private static Logger LOGGER = Utils.getLogger(Media.class.getName());

    protected Statement stm;
    protected int id;
    protected String title;
    protected String category;
    protected int value; 
    protected int price; 
    protected int quantity;
    protected String type;
    protected String imageURL;
    
    // Nguyen Quoc Tien
    // size of item
	protected int itemLength;
	protected int itemWidth;
	protected int itemWeight;
      
    protected Boolean spRushOrder; // support Rush Order

    public Media() throws SQLException{
        stm = AIMSDB.getConnection().createStatement();
    }
    
    public Media (int id, String title, String category, int price, int quantity, String type) throws SQLException{
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.type = type;

      
    }

    public Media (int id, String title, String category, int price, int quantity, String type, int itemLength, int itemWidth, int itemWeight, Boolean spRushOrder) throws SQLException{
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.itemLength = itemLength;
        this.itemWidth = itemWidth;
        this.itemWeight = itemWeight;
        
        this.spRushOrder = spRushOrder;

        
    }

    public int getQuantity() throws SQLException{
        int updated_quantity = getMediaById(id).quantity;
        this.quantity = updated_quantity;
        return updated_quantity;
    }

    public Media getMediaById(int id) throws SQLException{
        String sql = "SELECT * FROM Media ;";
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery(sql);
		if(res.next()) {

            return new Media()
                .setId(res.getInt("id"))
                .setTitle(res.getString("title"))
                .setQuantity(res.getInt("quantity"))
                .setCategory(res.getString("category"))
                .setMediaURL(res.getString("imageUrl"))
                .setPrice(res.getInt("price"))
                .setType(res.getString("type"))
            	.setSupportRushOrder(this.getBoolean());
        }
        return new Media();
    }

    public List getAllMedia() throws SQLException{
        Statement stm = AIMSDB.getConnection().createStatement();
        ResultSet res = stm.executeQuery("select * from Media");
        ArrayList medium = new ArrayList<>();
        while (res.next()) {
            Media media = new Media()
                .setId(res.getInt("id"))
                .setTitle(res.getString("title"))
                .setQuantity(res.getInt("quantity"))
                .setCategory(res.getString("category"))
                .setMediaURL(res.getString("imageUrl"))
                .setPrice(res.getInt("price"))
                .setType(res.getString("type"))
            	.setSupportRushOrder(getBoolean());
            medium.add(media);
        }
        return medium;
    }

    public void updateMediaFieldById(String tbname, int id, String field, Object value) throws SQLException {
        Statement stm = AIMSDB.getConnection().createStatement();
        if (value instanceof String){
            value = "\"" + value + "\"";
        }
        stm.executeUpdate(" update " + tbname + " set" + " " 
                          + field + "=" + value + " " 
                          + "where id=" + id + ";");
    }

    // getter and setter 
    public int getId() {
        return this.id;
    }

    private Media setId(int id){
        this.id = id;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public Media setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCategory() {
        return this.category;
    }

    public Media setCategory(String category) {
        this.category = category;
        return this;
    }

    public int getPrice() {
        return this.price;
    }

    public Media setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getImageURL(){
        return this.imageURL;
    }

    public Media setMediaURL(String url){
        this.imageURL = url;
        return this;
    }

    public Media setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public Media setType(String type) {
        this.type = type;
        return this;
    }
    
    // Length, Width, Weight - Getter, Setter for item
    public int getLength() {
        return this.itemLength;
    }

    public Media setLength(int itemLength) {
        this.itemLength = itemLength;
        return this;
    }
    
    public int getWidth() {
        return this.itemWidth;
    }

    public Media setWidth(int itemWidth) {
        this.itemWidth = itemWidth;
        return this;
    }
    
    public int getWeight() {
        return this.itemWeight;
    }

    public Media setWeight(int itemWeight) {
        this.itemWeight = itemWeight;
        return this;
    }
    
    
    public Boolean getSupportRushOrder() {
		return spRushOrder;
	}

	public Media setSupportRushOrder(Boolean spRushOrder) {
		
		this.spRushOrder = spRushOrder;
		return this;
	}
	
	/**
     * 
     * @return
     */
    public boolean getBoolean() {
    	return false;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", title='" + title + "'" +
            ", category='" + category + "'" +
            ", price='" + price + "'" +
            ", quantity='" + quantity + "'" +
            ", type='" + type + "'" +
            ", imageURL='" + imageURL + "'" +
            ", itemLength='" + itemLength + "'" +
            ", itemWidth='" + itemWidth + "'" +
            ", itemWeight='" + itemWeight + "'" +
            ", spRushOrder='" + spRushOrder + "'" +
            "}";
    }    

}