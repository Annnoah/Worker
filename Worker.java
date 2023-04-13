public class Worker {

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    public interface OnTaskErrorListener {
       void onError(String result);
    }

    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorcallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorcallback) {
        this.callback = callback;
        this.errorcallback = errorcallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            callback.onDone("Task " + i + " is done");
            if (i == 33) {
                errorcallback.onError("Task " + i + " is undone");
            }
        }

    }
}
