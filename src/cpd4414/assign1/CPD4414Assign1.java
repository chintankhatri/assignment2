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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class CPD4414Assign1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws noCustomerException, noPurchaseListException {
        // TODO code application logic here
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.err.println("Driver not Found " + ex.getMessage());

            }

            String url = "jdbc:mysql://ipro.lambton.on.ca/inventory";
            Connection conn = DriverManager.getConnection(url, "products", "products");

            // int listOfId[] = {1, 2, 4};
            String query = "SELECT * FROM inventory";
            //PreparedStatement pstmt = conn.prepareStatement(query);

//            for (int id : listOfId) {
//
//                pstmt.setInt(1, id);
//                ResultSet rs = pstmt.executeQuery();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("name")+"\t" + rs.getInt("id") + "\t" );
            }
            //}
            conn.close();

        } catch (SQLException ex) {
            System.err.println("SQL Issue: " + ex.getMessage());
        }
    

        

        System.out.println(new Date().getTime());

        Order o1 = new Order(1, "vicky");
        Purchase p1 = new Purchase("lobortis augue scelerisque", 97);
        o1.addPurchase(p1);
        OrderQueue q = new OrderQueue();
        q.add(o1);
        System.out.println(o1.getTimeReceived());

        Order o2 = new Order(2, "Jacky");
        Purchase p2 = new Purchase("libero. Integer in", 94);
        o2.addPurchase(p2);

        q.add(o2);
        o2.setTimeReceived(null);
        System.out.println(o2.getTimeReceived());
        System.out.println(o2.getTimeProcessed());
        System.out.println(q.next().getCustomerName());
        System.out.println(o2.getTimeReceived());

    }

}
