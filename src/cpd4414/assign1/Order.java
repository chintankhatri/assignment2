/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cpd4414.assign1;

import java.util.Date;
import java.util.List;

/**
 *
 * @author c0587637
 */
public class Order {
    private String customerId;
    private String customerName;
    private Date timeReceived;
    private Date timeProcessed;
    private Date timeFulfilled;
    private List<Purchase> listOfPurchases;
    private String notes;    
}
