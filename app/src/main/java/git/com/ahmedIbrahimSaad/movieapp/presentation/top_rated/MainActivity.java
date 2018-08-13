package git.com.ahmedIbrahimSaad.movieapp.presentation.top_rated;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.com.android.movieapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TopRatedMoviesFragment topRatedMoviesFragment=new TopRatedMoviesFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fram_layout,topRatedMoviesFragment,"top").addToBackStack("top").commit();
    }
}
