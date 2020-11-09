package com.example.wallpaperpexel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperViewHolder> {

    private Context context;
    private List<WallPaperModel> wallPaperModelList;

    public WallpaperAdapter(Context context, List<WallPaperModel> wallPaperModelList) {
        this.context = context;
        this.wallPaperModelList = wallPaperModelList;
    }



    @NonNull
    @Override
    public WallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);




        return new WallpaperViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperViewHolder holder, int position) {


        Glide.with(context).load(wallPaperModelList.get(position).getMediumUrl()).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.startActivity(new Intent(context, FullScreenWallpaper.class)

                        .putExtra("originalUrl", wallPaperModelList.get(position).getOriginalUrl().toString())
                );

            }
        });



    }

    @Override
    public int getItemCount() {
        return wallPaperModelList.size();

    }
}

class WallpaperViewHolder extends RecyclerView.ViewHolder{


    ImageView imageView;

    public WallpaperViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageview_item);


    }



}
