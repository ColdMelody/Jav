package rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Bill on 2017/4/24.
 * Email androidBaoCP@163.com
 * 一个简单的RxJava测试程序
 */
public class RunCurrentThread implements Executor {


    private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {
        RunCurrentThread sample = new RunCurrentThread();
        sample.observerOnMain();
        sample.runLoop();
    }

    private void observerOnMain() {
        createObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.from(this))
                .subscribe(message -> {
                    System.out.println("Observer thread " + message);
                    System.out.println("Observable thread " + Thread.currentThread().getName());
                });
        ;
    }

    public Observable<String> createObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext(Thread.currentThread().getName());
                observableEmitter.onComplete();
            }
        });
    }

    private void runLoop() throws InterruptedException {
        while (!Thread.interrupted()) {
            tasks.take().run();
        }
    }

    @Override
    public void execute(@NotNull Runnable command) {
        tasks.add(command);
    }
}
