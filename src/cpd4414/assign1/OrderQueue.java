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

    public void add(Order order) throws CustomerException, PurchaseListException {

        if (order.getCustomerId() == 0 || order.getCustomerName().isEmpty()) {
            throw new CustomerException();
        }
        if (order.getListOfPurchases().isEmpty()) {

            throw new PurchaseListException();

        }
        orderQueue.add(order);
        order.setTimeReceived(new Date());
    }

    public void fulfill(Order order) throws TimeProcessedException, TimeRecievedException {

        if (order.getTimeProcessed() == null) {
            throw new TimeProcessedException();

        }
        if (order.getTimeReceived() == null) {

            throw new TimeRecievedException();

        }
    }

    public Order next() {
        return orderQueue.peek();   
    }

    public void process(Order order) throws TimeRecievedException {
        if (order.getTimeReceived() == null) {
            throw new TimeRecievedException();
        }
    }

    class TimeProcessedException extends Exception {

    }

    class TimeRecievedException extends Exception {

    }

    class CustomerException extends Exception {

    }

    class PurchaseListException extends Exception {

    }

}
