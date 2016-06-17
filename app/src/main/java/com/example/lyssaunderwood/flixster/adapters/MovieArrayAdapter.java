package com.example.lyssaunderwood.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lyssaunderwood.flixster.R;
import com.example.lyssaunderwood.flixster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivImage;

    }

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for position
        Movie movie = getItem(position);

        //check to see if existing being reused
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // find image view
        //ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        //clear last image
        viewHolder.ivImage.setImageResource(0);

        //TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        //TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //populate data
        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverview.setText(movie.getOverview());

        boolean isLandscape = getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;


        if (isLandscape) {
            Picasso.with(getContext()).load(movie.getBackdropPath()).placeholder(R.drawable.ic_launcher).transform(new RoundedCornersTransformation(10, 10)).into(viewHolder.ivImage);

        } else {
            Picasso.with(getContext()).load(movie.getPosterPath()).placeholder(R.drawable.ic_launcher).transform(new RoundedCornersTransformation(10, 10)).into(viewHolder.ivImage);

        }

        //return view
        return convertView;
    }
}
