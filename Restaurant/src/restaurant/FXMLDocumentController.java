/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.SelectionMode;

/**
 *
 * @author Alejandro D
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private TextField unitPrice, subTotal, taxAmt, grandTotal;

    @FXML
    private ListView<String> tableLView;

    @FXML
    private ListView<String> orderLView;

    private OrderBean dataPriceOrder = new OrderBean();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<OrderBean> orderList= new ArrayList<>();
        
        Connection conn = ConnectDB.getConnection();
        
        
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ordenNo, mesaNo, isActivo, plat1, ");
        sql.append(" plat1price, plat2, plat2price, plat3, plat3price, bebida, bebidaprice ");
        sql.append(" FROM orders ");
        sql.append(" WHERE isActivo = 'Y'");
        sql.append(" Order by mesaNo");
        
        Statement ps = null;
        try {
            ps = conn.createStatement();
            ResultSet rs;
            rs = ps.executeQuery(sql.toString());
            
            while (rs.next()){
                OrderBean order = new OrderBean();
                order.setOrderNo(rs.getInt("ordenNo"));
                order.setMesaNo(rs.getInt("mesaNo"));
                order.setIsActivo(rs.getBoolean("isActivo"));
                order.setPlat1(rs.getString("plat1"));
                order.setPlat1Price(rs.getFloat("plat1price"));
                order.setPlat2(rs.getString("plat2"));
                order.setPlat2Price(rs.getFloat("plat2price"));
                order.setPlat3(rs.getString("plat3"));
                order.setPlat3Price(rs.getFloat("plat3price"));
                order.setBebida(rs.getString("bebida"));
                order.setBebidaprice(rs.getFloat("bebidaprice"));
                
                orderList.add(order);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        }
        
        
        ObservableList<String> tables = FXCollections.observableArrayList();

//        tables.add("Mesa 1");
//        tables.add("Mesa 2");
//        tables.add("Mesa 3");
orderList.stream().forEach((list) -> {
    tables.add(String.valueOf(list.getMesaNo()));
        });

        tableLView.setItems(tables);
        tableLView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableLView.getSelectionModel().getSelectedItem();
        
        ObservableList<String> orders = FXCollections.observableArrayList();
        
        OrderBean dataPriceOrder = new OrderBean();
        tableLView.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                for (OrderBean list: orderList){
                    if(list.isActivo()){
                        if(list.getMesaNo()==Integer.parseInt(newValue)){
                            orders.add(list.getPlat1());
                            orders.add(list.getPlat2());
                            orders.add(list.getPlat3());
                            orders.add(list.getBebida());
                            orderLView.setItems(orders);
                            dataPriceOrder.setPlat1Price(list.getPlat1Price());
                            dataPriceOrder.setPlat2Price(list.getPlat2Price());
                            dataPriceOrder.setPlat3Price(list.getPlat3Price());
                            dataPriceOrder.setBebidaprice(list.getBebidaprice());
                                                float subtotal = dataPriceOrder.getPlat1Price() 
            + dataPriceOrder.getPlat2Price() 
            + dataPriceOrder.getPlat3Price() 
            + dataPriceOrder.getBebidaprice();
        float taxTotal = (float) (subtotal * 0.16);
        float total = subtotal + taxTotal;
                subTotal.setText(String.valueOf(subtotal));
                taxAmt.setText(String.valueOf(taxTotal));
                grandTotal.setText(String.valueOf(total));
                            break;
                        }
                    }
                }
            }
        });
        
        orderLView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        orderLView.getSelectionModel().getSelectedIndex();
        
        orderLView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.equals(0)){
                    unitPrice.setText(String.valueOf(dataPriceOrder.getPlat1Price()));
                }else if(newValue.equals(1)){
                    unitPrice.setText(String.valueOf(dataPriceOrder.getPlat2Price()));
                }else if(newValue.equals(2)){
                    unitPrice.setText(String.valueOf(dataPriceOrder.getPlat3Price()));
                }else{
                    unitPrice.setText(String.valueOf(dataPriceOrder.getBebidaprice()));
                }
            }
        });
        
        
//        orders.add("Plato Fuerte: Crepas con Fresa");
//        orders.add("Plato Fuerte: Pan");
//        orders.add("Bebidas: Tasa de Cafe");
//        orderLView.setItems(orders);

        unitPrice.setAlignment(Pos.BOTTOM_RIGHT);
//        unitPrice.setText("22.00");
        subTotal.setAlignment(Pos.BOTTOM_RIGHT);
        
        taxAmt.setAlignment(Pos.BOTTOM_RIGHT);
        
        grandTotal.setAlignment(Pos.BOTTOM_RIGHT);
        
    }

}
