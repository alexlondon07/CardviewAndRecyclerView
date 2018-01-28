package io.github.alexlondon07.cardviewandreciclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import io.github.alexlondon07.cardviewandreciclerview.models.Movie;

/**
 * Created by alexlondon07 on 12/17/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<Movie> movies;
    private int layout;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public MyAdapter(List<Movie> movies, int layout, OnItemClickListener onItemClickListener) {
        this.movies = movies;
        this.layout = layout;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflamos la vista con nuestro Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        context = parent.getContext();
        return  vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Llamamos al método Bind del ViewHolder pasandole el objeto y Listener
        holder.bind(movies.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }



    /**
     * Clase ViewHolder
     */
    public  class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewName;
        public ImageView imageViewPoster;


        public ViewHolder(View v){
            //recibe la View Completa. La pasa al contrsuctor padre y enlazamos referencias UI
            //Con nuestras propiedades ViewHolder declaradas justo arriba
            super(v);

            textViewName = v.findViewById(R.id.my_recycler_view_text_view_title);
            imageViewPoster = v.findViewById(R.id.my_recycler_view_image_view_poster);

        }

        public void bind(final Movie movie, final OnItemClickListener listener){

            //Procesamos los datos a renderizar
            textViewName.setText(movie.getName());
            Picasso.with(context).load(movie.getPoster()).into(imageViewPoster);
            //imageViewPoster.setImageResource(movie.getPoster());

            //Definimos que por cada elemento de nuestro recycler view, un click listener que se comporta de la sgte manera
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(movie, getAdapterPosition());
                }
            });

        }
    }

    public interface OnItemClickListener{
        void onItemClick(Movie movie, int position);
    }
}
