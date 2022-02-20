package hello.advanced.app.v3;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepositoryV1;
    private final LogTrace trace;


    public void orderItem(String itemId) throws IllegalAccessException {
        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepositoryV1.save(itemId);
            trace.end(status);
        } catch(Exception e){
            trace.exception(status, e);
            throw e;
        }

    }
}