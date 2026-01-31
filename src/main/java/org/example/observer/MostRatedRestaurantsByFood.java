package org.example.observer;

import org.example.models.Order;
import org.example.models.Rating;

import java.util.*;

public class MostRatedRestaurantsByFood implements RateOrderObserver{
    // foodItemId - RestaurantId-Rating
    Map<String, Map<String,Rating>> ratings;

    public MostRatedRestaurantsByFood(){
        ratings=new HashMap<>();
    }

    @Override
    public void update(Order order) {
     ratings.putIfAbsent(order.getFoodItemId(),new HashMap<>());
     Map<String,Rating> restrauntsMap=ratings.get(order.getFoodItemId());
     restrauntsMap.putIfAbsent(order.getRestaurantId(),new Rating(0,0));
     restrauntsMap.get(order.getRestaurantId()).add(order.getRating());
    }

    public List<String> getRestaurants(int count,String foodItemId){

        Map<String,Rating> ratings=this.ratings.get(foodItemId);

        TreeSet<String> ts=new TreeSet<>((a, b)-> {
            double rA=ratings.getOrDefault(a,new Rating(0,0)).getAverageRating();
            double rB=ratings.getOrDefault(b,new Rating(0,0)).getAverageRating();
            if(rA!=rB){
                if(rA>rB){
                    return -1;
                }else{
                    return 1;
                }
            }
            return a.compareTo(b);
        });
        for(Map.Entry<String,Rating> ele: ratings.entrySet()){
            String key=ele.getKey();
            ts.add(key);
        }
        List<String> res=new ArrayList<>();
        for(String e: ts){
            res.add(e);
            count--;
            if(count==0){
                break;
            }
        }
        return res;
    }
}
