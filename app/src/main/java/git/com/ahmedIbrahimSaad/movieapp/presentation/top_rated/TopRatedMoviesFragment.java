package git.com.ahmedIbrahimSaad.movieapp.presentation.top_rated;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.com.android.movieapp.R;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import git.com.ahmedIbrahimSaad.movieapp.data.retrive_top_rated.new_model.ResultsItem;
import git.com.ahmedIbrahimSaad.movieapp.Injection;
import git.com.ahmedIbrahimSaad.movieapp.data.GenerericResponseModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRatedMoviesFragment extends Fragment implements TopRatedContract.TopRatedView{

    TopRatedPresenter presenter;
    MovieListAdapter movieListAdapter;
    GridLayoutManager mLayoutManager;
    View view;
    @BindView(R.id.movie_list)RecyclerView movies_list;

    public TopRatedMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_top_rated_movies, container, false);
        mLayoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        doInjection();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this,view);
        presenter.retriveTopRatedMovies();


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
                bundle.putString("origin title", moviesList.get(position).getTitle());
                bundle.putString("movie poster", moviesList.get(position).getPosterPath());
                bundle.putString("overview", moviesList.get(position).getOverview());
                bundle.putString("user rating",String.valueOf( moviesList.get(position).getVoteAverage()));
                bundle.putString("release date", moviesList.get(position).getReleaseDate());
                detailsFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().add(R.id.fram_layout,detailsFragment,"details").addToBackStack("details").commit();
            }
        });



    }

    @Override
    public void ononRetriveTopRatedMoviesFail(GenerericResponseModel responseModel) {
       // Toast.makeText(getActivity(), responseModel.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(TopRatedContract.TopRatedPresenter presenter) {

    }
    private void doInjection() {
        presenter = new TopRatedPresenter(Injection.injectRetriveMoviesUsecase(), Injection.provideUseCaseHandler(),this);

    }


}
