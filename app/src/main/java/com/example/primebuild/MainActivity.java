package com.example.primebuild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primebuild.adapter.CategoryAdapter;
import com.example.primebuild.adapter.DiscountedProductAdapter;
import com.example.primebuild.adapter.RecentlyViewedAdapter;
import com.example.primebuild.model.Category;
import com.example.primebuild.model.DiscountedProducts;
import com.example.primebuild.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView discountedRecyclerView, categoryRecyclerView , recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    RecentlyViewedAdapter recentlyViewedAdapter;
    List<DiscountedProducts> discountedProductsList;
    List<RecentlyViewed> recentlyViewedList;
    CategoryAdapter categoryAdapter;
    List<Category> categoryList;
    ImageView allCategoryImageView, Cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cart = findViewById(R.id.cart);

        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Cart.class);
                startActivity(intent);
            }
        });

        discountedRecyclerView=findViewById(R.id.discountedRecycler);
        //adding data to model
        discountedProductsList =new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1,R.drawable.discount1));
        discountedProductsList.add(new DiscountedProducts(2,R.drawable.discount2));
        discountedProductsList.add(new DiscountedProducts(3,R.drawable.discount3));
        discountedProductsList.add(new DiscountedProducts(4,R.drawable.discount1));
        discountedProductsList.add(new DiscountedProducts(5,R.drawable.discount2));
        discountedProductsList.add(new DiscountedProducts(6,R.drawable.discount3));
        setDiscountedRecycler(discountedProductsList);

        categoryRecyclerView =findViewById(R.id.catagoryRecycler);
        //adding data to model
        categoryList =new ArrayList<>();
        categoryList.add(new Category(1,R.drawable.a1)); // to dooooooooads
        categoryList.add(new Category(2,R.drawable.a2));
        categoryList.add(new Category(3,R.drawable.a3));
        categoryList.add(new Category(4,R.drawable.a4));
        categoryList.add(new Category(5,R.drawable.a5));
        categoryList.add(new Category(6,R.drawable.a6));
        categoryList.add(new Category(7,R.drawable.a7));
//        categoryList.add(new Category(8,R.drawable.ic_drink));
//        categoryList.add(new Category(9,R.drawable.ic_desert));
//        categoryList.add(new Category(10,R.drawable.ic_salad));
//        categoryList.add(new Category(11,R.drawable.ic_cookies));
//        categoryList.add(new Category(12,R.drawable.ic_spices));
        setCategoryRecycler();

        allCategoryImageView =findViewById(R.id.allCategoryImage);
        allCategoryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AllCategory.class);
                startActivity(intent);
            }
        });

        recentlyViewedRecycler =findViewById(R.id.recently_items);
        //adding data to model
        recentlyViewedList =new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Circular Saw","Simple yet reliable circular saw for rough cutting jobs.","₱ 2400","5","Pcs",R.drawable.newcard1,R.drawable.recently1));
        recentlyViewedList.add(new RecentlyViewed("Cordless Drill","The perfect DIY tool.","₱ 35,000","9","Pcs",R.drawable.newcard2,R.drawable.recently2));
        recentlyViewedList.add(new RecentlyViewed("Mallet","16 oz Rubber Mallet. Tough rubber head molded to wood handle","₹ 85","24","Pcs",R.drawable.newcard3,R.drawable.recently3));
        recentlyViewedList.add(new RecentlyViewed("Pliers","High quality carbon steel wholebody heat treatment.","₹ 40","51","Pcs",R.drawable.newcard4,R.drawable.recent4));
        setRecentlyRecycler();
    }

    private void setRecentlyRecycler() {
        RecyclerView.LayoutManager  layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

    private void setCategoryRecycler() {
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountedRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter =new DiscountedProductAdapter(this,dataList);
        discountedRecyclerView.setAdapter(discountedProductAdapter);
    }

}