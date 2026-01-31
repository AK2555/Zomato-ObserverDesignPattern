package org.example.observer;

import org.example.models.Order;
import org.example.models.Rating;

import java.util.*;

public class MostRatedRestaurants implements RateOrderObserver{
 // RestaurantId - Rating
   private TreeMap<String, Rating> ratings;

   public MostRatedRestaurants(){
       this.ratings=new TreeMap<>();
   }

    @Override
    public void update(Order order) {
       ratings.putIfAbsent(order.getRestaurantId(),new Rating(0,0));
       Rating rating=ratings.get(order.getRestaurantId());
       rating.add(order.getRating());
    }

    public List<String> getRestaurants(int count){
        TreeSet<String> ts=new TreeSet<>((a,b)-> {
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
