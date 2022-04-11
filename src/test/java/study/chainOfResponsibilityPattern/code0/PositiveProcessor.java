package study.chainOfResponsibilityPattern.code0;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PositiveProcessor implements Chain{

    private Chain nextInChain;

    @Override
    public void setNext(Chain nextInChain) {
        this.nextInChain = nextInChain;
    }

    @Override
    public void process(Number request) {
        if(request.getNumber() > 0){
            log.info("PositiveProcessor={}",request.getNumber());
        } else {
            nextInChain.process(request);
        }
    }
}
