package com.example.dishdash.homepage.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dishdash.R;
import com.example.dishdash.mealditalies.view.MealFragment;
import com.example.dishdash.model.response.Category;
import com.example.dishdash.model.response.Food;

import java.util.List;

public class AllCategoriesAdapter extends RecyclerView.Adapter<AllCategoriesAdapter.ViewHolder> {

    private static final String TAG = "RecyclerView2";
    private final Context context;
    private List<Food> allcategoryList;
    public AllCategoriesAdapter(Context context, List<Food> categoryList) {
        this.context = context;
        this.allcategoryList = categoryList;
    }
    public void setList(List<Food> categoryList){
        this.allcategoryList = categoryList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txtView;
        public ConstraintLayout constraintLayout;
        public View layout;

        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            img = v.findViewById(R.id.img);
            txtView = v.findViewById(R.id.textView);
            constraintLayout = v.findViewById(R.id.main);
        }
    }

        @NonNull
        @Override
        public AllCategoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(recyclerView.getContext());
            View v = inflater.inflate(R.layout.test2, recyclerView, false);
            AllCategoriesAdapter.ViewHolder vh = new AllCategoriesAdapter.ViewHolder(v);
            Log.i(TAG, "===== onCreateViewHolder =====");
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull AllCategoriesAdapter.ViewHolder holder, int position) {
            Glide.with(context).load(allcategoryList.get(position).getMealThumbnail())
                    .apply(new RequestOptions().override(200,200)
                            .placeholder(R.drawable.ic_launcher_background)
                            .error(R.drawable.ic_launcher_foreground))
                    .into(holder.img);
            holder.txtView.setText(allcategoryList.get(position).getMealName());
//            holder.img.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    MealFragment mealFragment=MealFragment.getInstance(allcategoryList.get(position));
//
//                    ((HomePageActivity) context).getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.fragment_container,mealFragment)
//                            .addToBackStack(null).commit();
//                }
//            });
        }

        @Override
        public int getItemCount() {
            return allcategoryList.size();
        }

}