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

import cpd4414.assign1.OrderQueue.noCustomerException;
import cpd4414.assign1.OrderQueue.noPurchaseListException;
import cpd4414.assign1.OrderQueue.noTimeProcessedException;
import cpd4414.assign1.OrderQueue.noTimeRecievedException;
import java.io.IOException;
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
    public void testWhenCustomerExistsAndPurchasesExistThenTimeReceivedIsNow() throws OrderQueue.noCustomerException, OrderQueue.noPurchaseListException {
        
        OrderQueue orderQueue = new OrderQueue();
        
        Order order = new Order(5, "RC Production");
        order.addPurchase(new Purchase("PROR0004", 460));
        order.addPurchase(new Purchase("PROR0006", 260));
        orderQueue.add(order);

        long expResult = new Date().getTime();
        long result = order.getTimeReceived().getTime();
        assertTrue(Math.abs(result - expResult) < 1000);
    }

    @Test
    public void testWhenNeitherCustomerNameNorIDExistThenThrowException() throws noPurchaseListException {
        
        boolean wasException = false;
        
        try {
            OrderQueue orderQ = new OrderQueue();
            Order order = new Order(0, "");
            orderQ.add(order);
        
        } catch (noCustomerException ex) {
            wasException = true;
        }

        assertTrue(wasException);

    }

    @Test
    public void testWhenPurchaseListNotExistThenThrowException() throws noCustomerException, noPurchaseListException {
 
        boolean wasException = false;
        try {
            OrderQueue orderQ = new OrderQueue();
            Order order = new Order(5, "RC Production");
            orderQ.add(order);

        } catch (noPurchaseListException ex) {
            wasException = true;
        }

        assertTrue(wasException);

    }

    @Test
    public void testWhenTimeProcessedIsNullThenThrowException() throws noCustomerException, noPurchaseListException, noTimeRecievedException {
       
        boolean exceptionOccur = false;
        try {
            OrderQueue orderQueue = new OrderQueue();
            Order order = new Order(5, "RC Production");
        
            order.addPurchase(new Purchase("PROR0004", 460));
            order.addPurchase(new Purchase("PROR0006", 260));
            order.setTimeProcessed(null);
        
            orderQueue.fulfill(order);
        } 
        catch (noTimeProcessedException ex) {
         
            exceptionOccur = true;
        
        }
        
        assertTrue(exceptionOccur);
    }

    @Test
    public void testWhenTimeRecievedIsNullThenThrowException() throws noCustomerException, noPurchaseListException, noTimeRecievedException, noTimeProcessedException {
        boolean exceptionOccur = false;
        try 
         {
        
            OrderQueue orderQueue = new OrderQueue();
            Order order = new Order(5, "ABC Construction");
            order.addPurchase(new Purchase("PROR0004", 460));
            order.addPurchase(new Purchase("PROR0006", 260));
            order.setTimeProcessed(new Date());
            order.setTimeReceived(null);
            orderQueue.fulfill(order);
        
         } 
        catch (noTimeRecievedException ex) {
        
            exceptionOccur = true;
        
        }
        assertTrue(exceptionOccur);
 
    }

}
