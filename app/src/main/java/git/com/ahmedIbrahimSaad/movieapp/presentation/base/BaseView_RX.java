package git.com.ahmedIbrahimSaad.movieapp.presentation.base;


import git.com.ahmedIbrahimSaad.movieapp.data.GenerericResponseModel;

public interface BaseView_RX <T extends BasePresenter> {

    void setPresenter(T presenter);

    void onServerError(GenerericResponseModel resp);

    void onUnknownError(String message);

    void setLoadingIndicator(boolean b);

    boolean isActive();


}
