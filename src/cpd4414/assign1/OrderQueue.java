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

    public void add(Order order) throws customerExcptn, prchaselist {
        if (order.getCustomerId() == 0 || order.getCustomerName().isEmpty() ) {
            throw new customerExcptn();
        }
        if (order.getListOfPurchases().isEmpty()) {
            throw new prchaselist();
        }
        orderQueue.add(order);
        order.setTimeReceived(new Date());
    }

}

class customerExcptn extends Exception {
}

class prchaselist extends Exception {
}
