package git.com.ahmedIbrahimSaad.movieapp.presentation.top_rated;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.com.android.movieapp.R;

import java.util.List;

import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.new_model.ResultsItem;


class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

    private Context mContext;
    public List<ResultsItem> movieList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    class MovieListViewHolder extends RecyclerView.ViewHolder {
        //  CardView movieListContainer;
        //  TextView nameTxt, overview, rating,releasedata;
        ImageView movie_poster;


        MovieListViewHolder(View view, final OnItemClickListener listener) {
            super(view);
           /* movieListContainer = view.findViewById(R.id.currentOrderListContainer);
            nameTxt = view.findViewById(R.id.original_title);
            overview = view.findViewById(R.id.overview);
            rating = view.findViewById(R.id.rating);
            releasedata = view.findViewById(R.id.releasedata);*/
            movie_poster = view.findViewById(R.id.movie_poster);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    public MovieListAdapter(Context mContext, List<ResultsItem> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_movie_list_item, parent, false);


        return new MovieListViewHolder(itemView, mListener);
    }


    @Override
    public void onBindViewHolder(final MovieListViewHolder holder, final int position) {
        final ResultsItem movie = movieList.get(position);

       /* holder.overview.setText(movie.getOverview());
        holder.nameTxt.setText(movie.getOriginalTitle());
        holder.rating.setText(movie.getVoteCount());
        holder.releasedata.setText(movie.getReleaseDate());*/
       /* if (movieList.get(position).getPosterPath() != null) {
            String image =  movieList.get(position).getPosterPath();
            Glide.with(mContext)
                    .load(image)
                    .into(holder.movie_poster);
        } else {
            // make sure Glide doesn't load anything into this view until told otherwise
            Glide.clear(holder.movie_poster);
            // remove the placeholder (optional); read comments below
            holder.movie_poster.setImageDrawable(null);
        }*/
        if (movieList.get(position).getPosterPath() != null) {
            String image = movieList.get(position).getPosterPath();
            Picasso.with(mContext).load(image).into(holder.movie_poster);
        }
    }
        @Override
        public int getItemCount () {
            return movieList.size();
        }


    }
