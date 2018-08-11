package git.com.ahmedIbrahimSaad.movieapp.presentation.top_rated;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.com.android.movieapp.R;


import java.util.ArrayList;
import java.util.List;

import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.new_model.ResultsItem;
import git.com.ahmedIbrahimSaad.movieapp.Injection;
import git.com.ahmedIbrahimSaad.movieapp.data.GenerericResponseModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedMoviesFragment extends Fragment implements TopRatedContract.TopRatedView{
    RecyclerView movies_list;
    TopRatedPresenter presenter;
    MovieListAdapter movieListAdapter;
    private LinearLayoutManager mLayoutManager;
    View view;


    public TopRatedMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_top_rated_movies, container, false);
        mLayoutManager = new LinearLayoutManager(getActivity());
        movies_list=view.findViewById(R.id.movie_list);
        doInjection();
        presenter.retriveTopRatedMovies();
        return view;
    }

    @Override
    public void onRetriveTopRatedMoviesSuccess(final List<ResultsItem> movieList) {
        movieListAdapter=new MovieListAdapter(getActivity(),movieList);
        movies_list.setLayoutManager(mLayoutManager);
        movies_list.setItemAnimator(new DefaultItemAnimator());
        movies_list.setAdapter(movieListAdapter);
        movieListAdapter.setOnItemClickListener(new MovieListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ArrayList<ResultsItem> moviesList = (ArrayList<ResultsItem>) movieList;
                DetailsFragment detailsFragment = new DetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("origin title", movieList.get(position).getOriginalTitle());
                bundle.putString("movie poster", movieList.get(position).getPosterPath());
                bundle.putString("overview", movieList.get(position).getOverview());
                bundle.putString("user rating",String.valueOf( movieList.get(position).getVoteAverage()));
                bundle.putString("release date", movieList.get(position).getReleaseDate());

                detailsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().add(detailsFragment,"details").commit();
            }
        });



    }

    @Override
    public void ononRetriveTopRatedMoviesFail(GenerericResponseModel responseModel) {

    }

    @Override
    public void setPresenter(TopRatedContract.TopRatedPresenter presenter) {

    }
    private void doInjection() {
        presenter = new TopRatedPresenter(Injection.injectRetriveMoviesUsecase(), Injection.provideUseCaseHandler(),this);

    }


}
