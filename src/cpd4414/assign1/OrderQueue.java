/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cpd4414.assign1;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class OrderQueue {

    Queue<Order> orderQueue = new ArrayDeque<>();
    
    

    public void add(Order order) throws noCustomerException, noPurchaseListException {
        if (order.getCustomerId() < 1 || order.getCustomerName().isEmpty() ) {
            throw new noCustomerException();
        }
        if (order.getListOfPurchases().isEmpty()) {
            throw new noPurchaseListException();
        }
        orderQueue.add(order);
        order.setTimeReceived(new Date());  // set Time to curremt Time
    }

    public Order next() {
       return orderQueue.peek();    // Return, but does not remove, the head of this queue, or returns null if this queue is empty.
    }
    
    public void process(Order order,Purchase purchase) throws noTimeRecievedException{
        if(order.getTimeReceived() == null){
            throw new noTimeRecievedException();
        }
        if(purchase.getProductId().contentEquals(null)){
            
        }
        
    }
    
    public void fulfill(Order order) throws noTimeProcessedException, noTimeRecievedException{
        if(order.getTimeProcessed() == null){
            throw new noTimeProcessedException();
        }
        if(order.getTimeReceived() == null){
            throw new noTimeRecievedException();
            
        }
    }
}

class noCustomerException extends Exception {
}

class noPurchaseListException extends Exception {
}

class noTimeRecievedException extends Exception {    
}

class noTimeProcessedException extends Exception {   
}