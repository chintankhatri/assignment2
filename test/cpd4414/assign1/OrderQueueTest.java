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
import cpd4414.assign1.noCustomerException;
import cpd4414.assign1.noPurchaseListException;

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
    public void testWhenCustomerExistsAndPurchasesExistThenTimeReceivedIsNow() throws noCustomerException, noPurchaseListException  {
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("CUST00001", "ABC Construction");
        order.addPurchase(new Purchase("PROD0004", 450));
        order.addPurchase(new Purchase("PROD0006", 250));
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
            Order order = new Order("", "");
            order.addPurchase(new Purchase("PROD0004", 450));
            order.addPurchase(new Purchase("PROD0006", 250));
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
            Order order = new Order("CUST00001", "ABC Construction");
            orderQ.add(order);
            
        } catch (noPurchaseListException ex) {
            wasException = true;
        }

        assertTrue(wasException);

    }
}
