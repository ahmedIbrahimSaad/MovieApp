package git.com.ahmedIbrahimSaad.movieapp.domain.base;

/**
 * Interface for schedulers, see {@link UseCaseThreadPoolScheduler}.
 */
public interface UseCaseScheduler {

    void execute(Runnable runnable);

    <V extends UseCase.ResponseValue> void notifyResponse(final V response,
                                                          final UseCase.UseCaseCallback<V> useCaseCallback);

    <V extends UseCase.ResponseValue> void notifyErrorResponse(final V response,
                                                               final UseCase.UseCaseCallback<V> useCaseCallback);
}
