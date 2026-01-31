package org.example.models;

public class Order {
    private String orderId,restaurantId,foodItemId;
    private int rating;

    public Order(String orderId,String restaurantId,String foodItemId,int rating){
        this.orderId=orderId;
        this.restaurantId=restaurantId;
        this.foodItemId=foodItemId;
        this.rating=rating;
    }

    public void setRating(int rating){
        this.rating=rating;
    }
    public int getRating(){
        return this.rating;
    }
    public String getRestaurantId(){
        return this.restaurantId;
    }
    public String getFoodItemId(){
        return this.foodItemId;
    }
}
