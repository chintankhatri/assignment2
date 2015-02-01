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

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class OrderQueueTest {
    
    public OrderQueueTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void wheneithercustomerIDorcustomernameexistandthereisalistofpurchasesthensetthetimereceivedtonow() throws customerExcptn, prchaselist{
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order(20, "ABC Construction");
        order.addPurchase(new Purchase("PROD0004", 450));
        order.addPurchase(new Purchase("PROD0006", 250));
        orderQueue.add(order);
        
        long expResult = new Date().getTime();
        long result = order.getTimeReceived().getTime();
        assertTrue(Math.abs(result - expResult) < 1000);
    }
    
    @Test
    public void WhenNeitherCustomerNameNorIDExistThenThrowException() throws prchaselist  {
        boolean excptn = false;
        try {
            OrderQueue orderQ = new OrderQueue();
            Order order = new Order(0, "");
            orderQ.add(order);
        } catch (customerExcptn ex) {
            excptn = true;
        }

        assertTrue(excptn);

    }

    @Test
    public void WhenPurchaseListNotExistThenThrowException() throws customerExcptn {
        boolean excptn = false;
        try {
            OrderQueue orderQ = new OrderQueue();
            Order order = new Order(25, "Smith");
            orderQ.add(order);

        } catch (prchaselist ex) {
            excptn = true;
        }

        assertTrue(excptn);

    }
    
    
    @Test
    public void WhenOrderQueueIsEmptyThenReturnNull() {
        OrderQueue Q = new OrderQueue();
        Order result = Q.next();
        assertNull(result);

    }

    @Test
    public void WhenOrderQueueIsNotEmptyThenReturn() throws customerExcptn, prchaselist {
        OrderQueue Q = new OrderQueue();
        Order order = new Order(1, "ABC Construction");
        order.addPurchase(new Purchase("PROD0004", 450));
        order.addPurchase(new Purchase("PROD0006", 250));
        Q.add(order);
        Order result = Q.next();
        Order expected = order;
        assertEquals(expected, result);
    }

    
    @Test
    public void WhenTimeReceivedIsNullThenThrowException() throws customerExcptn, prchaselist {
        boolean exceptionOccur = false;
        try {
            OrderQueue orderQueue = new OrderQueue();
            Order order = new Order(1, "ABC Construction");
            order.addPurchase(new Purchase("PROD0004", 450));
            order.addPurchase(new Purchase("PROD0006", 250));
            order.setTimeReceived(null);
            orderQueue.process(order);
        } catch (Notymexcptn ex) {
            exceptionOccur = true;
        }
        assertTrue(exceptionOccur);
    }

    @Test
    public void WhenTimeProcessedIsNullThenThrowException() throws customerExcptn, prchaselist, Notymexcptn {
        boolean exceptionOccur = false;
        try {
            OrderQueue orderQueue = new OrderQueue();
            Order order = new Order(1, "ABC Construction");
            order.addPurchase(new Purchase("PROD0004", 450));
            order.addPurchase(new Purchase("PROD0006", 250));
            order.setTimeProcessed(null);
            orderQueue.fulfill(order);
        } catch (NoTymprcssdexcptn ex) {
            exceptionOccur = true;
        }
        assertTrue(exceptionOccur);
    }

    @Test
    public void WhenTimeRecievedIsNullThenThrowException() throws customerExcptn, prchaselist, Notymexcptn, NoTymprcssdexcptn {
        boolean exceptionOccur = false;
        try {
            OrderQueue orderQueue = new OrderQueue();
            Order order = new Order(1, "ABC Construction");
            order.addPurchase(new Purchase("PROD0004", 450));
            order.addPurchase(new Purchase("PROD0006", 250));
            order.setTimeProcessed(new Date());
            order.setTimeReceived(null);
            orderQueue.fulfill(order);
        } catch (Notymexcptn ex) {
            exceptionOccur = true;
        }
        assertTrue(exceptionOccur);
    }
    
}


    
    
    
    

