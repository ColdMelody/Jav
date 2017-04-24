package rxjava;

import io.reactivex.*;
import io.reactivex.annotations.NonNull;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * Created by Bill on 2017/4/23.
 * Email androidBaoCP@163.com
 */
public class RxJavaHelloWorld implements Executor{

    BlockingDeque<Runnable> tasks = new LinkedBlockingDeque<>();
    public static void main(String[] args) throws InterruptedException {
        Flowable.just("Hello world").subscribe(System.out::println);
        Observable.just("Hello Java!").subscribe(System.out::println);
        Single.just("Hello me!").subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                System.out.println(s);
            }
        });

        RxJavaHelloWorld world = new RxJavaHelloWorld();

        world.runOnMain();
        world.runLoop();

    }
    private void runOnMain(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> observableEmitter) throws Exception {
                for (int i =0;i<5;i++){
                    observableEmitter.onNext(i);
                }
                observableEmitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.from(this))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        // 注册观察者之后，Observable会先调用这个函数，然后再调用onNext()
//                disposable.dispose();
                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void runLoop() throws InterruptedException {
        if (!Thread.interrupted()){
            tasks.take().run();
        }
    }
    @Override
    public void execute(@NotNull Runnable command) {
        tasks.add(command);
    }
}
