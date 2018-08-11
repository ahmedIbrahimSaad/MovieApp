package git.com.ahmedIbrahimSaad.movieapp.presentation.top_rated;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.com.android.movieapp.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {
    @BindView(R.id.release_date)
    TextView release_data;
    @BindView(R.id.overview)
    TextView overview;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.rate)
    TextView rate;
    @BindView(R.id.movie_poster)
    ImageView movie_poster;
    View rootView;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*Bundle b = getArguments();
        rate.setText(b.getString("user rating"));
        release_data.setText(b.getString("release date"));
        overview.setText(b.getString("overview"));
        title.setText(b.getString("origin title"));
        Picasso.with(getContext()).load(b.getString("movie poster")).into(movie_poster);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, rootView);
        Bundle b = getArguments();
        // rate.setText(b.getString("user rating"));
        release_data.setText(b.getString("movie poster"));
        overview.setText(b.getString("overview"));
        title.setText(b.getString("origin title"));
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       // Picasso.with(getContext()).load(b.getString("movie poster")).into(movie_poster);
    }
}
