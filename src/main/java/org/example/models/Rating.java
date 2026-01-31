package org.example.models;

public class Rating {
    private int sum,count;
    public Rating(int sum,int count){
        this.sum=sum;
        this.count=count;
    }
    public double getAverageRating(){
        if(count<=0){
            return 0;
        }
        double average= (double) sum/count;
        double rating=(double)((int)((average+0.05)*10))/10.0;
        return rating;
    }
    public void add(int num){
        this.sum+=num;
        this.count+=1;
    }
}
