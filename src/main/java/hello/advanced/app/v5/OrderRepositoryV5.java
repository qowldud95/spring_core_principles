package hello.advanced.app.v5;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {
    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId) throws IllegalAccessException {
        template.execute("OrderRepository.save()", ()-> {
            //저장로직
            if(itemId.equals("ex")){
                throw new IllegalAccessException("예외 발생!");
            }
            sleep(1000);
            return null;
        });
    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}